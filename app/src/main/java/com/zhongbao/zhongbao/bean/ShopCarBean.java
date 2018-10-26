package com.zhongbao.zhongbao.bean;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class ShopCarBean {
    private String name;
    private String price;
    private String num;
    private int resId;
    private int checked;
    private boolean isShow;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ShopCarBean{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", resId=" + resId +
                ", checked=" + checked +
                ", isShow=" + isShow +
                '}';
    }
}
