package com.zhongbao.zhongbao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.zhongbao.zhongbao.bean.MyObjectBox;
import com.zhongbao.zhongbao.bean.UserInfoModel;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

import static android.content.Context.MODE_PRIVATE;

public class ZBApp extends MultiDexApplication {

    private static ZBApp mApp;
    private String userId;
    private SharedPreferences mPreferences;
    private Boolean isFirst;
    private UserInfoModel mUserInfoModel;
    private BoxStore mBoxStore;

    @NonNull
    public BoxStore getBoxStore() {
        return mBoxStore;
    }

    public static ZBApp get() {
        return mApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mPreferences = getSharedPreferences("Nantang", MODE_PRIVATE);
        mApp = this;
        mBoxStore = MyObjectBox.builder().androidContext(this).build();
        Box<UserInfoModel> userInfoModelBox = mBoxStore.boxFor(UserInfoModel.class);
        List<UserInfoModel> users = userInfoModelBox.getAll();
        if (users != null && users.size() > 0) {
            setUserInfoModel(users.get(0));
        }
    }

    public String getUserId() {
//        if (getUserInfoModel() == null) {
//            Intent intent = new Intent(this, MsgLoginActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            return "";
//        }
        return getUserInfoModel().getUid();
    }

//
    public UserInfoModel getUserInfoModel() {
        return mUserInfoModel;
    }

    public void setUserInfoModel(UserInfoModel userInfoModel) {
        Box<UserInfoModel> userInfoModelBox = mBoxStore.boxFor(UserInfoModel.class);
        if (userInfoModel == null && mUserInfoModel != null) {
            userInfoModelBox.remove(mUserInfoModel.getId());
            mUserInfoModel = null;
            return;
        }
        mUserInfoModel = userInfoModel;
    }

//    public boolean isLogin() {
//        return mUserInfoModel != null;
//    }

//    /**
//     * 是否已登录，未登录直接跳登录界面。
//     *
//     * @return
//     */
//    public boolean checkLogin() {
//        return !TextUtils.isEmpty(getUserId());
//    }

    public SharedPreferences getSp() {
        return mPreferences;
    }

//    AMapLocation mAMapLocation;
//
//    public AMapLocation getAMapLocation() {
//        return mAMapLocation;
//    }
//
//    public void setAMapLocation(AMapLocation AMapLocation) {
//        mAMapLocation = AMapLocation;
//    }
//
//    public String getLat() {
//        if (getAMapLocation() == null)
//            return "0";
//        return String.valueOf(getAMapLocation().getLatitude());
//    }
//
//    public String getLng() {
//        if (getAMapLocation() == null)
//            return "0";
//        return String.valueOf(getAMapLocation().getLongitude());
//    }
}
