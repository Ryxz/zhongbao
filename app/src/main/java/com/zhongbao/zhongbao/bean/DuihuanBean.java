package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class DuihuanBean {

    private int ResId;
    private int type;

    @Override
    public String toString() {
        return "DuihuanBean{" +
                "ResId=" + ResId +
                ", type=" + type +
                '}';
    }

    public int getResId() {
        return ResId;
    }

    public void setResId(int resId) {
        ResId = resId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
