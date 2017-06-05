package com.iwant.agv.agv2rostest04;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.iwant.agv.agv2rostest04.model.Move_base_status;
import com.jilk.ros.ROSClient;
import com.jilk.ros.rosbridge.ROSBridgeClient;

import net.whsgzcy.rosclient.RCApplication;
import net.whsgzcy.rosclient.entity.PublishEvent;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "whsgzcy";

    private EditText mIPEdit;
    private Button mConnectBtn;
    private Button mUpBtn, mDownBtn, mLeftBtn, mRightBtn, mStopBtn;
    private Button mTestBtn, mNaviTestBtn;
    private TextView mStateText, mStationText;

    private ROSBridgeClient client;

    private Move_base_status move_base_status;

    private String mWSURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        mIPEdit = (EditText) findViewById(R.id.ip_edit);
        mConnectBtn = (Button) findViewById(R.id.connect_btn);
        mConnectBtn.setOnClickListener(this);

        mUpBtn = (Button) findViewById(R.id.up_btn);
        mDownBtn = (Button) findViewById(R.id.down_btn);
        mLeftBtn = (Button) findViewById(R.id.left_btn);
        mRightBtn = (Button) findViewById(R.id.right_btn);
        mStopBtn = (Button) findViewById(R.id.stay_btn);

        mTestBtn = (Button) findViewById(R.id.test_state);
        mNaviTestBtn = (Button) findViewById(R.id.test_navi);

        mStateText = (TextView) findViewById(R.id.state_info_text);
        mStationText = (TextView) findViewById(R.id.station_info_text);

//        mIPEdit.setText("ws://172.26.144.50:9090");
        mIPEdit.setText("ws://192.168.3.11:9090");
        // 控制小车
//        mLeftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                processMoveTopic(0,1);
//            }
//        });

//        mUpBtn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        processMoveTopic(1, 1);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        processStopTopic();
//                        break;
//                }
//                return false;
//            }
//        });
//
//        mDownBtn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":" +
//                                "{\"linear\":{\"x\":" + -1 + ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":" + -1 + "}}}");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        processStopTopic();
//                        break;
//                }
//                return false;
//            }
//        });

        mLeftBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        processMoveTopic(0, 1);
                        break;
//                    case MotionEvent.ACTION_UP:
//                        processStopTopic();
//                        break;
                }
                return false;
            }
        });

//        mRightBtn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":" +
//                                "{\"linear\":{\"x\":" + 0 + ",\"y\":0,\"z\":0},\"angular\":{\"x\":-1,\"y\":0,\"z\":" + -1 + "}}}");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        processStopTopic();
//                        break;
//                }
//                return false;
//            }
//        });
//
//        mStopBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                processStopTopic();
//            }
//        });

        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // /move_base/feedback
                // /nav_ctrl_status
                // /nav_ctrl
                // /waypoint_markers
                // /waypoints
                // /trajectory_markers
                // /cmd_string
                // /move_base/status
                if (client == null) return;
//                client.send("{\"op\":\"subscribe\",\"topic\":\"" + "/waypoint_markers" + "\"}");
//                client.send("{\"op\":\"subscribe\",\"topic\":\"" + "/waypoint_markers" + "\"}");
//                String msg = "{\"op\":\"publish\",\"topic\":\"" + "/cmd_string" + "\",\"msg\":{"+"cancel"+"}}";
//                client.send(" {\"op\":\"publish\",\"topic\":\"/cmd_string\",\"msg\":{\"data\":\"cancel\"}}");
//                client.send("{\"op\":\"subscribe\",\"topic\":\"" + "/nav_ctrl" + "\"}");
                client.send("{\"op\":\"subscribe\",\"topic\":\"" + "/waypoints" + "\"}");
                Log.d(TAG, "testOnClick()");
            }
        });

        mNaviTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (client == null) return;
                // /move_base/goal
                String goal_id = move_base_status.getStatus_list().get(0).getGoal_id().getId();
                int goal_id_stamp_secs = move_base_status.getStatus_list().get(0).getGoal_id().getStamp().getSecs();
                int goal_id_stamp_nsecs = move_base_status.getStatus_list().get(0).getGoal_id().getStamp().getNsecs();
                int header_seq = move_base_status.getHeader().getSeq();
                int header_stamp_secs = move_base_status.getHeader().getStamp().getSecs();
                int header_stamp_nsecs = move_base_status.getHeader().getStamp().getNsecs();
                String msg = "{\n" +
                        "    \"op\": \"publish\",\n" +
                        "    \"topic\": \"/move_base/goal\",\n" +
                        "    \"msg\": {\n" +
                        "        \"header\": {\n" +
                        "            \"seq\": " + header_seq + ",\n" +
                        "            \"stamp\": {\n" +
                        "                \"secs\": " + header_stamp_secs + ",\n" +
                        "                \"nsecs\": " + header_stamp_nsecs + "\n" +
                        "            },\n" +
                        "            \"frame_id\": \"\"\n" +
                        "        },\n" +
                        "        \"goal_id\": {\n" +
                        "            \"stamp\": {\n" +
                        "                \"secs\": " + goal_id_stamp_secs + ",\n" +
                        "                \"nsecs\": " + goal_id_stamp_nsecs + "\n" +
                        "            },\n" +
                        "            \"id\": \"" + goal_id + "\n" +
                        "        },\n" +
                        "        \"goal\": {\n" +
                        "            \"target_pose\": {\n" +
                        "                \"header\": {\n" +
                        "                    \"seq\": 4,\n" +
                        "                    \"stamp\": {\n" +
                        "                        \"secs\": 1494482836,\n" +
                        "                        \"nsecs\": 594048023\n" +
                        "                    },\n" +
                        "                    \"frame_id\": \"map\"\n" +
                        "                },\n" +
                        "                \"pose\": {\n" +
                        "                    \"position\": {\n" +
                        "                        \"z\": 0,\n" +
                        "                        \"y\": 0.059577807928737736,\n" +
                        "                        \"x\": -0.23101512046212858\n" +
                        "                    },\n" +
                        "                    \"orientation\": {\n" +
                        "                        \"w\": 0.9994535234062796,\n" +
                        "                        \"z\": -0.030639017710174105,\n" +
                        "                        \"y\": 0,\n" +
                        "                        \"x\": 0\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
                Log.d(TAG, "send /move_base/goal msg " + msg);
                client.send(msg);
            }
        });

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            // 连接 IP
            case R.id.connect_btn:
                mWSURL = mIPEdit.getText().toString().trim();
                connect(mWSURL);
                break;
        }
    }

    //    Add TouchListener on log TextView
    private void processMoveTopic(float linearX, float angularZ) {
        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" + linearX + ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":" + angularZ + "}}}");
        Log.d(TAG, "send cmd_vel msg:x:" + linearX + " z:" + angularZ);
    }

    //    Add TouchListener on log TextView
    private void processStopTopic() {
        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":" + 0 + ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":" + 0 + "}}}");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_UP) {
            if (client != null) {
                processStopTopic();
            }
        }
        return super.dispatchTouchEvent(ev);
    }
//
//    private Timer mTimer;
//    private TimerTask mTimerTask;
//    private void connect(final String wsUrl){
//        Log.d(TAG, "connect()");
//        mTimer = new Timer();
//        mTimerTask = new TimerTask() {
//            @Override
//            public void run() {
//                // ros连接成功 则不往下执行
//                if(client != null){
//                    if(client.connect()) return;
//                }
//                final Message message = new Message();
//                client = new ROSBridgeClient(wsUrl);
//                client.connect(new ROSClient.ConnectionStatusListener() {
//                    @Override
//                    public void onConnect() {
//                        client.setDebug(true);
//                        ((RCApplication) getApplication()).setRosClient(client);
//                        Log.d(TAG, "Connect ROS success");
//                        message.what = 1;
//                        mHandler.sendMessage(message);
//                    }
//                    @Override
//                    public void onDisconnect(boolean normal, String reason, int code) {
//                        message.what = 2;
//                        mHandler.sendMessage(message);
//                        Log.d(TAG, "ROS disconnect");
//                    }
//                    @Override
//                    public void onError(Exception ex) {
//                        ex.printStackTrace();
//                        Log.d(TAG, "ROS communication error");
//                    }
//                });
//            }
//        };
//        //开始一个定时任务
//        mTimer.schedule(mTimerTask, 1000, 1500);
//    }

    private void connect(String wsUrl) {
        Log.d(TAG, "connect()");
        if (client != null) {
            // 节省内存
            if (client.connect()) return;
        }
        final Message message = new Message();
        client = new ROSBridgeClient(wsUrl);
        client.connect(new ROSClient.ConnectionStatusListener() {
            @Override
            public void onConnect() {
                client.setDebug(true);
                ((RCApplication) getApplication()).setRosClient(client);
                Log.d(TAG, "Connect ROS success");
                message.what = 1;
                mHandler.sendMessage(message);
            }

            @Override
            public void onDisconnect(boolean normal, String reason, int code) {
                Log.d(TAG, "ROS disconnect");
                message.what = 2;
                mHandler.sendMessage(message);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                message.what = 2;
                mHandler.sendMessage(message);
                Log.d(TAG, "ROS communication error");
            }
        });
    }

    //Receive data from ROS server, send from ROSBridgeWebSocketClient onMessage()
    public void onEvent(final PublishEvent event) {
        if ("/map".equals(event.name)) {
            return;
        }
        Log.d(TAG, "MainAcitvity response = " + event.op);
        Log.d(TAG, "MainAcitvity response = " + event.id);
        Log.d(TAG, "MainAcitvity response = " + event.name);
        Log.d(TAG, "MainAcitvity response = " + event.msg);

        // 事实的数据 为单点导航使用
        if (event.name.equals("/move_base/status")) {
            Gson gson = new Gson();
            move_base_status = gson.fromJson(event.msg, Move_base_status.class);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:

                    break;
                // 连接成功 获取设备信息
                case 1:
//                    mStateText
                    // getNodes
//                    try {
//                        String[] m = client.getNodes();
//                        StringBuffer sb = new StringBuffer();
//                        for(int i = 0; i < m.length; i++){
//                            sb. append(m[i]);
//                        }
//                        String s = sb.toString();
//                        mStateText.setText(s);
//                        Log.d("whsgzcy","MainActivity getNodes --> = " + s);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    // getService
//                    try {
//                        String[] m = client.getServices();
//                        StringBuffer sb = new StringBuffer();
//                        for(int i = 0; i < m.length; i++){
//                            String str = "";
//                            sb. append(m[i]);
//                            str = m[i];
//                            Log.d("whsgzcy",str);
//                        }
//                        String s = sb.toString();
//                        mStateText.setText(s);
//                        Log.d("whsgzcy","MainActivity getService --> = " + s);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    // getTopics
//                    try {
//                        String[] m = client.getTopics();
//                        StringBuffer sb = new StringBuffer();
//                        for(int i = 0; i < m.length; i++){
//                            String str = "";
//                            sb. append(m[i]);
//                            str = m[i];
//                            Log.d("whsgzcy",str);
//                        }
//                        String s = sb.toString();
//                        mStateText.setText(s);
//                        Log.d("whsgzcy","MainActivity getTopics --> = " + s);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    //get_Time()
//                    String get_time = "{\"op\":\"call_service\",\"service\":\"" + "/rosapi/get_time" + "\",\"args\":["+""+"]}";
//                    client.send(get_time);
//                    Log.d("whsgzcy","MainActivity get_time --> = " + get_time);

                    // /move_base/status
//                    client.send("{\"op\":\"subscribe\",\"topic\":\"" + "/move_base/status" + "\"}");
                    break;
            }
        }
    };


}
