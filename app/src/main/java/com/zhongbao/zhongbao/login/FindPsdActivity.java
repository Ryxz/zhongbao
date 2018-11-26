package com.zhongbao.zhongbao.login;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.utils.ViewUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.ObservableTransformer;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class FindPsdActivity extends BaseActivity implements View.OnClickListener {
    private EditText mPhone, mPsd, mTruePsd;
    private TextView mTrue,tv_get_code;
    private ImageView mEye;
    private ImageView mHideEye;
    private boolean isShow = false;
    private boolean isTrueShow = false;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_find_psd;
    }

    protected void initListener() {
        mTrue.setOnClickListener(this);
        mEye.setOnClickListener(this);
        mHideEye.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mPhone = f(R.id.psd_phone_et);
        mPsd = f(R.id.psd_et);
        mTruePsd = f(R.id.true_psd_et);
        mTrue = f(R.id.find_psd_btn);
        tv_get_code = f(R.id.tv_get_code);
        tv_get_code.setOnClickListener(this);
        mEye = f(R.id.eye);
        mHideEye = f(R.id.hide_eye);
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
        mTruePsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
        initListener();
        findViewById(R.id.back_left).setOnClickListener(this);
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
            case R.id.tv_get_code:
                getCode();
                break;
            case R.id.find_psd_btn:
                if (mPhone.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入手机号码", Toast.LENGTH_LONG).show();
                } else if (getTextStr(R.id.psd_yanzheng_et).isEmpty()) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show();
                } else if (mPsd.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
                } else if (mTruePsd.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入确认密码", Toast.LENGTH_LONG).show();
                } else {
                    findpwd();
                }
                break;
        }
    }

    /**
     * 找回密码
     */
    public void findpwd(){
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mPhone.getText().toString().trim());
        map.put("password",getTextStr(R.id.psd_et));
        map.put("verify",getTextStr(R.id.psd_yanzheng_et));
        map.put("repassword",getTextStr(R.id.true_psd_et));
        getHttpService().find_password(map)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
//                        if (basicModel.getCode().equals("200")){
//                            finish();
//                            startActivity(new Intent(FindPsdActivity.this, MainActivity.class).putExtra("userId",String.valueOf(basicModel.getData())));
//                        }
                        Toast.makeText(FindPsdActivity.this, basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    /**
     * 验证码
     */
    public void getCode(){
        String phone = getTextStr(R.id.psd_phone_et);
        if (TextUtils.isEmpty(phone)){
            Toast.makeText(FindPsdActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        getHttpService().backcode(phone)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
                        if (basicModel.getCode().equals("200")){
                            tv_get_code.setClickable(false);
                            ObservableTransformer<Integer, Integer> transformer = bindToLifecycle();
                            ViewUtil.countdown(60).compose(transformer).subscribe(new BaseSubscriber<Integer>() {
                                @Override
                                protected void onDoNext(Integer integer) {
                                    if (integer <= 0) {
                                        tv_get_code.setClickable(true);
                                        tv_get_code.setText("获取验证码");
                                    }else {
                                        tv_get_code.setText("重新获取(" + (integer == 0 ? "" : String.valueOf(integer))+")");
                                    }

                                }
                            });
                            Toast.makeText(FindPsdActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(FindPsdActivity.this, basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
