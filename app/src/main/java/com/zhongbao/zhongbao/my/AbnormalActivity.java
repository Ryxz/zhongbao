package com.zhongbao.zhongbao.my;

import android.content.Intent;
import android.view.View;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

public class AbnormalActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int getLayoutID() {
        return R.layout.layout_abnormal;
    }


    @Override
    protected void initView() {
        findViewById(R.id.ll_flashback).setOnClickListener(this);
        findViewById(R.id.ll_account).setOnClickListener(this);
        findViewById(R.id.ll_shopcar).setOnClickListener(this);
        findViewById(R.id.ll_myzb).setOnClickListener(this);
        findViewById(R.id.ll_order_question).setOnClickListener(this);
    }


    private int detailStyle = 0;

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,AbnormalDetailActivity.class);
        switch (v.getId()){
            case R.id.ll_flashback:
                detailStyle = 1;
                break;
            case R.id.ll_account:
                detailStyle = 2;
                break;
            case R.id.ll_shopcar:
                detailStyle = 3;
                break;
            case R.id.ll_myzb:
                detailStyle = 4;
                break;
            case R.id.ll_order_question:
                detailStyle = 5;
                break;
        }
        intent.putExtra("detailStyle",detailStyle);
        startActivity(new Intent(intent));
    }
}
