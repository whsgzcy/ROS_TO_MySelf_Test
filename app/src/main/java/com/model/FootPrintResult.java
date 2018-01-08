package com.model;

import java.util.List;

/**
 * Created by super_yu on 2018/1/8.
 */

public class FootPrintResult {
    /**
     * header : {"seq":4297,"frame_id":"odom","stamp":{"secs":1515378187,"nsecs":125325857}}
     * polygon : {"points":[{"z":0,"x":0.31369608640670776,"y":-0.5355392694473267},{"z":0,"x":0.35115259885787964,"y":-0.016890067607164383},{"z":0,"x":-0.30713292956352234,"y":0.03065088950097561},{"z":0,"x":-0.3445894420146942,"y":-0.4879983365535736}]}
     */

    private HeaderBean header;
    private PolygonBean polygon;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public PolygonBean getPolygon() {
        return polygon;
    }

    public void setPolygon(PolygonBean polygon) {
        this.polygon = polygon;
    }

    public static class HeaderBean {
        /**
         * seq : 4297
         * frame_id : odom
         * stamp : {"secs":1515378187,"nsecs":125325857}
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
             * secs : 1515378187
             * nsecs : 125325857
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

    public static class PolygonBean {
        private List<PointsBean> points;

        public List<PointsBean> getPoints() {
            return points;
        }

        public void setPoints(List<PointsBean> points) {
            this.points = points;
        }

        public static class PointsBean {
            /**
             * z : 0
             * x : 0.31369608640670776
             * y : -0.5355392694473267
             */

            private int z;
            private double x;
            private double y;

            public int getZ() {
                return z;
            }

            public void setZ(int z) {
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

//    {
//        "header": {
//        "seq": 4297,
//                "frame_id": "odom",
//                "stamp": {
//            "secs": 1515378187,
//                    "nsecs": 125325857
//        }
//    },
//        "polygon": {
//        "points": [
//        {
//            "z": 0,
//                "x": 0.31369608640670776,
//                "y": -0.5355392694473267
//        },
//        {
//            "z": 0,
//                "x": 0.35115259885787964,
//                "y": -0.016890067607164383
//        },
//        {
//            "z": 0,
//                "x": -0.30713292956352234,
//                "y": 0.03065088950097561
//        },
//        {
//            "z": 0,
//                "x": -0.3445894420146942,
//                "y": -0.4879983365535736
//        }
//        ]
//    }
//    }
}
