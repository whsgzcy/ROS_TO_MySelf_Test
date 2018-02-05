package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super_yu on 2018/2/5.
 */

public class InitPoseResult {

    /**
     * op : publish
     * topic : /initialpose
     * msg : {"header":{"frame_id":"map"},"pose":{"pose":{"position":{"x":0,"y":0,"z":0},"orientation":{"x":0,"y":0,"z":0,"w":1}},"covariance":[0.25,0,0,0,0,0,0,0.25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.06853891945200942]}}
     */

    private String op = "publish";
    private String topic = "/initialpose";
    private MsgBean msg;


    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * header : {"frame_id":"map"}
         * pose : {"pose":{"position":{"x":0,"y":0,"z":0},"orientation":{"x":0,"y":0,"z":0,"w":1}},"covariance":[0.25,0,0,0,0,0,0,0.25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.06853891945200942]}
         */

        private HeaderBean header;
        private PoseBeanX pose;

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public PoseBeanX getPose() {
            return pose;
        }

        public void setPose(PoseBeanX pose) {
            this.pose = pose;
        }

        public static class HeaderBean {
            /**
             * frame_id : map
             */

            private String frame_id = "map";
        }

        public static class PoseBeanX {
            /**
             * pose : {"position":{"x":0,"y":0,"z":0},"orientation":{"x":0,"y":0,"z":0,"w":1}}
             * covariance : [0.25,0,0,0,0,0,0,0.25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.06853891945200942]
             */

            private PoseBean pose;
            private List<Double> covariance;

            public PoseBean getPose() {
                return pose;
            }

            public void setPose(PoseBean pose) {
                this.pose = pose;
            }

            public void setCovariance() {
                covariance = new ArrayList<Double>();
                Double[] d = new Double[36];
                for (int i = 0; i < 36; i++) {
                    covariance.add(d[i]);
                }
            }

            public static class PoseBean {
                /**
                 * position : {"x":0,"y":0,"z":0}
                 * orientation : {"x":0,"y":0,"z":0,"w":1}
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
                     * x : 0
                     * y : 0
                     * z : 0
                     */

                    private int x;
                    private int y;
                    private int z;

                    public int getX() {
                        return x;
                    }

                    public void setX(int x) {
                        this.x = x;
                    }

                    public int getY() {
                        return y;
                    }

                    public void setY(int y) {
                        this.y = y;
                    }

                    public int getZ() {
                        return z;
                    }

                    public void setZ(int z) {
                        this.z = z;
                    }
                }

                public static class OrientationBean {
                    /**
                     * x : 0
                     * y : 0
                     * z : 0
                     * w : 1
                     */

                    private int x;
                    private int y;
                    private int z;
                    private int w;

                    public int getX() {
                        return x;
                    }

                    public void setX(int x) {
                        this.x = x;
                    }

                    public int getY() {
                        return y;
                    }

                    public void setY(int y) {
                        this.y = y;
                    }

                    public int getZ() {
                        return z;
                    }

                    public void setZ(int z) {
                        this.z = z;
                    }

                    public int getW() {
                        return w;
                    }

                    public void setW(int w) {
                        this.w = w;
                    }
                }
            }
        }
    }


//    {
//        "op": "publish",
//            "topic": "/initialpose",
//            "msg": {
//        "header": {
//            "frame_id": "map"
//        },
//        "pose": {
//            "pose": {
//                "position": {
//                    "x": 0,
//                            "y": 0,
//                            "z": 0
//                },
//                "orientation": {
//                    "x": 0,
//                            "y": 0,
//                            "z": 0,
//                            "w": 1
//                }
//            },
//            "covariance": [
//            0.25,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0.25,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0,
//                    0.06853891945200942
//            ]
//        }
//    }
//    }
}
