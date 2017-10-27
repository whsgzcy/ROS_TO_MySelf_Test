package com.iwant.tt.super_frefser_library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;


public class ReactiveNetwork {

    private ConnectivityStatus status = ConnectivityStatus.UNKNOWN;

    /**
     * 判断链接的类型
     * @param context
     * @return
     */
    public Observable<ConnectivityStatus> observeNetworkConnectivity(final Context context) {
        final IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        return Observable.create(new Observable.OnSubscribe<ConnectivityStatus>() {
            @Override
            public void call(final Subscriber<? super ConnectivityStatus> subscriber) {
                final BroadcastReceiver receiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        final ConnectivityStatus newStatus = getConnectivityStatus(context);

                        // we need to perform check below,
                        // because after going off-line, onReceive() is called twice
                        if (newStatus != status) {
                            status = newStatus;
                            subscriber.onNext(newStatus);
                        }
                    }
                };

                context.registerReceiver(receiver, filter);

                subscriber.add(unsubscribeInUiThread(new Action0() {
                    @Override
                    public void call() {
                        context.unregisterReceiver(receiver);
                    }
                }));
            }
        }).defaultIfEmpty(ConnectivityStatus.OFFLINE);
    }


    /**
     * 测试网络可用性
     * @return
     */
    public Observable<Boolean> observeInternetConnectivity( ) {
        return Observable.interval( 2000, TimeUnit.MILLISECONDS, Schedulers.io())
                .map(new Func1<Long, Boolean>() {
                    @Override
                    public Boolean call(Long tick) {
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress( "www.baidu.com", 80 ), 2000 );
                            return socket.isConnected();
                        } catch (IOException e) {
                            return Boolean.FALSE;
                        }
                    }
                })
                .distinctUntilChanged();
    }


    /**
     * 监听wifi 按钮开关的
     * @param context
     * @return
     */
    public Observable<ConnectivityStatus> observeWifiSwitch( final Context context){
        final IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION );

        return rx.Observable.create(new Observable.OnSubscribe<ConnectivityStatus>() {
            @Override
            public void call(final Subscriber<? super ConnectivityStatus> subscriber) {
             final BroadcastReceiver receiver = new BroadcastReceiver(){
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                        switch (wifiState) {
                            case WifiManager.WIFI_STATE_DISABLED:
                                subscriber.onNext( ConnectivityStatus.WIFI_STATE_DISABLED );
                               // Toast.makeText(context, "wifi 关闭了", Toast.LENGTH_SHORT).show();
                                break;
                            case WifiManager.WIFI_STATE_DISABLING:
                                subscriber.onNext( ConnectivityStatus.WIFI_STATE_DISABLING );
                              //  Toast.makeText(context, "wifi 正在关闭", Toast.LENGTH_SHORT).show();
                                break;
                            case WifiManager.WIFI_STATE_ENABLED:
                                subscriber.onNext( ConnectivityStatus.WIFI_STATE_ENABLED );
                              //  Toast.makeText(context, "wifi 打开了", Toast.LENGTH_SHORT).show();
                                break;
                            case WifiManager.WIFI_STATE_ENABLING:
                                subscriber.onNext( ConnectivityStatus.WIFI_STATE_ENABLING );
                              //  Toast.makeText(context, "wifi 正在打开", Toast.LENGTH_SHORT).show();
                                break;
                            case WifiManager.WIFI_STATE_UNKNOWN:
                                subscriber.onNext( ConnectivityStatus.WIFI_STATE_UNKNOWN );
                                break;
                        }
                    }
                } ;

                context.registerReceiver( receiver , filter ) ;
                subscriber.add( unsubscribeInUiThread(new Action0() {
                    @Override
                    public void call() {
                        context.unregisterReceiver(receiver);
                    }
                }));
            }
        }) ;

    }

    /**
     * Gets current network connectivity status
     *
     * @param context Application Context is recommended here
     * @return ConnectivityStatus, which can be WIFI_CONNECTED, MOBILE_CONNECTED or OFFLINE
     */
    public ConnectivityStatus getConnectivityStatus(final Context context) {
        final String service = Context.CONNECTIVITY_SERVICE;
        final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(service);
        final NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo == null) {
            return ConnectivityStatus.OFFLINE;
        }

        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return ConnectivityStatus.WIFI_CONNECTED;
        } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return ConnectivityStatus.MOBILE_CONNECTED;
        }

        return ConnectivityStatus.OFFLINE;
    }

    private Subscription unsubscribeInUiThread(final Action0 unsubscribe) {
        return Subscriptions.create(new Action0() {

            @Override
            public void call() {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    unsubscribe.call();
                } else {
                    final Scheduler.Worker inner = AndroidSchedulers.mainThread().createWorker();
                    inner.schedule(new Action0() {
                        @Override
                        public void call() {
                            unsubscribe.call();
                            inner.unsubscribe();
                        }
                    });
                }
            }
        });
    }

}
