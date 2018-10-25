package com.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/15.
 */

public class SearchBean {
    private String name;
    private int type;

    @Override
    public String toString() {
        return "SearchBean{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
