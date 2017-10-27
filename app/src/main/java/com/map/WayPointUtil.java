package com.map;

import java.util.List;

/**
 * Created by super_yu on 27/10/2017.
 */

public class WayPointUtil {


    private List<WaypointsBean> waypoints;

    public List<WaypointsBean> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<WaypointsBean> waypoints) {
        this.waypoints = waypoints;
    }

    public static class WaypointsBean {
        /**
         * goal_timeout : 0
         * name : pose_6_A_O
         * header : {"seq":0,"frame_id":"initial_pose","stamp":{"secs":0,"nsecs":0}}
         * close_enough : 0
         * failure_mode : NONE
         * pose : {"orientation":{"z":-0.0109401,"x":0.00157974,"w":0.999927,"y":-0.00481363},"position":{"z":0.00984454,"x":-0.0483838,"y":-0.00480753}}
         */

        private int goal_timeout;
        private String name;
        private HeaderBean header;
        private int close_enough;
        private String failure_mode;
        private PoseBean pose;

        public int getGoal_timeout() {
            return goal_timeout;
        }

        public void setGoal_timeout(int goal_timeout) {
            this.goal_timeout = goal_timeout;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getClose_enough() {
            return close_enough;
        }

        public void setClose_enough(int close_enough) {
            this.close_enough = close_enough;
        }

        public String getFailure_mode() {
            return failure_mode;
        }

        public void setFailure_mode(String failure_mode) {
            this.failure_mode = failure_mode;
        }

        public PoseBean getPose() {
            return pose;
        }

        public void setPose(PoseBean pose) {
            this.pose = pose;
        }

        public static class HeaderBean {
            /**
             * seq : 0
             * frame_id : initial_pose
             * stamp : {"secs":0,"nsecs":0}
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
                 * secs : 0
                 * nsecs : 0
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

        public static class PoseBean {
            /**
             * orientation : {"z":-0.0109401,"x":0.00157974,"w":0.999927,"y":-0.00481363}
             * position : {"z":0.00984454,"x":-0.0483838,"y":-0.00480753}
             */

            private OrientationBean orientation;
            private PositionBean position;

            public OrientationBean getOrientation() {
                return orientation;
            }

            public void setOrientation(OrientationBean orientation) {
                this.orientation = orientation;
            }

            public PositionBean getPosition() {
                return position;
            }

            public void setPosition(PositionBean position) {
                this.position = position;
            }

            public static class OrientationBean {
                /**
                 * z : -0.0109401
                 * x : 0.00157974
                 * w : 0.999927
                 * y : -0.00481363
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

            public static class PositionBean {
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
//        "waypoints": [
//        {
//            "goal_timeout": 0,
//                "name": "pose_6_A_O",
//                "header": {
//            "seq": 0,
//                    "frame_id": "initial_pose",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "NONE",
//                "pose": {
//            "orientation": {
//                "z": -0.0109401,
//                        "x": 0.00157974,
//                        "w": 0.999927,
//                        "y": -0.00481363
//            },
//            "position": {
//                "z": 0.00984454,
//                        "x": -0.0483838,
//                        "y": -0.00480753
//            }
//        }
//        },
//        {
//            "goal_timeout": 0,
//                "name": "map_6_A_601",
//                "header": {
//            "seq": 0,
//                    "frame_id": "map",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "LOOP",
//                "pose": {
//            "orientation": {
//                "z": -0.688561,
//                        "x": 0.00455891,
//                        "w": 0.72508,
//                        "y": 0.0110448
//            },
//            "position": {
//                "z": 0.000296803,
//                        "x": -5.56034,
//                        "y": 0.543951
//            }
//        }
//        },
//        {
//            "goal_timeout": 0,
//                "name": "map_6_A_602",
//                "header": {
//            "seq": 0,
//                    "frame_id": "map",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "NONE",
//                "pose": {
//            "orientation": {
//                "z": 0.697559,
//                        "x": -0.00366306,
//                        "w": 0.716504,
//                        "y": 0.00436201
//            },
//            "position": {
//                "z": 0.0000223732,
//                        "x": -3.68783,
//                        "y": 0.333907
//            }
//        }
//        },
//        {
//            "goal_timeout": 0,
//                "name": "map_6_A_603",
//                "header": {
//            "seq": 0,
//                    "frame_id": "map",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "NONE",
//                "pose": {
//            "orientation": {
//                "z": 0.99902,
//                        "x": 0.00286313,
//                        "w": 0.0435695,
//                        "y": 0.00730277
//            },
//            "position": {
//                "z": 0.0000444777,
//                        "x": -1.4135,
//                        "y": 0.231864
//            }
//        }
//        },
//        {
//            "goal_timeout": 0,
//                "name": "map_6_B_604",
//                "header": {
//            "seq": 0,
//                    "frame_id": "map",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "NONE",
//                "pose": {
//            "orientation": {
//                "z": -0.695688,
//                        "x": 0.000728705,
//                        "w": 0.71834,
//                        "y": 0.00213251
//            },
//            "position": {
//                "z": 0.00229645,
//                        "x": -1.77529,
//                        "y": -1.6051
//            }
//        }
//        },
//        {
//            "goal_timeout": 0,
//                "name": "map_6_B_605",
//                "header": {
//            "seq": 0,
//                    "frame_id": "map",
//                    "stamp": {
//                "secs": 0,
//                        "nsecs": 0
//            }
//        },
//            "close_enough": 0,
//                "failure_mode": "NONE",
//                "pose": {
//            "orientation": {
//                "z": 0.0340926,
//                        "x": -0.00587309,
//                        "w": 0.999379,
//                        "y": 0.00665722
//            },
//            "position": {
//                "z": 0.000426643,
//                        "x": -0.215954,
//                        "y": -7.3912
//            }
//        }
//        }
//    ]
//    }
}
