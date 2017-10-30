package com.nav;

/**
 * Created by super_yu on 30/10/2017.
 */

public class TMove_Base_Goal {
    /**
     * op : publish
     * topic : /move_base/goal
     * msg : {"header":{"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"},"goal_id":{"stamp":{"secs":0,"nsecs":0},"id":"map_6_A_601"},"goal":{"target_pose":{"header":{"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"},"pose":{"position":{"z":2.96803E-4,"x":-5.56034,"y":0.543951},"orientation":{"z":-0.688561,"x":0.00455891,"w":0.72508,"y":0.0110448}}}}}
     */
    private String op = "publish";
    private String topic = "/move_base/goal";
    private MsgBean msg;

    public String getOp() {
        return op;
    }

    public String getTopic() {
        return topic;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * header : {"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"}
         * goal_id : {"stamp":{"secs":0,"nsecs":0},"id":"map_6_A_601"}
         * goal : {"target_pose":{"header":{"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"},"pose":{"position":{"z":2.96803E-4,"x":-5.56034,"y":0.543951},"orientation":{"z":-0.688561,"x":0.00455891,"w":0.72508,"y":0.0110448}}}}
         */

        private HeaderBean header;
        private GoalIdBean goal_id;
        private GoalBean goal;

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public GoalIdBean getGoal_id() {
            return goal_id;
        }

        public void setGoal_id(GoalIdBean goal_id) {
            this.goal_id = goal_id;
        }

        public GoalBean getGoal() {
            return goal;
        }

        public void setGoal(GoalBean goal) {
            this.goal = goal;
        }

        public static class HeaderBean {
            /**
             * seq : 0
             * stamp : {"secs":0,"nsecs":0}
             * frame_id : map
             */

            private int seq = 0;
            private StampBean stamp;
            private String frame_id = "map";

            public int getSeq() {
                return seq;
            }

            public StampBean getStamp() {
                return stamp;
            }

            public void setStamp(StampBean stamp) {
                this.stamp = stamp;
            }

            public String getFrame_id() {
                return frame_id;
            }

            public static class StampBean {
                /**
                 * secs : 0
                 * nsecs : 0
                 */

                private int secs = 0;
                private int nsecs = 0;

                public int getSecs() {
                    return secs;
                }

                public int getNsecs() {
                    return nsecs;
                }
            }
        }

        public static class GoalIdBean {
            /**
             * stamp : {"secs":0,"nsecs":0}
             * id : map_6_A_601
             */

            private StampBeanX stamp;
            private String id = "";

            public StampBeanX getStamp() {
                return stamp;
            }

            public void setStamp(StampBeanX stamp) {
                this.stamp = stamp;
            }

            public String getId() {
                return id;
            }

            public static class StampBeanX {
                /**
                 * secs : 0
                 * nsecs : 0
                 */

                private int secs = 0;
                private int nsecs = 0;

                public int getSecs() {
                    return secs;
                }

                public int getNsecs() {
                    return nsecs;
                }
            }
        }

        public static class GoalBean {
            /**
             * target_pose : {"header":{"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"},"pose":{"position":{"z":2.96803E-4,"x":-5.56034,"y":0.543951},"orientation":{"z":-0.688561,"x":0.00455891,"w":0.72508,"y":0.0110448}}}
             */

            private TargetPoseBean target_pose;

            public TargetPoseBean getTarget_pose() {
                return target_pose;
            }

            public void setTarget_pose(TargetPoseBean target_pose) {
                this.target_pose = target_pose;
            }

            public static class TargetPoseBean {
                /**
                 * header : {"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"map"}
                 * pose : {"position":{"z":2.96803E-4,"x":-5.56034,"y":0.543951},"orientation":{"z":-0.688561,"x":0.00455891,"w":0.72508,"y":0.0110448}}
                 */

                private HeaderBeanX header;
                private PoseBean pose;

                public HeaderBeanX getHeader() {
                    return header;
                }

                public void setHeader(HeaderBeanX header) {
                    this.header = header;
                }

                public PoseBean getPose() {
                    return pose;
                }

                public void setPose(PoseBean pose) {
                    this.pose = pose;
                }

                public static class HeaderBeanX {
                    /**
                     * seq : 0
                     * stamp : {"secs":0,"nsecs":0}
                     * frame_id : map
                     */

                    private int seq = 0;
                    private StampBeanXX stamp;
                    private String frame_id = "map";

                    public int getSeq() {
                        return seq;
                    }

                    public StampBeanXX getStamp() {
                        return stamp;
                    }

                    public void setStamp(StampBeanXX stamp) {
                        this.stamp = stamp;
                    }

                    public String getFrame_id() {
                        return frame_id;
                    }

                    public static class StampBeanXX {
                        /**
                         * secs : 0
                         * nsecs : 0
                         */

                        private int secs = 0;
                        private int nsecs = 0;

                        public int getSecs() {
                            return secs;
                        }

                        public int getNsecs() {
                            return nsecs;
                        }
                    }
                }

                public static class PoseBean {
                    /**
                     * position : {"z":2.96803E-4,"x":-5.56034,"y":0.543951}
                     * orientation : {"z":-0.688561,"x":0.00455891,"w":0.72508,"y":0.0110448}
                     */

                    private PositionBean position;
                    private OrientationBean orientation;

                    public PositionBean getPosition() {
                        return position;
                    }

                    public void setPosition(PositionBean position) {
                        this.position = position;
                    }

                    public OrientationBean getOrientation() {
                        return orientation;
                    }

                    public void setOrientation(OrientationBean orientation) {
                        this.orientation = orientation;
                    }

                    public static class PositionBean {
                        /**
                         * z : 2.96803E-4
                         * x : -5.56034
                         * y : 0.543951
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

                    public static class OrientationBean {
                        /**
                         * z : -0.688561
                         * x : 0.00455891
                         * w : 0.72508
                         * y : 0.0110448
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
            }
        }
    }

//    {
//        "op": "publish",
//            "topic": "/move_base/goal",
//            "msg": {
//        "header": {
//            "seq": 0,
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            },
//            "frame_id": "map"
//        },
//        "goal_id": {
//            "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            },
//            "id": "map_6_A_601"
//        },
//        "goal": {
//            "target_pose": {
//                "header": {
//                    "seq": 0,
//                            "stamp": {
//                        "secs": 0,
//                                "nsecs": 0
//                    },
//                    "frame_id": "map"
//                },
//                "pose": {
//                    "position": {
//                        "z": 0.000296803,
//                                "x": -5.56034,
//                                "y": 0.543951
//                    },
//                    "orientation": {
//                        "z": -0.688561,
//                                "x": 0.00455891,
//                                "w": 0.72508,
//                                "y": 0.0110448
//                    }
//                }
//            }
//        }
//    }
//    }
}