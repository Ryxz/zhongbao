package com.zhongbao.zhongbao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.R;

import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.base.BaseFragment;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.UserInfoModel;
import com.zhongbao.zhongbao.dialog.QrcodeDialog;
import com.zhongbao.zhongbao.login.FindPsdActivity;
import com.zhongbao.zhongbao.login.LoginActivity;
import com.zhongbao.zhongbao.login.RegisterActivity;
import com.zhongbao.zhongbao.my.GetGoodsActivity;
import com.zhongbao.zhongbao.my.HelpActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.my.PayActivity;
import com.zhongbao.zhongbao.my.PersonalDataActivity;
import com.zhongbao.zhongbao.my.SystemNewsActivity;
import com.zhongbao.zhongbao.my.ZbRecordActivity;
import com.zhongbao.zhongbao.utils.PreferenceUtils;
import com.zhongbao.zhongbao.view.HomePopwindow;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout mCenter;
    private ImageView mNews, mType,mine_head;
    private TextView  register, login,tv_name;
    private RelativeLayout mGuest;
    private LinearLayout mLoginDetail;
    private TextView mShow;
    private QrcodeDialog qrcodeDialog;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        findViewById(R.id.record_linear).setOnClickListener(this);
        findViewById(R.id.goods_linear).setOnClickListener(this);
        findViewById(R.id.camaro_linear).setOnClickListener(this);
        findViewById(R.id.help_linear).setOnClickListener(this);
        findViewById(R.id.qrcode_linear).setOnClickListener(this);

        mCenter = findViewById(R.id.mine_center);
        mNews = findViewById(R.id.mine_news_iv);
        mType = findViewById(R.id.mine_type_iv);

        findViewById(R.id.mine_go_pay).setOnClickListener(this);
        mGuest = findViewById(R.id.guest_rela);
        register = findViewById(R.id.register);
        mLoginDetail = findViewById(R.id.login_type);
        mShow = findViewById(R.id.show_p);
        login = findViewById(R.id.login);
        tv_name = findViewById(R.id.tv_name);
        mine_head = findViewById(R.id.mine_head);
        qrcodeDialog = new QrcodeDialog(getContext());
        visible();
        initLintener();
    }

    public void visible(){
        if (ZBApp.get().getUserInfoModel() != null) {
            mCenter.setVisibility(View.VISIBLE);
            mLoginDetail.setVisibility(View.VISIBLE);
            mGuest.setVisibility(View.GONE);
            getUserInfo();
        } else {
            mCenter.setVisibility(View.GONE);
            mLoginDetail.setVisibility(View.GONE);
            mGuest.setVisibility(View.VISIBLE);
        }
    }


    private void initLintener() {
        mCenter.setOnClickListener(this);
        mNews.setOnClickListener(this);
        mType.setOnClickListener(this);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    public void getUserInfo(){
        getHttpService().person_info(ZBApp.get().getUserId())
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<UserInfoModel>>() {
                    @Override
                    protected void onDoNext(BasicModel<UserInfoModel> basicModel) {
                        tv_name.setText(basicModel.getData().getNickname());
                        if (!basicModel.getCode().equals("200")){
                            Toast.makeText(getContext(), basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
        visible();
        super.onResume();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }
}
