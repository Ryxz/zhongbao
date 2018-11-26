package com.zhongbao.zhongbao.my;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.UserInfoModel;
import com.zhongbao.zhongbao.utils.PreferenceUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class PersonalDataActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_name,tv_sex,tv_birthday;


    @Override
    protected int getLayoutID() {
        return R.layout.activity_personaldata;
    }

    @Override
    protected void initView() {
        findViewById(R.id.head_roundImage).setOnClickListener(this);
        findViewById(R.id.name_relative).setOnClickListener(this);
        findViewById(R.id.sex_relative).setOnClickListener(this);
        findViewById(R.id.birthday_relative).setOnClickListener(this);
        findViewById(R.id.adress_relative).setOnClickListener(this);
        findViewById(R.id.back_left).setOnClickListener(this);
        findViewById(R.id.ll_modifyPwd).setOnClickListener(this);
        findViewById(R.id.tv_login_out).setOnClickListener(this);
        tv_name = findViewById(R.id.tv_name);
        tv_sex = findViewById(R.id.tv_sex);
        tv_birthday = findViewById(R.id.tv_birthday);
        getUserInfo();
    }


    public void getUserInfo(){
        getHttpService().person_info(ZBApp.get().getUserId())
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<UserInfoModel>>() {
                    @Override
                    protected void onDoNext(BasicModel<UserInfoModel> basicModel) {
                        tv_name.setText(basicModel.getData().getNickname());
                        if (basicModel.getData().getSex().equals("1")){
                            tv_sex.setText("男");
                        }else if (basicModel.getData().getSex().equals("2")){
                            tv_sex.setText("女");
                        }
                        tv_birthday.setText(basicModel.getData().getBirthday());
                        if (!basicModel.getCode().equals("200")){
                            Toast.makeText(PersonalDataActivity.this, basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head_roundImage:
            case R.id.head_arraw:
                //头像设置
                break;
            case R.id.name_relative:
                //昵称修改
                break;
            case R.id.sex_relative:
                //性别设置
                break;
            case R.id.birthday_relative:
                //生日设置
                break;
            case R.id.adress_relative:
                //地址设置
                startActivity(new Intent(this, MyAdressActivity.class));
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.ll_modifyPwd:
                //修改密码
                startActivity(new Intent(this, ModifyPwdActivity.class));
                break;
            case R.id.tv_login_out:
                PreferenceUtils.write(this, "ZHONGBAO", "appkey", null);
                finish();
                break;
        }
    }
}
