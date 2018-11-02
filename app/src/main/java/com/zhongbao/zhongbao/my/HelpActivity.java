package com.zhongbao.zhongbao.my;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class HelpActivity extends Activity implements View.OnClickListener {

    private RelativeLayout mAboutZb, mAccount, mPayProblem, mMic, mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
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
        mAboutZb = findViewById(R.id.about_zb);
        mAccount = findViewById(R.id.account_zb);
        mPayProblem = findViewById(R.id.pay_problem_zb);
        mMic = findViewById(R.id.mic_relative);
        findViewById(R.id.weixin_call).setOnClickListener(this);
        findViewById(R.id.qq_call).setOnClickListener(this);
        mBack = findViewById(R.id.back_left);
        findViewById(R.id.tv_abnormal).setOnClickListener(this);
        findViewById(R.id.tv_feedback).setOnClickListener(this);
        initListener();
    }

    private void initListener() {
        mAboutZb.setOnClickListener(this);
        mAccount.setOnClickListener(this);
        mPayProblem.setOnClickListener(this);
        mMic.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_zb:
                startActivity(new Intent(this,AboutActivity.class));
                break;
            case R.id.account_zb:

                break;
            case R.id.pay_problem_zb:

                break;
            case R.id.mic_relative:
                callPhone("025-87688888");
                break;
            case R.id.weixin_call:
                diallPhone("025-87688888");
                break;
            case R.id.qq_call:
                diallPhone("025-87688888");
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.tv_abnormal:
                startActivity(new Intent(this,AbnormalActivity.class));
                break;
            case R.id.tv_feedback:
                startActivity(new Intent(this,FeedBackActivity.class));
                break;
        }
    }

    public void diallPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }


}
