package com.zhongbao.zhongbao.base.http;



import android.support.annotation.Nullable;

import com.zhongbao.zhongbao.bean.AdressBean;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.GoodsDetailBean;
import com.zhongbao.zhongbao.bean.HomeBean;
import com.zhongbao.zhongbao.bean.TypeBean;
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

    /**
     * 手机号验证码登录
     * @param mobile
     * @param verify
     * @return
     */
    @FormUrlEncoded
    @POST("/api/login/phone_login")
    Observable<BasicModel> phone_login(@Field("mobile") String mobile,@Field("verify") String verify);


    /**
     * 找回密码
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api/login/find_password")
    Observable<BasicModel> find_password(@FieldMap Map<String,String> map);


    /**
     * 个人资料
     * @param uid
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/person_info/")
    Observable<BasicModel<UserInfoModel>> person_info(@Field("uid") String uid);



    /**
     * 我的收获地址
     * @param uid
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/my_addr")
    Observable<BasicModel<List<AdressBean>>> my_addr(@Field("uid") String uid);


    /**
     * 添加收货地址
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/add_address")
    Observable<BasicModel> add_address(@FieldMap Map<String,String> map);


    /**
     * 首页
     * @param map
     * @return
     */
    @GET("/home/api/index")
    Observable<BasicModel<HomeBean>> index(@QueryMap Map<String,String> map);


    /**
     * 商品列表
     * @return
     */
    @GET("/home/api/goodstype")
    Observable<BasicModel<List<TypeBean>>> goodstype();


    /**
     * 商品限购专区
     * @param is_xiangou
     * @return
     */
    @GET("/home/api/xiangougoods")
    Observable<BasicModel<List<GoodsDetailBean>>> xiangougoods(@Query("is_xiangou") String is_xiangou);
}
