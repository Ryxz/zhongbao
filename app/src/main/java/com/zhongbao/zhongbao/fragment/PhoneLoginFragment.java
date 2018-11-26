package com.zhongbao.zhongbao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.base.BaseFragment;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.BasicModel;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class PhoneLoginFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhone, mYanzheng;
    private TextView mGetCode;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mPhone = findViewById(R.id.phone_et);
        mYanzheng = findViewById(R.id.yanzheng_et);
        findViewById(R.id.login_btn).setOnClickListener(this);
        findViewById(R.id.service_tv).setOnClickListener(this);//服务协议
        findViewById(R.id.yinsi_tv).setOnClickListener(this);//隐私协议
        mGetCode = findViewById(R.id.login_get_code);
        mGetCode.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                if (mPhone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "请输入手机号", Toast.LENGTH_LONG).show();
                } else if (mYanzheng.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "请输入验证码", Toast.LENGTH_LONG).show();
                } else {
                    phone_login();
                }
                break;
            case R.id.service_tv:

                break;
            case R.id.yinsi_tv:

                break;
            case R.id.login_get_code:
                mYanzheng.setFocusable(true);
                mYanzheng.setFocusableInTouchMode(true);
                mYanzheng.requestFocus();
                break;
        }
    }

    public void phone_login(){
        getHttpService().phone_login(mPhone.getText().toString().trim(),mYanzheng.getText().toString().trim())
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
                        if (basicModel.getCode().equals("200")){
                            getActivity().finish();
                            startActivity(new Intent(getContext(), MainActivity.class).putExtra("userId",String.valueOf(basicModel.getData())));
                        }
                        Toast.makeText(getContext(), basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phone_login;
    }
}
