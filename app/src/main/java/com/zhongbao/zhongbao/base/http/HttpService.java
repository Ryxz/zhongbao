package com.zhongbao.zhongbao.base.http;



import android.support.annotation.Nullable;

import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.UserInfoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface HttpService {
    String IP = "http://39.98.62.92";


    /**
     * 用户注册
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api/register/index")
    Observable<BasicModel<UserInfoModel>> register(@FieldMap Map<String,String> map);


    /**
     *  发送验证码
     * @param user_phone
     * @return
     */
    @FormUrlEncoded
    @POST("/api/register/backcode")
    Observable<BasicModel> backcode(@Field("user_phone") String user_phone);


    /**
     * 用户名密码登陆
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("api/login/login")
    Observable<BasicModel> login(@Field("username") String username,@Field("password") String password);
}
