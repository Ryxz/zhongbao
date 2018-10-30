package com.zhongbao.zhongbao;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.zhongbao.zhongbao.utils.StatusBarUtil;
import com.zhongbao.zhongbao.utils.Util;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public abstract class BaseActivity extends FragmentActivity{

    protected BaseActivity act;

    protected final String TAG=getClass().getSimpleName();

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        act=this;
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
        initData();
        initListener();
    }
    @LayoutRes
    protected abstract int getLayoutID();
    protected abstract void initListener();
    protected abstract void initView();
    protected abstract void initData();
    @SuppressWarnings("unchecked")
    protected <E> E f(int id){
        return (E)findViewById(id);
    }

    /**
     * 设置不需要设置状态栏的颜色
     *
     * 是否设置StatusBar的颜色，绝大部分是要设置的，特殊的不需要设置，例如一个Activity中有多个Fragment的
     * Activity，多个Fragment的状态栏颜色可能不相同，那就只好交给Fragment自己去设置。遇到这样的Activity
     * 需要返回false
     */
    protected void notSetStatusBarColor() {
        StatusBarUtil.setStatusBarTranslucent(this);
    }

    public void showProgress(String log){
        if (!Util.isEmpty(log)) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(log);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }

    public void hideProgress(){
        if (null != progressDialog) {
            progressDialog.dismiss();
        }
    }




}
