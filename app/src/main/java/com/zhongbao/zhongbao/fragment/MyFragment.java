package com.zhongbao.zhongbao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import com.zhongbao.zhongbao.dialog.QrcodeDialog;
import com.zhongbao.zhongbao.login.LoginActivity;
import com.zhongbao.zhongbao.login.RegisterActivity;
import com.zhongbao.zhongbao.my.GetGoodsActivity;
import com.zhongbao.zhongbao.my.HelpActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.my.PayActivity;
import com.zhongbao.zhongbao.my.PersonalDataActivity;
import com.zhongbao.zhongbao.my.QrcodeActivity;
import com.zhongbao.zhongbao.my.SystemNewsActivity;
import com.zhongbao.zhongbao.my.ZbRecordActivity;
import com.zhongbao.zhongbao.view.HomePopwindow;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    private View rootView;
    private RelativeLayout mRecord, mGoods, mCamaro, mHelp, mQrcode, mCenter;
    private ImageView mNews, mType;
    private TextView mPay, register, login;
    private RelativeLayout mGuest;
    private boolean isLogin;
    private LinearLayout mLoginDetail;
    private TextView mShow;
    private QrcodeDialog qrcodeDialog;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            SharedPreferences sp = getActivity().getSharedPreferences("com.zhongbao.zhongbao.login", Activity.MODE_PRIVATE);
            isLogin = sp.getBoolean("isLogin", false);
            if (isLogin) {
                mCenter.setVisibility(View.VISIBLE);
                mLoginDetail.setVisibility(View.VISIBLE);
                mGuest.setVisibility(View.GONE);
            } else {
                mCenter.setVisibility(View.GONE);
                mLoginDetail.setVisibility(View.GONE);
                mGuest.setVisibility(View.VISIBLE);
            }
            rootView.invalidate();
            super.handleMessage(msg);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mRecord = rootView.findViewById(R.id.record_linear);
        mGoods = rootView.findViewById(R.id.goods_linear);
        mCamaro = rootView.findViewById(R.id.camaro_linear);
        mHelp = rootView.findViewById(R.id.help_linear);
        mQrcode = rootView.findViewById(R.id.qrcode_linear);

        mCenter = rootView.findViewById(R.id.mine_center);
        mNews = rootView.findViewById(R.id.mine_news_iv);
        mType = rootView.findViewById(R.id.mine_type_iv);

        mPay = rootView.findViewById(R.id.mine_go_pay);
        mGuest = rootView.findViewById(R.id.guest_rela);
        register = rootView.findViewById(R.id.register);
        mLoginDetail = rootView.findViewById(R.id.login_type);
        mShow = rootView.findViewById(R.id.show_p);
        login = rootView.findViewById(R.id.login);
        SharedPreferences sp = getActivity().getSharedPreferences("com.zhongbao.zhongbao.login", Activity.MODE_PRIVATE);
        isLogin = sp.getBoolean("isLogin", false);
        if (isLogin) {
            mCenter.setVisibility(View.VISIBLE);
            mLoginDetail.setVisibility(View.VISIBLE);
            mGuest.setVisibility(View.GONE);
        } else {
            mCenter.setVisibility(View.GONE);
            mLoginDetail.setVisibility(View.GONE);
            mGuest.setVisibility(View.VISIBLE);
        }
        qrcodeDialog = new QrcodeDialog(getContext());
        initLintener();
    }

    private void initData() {
        //此处判断是否首次进入和未登录，如果是首次进入和未登录的时候显示游客状态布局。
    }


    private void initLintener() {
        mRecord.setOnClickListener(this);
        mGoods.setOnClickListener(this);
        mCamaro.setOnClickListener(this);
        mHelp.setOnClickListener(this);
        mQrcode.setOnClickListener(this);
        mCenter.setOnClickListener(this);
        mNews.setOnClickListener(this);
        mType.setOnClickListener(this);
        mPay.setOnClickListener(this);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_center:
                startActivity(new Intent(getActivity(), PersonalDataActivity.class));
                break;
            case R.id.mine_go_pay:
                startActivity(new Intent(getActivity(), PayActivity.class));
                break;
            case R.id.help_linear:
                startActivity(new Intent(getActivity(), HelpActivity.class));
                break;
            case R.id.record_linear:
                startActivity(new Intent(getActivity(), ZbRecordActivity.class));
                break;
            case R.id.camaro_linear:
                startActivity(new Intent(getActivity(), MyBaskActivity.class));
                break;
            case R.id.goods_linear:
                startActivity(new Intent(getActivity(), GetGoodsActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                //注册
                break;
            case R.id.login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                //登录
                break;
            case R.id.qrcode_linear:
                qrcodeDialog.show();
//                startActivity(new Intent(getActivity(), QrcodeActivity.class));
                break;
            case R.id.mine_news_iv:
                startActivity(new Intent(getActivity(), SystemNewsActivity.class));
                break;
            case R.id.mine_type_iv:
                HomePopwindow pop = new HomePopwindow(getActivity());
                pop.showAsDropDown(mShow);
                break;
        }
    }

    @Override
    public void onResume() {
        mHandler.sendEmptyMessage(0);
        super.onResume();
    }
}
