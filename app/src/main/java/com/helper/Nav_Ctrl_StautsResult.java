package com.helper;

/**
 * Created by super_yu on 26/10/2017.
 */

public class Nav_Ctrl_StautsResult {

    /**
     * status : 1
     * waypoint_name : map_6_A_601
     * status_desc : Navigating to way point.
     */

    private int status;
    private String waypoint_name;
    private String status_desc;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWaypoint_name() {
        return waypoint_name;
    }

    public void setWaypoint_name(String waypoint_name) {
        this.waypoint_name = waypoint_name;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }
}
