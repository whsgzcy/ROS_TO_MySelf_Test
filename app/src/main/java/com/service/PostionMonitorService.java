package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.jilk.ros.rosbridge.ROSBridgeClient;
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

    public class MyBinder extends Binder {

        public void setPoiListener(POI poi) {
            mPOI = poi;
        }

        public void getPoi(ROSBridgeClient client) {
            mClient = client;
            String msg = "{ \"op\": \"subscribe\", \"topic\": \"/move_base/local_costmap/footprint\"}";
//            String msg = "{ \"op\": \"subscribe\", \"topic\": \"/odom\", \"throttle_rate\": 2000}";
//            String msg = "{ \"op\": \"subscribe\", \"topic\": \"/move_base/feedback\"}";
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
    public void onEventAsync(PoiEvent event) {
        Log.d("yu", "x = " + event.msg);
//        PoiResult poiResult = new Gson().fromJson(event.msg, PoiResult.class);
//        if (poiResult != null) {
//            // position x and y
//            double p_x = poiResult.getPose().getPose().getPosition().getX();
//            double p_y = poiResult.getPose().getPose().getPosition().getY();
//            mPOI.poi_x(p_x);
//            mPOI.poi_y(p_y);
////            Log.d("yu", "x = " + p_x + " y = " + p_y);
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mClient != null) {
            String unmsg = "{" + "\"op\": \"unsubscribe\"," + "\"topic\": \"/odom\"" + "}";
            mClient.send(unmsg);
        }
        EventBus.getDefault().unregister(this);
    }

    public interface POI {
        void poi_x(double x);

        void poi_y(double y);
    }
}