package com.zhongbao.zhongbao.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.dialog.LoadingDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseSubscriber<T> implements Observer<T> {

    private static final String TAG = "BaseSubscriber";
    LoadingDialog mDialog;
    private Object target;

    public BaseSubscriber(Context context) {
        mDialog = new LoadingDialog(context);
        mDialog.show();
    }

    public BaseSubscriber(Object context, boolean needDialog) {
        target = context;
        if (needDialog) {
            if (context instanceof Fragment) {
                mDialog = new LoadingDialog(((Fragment) context).getContext());
            } else if (context instanceof Activity) {
                mDialog = new LoadingDialog((Context) context);
            }
            mDialog.show();
        }
    }

    public BaseSubscriber() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        if (target != null) {
//            if (target instanceof BaseListFragment) {
//                ((BaseListFragment) target).onRefreshComplete();
//            } else if (target instanceof BaseMultiTypeListFragment) {
//                ((BaseMultiTypeListFragment) target).onRefreshComplete();
//            } else if (target instanceof BaseLazyLoadListFragment) {
//                ((BaseLazyLoadListFragment) target).onRefreshComplete();
//            }
        }

        if (mDialog != null) {
            mDialog.dismiss();
        }
        if (t != null && t instanceof BasicModel) {
            if (!((BasicModel) t).getCode().equals("200")) {
                onResultError(((BasicModel) t).getCode(), ((BasicModel) t).getMessage());
                return;
            }
        }
        onDoNext(t);
    }

    protected void onResultError(String code, String msg) {
        Toast.makeText(ZBApp.get(), msg, Toast.LENGTH_SHORT).show();
    }

    protected abstract void onDoNext(T t);

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.e(TAG, String.valueOf(e));
//        if (target != null && target instanceof BaseListFragment) {
//            ((BaseListFragment) target).onRefreshComplete();
//        } else if (target instanceof BaseMultiTypeListFragment) {
//            ((BaseMultiTypeListFragment) target).onRefreshComplete();
//        }
        if (mDialog != null) {
            mDialog.dismiss();
        }
        Toast.makeText(ZBApp.get(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
