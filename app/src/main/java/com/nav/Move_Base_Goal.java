package com.nav;

/**
 * Created by super_yu on 27/10/2017.
 */

public class Move_Base_Goal {

    /**
     * op : publish
     * topic : /move_base/goal
     * page : 88
     * msg : {"target_pose":{"header":{"frame_id":"/map"},"pose":{"z":-0.695688,"x":7.28705E-4,"w":0.71834,"y":0.00213251}},"target_position":{"header":{"frame_id":"/map"},"pose":{"z":0.00984454,"x":-0.0483838,"y":-0.00480753}}}
     */

    private String op;
    private String topic;
    private MsgBean msg;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * target_pose : {"header":{"frame_id":"/map"},"pose":{"z":-0.695688,"x":7.28705E-4,"w":0.71834,"y":0.00213251}}
         * target_position : {"header":{"frame_id":"/map"},"pose":{"z":0.00984454,"x":-0.0483838,"y":-0.00480753}}
         */

        private TargetPoseBean target_pose;
        private TargetPositionBean target_position;

        public TargetPoseBean getTarget_pose() {
            return target_pose;
        }

        public void setTarget_pose(TargetPoseBean target_pose) {
            this.target_pose = target_pose;
        }

        public TargetPositionBean getTarget_position() {
            return target_position;
        }

        public void setTarget_position(TargetPositionBean target_position) {
            this.target_position = target_position;
        }

        public static class TargetPoseBean {
            /**
             * header : {"frame_id":"/map"}
             * pose : {"z":-0.695688,"x":7.28705E-4,"w":0.71834,"y":0.00213251}
             */

            private HeaderBean header;
            private PoseBean pose;

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public PoseBean getPose() {
                return pose;
            }

            public void setPose(PoseBean pose) {
                this.pose = pose;
            }

            public static class HeaderBean {
                /**
                 * frame_id : /map
                 */

                private String frame_id;

                public String getFrame_id() {
                    return frame_id;
                }

                public void setFrame_id(String frame_id) {
                    this.frame_id = frame_id;
                }
            }

            public static class PoseBean {
                /**
                 * z : -0.695688
                 * x : 7.28705E-4
                 * w : 0.71834
                 * y : 0.00213251
                 */

                private double z;
                private double x;
                private double w;
                private double y;

                public double getZ() {
                    return z;
                }

                public void setZ(double z) {
                    this.z = z;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getW() {
                    return w;
                }

                public void setW(double w) {
                    this.w = w;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }
        }

        public static class TargetPositionBean {
            /**
             * header : {"frame_id":"/map"}
             * pose : {"z":0.00984454,"x":-0.0483838,"y":-0.00480753}
             */

            private HeaderBeanX header;
            private PoseBeanX pose;

            public HeaderBeanX getHeader() {
                return header;
            }

            public void setHeader(HeaderBeanX header) {
                this.header = header;
            }

            public PoseBeanX getPose() {
                return pose;
            }

            public void setPose(PoseBeanX pose) {
                this.pose = pose;
            }

            public static class HeaderBeanX {
                /**
                 * frame_id : /map
                 */

                private String frame_id;

                public String getFrame_id() {
                    return frame_id;
                }

                public void setFrame_id(String frame_id) {
                    this.frame_id = frame_id;
                }
            }

            public static class PoseBeanX {
                /**
                 * z : 0.00984454
                 * x : -0.0483838
                 * y : -0.00480753
                 */

                private double z;
                private double x;
                private double y;

                public double getZ() {
                    return z;
                }

                public void setZ(double z) {
                    this.z = z;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }
        }
    }
//    {
//        "op": "publish",
//            "topic": "/move_base/goal",
//            "msg": {
//        "target_pose": {
//            "header": {
//                "frame_id": "/map"
//            },
//            "pose": {
//                "z": -0.695688,
//                        "x": 0.000728705,
//                        "w": 0.71834,
//                        "y": 0.00213251
//            }
//        },
//        "target_position": {
//            "header": {
//                "frame_id": "/map"
//            },
//            "pose": {
//                "z": 0.00984454,
//                        "x": -0.0483838,
//                        "y": -0.00480753
//            }
//        }
//    }
//    }
}
