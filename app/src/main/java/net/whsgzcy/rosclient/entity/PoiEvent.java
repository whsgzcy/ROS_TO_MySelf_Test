package net.whsgzcy.rosclient.entity;

import com.jilk.ros.rosbridge.operation.Operation;

/**
 * Created by super_yu on 2017/9/29.
 */

public class PoiEvent {

    public String msg;
    public String id;
    public String name;
    public String op;

    public PoiEvent(Operation operation, String name, String content) {
        if (operation != null) {
            id = operation.id;
            op = operation.op;
        }
        this.name = name;
        msg = content;
    }
}
