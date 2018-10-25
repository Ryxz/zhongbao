package com.zhongbao.goods;

import android.view.View;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for 新手指导
 * Created by tuyz on 2018/10/14.
 */

public class NoviceActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mBack;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_novice;
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mBack = f(R.id.back_left);
    }

    @Override
    protected void initData() {

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
