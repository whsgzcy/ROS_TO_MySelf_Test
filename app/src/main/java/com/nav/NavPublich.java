package com.nav;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存储导航对象
 * Created by super_yu on 27/10/2017.
 */

public class NavPublich {

    private List<String> wayPointsNames;

    private HashMap<String, Move_Base_Goal> navPublishHashMap;

    public List<String> getWayPointsNames() {
        return wayPointsNames;
    }

    public void setWayPointsNames(List<String> wayPointsNames) {
        this.wayPointsNames = wayPointsNames;
    }

    public HashMap<String, Move_Base_Goal> getNavPublishHashMap() {
        return navPublishHashMap;
    }

    public void setNavPublishHashMap(HashMap<String, Move_Base_Goal> navPublishHashMap) {
        this.navPublishHashMap = navPublishHashMap;
    }
}
