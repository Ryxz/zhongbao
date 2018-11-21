package com.zhongbao.zhongbao.my;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class NewsDetailActivity extends BaseActivity implements View.OnClickListener {

    private String time,content,title;
    private TextView mTitle,mTime,mContent;
    private RelativeLayout mBack;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_news_detail;
    }

    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        time = intent.getStringExtra("time");
        content = intent.getStringExtra("content");
        title = intent.getStringExtra("title");
        mTitle = f(R.id.news_title);
        mTime = f(R.id.news_time);
        mContent = f(R.id.news_content);
        mBack = f(R.id.back_left);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.back_left:
                finish();
                break;
        }
    }
}
