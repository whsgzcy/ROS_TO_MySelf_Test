package com.helper;

import com.google.gson.Gson;

/**
 * Created by super_yu on 26/10/2017.
 */

public class NavHelper {

    /**
     * 获取导航状态
     *
     * @return cmd
     */
    public static String getNavStatus() {
        Nav_Ctrl_StatusUtil navCtrlStatusUtil = new Nav_Ctrl_StatusUtil();
        navCtrlStatusUtil.setOp("subscribe");
        navCtrlStatusUtil.setTopic("/nav_ctrl_status");
        String json = new Gson().toJson(navCtrlStatusUtil);
        return json;
    }
}
