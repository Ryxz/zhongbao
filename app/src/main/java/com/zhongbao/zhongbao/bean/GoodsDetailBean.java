package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class GoodsDetailBean {

    private String name;
    private String userId;
    private String time;
    private String ipId;
    private String goldNum;
    private String joinNum;

    @Override
    public String toString() {
        return "GoodsDetailBean{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", time='" + time + '\'' +
                ", ipId='" + ipId + '\'' +
                ", goldNum='" + goldNum + '\'' +
                ", joinNum='" + joinNum + '\'' +
                '}';
    }

    public String getIpId() {
        return ipId;
    }

    public void setIpId(String ipId) {
        this.ipId = ipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(String goldNum) {
        this.goldNum = goldNum;
    }

    public String getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(String joinNum) {
        this.joinNum = joinNum;
    }
}
