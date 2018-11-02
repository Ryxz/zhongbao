package com.zhongbao.zhongbao;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

public class WelcomeActivity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            gohome();
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayoutID() {
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_welcome;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        handler.sendEmptyMessageDelayed(0,2000);

    }

    @Override
    protected void initData() {

    }

    public void gohome(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
