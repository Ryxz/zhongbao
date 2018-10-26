package com.zhongbao.zhongbao.login;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class RegisterActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheck;
    private TextView mBtn;
    private RelativeLayout mLogin;
    private RelativeLayout mBack;
    private TextView mGetCode;

    private EditText mPhone,mYanzheng,mPsd,mPsdTrue;
    private ImageView mEye;
    private ImageView mHideEye;
    private boolean isShow = false;
    private boolean isTrueShow = false;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initListener() {
        mLogin.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mBtn.setOnClickListener(this);
        mCheck.setOnCheckedChangeListener(this);
        mEye.setOnClickListener(this);
        mHideEye.setOnClickListener(this);
        mGetCode.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mCheck = f(R.id.resgiter_cb);
        mBtn = f(R.id.register_btn);
        mLogin = f(R.id.register_login);
        mBack = f(R.id.back_left);

        mPhone = f(R.id.register_phone_et);
        mYanzheng = f(R.id.register_yanzheng_et);
        mPsd = f(R.id.register_psd_et);
        mPsdTrue = f(R.id.register_true_et);

        mGetCode = f(R.id.get_code);

        mEye = f(R.id.eye);
        mHideEye = f(R.id.hide_eye);
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
        mPsdTrue.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.hide_eye:
                if(!isTrueShow)
                {
                    mPsdTrue.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mHideEye.setImageResource(R.mipmap.hide_eye);
                    isTrueShow = true;
                }else{
                    isTrueShow = false;
                    mHideEye.setImageResource(R.mipmap.eye);
                    mPsdTrue.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                }
                break;
            case R.id.eye:
                if(!isShow)
                {
                    mPsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mEye.setImageResource(R.mipmap.hide_eye);
                    isShow = true;
                }else{
                    isShow = false;
                    mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                    mEye.setImageResource(R.mipmap.eye);
                }
                break;

            case R.id.resgiter_cb:

                break;
            case R.id.register_btn:
                if(mPhone.getText().toString().isEmpty())
                {
                    Toast.makeText(this,"请输入手机号码",Toast.LENGTH_LONG).show();
                }else if(mYanzheng.getText().toString().isEmpty())
                {
                    Toast.makeText(this,"请输入验证码",Toast.LENGTH_LONG).show();
                }else if(mPsd.getText().toString().isEmpty())
                {
                    Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
                }else if(mPsdTrue.getText().toString().isEmpty())
                {
                    Toast.makeText(this,"请再次输入密码",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            case R.id.register_login:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.get_code:
                mYanzheng.setFocusable(true);
                mYanzheng.setFocusableInTouchMode(true);
                mYanzheng.requestFocus();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
