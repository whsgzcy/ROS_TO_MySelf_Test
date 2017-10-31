package com.nav;

import java.util.List;

/**
 * Created by super_yu on 30/10/2017.
 */

public class Move_Base_Status {
    /**
     * status_list : [{"goal_id":{"id":"map_6_A_603","stamp":{"secs":1509348841,"nsecs":490135242}},"text":"Goal reached.","status":3},{"goal_id":{"id":"map_6_A_601","stamp":{"secs":1509348875,"nsecs":650002258}},"text":"This goal has been accepted by the simple action server","status":1}]
     * header : {"seq":13516,"frame_id":"","stamp":{"secs":1509348876,"nsecs":156902566}}
     */

    private HeaderBean header;
    private List<StatusListBean> status_list;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public List<StatusListBean> getStatus_list() {
        return status_list;
    }

    public void setStatus_list(List<StatusListBean> status_list) {
        this.status_list = status_list;
    }

    public static class HeaderBean {
        /**
         * seq : 13516
         * frame_id :
         * stamp : {"secs":1509348876,"nsecs":156902566}
         */

        private int seq;
        private String frame_id;
        private StampBean stamp;

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getFrame_id() {
            return frame_id;
        }

        public void setFrame_id(String frame_id) {
            this.frame_id = frame_id;
        }

        public StampBean getStamp() {
            return stamp;
        }

        public void setStamp(StampBean stamp) {
            this.stamp = stamp;
        }

        public static class StampBean {
            /**
             * secs : 1509348876
             * nsecs : 156902566
             */

            private int secs;
            private int nsecs;

            public int getSecs() {
                return secs;
            }

            public void setSecs(int secs) {
                this.secs = secs;
            }

            public int getNsecs() {
                return nsecs;
            }

            public void setNsecs(int nsecs) {
                this.nsecs = nsecs;
            }
        }
    }

    public static class StatusListBean {
        /**
         * goal_id : {"id":"map_6_A_603","stamp":{"secs":1509348841,"nsecs":490135242}}
         * text : Goal reached.
         * status : 3
         */

        private GoalIdBean goal_id;
        private String text;
        private int status;

        public GoalIdBean getGoal_id() {
            return goal_id;
        }

        public void setGoal_id(GoalIdBean goal_id) {
            this.goal_id = goal_id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public static class GoalIdBean {
            /**
             * id : map_6_A_603
             * stamp : {"secs":1509348841,"nsecs":490135242}
             */

            private String id;
            private StampBeanX stamp;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public StampBeanX getStamp() {
                return stamp;
            }

            public void setStamp(StampBeanX stamp) {
                this.stamp = stamp;
            }

            public static class StampBeanX {
                /**
                 * secs : 1509348841
                 * nsecs : 490135242
                 */

                private int secs;
                private int nsecs;

                public int getSecs() {
                    return secs;
                }

                public void setSecs(int secs) {
                    this.secs = secs;
                }

                public int getNsecs() {
                    return nsecs;
                }

                public void setNsecs(int nsecs) {
                    this.nsecs = nsecs;
                }
            }
        }
    }


//    {
//        "status_list": [
//        {
//            "goal_id": {
//            "id": "map_6_A_603",
//                    "stamp": {
//                "secs": 1509348841,
//                        "nsecs": 490135242
//            }
//        },
//            "text": "Goal reached.",
//                "status": 3
//        },
//        {
//            "goal_id": {
//            "id": "map_6_A_601",
//                    "stamp": {
//                "secs": 1509348875,
//                        "nsecs": 650002258
//            }
//        },
//            "text": "This goal has been accepted by the simple action server",
//                "status": 1
//        }
//    ],
//        "header": {
//        "seq": 13516,
//                "frame_id": "",
//                "stamp": {
//            "secs": 1509348876,
//                    "nsecs": 156902566
//        }
//    }
//    }
}
