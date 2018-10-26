package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class MyBaskBean {
    private String name;
    private String introduce;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyBaskBean{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
