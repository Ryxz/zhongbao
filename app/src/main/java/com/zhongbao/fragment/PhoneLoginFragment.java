package com.zhongbao.fragment;

import android.app.Activity;
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

import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class PhoneLoginFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private EditText mPhone,mYanzheng;
    private TextView mLogin,mServiceTv,mYinsi;
    private TextView mGetCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_phone_login, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view)
    {
        mPhone = view.findViewById(R.id.phone_et);
        mYanzheng = view.findViewById(R.id.yanzheng_et);
        mLogin = view.findViewById(R.id.login_btn);
        mServiceTv = view.findViewById(R.id.service_tv);//服务协议
        mYinsi = view.findViewById(R.id.yinsi_tv);//隐私协议
        mGetCode = view.findViewById(R.id.login_get_code);
        initListener();
    }

    private void initListener()
    {
        mLogin.setOnClickListener(this);
        mYinsi.setOnClickListener(this);
        mServiceTv.setOnClickListener(this);
        mGetCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login_btn:
                if(mPhone.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"请输入手机号",Toast.LENGTH_LONG).show();
                }else if(mYanzheng.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"请输入验证码",Toast.LENGTH_LONG).show();
                }else
                {
                    SharedPreferences sp = getActivity().getSharedPreferences("com/zhongbao/login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isLogin",true);
                    Log.e("woyaokk","sp:"+sp.getBoolean("isLogin",false));
                    editor.commit();
                    getActivity().finish();
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

    @Override
    public void onResume() {
        super.onResume();
    }
}
