package com.model;

/**
 * Created by super_yu on 2018/1/5.
 */

import java.util.List;

/**
 *对位置移动有数据变化的是
 * orientation z、w
 * position x、y
 * twist x
 * angular z
 * Created by super_yu on 2017/9/29.
 */

public class PoiResult {

    /**
     * twist : {"twist":{"angular":{"z":0,"y":0,"x":0},"linear":{"z":0,"y":0,"x":0}},"covariance":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}
     * child_frame_id : base_footprint
     * pose : {"covariance":[0.1,0,0,0,0,0,0,0.1,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,0.2],"pose":{"position":{"z":0,"y":-0.16137039724419636,"x":0.001470031525333453},"orientation":{"w":-0.08271030624895466,"z":-0.9965736326234024,"y":"-0","x":0}}}
     * header : {"seq":69712,"stamp":{"secs":1506650141,"nsecs":455670567},"frame_id":"odom"}
     */

    private TwistBeanX twist;
    private String child_frame_id;
    private PoseBeanX pose;
    private HeaderBean header;

    public TwistBeanX getTwist() {
        return twist;
    }

    public void setTwist(TwistBeanX twist) {
        this.twist = twist;
    }

    public String getChild_frame_id() {
        return child_frame_id;
    }

    public void setChild_frame_id(String child_frame_id) {
        this.child_frame_id = child_frame_id;
    }

    public PoseBeanX getPose() {
        return pose;
    }

    public void setPose(PoseBeanX pose) {
        this.pose = pose;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class TwistBeanX {
        /**
         * twist : {"angular":{"z":0,"y":0,"x":0},"linear":{"z":0,"y":0,"x":0}}
         * covariance : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
         */

        private TwistBean twist;
        private List<Integer> covariance;

        public TwistBean getTwist() {
            return twist;
        }

        public void setTwist(TwistBean twist) {
            this.twist = twist;
        }

        public List<Integer> getCovariance() {
            return covariance;
        }

        public void setCovariance(List<Integer> covariance) {
            this.covariance = covariance;
        }

        public static class TwistBean {
            /**
             * angular : {"z":0,"y":0,"x":0}
             * linear : {"z":0,"y":0,"x":0}
             */

            private AngularBean angular;
            private LinearBean linear;

            public AngularBean getAngular() {
                return angular;
            }

            public void setAngular(AngularBean angular) {
                this.angular = angular;
            }

            public LinearBean getLinear() {
                return linear;
            }

            public void setLinear(LinearBean linear) {
                this.linear = linear;
            }

            public static class AngularBean {
                /**
                 * z : 0
                 * y : 0
                 * x : 0
                 */

                private int z;
                private int y;
                private int x;

                public int getZ() {
                    return z;
                }

                public void setZ(int z) {
                    this.z = z;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LinearBean {
                /**
                 * z : 0
                 * y : 0
                 * x : 0
                 */

                private int z;
                private int y;
                private int x;

                public int getZ() {
                    return z;
                }

                public void setZ(int z) {
                    this.z = z;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }
        }
    }

    public static class PoseBeanX {
        /**
         * covariance : [0.1,0,0,0,0,0,0,0.1,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,1.7976931348623157E308,0,0,0,0,0,0,0.2]
         * pose : {"position":{"z":0,"y":-0.16137039724419636,"x":0.001470031525333453},"orientation":{"w":-0.08271030624895466,"z":-0.9965736326234024,"y":"-0","x":0}}
         */

        private PoseBean pose;
        private List<Double> covariance;

        public PoseBean getPose() {
            return pose;
        }

        public void setPose(PoseBean pose) {
            this.pose = pose;
        }

        public List<Double> getCovariance() {
            return covariance;
        }

        public void setCovariance(List<Double> covariance) {
            this.covariance = covariance;
        }

        public static class PoseBean {
            /**
             * position : {"z":0,"y":-0.16137039724419636,"x":0.001470031525333453}
             * orientation : {"w":-0.08271030624895466,"z":-0.9965736326234024,"y":"-0","x":0}
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
                 * z : 0
                 * y : -0.16137039724419636
                 * x : 0.001470031525333453
                 */

                private int z;
                private double y;
                private double x;

                public int getZ() {
                    return z;
                }

                public void setZ(int z) {
                    this.z = z;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class OrientationBean {
                /**
                 * w : -0.08271030624895466
                 * z : -0.9965736326234024
                 * y : -0
                 * x : 0
                 */

                private double w;
                private double z;
                private String y;
                private int x;

                public double getW() {
                    return w;
                }

                public void setW(double w) {
                    this.w = w;
                }

                public double getZ() {
                    return z;
                }

                public void setZ(double z) {
                    this.z = z;
                }

                public String getY() {
                    return y;
                }

                public void setY(String y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }
        }
    }

    public static class HeaderBean {
        /**
         * seq : 69712
         * stamp : {"secs":1506650141,"nsecs":455670567}
         * frame_id : odom
         */

        private int seq;
        private StampBean stamp;
        private String frame_id;

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
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

        public void setFrame_id(String frame_id) {
            this.frame_id = frame_id;
        }

        public static class StampBean {
            /**
             * secs : 1506650141
             * nsecs : 455670567
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

//
//    {
//        "twist": {
//        "twist": {
//            "angular": {
//                "z": 0,
//                        "y": 0,
//                        "x": 0
//            },
//            "linear": {
//                "z": 0,
//                        "y": 0,
//                        "x": 0
//            }
//        },
//        "covariance": [
//        0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0
//        ]
//    },
//        "child_frame_id": "base_footprint",
//            "pose": {
//        "covariance": [
//        0.1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0.1,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                1.7976931348623157E308,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                1.7976931348623157E308,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                1.7976931348623157E308,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0,
//                0.2
//        ],
//        "pose": {
//            "position": {
//                "z": 0,
//                        "y": -0.16137039724419636,
//                        "x": 0.001470031525333453
//            },
//            "orientation": {
//                "w": -0.08271030624895466,
//                        "z": -0.9965736326234024,
//                        "y": -0,
//                        "x": 0
//            }
//        }
//    },
//        "header": {
//        "seq": 69712,
//                "stamp": {
//            "secs": 1506650141,
//                    "nsecs": 455670567
//        },
//        "frame_id": "odom"
//    }
//    }
}
