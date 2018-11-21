package com.zhongbao.zhongbao;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

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
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zhongbao.zhongbao.base.http.HttpManager;
import com.zhongbao.zhongbao.base.http.HttpService;
import com.zhongbao.zhongbao.utils.StatusBarUtil;
import com.zhongbao.zhongbao.utils.Util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    protected BaseActivity act;

    protected final String TAG = getClass().getSimpleName();

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
//        Window window = act.getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Window window = act.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.bg_toolbar));
        }

        setContentView(getLayoutID());
        initView();
    }

    @LayoutRes
    protected abstract int getLayoutID();


    protected abstract void initView();


    @SuppressWarnings("unchecked")
    protected <E> E f(int id) {
        return (E) findViewById(id);
    }

    /**
     * 设置不需要设置状态栏的颜色
     * <p>
     * 是否设置StatusBar的颜色，绝大部分是要设置的，特殊的不需要设置，例如一个Activity中有多个Fragment的
     * Activity，多个Fragment的状态栏颜色可能不相同，那就只好交给Fragment自己去设置。遇到这样的Activity
     * 需要返回false
     */
    protected void notSetStatusBarColor() {
        StatusBarUtil.setStatusBarTranslucent(this);
    }

    public void showProgress(String log) {
        if (!Util.isEmpty(log)) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(log);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }

    public void hideProgress() {
        if (null != progressDialog) {
            progressDialog.dismiss();
        }
    }
    protected HttpService getHttpService() {
        return HttpManager.get().getHttpService();
    }

    public <T> ObservableTransformer<T, T> apply() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                ObservableTransformer<T, T> transformer = bindToLifecycle();
                return observable.subscribeOn(Schedulers.io()).doOnSubscribe(new io.reactivex.functions.Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (!isNetworkConnected(BaseActivity.this)) {
                            Toast.makeText(BaseActivity.this, "网络未连接，请检查网络后重试", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).compose(transformer).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public <T> ObservableTransformer<T, T> applyNoLifeCycle() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).doOnSubscribe(new io.reactivex.functions.Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (!isNetworkConnected(BaseActivity.this)) {
                            Toast.makeText(BaseActivity.this, "网络未连接，请检查网络后重试", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public String getTextStr(int id) {
        return ((TextView) findViewById(id)).getText().toString().trim();
    }
    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        boolean isConnect = false;
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            isConnect = conManager.getActiveNetworkInfo().isAvailable();
        }
        return isConnect;
    }

}
