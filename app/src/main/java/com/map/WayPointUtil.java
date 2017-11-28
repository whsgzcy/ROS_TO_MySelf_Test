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

    /**
     * {
     "waypoints": [
     {
     "goal_timeout": 0,
     "name": "pose_charge",
     "header": {
     "seq": 0,
     "frame_id": "initial_pose",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0.0000672817,
     "x": 0.00212954,
     "w": 0.999965,
     "y": 0.00806749
     },
     "position": {
     "z": -0.0000111391,
     "x": 0.0140563,
     "y": -0.00219822
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "map_dockBegin",
     "header": {
     "seq": 0,
     "frame_id": "map",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0.0000672817,
     "x": 0.00212954,
     "w": 0.999965,
     "y": 0.00806749
     },
     "position": {
     "z": -0.0000111391,
     "x": -0.335944,
     "y": -0.00224531
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pubsuber_charge_adjust",
     "header": {
     "seq": 0,
     "frame_id": "pubsuber",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "charge_adjust_done",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pubsuber_auto_charge",
     "header": {
     "seq": 0,
     "frame_id": "pubsuber",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "3",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "vel_forward",
     "header": {
     "seq": 0,
     "frame_id": "cmd_vel",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.05000000074505806,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "vel_stop",
     "header": {
     "seq": 0,
     "frame_id": "cmd_vel",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "vel_backward",
     "header": {
     "seq": 0,
     "frame_id": "cmd_vel",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": -0.05000000074505806,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_bumper_on",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_bumper_off",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_estop_on",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_estop_off",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_estop_auto",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_light_r",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_light_g",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_light_b",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "pub_light_y",
     "header": {
     "seq": 0,
     "frame_id": "publisher",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "sound_sound_on",
     "header": {
     "seq": 0,
     "frame_id": "sound_play",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "START",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "sound_sound_off",
     "header": {
     "seq": 0,
     "frame_id": "sound_play",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "STOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "sound_sound_play_once",
     "header": {
     "seq": 0,
     "frame_id": "sound_play",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "ONCE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_9",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.8999999761581421,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_8",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.800000011920929,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_7",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.699999988079071,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_6",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.6000000238418579,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_5",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.5,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_scan_4",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0.4000000059604645,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 6,
     "name": "timer_sail",
     "header": {
     "seq": 0,
     "frame_id": "timer",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "NONE",
     "pose": {
     "orientation": {
     "z": 0,
     "x": 0,
     "w": 1,
     "y": 0
     },
     "position": {
     "z": 0,
     "x": 0,
     "y": 0
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "map_6_A_601",
     "header": {
     "seq": 0,
     "frame_id": "map",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": -0.710356,
     "x": 0.00568841,
     "w": 0.70382,
     "y": 0.000206077
     },
     "position": {
     "z": 0.0000268415,
     "x": -5.43955,
     "y": 0.441982
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "scanMarker_6_A_O",
     "header": {
     "seq": 0,
     "frame_id": "scan_marker",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": -0.00584617,
     "x": 0.00134079,
     "w": 0.999976,
     "y": -0.00348327
     },
     "position": {
     "z": 0.0095544,
     "x": -0.00660459,
     "y": -0.0187305
     }
     }
     },
     {
     "goal_timeout": 0,
     "name": "map_6_A_602",
     "header": {
     "seq": 0,
     "frame_id": "map",
     "stamp": {
     "secs": 0,
     "nsecs": 0
     }
     },
     "close_enough": 0,
     "failure_mode": "LOOP",
     "pose": {
     "orientation": {
     "z": 0.673475,
     "x": 0.00818346,
     "w": 0.739164,
     "y": 0.00151504
     },
     "position": {
     "z": 0.000584151,
     "x": -2.65592,
     "y": 0.365388
     }
     }
     }
     ]
     }
     */
}
