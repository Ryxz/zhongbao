package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class SystemNewsBean {
    private String name;
    private boolean isShow;
    private String time;
    private String newsContent;

    @Override
    public String toString() {
        return "SystemNewsBean{" +
                "name='" + name + '\'' +
                ", isShow=" + isShow +
                ", time='" + time + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
