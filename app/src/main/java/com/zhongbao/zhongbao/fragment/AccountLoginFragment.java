package com.zhongbao.zhongbao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;

import com.zhongbao.zhongbao.base.BaseFragment;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.login.FindPsdActivity;
import com.zhongbao.zhongbao.login.LoginActivity;
import com.zhongbao.zhongbao.utils.PreferenceUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class AccountLoginFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhone, mPsd;
    private ImageView mEye;
    private boolean isShow = false;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mPhone = findViewById(R.id.account_phone_et);
        mPsd = findViewById(R.id.psd_et);
        mEye = findViewById(R.id.eye);
        findViewById(R.id.login_btn).setOnClickListener(this);
        findViewById(R.id.forget_psd).setOnClickListener(this);
        findViewById(R.id.account_service_tv).setOnClickListener(this);
        findViewById(R.id.account_yinsi_tv).setOnClickListener(this);
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mEye.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_psd:
                startActivity(new Intent(getActivity(), FindPsdActivity.class));
                break;
            case R.id.eye:
                if (!isShow) {
                    mPsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mEye.setImageResource(R.mipmap.hide_eye);
                    isShow = true;
                } else {
                    isShow = false;
                    mEye.setImageResource(R.mipmap.eye);
                    mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                }
                break;
            case R.id.account_service_tv:

                break;
            case R.id.account_yinsi_tv:

                break;
            case R.id.login_btn:
                if (mPhone.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "请输入手机号", Toast.LENGTH_LONG).show();
                } else if (mPsd.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "请输入密码", Toast.LENGTH_LONG).show();
                } else {
                    login();
                }
                break;
        }
    }

    /**
     * 登录
     */
    public void login(){
        String phone = mPhone.getText().toString();
        getHttpService().login(phone,mPsd.getText().toString().trim())
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
                        if (basicModel.getCode().equals("200")){
                            getActivity().finish();
                            startActivity(new Intent(getContext(), MainActivity.class).putExtra("userId",String.valueOf(basicModel.getData())));
                        }else {
                            Toast.makeText(getContext(), basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_login;
    }
}
