package com.zhongbao.zhongbao.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class UserInfoModel {

    /**
     * id : 11
     * mobile : 15802207394
     * nickname : 1539572GI625
     * register_time : 1539572625
     * sign_id : 780820
     */
    @Id
    long id;
    private String mobile;
    private String nickname;
    private String register_time;
    private int sign_id;
    /**
     * uid : 21
     */

    private String uid;
    /**
     * avatar :
     * sex : 1
     * birthday : 2000-1-1
     */

    private String avatar;
    private String sex;
    private String birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public int getSign_id() {
        return sign_id;
    }

    public void setSign_id(int sign_id) {
        this.sign_id = sign_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
