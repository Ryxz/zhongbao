package com.zhongbao.zhongbao.base.http;

import android.util.Log;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;
import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.bean.GoodCommonDetailModel;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private final String BASE_URL = "http://39.98.62.92";
    //    "http://47.97.211.84/index.php?c=ios&a=shopping_member_index"
    private final int TIMEOUT = 20;
    private static HttpManager instance;
    private HttpService mHttpService;
    private static final String TAG = "HttpManager";

    public static HttpManager get() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null)
                    instance = new HttpManager();
            }
        }
        return instance;
    }

    private String cookie = null;

    private HttpManager() {
        Gson mGson = new GsonBuilder().registerTypeAdapter(GoodCommonDetailModel.Bijia.class, new TypeAdapter<GoodCommonDetailModel.Bijia>() {


            @Override
            public void write(JsonWriter out, GoodCommonDetailModel.Bijia value) throws IOException {

            }

            @Override
            public GoodCommonDetailModel.Bijia read(JsonReader in) throws IOException {
                JsonToken token = in.peek();
                if (token.name().equals("STRING")) {
                    in.nextString();
                    return null;
                }
                GoodCommonDetailModel.Bijia bijia = null;
                try {
                    in.beginObject();
                    bijia = new GoodCommonDetailModel.Bijia();
                    while (in.hasNext()) {
                        String fieldName = in.nextName();
                        Field field = bijia.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        field.set(bijia, in.nextString());
                    }
                } catch (Exception e) {
                    Log.e(TAG, String.valueOf(e));
                }
                in.endObject();
                return bijia;
            }
        }).create();

        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(ZBApp.get()));
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                // 添加通用的Header
                .addInterceptor(new LogInterceptor()).connectTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS).build();
        mHttpService = new Retrofit.Builder().baseUrl(BASE_URL)  // 添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create(mGson))
                // 添加Retrofit到RxJava的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
                .create(HttpService.class);
    }


    public HttpService getHttpService() {
        return mHttpService;
    }
}
