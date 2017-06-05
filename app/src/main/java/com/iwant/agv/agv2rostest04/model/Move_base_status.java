package com.iwant.agv.agv2rostest04.model;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class Move_base_status {
    /**
     * seq : 45190
     * stamp : {"secs":1494491612,"nsecs":733554385}
     * frame_id :
     */

    /**
     * status : 3
     * text : Goal reached.
     * goal_id : {"id":"/waypoints_navi-43-1494489540.592465434","stamp":{"secs":1494489540,"nsecs":592465434}}
     */

    //    {
//        "status_list": [
//        {
//            "status": 3,
//                "text": "Goal reached.",
//                "goal_id": {
//            "id": "/waypoints_navi-43-1494489540.592465434",
//                    "stamp": {
//                "secs": 1494489540,
//                        "nsecs": 592465434
//            }
//        }
//        }
//    ],
//        "header": {
//        "seq": 60509,
//                "stamp": {
//            "secs": 1494494676,
//                    "nsecs": 533441212
//        },
//        "frame_id": ""
//    }
//    }

    private List<StatusListEntity> status_list;
    private HeaderEntity header;

    public void setHeader(HeaderEntity header) {
        this.header = header;
    }

    public void setStatus_list(List<StatusListEntity> status_list) {
        this.status_list = status_list;
    }

    public HeaderEntity getHeader() {
        return header;
    }

    public List<StatusListEntity> getStatus_list() {
        return status_list;
    }

    public static class HeaderEntity {
        private int seq;
        /**
         * secs : 1494491612
         * nsecs : 733554385
         */

        private StampEntity stamp;
        private String frame_id;

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public void setStamp(StampEntity stamp) {
            this.stamp = stamp;
        }

        public void setFrame_id(String frame_id) {
            this.frame_id = frame_id;
        }

        public int getSeq() {
            return seq;
        }

        public StampEntity getStamp() {
            return stamp;
        }

        public String getFrame_id() {
            return frame_id;
        }

        public static class StampEntity {
            private int secs;
            private int nsecs;

            public void setSecs(int secs) {
                this.secs = secs;
            }

            public void setNsecs(int nsecs) {
                this.nsecs = nsecs;
            }

            public int getSecs() {
                return secs;
            }

            public int getNsecs() {
                return nsecs;
            }
        }
    }

    public static class StatusListEntity {
        private int status;
        private String text;
        /**
         * id : /waypoints_navi-43-1494489540.592465434
         * stamp : {"secs":1494489540,"nsecs":592465434}
         */

        private GoalIdEntity goal_id;

        public void setStatus(int status) {
            this.status = status;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setGoal_id(GoalIdEntity goal_id) {
            this.goal_id = goal_id;
        }

        public int getStatus() {
            return status;
        }

        public String getText() {
            return text;
        }

        public GoalIdEntity getGoal_id() {
            return goal_id;
        }

        public static class GoalIdEntity {
            private String id;
            /**
             * secs : 1494489540
             * nsecs : 592465434
             */

            private StampEntity stamp;

            public void setId(String id) {
                this.id = id;
            }

            public void setStamp(StampEntity stamp) {
                this.stamp = stamp;
            }

            public String getId() {
                return id;
            }

            public StampEntity getStamp() {
                return stamp;
            }

            public static class StampEntity {
                private int secs;
                private int nsecs;

                public void setSecs(int secs) {
                    this.secs = secs;
                }

                public void setNsecs(int nsecs) {
                    this.nsecs = nsecs;
                }

                public int getSecs() {
                    return secs;
                }

                public int getNsecs() {
                    return nsecs;
                }
            }
        }
    }




}
