package com.map;

import java.util.List;

/**
 * Created by super_yu on 27/10/2017.
 */

public class WayPointUtil {

    /**
     * goal_timeout : 0
     * name : pose_charge
     * header : {"seq":0,"frame_id":"initial_pose","stamp":{"secs":0,"nsecs":0}}
     * close_enough : 0
     * failure_mode : LOOP
     * pose : {"orientation":{"z":6.72817E-5,"x":0.00212954,"w":0.999965,"y":0.00806749},"position":{"z":-1.11391E-5,"x":0.0140563,"y":-0.00219822}}
     */

    private List<WaypointsBean> waypoints;

    public List<WaypointsBean> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<WaypointsBean> waypoints) {
        this.waypoints = waypoints;
    }

    public static class WaypointsBean {
        private int goal_timeout;
        private String name;
        /**
         * seq : 0
         * frame_id : initial_pose
         * stamp : {"secs":0,"nsecs":0}
         */

        private HeaderBean header;
        private double close_enough;
        private String failure_mode;
        /**
         * orientation : {"z":6.72817E-5,"x":0.00212954,"w":0.999965,"y":0.00806749}
         * position : {"z":-1.11391E-5,"x":0.0140563,"y":-0.00219822}
         */

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

        public double getClose_enough() {
            return close_enough;
        }

        public void setClose_enough(double close_enough) {
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
            private int seq;
            private String frame_id;
            /**
             * secs : 0
             * nsecs : 0
             */

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
             * z : 6.72817E-5
             * x : 0.00212954
             * w : 0.999965
             * y : 0.00806749
             */

            private OrientationBean orientation;
            /**
             * z : -1.11391E-5
             * x : 0.0140563
             * y : -0.00219822
             */

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
}
