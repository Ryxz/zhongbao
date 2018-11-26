package com.zhongbao.zhongbao.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class AdressBean implements Parcelable{

    /**
     * id : 19
     * uid : 9
     * address : 南京市
     * mobile : 15802207394
     * realname : me
     */

    private int id;
    private int uid;
    private String address;
    private String mobile;
    private String realname;
    /**
     * is_default : 1
     */

    private int is_default;

    protected AdressBean(Parcel in) {
        id = in.readInt();
        uid = in.readInt();
        address = in.readString();
        mobile = in.readString();
        realname = in.readString();
        is_default = in.readInt();
    }

    public static final Creator<AdressBean> CREATOR = new Creator<AdressBean>() {
        @Override
        public AdressBean createFromParcel(Parcel in) {
            return new AdressBean(in);
        }

        @Override
        public AdressBean[] newArray(int size) {
            return new AdressBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(uid);
        dest.writeString(address);
        dest.writeString(mobile);
        dest.writeString(realname);
        dest.writeInt(is_default);
    }
}
