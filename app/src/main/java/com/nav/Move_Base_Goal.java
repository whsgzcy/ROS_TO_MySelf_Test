package com.nav;

/**
 * Created by super_yu on 27/10/2017.
 */

public class Move_Base_Goal {
    /**
     * msg : {"target_pose":{"header":{"frame_id":"/map"},"pose":{"w":0.72508,"x":0.00455891,"y":0.0110448,"z":-0.688561}},"base_position":{"header":{"frame_id":"/map"},"pose":{"x":-5.56034,"y":0.543951,"z":2.96803E-4}}}
     * op : publish
     * topic : /move_base/goal
     */

    private MsgBean msg;
    private String op = "publish";
    private String topic = "/move_base/goal";

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public String getOp() {
        return op;
    }

    public String getTopic() {
        return topic;
    }

    public static class MsgBean {
        /**
         * target_pose : {"header":{"frame_id":"/map"},"pose":{"w":0.72508,"x":0.00455891,"y":0.0110448,"z":-0.688561}}
         * base_position : {"header":{"frame_id":"/map"},"pose":{"x":-5.56034,"y":0.543951,"z":2.96803E-4}}
         */

        private TargetPoseBean target_pose;
        private BasePositionBean base_position;

        public TargetPoseBean getTarget_pose() {
            return target_pose;
        }

        public void setTarget_pose(TargetPoseBean target_pose) {
            this.target_pose = target_pose;
        }

        public BasePositionBean getBase_position() {
            return base_position;
        }

        public void setBase_position(BasePositionBean base_position) {
            this.base_position = base_position;
        }

        public static class TargetPoseBean {
            /**
             * header : {"frame_id":"/map"}
             * pose : {"w":0.72508,"x":0.00455891,"y":0.0110448,"z":-0.688561}
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

                private String frame_id = "/map";

                public String getFrame_id() {
                    return frame_id;
                }
            }

            public static class PoseBean {
                /**
                 * w : 0.72508
                 * x : 0.00455891
                 * y : 0.0110448
                 * z : -0.688561
                 */

                private double w;
                private double x;
                private double y;
                private double z;

                public double getW() {
                    return w;
                }

                public void setW(double w) {
                    this.w = w;
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

                public double getZ() {
                    return z;
                }

                public void setZ(double z) {
                    this.z = z;
                }
            }
        }

        public static class BasePositionBean {
            /**
             * header : {"frame_id":"/map"}
             * pose : {"x":-5.56034,"y":0.543951,"z":2.96803E-4}
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

                private String frame_id = "/map";

                public String getFrame_id() {
                    return frame_id;
                }
            }

            public static class PoseBeanX {
                /**
                 * x : -5.56034
                 * y : 0.543951
                 * z : 2.96803E-4
                 */

                private double x;
                private double y;
                private double z;

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

                public double getZ() {
                    return z;
                }

                public void setZ(double z) {
                    this.z = z;
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
//        "base_position": {
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