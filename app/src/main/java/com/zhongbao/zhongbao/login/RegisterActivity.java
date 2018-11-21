package com.zhongbao.zhongbao.login;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.base.http.HttpService;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.UserInfoModel;
import com.zhongbao.zhongbao.utils.ViewUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.functions.Function;


/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText mPhone, mYanzheng, mPsd, mPsdTrue;
    private ImageView mEye;
    private ImageView mHideEye;
    private boolean isShow = false;
    private boolean isTrueShow = false;
    private TextView get_code;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        findViewById(R.id.resgiter_cb).setOnClickListener(this);
        findViewById(R.id.register_btn).setOnClickListener(this);
        findViewById(R.id.register_login).setOnClickListener(this);
        findViewById(R.id.back_left).setOnClickListener(this);
        get_code = findViewById(R.id.get_code);
        get_code.setOnClickListener(this);
        findViewById(R.id.hide_eye).setOnClickListener(this);
        findViewById(R.id.eye).setOnClickListener(this);

        mHideEye =findViewById(R.id.hide_eye);
        mPhone = f(R.id.register_phone_et);
        mYanzheng = f(R.id.register_yanzheng_et);
        mPsd = f(R.id.register_psd_et);
        mPsdTrue = f(R.id.register_true_et);


        mEye = f(R.id.eye);
        mPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
        mPsdTrue.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hide_eye:
                if (!isTrueShow) {
                    mPsdTrue.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                    mHideEye.setImageResource(R.mipmap.hide_eye);
                    isTrueShow = true;
                } else {
                    isTrueShow = false;
                    mHideEye.setImageResource(R.mipmap.eye);
                    mPsdTrue.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
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

            case R.id.resgiter_cb:

                break;
            case R.id.register_btn:
                if (mPhone.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入手机号码", Toast.LENGTH_LONG).show();
                } else if (mYanzheng.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show();
                } else if (mPsd.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
                } else if (mPsdTrue.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请再次输入密码", Toast.LENGTH_LONG).show();
                } else {
                    register();
                }
                break;
            case R.id.register_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.get_code:
                getCode();
                break;
        }
    }


    public void getCode(){
        String phone = getTextStr(R.id.register_phone_et);
        getHttpService().backcode(phone)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
                        if (basicModel.getCode().equals("200")){
                            get_code.setClickable(false);
                            ObservableTransformer<Integer, Integer> transformer = bindToLifecycle();
                            ViewUtil.countdown(60).compose(transformer).subscribe(new BaseSubscriber<Integer>() {
                                @Override
                                protected void onDoNext(Integer integer) {
                                    if (integer <= 0) {
                                        get_code.setClickable(true);
                                        get_code.setText("获取验证码");
                                    }else {
                                        get_code.setText("重新获取(" + (integer == 0 ? "" : String.valueOf(integer))+")");
                                    }

                                }
                            });
                            Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    //注册
    public void register(){
        Map<String,String> map = new HashMap<>();
        map.put("password",getTextStr(R.id.register_psd_et));
        map.put("repassword",getTextStr(R.id.register_true_et));
        map.put("mobile",getTextStr(R.id.register_phone_et));
        map.put("verify",getTextStr(R.id.register_yanzheng_et));
        map.put("username",getTextStr(R.id.register_phone_et));
        getHttpService().register(map)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<UserInfoModel>>(this,true) {
                    @Override
                    protected void onDoNext(BasicModel<UserInfoModel> userModel) {
                        if (userModel.getCode().equals("200")){
                            finish();
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class).putExtra("userId",userModel.getData().getUid()));
                        }
                    }
                });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
