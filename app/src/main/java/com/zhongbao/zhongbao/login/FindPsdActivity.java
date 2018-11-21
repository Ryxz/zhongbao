package com.zhongbao.zhongbao.login;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class FindPsdActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout mBack;
    private EditText mPhone, mYanzheng, mPsd, mTruePsd;
    private TextView mTrue;
    private ImageView mEye;
    private ImageView mHideEye;
    private boolean isShow = false;
    private boolean isTrueShow = false;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_find_psd;
    }

    protected void initListener() {
        mBack.setOnClickListener(this);
        mTrue.setOnClickListener(this);
        mEye.setOnClickListener(this);
        mHideEye.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mBack = f(R.id.back_left);
        mPhone = f(R.id.psd_phone_et);
        mYanzheng = f(R.id.psd_yanzheng_et);
        mPsd = f(R.id.psd_et);
        mTruePsd = f(R.id.true_psd_et);
        mTrue = f(R.id.find_psd_btn);
        mEye = f(R.id.eye);
        mHideEye = f(R.id.hide_eye);
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
        mTruePsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hide_eye:
                if (!isTrueShow) {
                    mTruePsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mHideEye.setImageResource(R.mipmap.hide_eye);
                    isTrueShow = true;
                } else {
                    isTrueShow = false;
                    mHideEye.setImageResource(R.mipmap.eye);
                    mTruePsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                }
                break;
            case R.id.eye:
                if (!isShow) {
                    mPsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mEye.setImageResource(R.mipmap.hide_eye);
                    isShow = true;
                } else {
                    isShow = false;
                    mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                    mEye.setImageResource(R.mipmap.eye);
                }
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.find_psd_btn:
                if (mPhone.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入手机号码", Toast.LENGTH_LONG).show();
                } else if (mYanzheng.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show();
                } else if (mPsd.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
                } else if (mTruePsd.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入确认密码", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }
                break;
        }
    }
}
