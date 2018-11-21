package com.zhongbao.zhongbao.base;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxFragment;
import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.base.http.HttpManager;
import com.zhongbao.zhongbao.base.http.HttpService;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseFragment extends RxFragment {

    protected <T extends View> T findViewById(@IdRes int id) {
        return getView().findViewById(id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() > 0) {
            return inflater.inflate(getLayoutId(), container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setClickable(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mOnLoadListener != null) {
            mOnLoadListener.onLoadEnd();
            mOnLoadListener = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    protected abstract int getLayoutId();

    public BaseActivity getBaseActivity() {
        if (getActivity() == null)
            return null;
        return ((BaseActivity) getActivity());
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
                        if (!isNetworkConnected(getActivity())) {
                            Toast.makeText(getActivity(), "网络未连接，请检查网络后重试", Toast.LENGTH_SHORT).show();
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
                        if (!isNetworkConnected(getActivity())) {
                            Toast.makeText(getActivity(), "网络未连接，请检查网络后重试", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread());
            }
        };
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


    OnLoadListener mOnLoadListener;

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        mOnLoadListener = onLoadListener;
    }

    public interface OnLoadListener {
        void onLoadEnd();
    }


    public void setText(int id, String text) {
        ((TextView) findViewById(id)).setText(text);
    }

    public String getTextStr(int id) {
        return ((TextView) findViewById(id)).getText().toString().trim();
    }

    public void launch(Class clazz) {
        startActivity(new Intent(getActivity(), clazz));
    }
}
