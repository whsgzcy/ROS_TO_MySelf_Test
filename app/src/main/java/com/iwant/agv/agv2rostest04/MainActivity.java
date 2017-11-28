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
import android.widget.Toast;

import com.google.gson.Gson;
import com.helper.NavHelper;
import com.iwant.agv.agv2rostest04.model.Move_base_status;
import com.jilk.ros.ROSClient;
import com.jilk.ros.rosbridge.ROSBridgeClient;
import com.map.WayPointUtil;
import com.nav.Move_Base_Status;
import com.nav.NavPublich;
import com.nav.TMove_Base_Goal;

import net.whsgzcy.rosclient.RCApplication;
import net.whsgzcy.rosclient.entity.PublishEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "whsgzcy";

    private EditText mIPEdit;
    private Button mConnectBtn;
    private Button mUpBtn, mDownBtn, mLeftBtn, mRightBtn, mStopBtn;
    private Button mTestBtn;
    private Button mPowerBtn;
    private Button mUnPowerBtn;
    private TextView mStateText, mStationText;

    private ROSBridgeClient client;

    private Move_base_status move_base_status;

    private String mWSURL;

    private Button mState;
    private TextView mStateTextView;

    // 导航publish
    private NavPublich mNavPublich = new NavPublich();

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

        mTestBtn = (Button) findViewById(R.id.ansy_data);
        mTestBtn.setOnClickListener(this);

        mStateText = (TextView) findViewById(R.id.state_info_text);
        mStationText = (TextView) findViewById(R.id.station_info_text);

        // 获取电量按钮
        mPowerBtn = (Button) findViewById(R.id.power);
        mPowerBtn.setOnClickListener(this);

        mUnPowerBtn = (Button) findViewById(R.id.unpower);
        mUnPowerBtn.setOnClickListener(this);

        mIPEdit.setText("ws://192.168.4.11:9090");
//        mIPEdit.setText("ws://192.168.4.11:9090");
        // 控制小车
//        mLeftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                processMoveTopic(0,1);
//            }
//        });

        mUpBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        processMoveTopic(1, 1);
                        break;
                    case MotionEvent.ACTION_UP:
                        processStopTopic();
                        break;
                }
                return false;
            }
        });

        mDownBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":" +
                                "{\"linear\":{\"x\":" + -1 + ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":" + -1 + "}}}");
                        break;
                    case MotionEvent.ACTION_UP:
                        processStopTopic();
                        break;
                }
                return false;
            }
        });

        mLeftBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        processMoveTopic(0, 1);
                        break;
                    case MotionEvent.ACTION_UP:
                        processStopTopic();
                        break;
                }
                return false;
            }
        });

        mRightBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        client.send("{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":" +
                                "{\"linear\":{\"x\":" + 0 + ",\"y\":0,\"z\":0},\"angular\":{\"x\":-1,\"y\":0,\"z\":" + -1 + "}}}");
                        break;
                    case MotionEvent.ACTION_UP:
                        processStopTopic();
                        break;
                }
                return false;
            }
        });

        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processStopTopic();
            }
        });
//        mNaviTestBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (client == null) return;
//                // /move_base/goal
//                String goal_id = move_base_status.getStatus_list().get(0).getGoal_id().getId();
//                int goal_id_stamp_secs = move_base_status.getStatus_list().get(0).getGoal_id().getStamp().getSecs();
//                int goal_id_stamp_nsecs = move_base_status.getStatus_list().get(0).getGoal_id().getStamp().getNsecs();
//                int header_seq = move_base_status.getHeader().getSeq();
//                int header_stamp_secs = move_base_status.getHeader().getStamp().getSecs();
//                int header_stamp_nsecs = move_base_status.getHeader().getStamp().getNsecs();
//                String msg = "{\n" +
//                        "    \"op\": \"publish\",\n" +
//                        "    \"topic\": \"/move_base/goal\",\n" +
//                        "    \"msg\": {\n" +
//                        "        \"header\": {\n" +
//                        "            \"seq\": " + header_seq + ",\n" +
//                        "            \"stamp\": {\n" +
//                        "                \"secs\": " + header_stamp_secs + ",\n" +
//                        "                \"nsecs\": " + header_stamp_nsecs + "\n" +
//                        "            },\n" +
//                        "            \"frame_id\": \"\"\n" +
//                        "        },\n" +
//                        "        \"goal_id\": {\n" +
//                        "            \"stamp\": {\n" +
//                        "                \"secs\": " + goal_id_stamp_secs + ",\n" +
//                        "                \"nsecs\": " + goal_id_stamp_nsecs + "\n" +
//                        "            },\n" +
//                        "            \"id\": \"" + goal_id + "\n" +
//                        "        },\n" +
//                        "        \"goal\": {\n" +
//                        "            \"target_pose\": {\n" +
//                        "                \"header\": {\n" +
//                        "                    \"seq\": 4,\n" +
//                        "                    \"stamp\": {\n" +
//                        "                        \"secs\": 1494482836,\n" +
//                        "                        \"nsecs\": 594048023\n" +
//                        "                    },\n" +
//                        "                    \"frame_id\": \"map\"\n" +
//                        "                },\n" +
//                        "                \"pose\": {\n" +
//                        "                    \"position\": {\n" +
//                        "                        \"z\": 0,\n" +
//                        "                        \"y\": 0.059577807928737736,\n" +
//                        "                        \"x\": -0.23101512046212858\n" +
//                        "                    },\n" +
//                        "                    \"orientation\": {\n" +
//                        "                        \"w\": 0.9994535234062796,\n" +
//                        "                        \"z\": -0.030639017710174105,\n" +
//                        "                        \"y\": 0,\n" +
//                        "                        \"x\": 0\n" +
//                        "                    }\n" +
//                        "                }\n" +
//                        "            }\n" +
//                        "        }\n" +
//                        "    }\n" +
//                        "}";
//                Log.d(TAG, "send /move_base/goal msg " + msg);
//                client.send(msg);
//            }
//        });

        Button mABtn = (Button) findViewById(R.id.test_navi_a);
        Button mBBtn = (Button) findViewById(R.id.test_navi_b);
        Button mCBtn = (Button) findViewById(R.id.test_navi_c);
        Button mDBtn = (Button) findViewById(R.id.test_navi_d);
        Button mEBtn = (Button) findViewById(R.id.test_navi_e);
        Button mFBtn = (Button) findViewById(R.id.test_navi_f);
        mABtn.setOnClickListener(this);
        mBBtn.setOnClickListener(this);
        mCBtn.setOnClickListener(this);
        mDBtn.setOnClickListener(this);
        mEBtn.setOnClickListener(this);
        mFBtn.setOnClickListener(this);

        // 导航状态
        mState = (Button) findViewById(R.id.nav_state);
        mState.setOnClickListener(this);
        mStateTextView = (TextView) findViewById(R.id.nav_state_text);

        // 暂停接收导航状态
        Button stop_nav_state_btn = (Button) findViewById(R.id.stop_nav_state);
        stop_nav_state_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            // 连接 IP
            case R.id.connect_btn:
                mIPEdit.setText("ws://192.168.4.11:9090");
                mWSURL = mIPEdit.getText().toString().trim();
                connect(mWSURL);
                break;
            case R.id.test_navi_a:
//                client.send("{\"op\":\"publish\",\"topic\":\"/nav_ctrl\",\"msg\":{\"control\":1,\"goal_name\":\"map_6_A_601\"}}");
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/cmd_string\"," + "\"msg\": \"cancel\"" + "}");
                String t = new Gson().toJson(mNavPublich.getNavPublishHashMap().get("map_6_A_601"));
                mNavPointName = "map_6_A_601";
                mNavPointState = 1;
                Log.d("zheng", "正在导航去 " + mNavPointName + " 点");
                client.send(t);
                break;
            case R.id.test_navi_b:
//                client.send("{\"op\":\"publish\",\"topic\":\"/nav_ctrl\",\"msg\":{\"control\":1,\"goal_name\":\"map_6_A_602\"}}");
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/cmd_string\"," + "\"msg\": \"cancel\"" + "}");
                mNavPointName = "map_6_A_602";
                mNavPointState = 1;
                Log.d("zheng", "正在导航去 " + mNavPointName + " 点");
                client.send(new Gson().toJson(mNavPublich.getNavPublishHashMap().get("map_6_A_602")));
                break;
            case R.id.test_navi_c:
//                client.send("{\"op\":\"publish\",\"topic\":\"/nav_ctrl\",\"msg\":{\"control\":1,\"goal_name\":\"map_6_A_603\"}}");
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/cmd_string\"," + "\"msg\": \"cancel\"" + "}");
                mNavPointName = "map_6_A_603";
                mNavPointState = 1;
                Log.d("zheng", "正在导航去 " + mNavPointName + " 点");
                client.send(new Gson().toJson(mNavPublich.getNavPublishHashMap().get("map_6_A_603")));
                break;
            case R.id.test_navi_d:
//                client.send("{\"op\":\"publish\",\"topic\":\"/nav_ctrl\",\"msg\":{\"control\":1,\"goal_name\":\"map_6_B_604\"}}");
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/cmd_string\"," + "\"msg\": \"cancel\"" + "}");
                mNavPointName = "map_6_B_604";
                mNavPointState = 1;
                Log.d("zheng", "正在导航去 " + mNavPointName + " 点");
                client.send(new Gson().toJson(mNavPublich.getNavPublishHashMap().get("map_6_B_604")));
                break;
            case R.id.test_navi_e:
//                client.send("{\"op\":\"publish\",\"topic\":\"/nav_ctrl\",\"msg\":{\"control\":1,\"goal_name\":\"map_6_B_605\"}}");
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/cmd_string\"," + "\"msg\": \"cancel\"" + "}");
                mNavPointName = "map_6_B_605";
                mNavPointState = 1;
                Log.d("zheng", "正在导航去 " + mNavPointName + " 点");
                client.send(new Gson().toJson(mNavPublich.getNavPublishHashMap().get("map_6_A_605")));
                break;
            case R.id.test_navi_f:
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/rosnodejs/charge_ctrl\"," + "\"msg\": {" + "\"data\": \"charge\"" + "}" + "}");
                break;
            case R.id.unpower:
                client.send("{" + "\"op\": \"publish\"," + "\"topic\": \"/rosnodejs/charge_ctrl\"," + "\"msg\": {" + "\"data\": \"uncharge\"" + "}" + "}");
                break;
            case R.id.power:
                String msg = "{" + "\"op\": \"subscribe\"," + "\"topic\": \"/rosnodejs/robot_status\"," + "\"throttle_rate\": 3000" + "}";
                client.send(msg);
                break;
            case R.id.nav_state:
                client.send("{" + "\"op\": \"subscribe\"," + "\"topic\": \"/move_base/status\"," + "\"throttle_rate\": 3000" + "}");
//                client.send("{" + "\"op\": \"subscribe\"," + "\"topic\": \"/move_base/status\"" +  "}");
                break;
            case R.id.stop_nav_state:

                Log.d("click", NavHelper.getTime());

                client.send("{" + "\"op\": \"unsubscribe\"," + "\"topic\": \"/move_base/status\"" + "}");

                Log.d("click", NavHelper.getTime());

                break;
            // 同步站点数据
            case R.id.ansy_data:
                client.send("{ \"op\": \"subscribe\", \"topic\": \"/waypoints\"}");
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
                Log.d("chuan", "Connect ROS success");
                message.what = 1;
                mHandler.sendMessage(message);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onDisconnect(boolean normal, String reason, int code) {
                Log.d("chuan", "ROS disconnect");
                message.what = 2;
                mHandler.sendMessage(message);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                message.what = 2;
                mHandler.sendMessage(message);
                Log.d("chuan", "ROS communication error");
            }
        });
    }

    //Receive data from ROS server, send from ROSBridgeWebSocketClient onMessage()
    String mNavPointName;
    // 记录导航命令的下达 1是 0否
    int mNavPointState = 0;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMain(final PublishEvent event) {
        if ("/map".equals(event.name)) {
            return;
        }
        Log.d(TAG, "MainAcitvity response = " + event.op);
        Log.d(TAG, "MainAcitvity response = " + event.id);
        Log.d(TAG, "MainAcitvity response = " + event.name);
        Log.d(TAG, "MainAcitvity response = " + event.msg);

        // 事实的数据 为单点导航使用
        if (event.name.equals("/move_base/status")) {
            Log.d("move", "MainAcitvity response = " + event.msg);

            mStateTextView.setText(event.msg);
            Move_Base_Status mbs = new Gson().fromJson(event.msg, Move_Base_Status.class);
        }

        // 获取所有站点并存入到HashMap集合中去
        if (event.name.equals("/waypoints")) {
            /****第一种方式***/

            /****第二种方式***/

            // 将返回的数据生成实体类
            WayPointUtil wayPointUtil = new Gson().fromJson(event.msg, WayPointUtil.class);
            // mNavPublich 赋值
            List<String> mWayPointsNamesList = new ArrayList<String>();
            HashMap<String, TMove_Base_Goal> mNavPublishHashMap = new HashMap<String, TMove_Base_Goal>();

            for (int i = 0; i < wayPointUtil.getWaypoints().size(); i++) {

                String wayPointName = wayPointUtil.getWaypoints().get(i).getName();
                mWayPointsNamesList.add(wayPointName);

                /******************************************** 拼接导航对象 ****************************************/
                TMove_Base_Goal mbg = new TMove_Base_Goal();

                // 设置msg
                TMove_Base_Goal.MsgBean mgb_msg = new TMove_Base_Goal.MsgBean();
                TMove_Base_Goal.MsgBean.HeaderBean mbg_msg_header = new TMove_Base_Goal.MsgBean.HeaderBean();
                TMove_Base_Goal.MsgBean.HeaderBean.StampBean mbg_msg_header_stamp = new TMove_Base_Goal.MsgBean.HeaderBean.StampBean();
                mbg_msg_header.setStamp(mbg_msg_header_stamp);
                mgb_msg.setHeader(mbg_msg_header);

                // 设置 goal
                TMove_Base_Goal.MsgBean.GoalIdBean mbg_msg_gid = new TMove_Base_Goal.MsgBean.GoalIdBean();
                TMove_Base_Goal.MsgBean.GoalIdBean.StampBeanX mbg_msg_gid_stamp = new TMove_Base_Goal.MsgBean.GoalIdBean.StampBeanX();
                mbg_msg_gid.setStamp(mbg_msg_gid_stamp);
                mbg_msg_gid.setId(wayPointName);
                mgb_msg.setGoal_id(mbg_msg_gid);

                // 设置 goal
                TMove_Base_Goal.MsgBean.GoalBean mbg_msg_goal = new TMove_Base_Goal.MsgBean.GoalBean();
                // 设置 goal ------> target_pose -------->header
                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean mbg_msg_goal_targetpose = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean();
                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.HeaderBeanX mbg_msg_goal_targetpose_hearder = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.HeaderBeanX();
                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.HeaderBeanX.StampBeanXX mbg_msg_goal_targetpose_hearder_stamp = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.HeaderBeanX.StampBeanXX();
                mbg_msg_goal_targetpose_hearder.setStamp(mbg_msg_goal_targetpose_hearder_stamp);
                mbg_msg_goal_targetpose.setHeader(mbg_msg_goal_targetpose_hearder);
                // 设置 goal ------> target_pose -------->pose
                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean mbg_msg_goal_targetpose_pose = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean();
                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean.PositionBean mbg_msg_goal_targetpose_pose_position = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean.PositionBean();
                mbg_msg_goal_targetpose_pose_position.setZ(wayPointUtil.getWaypoints().get(i).getPose().getPosition().getZ());
                mbg_msg_goal_targetpose_pose_position.setX(wayPointUtil.getWaypoints().get(i).getPose().getPosition().getX());
                mbg_msg_goal_targetpose_pose_position.setY(wayPointUtil.getWaypoints().get(i).getPose().getPosition().getY());
                mbg_msg_goal_targetpose_pose.setPosition(mbg_msg_goal_targetpose_pose_position);

                TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean.OrientationBean mbg_msg_goal_targetpose_pose_orient = new TMove_Base_Goal.MsgBean.GoalBean.TargetPoseBean.PoseBean.OrientationBean();
                mbg_msg_goal_targetpose_pose_orient.setZ(wayPointUtil.getWaypoints().get(i).getPose().getOrientation().getZ());
                mbg_msg_goal_targetpose_pose_orient.setX(wayPointUtil.getWaypoints().get(i).getPose().getOrientation().getX());
                mbg_msg_goal_targetpose_pose_orient.setW(wayPointUtil.getWaypoints().get(i).getPose().getOrientation().getW());
                mbg_msg_goal_targetpose_pose_orient.setY(wayPointUtil.getWaypoints().get(i).getPose().getOrientation().getY());
                mbg_msg_goal_targetpose_pose.setOrientation(mbg_msg_goal_targetpose_pose_orient);

                mbg_msg_goal_targetpose.setPose(mbg_msg_goal_targetpose_pose);

                mbg_msg_goal.setTarget_pose(mbg_msg_goal_targetpose);

                mgb_msg.setGoal(mbg_msg_goal);
                // 数据汇总
                mbg.setMsg(mgb_msg);
                /******************************************** 抛出 mbg ****************************************/
                mNavPublishHashMap.put(wayPointName, mbg);
            }
            // 清除数据缓存
            mNavPublich.clear();
            // 复制数据至新的集合
            mNavPublich.setWayPointsNames(mWayPointsNamesList);
            mNavPublich.setNavPublishHashMap(mNavPublishHashMap);
            Toast.makeText(this, " 数据同步成功 ", Toast.LENGTH_SHORT).show();
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