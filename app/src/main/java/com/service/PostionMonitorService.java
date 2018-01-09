package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.jilk.ros.rosbridge.ROSBridgeClient;
import com.model.FootPrintResult;
import com.model.PoiResult;

import net.whsgzcy.rosclient.entity.PoiEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by super_yu on 2017/9/28.
 */

public class PostionMonitorService extends Service {

    private String TAG = "PostionMonitorService";
    private ROSBridgeClient mClient;

    private POI mPOI;

    private int GEI_POI = 0;

    public class MyBinder extends Binder {

        public void setPoiListener(POI poi) {
            mPOI = poi;
        }

        public void getPoi(ROSBridgeClient client) {
            mClient = client;
            String msg = "{\"op\": \"subscribe\",  \"topic\": \"/move_base/local_costmap/footprint\"}";
            mClient.send(msg);
            GEI_POI = 1;
        }

        public void pausePoi() {
            GEI_POI = -1;
        }

        public void startPoi() {
            GEI_POI = 1;
            String msg = "{\"op\": \"subscribe\",  \"topic\": \"/move_base/local_costmap/footprint\"}";
            mClient.send(msg);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 注册事件总线
        EventBus.getDefault().register(this);
    }

    /**
     * Event 事件回调
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMain(PoiEvent event) {
        FootPrintResult footResult = new Gson().fromJson(event.msg, FootPrintResult.class);
        Log.d("yu", "x = " + footResult.getPolygon().getPoints().get(3).getX());
        if (GEI_POI == -1) return;
        if (footResult != null) {
            // position x and y
            double p_x = footResult.getPolygon().getPoints().get(3).getX();
            double p_y = footResult.getPolygon().getPoints().get(3).getY();
            if (p_x >= -0.25) {
                GEI_POI = -1;
                Intent intent = new Intent();
                intent.setAction("com.iwant.action");
                intent.putExtra("action", "cancel");
                sendBroadcast(intent);

                Log.d("yu", "hava already sent");

                // 取消订阅
                Log.d("yu", "x = " + footResult.getPolygon().getPoints().get(3).getX());
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
            mPOI.poi_x(p_x);
            mPOI.poi_y(p_y);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Log.d("yu", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    // 先让底盘不动
                    mClient.send("{\"op\":\"publish\",\"topic\":\"/cmd_string\",\"msg\":{\"data\":\"cancel\"}}");
                    Log.d("yu", "hava canceled");
                    mPOI.cancel();
                    // 7s后回调此函数 让设备从充电桩上下来
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mClient.send("{\"op\":\"publish\",\"topic\":\"/odom_reset\",\"msg\":{}}");
                            mPOI.unCharge();
                        }
                    }, 7000);
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mClient != null) {
            String unmsg = "{" + "\"op\": \"unsubscribe\"," + "\"topic\": \"/move_base/local_costmap/footprint\"" + "}";
            mClient.send(unmsg);
        }
        EventBus.getDefault().unregister(this);
    }

    public interface POI {
        void poi_x(double x);

        void poi_y(double y);

        void unCharge();

        void cancel();
    }
}