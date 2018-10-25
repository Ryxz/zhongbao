package com.zhongbao.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

import com.zhongbao.zhongbao.R;

import org.w3c.dom.Text;

import com.zhongbao.login.FindPsdActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class AccountLoginFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private EditText mPhone,mPsd;
    private TextView mService,mYinsi,mLogin;
    private ImageView mEye;
    private boolean isShow = false;
    private TextView mForget;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_account_login, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view)
    {
        mPhone = view.findViewById(R.id.account_phone_et);
        mPsd = view.findViewById(R.id.psd_et);
        mEye = view.findViewById(R.id.eye);
        mService = view.findViewById(R.id.account_service_tv);
        mYinsi = view.findViewById(R.id.account_yinsi_tv);
        mLogin = view.findViewById(R.id.login_btn);
        mForget = view.findViewById(R.id.forget_psd);
        initListener();
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private void initListener()
    {
        mForget.setOnClickListener(this);
        mEye.setOnClickListener(this);
        mService.setOnClickListener(this);
        mYinsi.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.forget_psd:
                startActivity(new Intent(getActivity(), FindPsdActivity.class));
                break;
            case R.id.eye:
                if(!isShow)
                {
                    mPsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mEye.setImageResource(R.mipmap.hide_eye);
                    isShow = true;
                }else{
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
                if(mPhone.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"请输入手机号",Toast.LENGTH_LONG).show();
                }else if(mPsd.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"请输入密码",Toast.LENGTH_LONG).show();
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
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
