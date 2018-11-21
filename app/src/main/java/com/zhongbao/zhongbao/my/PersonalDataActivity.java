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

import com.makeramen.roundedimageview.RoundedImageView;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.utils.PreferenceUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class PersonalDataActivity extends Activity implements View.OnClickListener {

    private RoundedImageView mHeadImage;
    private RelativeLayout mName, mSex, mAdress, mBack;
    private ImageView mHeadArraw;
    private LinearLayout mBirthday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.bg_toolbar));
        }
        initView();
    }

    private void initView() {
        mHeadImage = findViewById(R.id.head_roundImage);
        mHeadArraw = findViewById(R.id.head_arraw);
        mName = findViewById(R.id.name_relative);
        mSex = findViewById(R.id.sex_relative);
        mBirthday = findViewById(R.id.birthday_relative);
        mAdress = findViewById(R.id.adress_relative);
        mBack = findViewById(R.id.back_left);
        findViewById(R.id.ll_modifyPwd).setOnClickListener(this);
        findViewById(R.id.tv_login_out).setOnClickListener(this);
        initLintener();
    }

    private void initLintener() {
        mHeadImage.setOnClickListener(this);
        mHeadArraw.setOnClickListener(this);
        mName.setOnClickListener(this);
        mSex.setOnClickListener(this);
        mBirthday.setOnClickListener(this);
        mAdress.setOnClickListener(this);
        mBack.setOnClickListener(this);
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
