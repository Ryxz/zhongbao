package com.zhongbao.zhongbao.my;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;


public class FeedBackActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img1,img2;

    @Override
    protected int getLayoutID() {
        return R.layout.layout_feedback;
    }


    @Override
    protected void initView() {
        findViewById(R.id.ll_feed1).setOnClickListener(this);
        findViewById(R.id.ll_feed2).setOnClickListener(this);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_feed1:
                img1.setImageResource(R.drawable.login_true);
                img2.setImageResource(R.drawable.shopcar_noselect);
                break;
            case R.id.ll_feed2:
                img2.setImageResource( R.drawable.login_true);
                img1.setImageResource(R.drawable.shopcar_noselect);
                break;
        }
    }
}
