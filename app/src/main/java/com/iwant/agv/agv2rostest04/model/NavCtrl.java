package com.iwant.agv.agv2rostest04.model;

/**
 * Created by super_yu on 2018/2/23.
 */

public class NavCtrl {


    /**

     * msg : {"control":0,"goal_name":"nihao"}
     */

    private String op = "publish";
    private String topic = "/nav_ctrl";
    private MsgBean msg;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * control : 0
         * goal_name : nihao
         */

        private int control;
        private String goal_name;

        public int getControl() {
            return control;
        }

        public void setControl(int control) {
            this.control = control;
        }

        public String getGoal_name() {
            return goal_name;
        }

        public void setGoal_name(String goal_name) {
            this.goal_name = goal_name;
        }
    }
}
