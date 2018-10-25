package com.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/14.
 */

public class LatestBean {
    private String name;
    private String price;
    private String person;
    private String time;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LatestBean{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", person='" + person + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
