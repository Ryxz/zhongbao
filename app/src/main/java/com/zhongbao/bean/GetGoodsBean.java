package com.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class GetGoodsBean {

    private String name;
    private String adress;
    private int changeType;
    private int wuliuType;

    @Override
    public String toString() {
        return "GetGoodsBean{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", changeType=" + changeType +
                ", wuliuType=" + wuliuType +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getChangeType() {
        return changeType;
    }

    public void setChangeType(int changeType) {
        this.changeType = changeType;
    }

    public int getWuliuType() {
        return wuliuType;
    }

    public void setWuliuType(int wuliuType) {
        this.wuliuType = wuliuType;
    }
}
