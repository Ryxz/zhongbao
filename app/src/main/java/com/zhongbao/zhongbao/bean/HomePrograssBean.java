package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class HomePrograssBean {
    private String name;
    private String jindu;
    private String state;
    private int ImageResId;

    @Override
    public String toString() {
        return "HomePrograssBean{" +
                "name='" + name + '\'' +
                ", jindu='" + jindu + '\'' +
                ", state='" + state + '\'' +
                ", ImageResId=" + ImageResId +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJindu() {
        return jindu;
    }

    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public int getImageResId() {
        return ImageResId;
    }

    public void setImageResId(int imageResId) {
        ImageResId = imageResId;
    }
}
