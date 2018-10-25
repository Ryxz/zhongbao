package com.zhongbao.home;

import android.view.View;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class HomeDialogActivity extends BaseActivity implements View.OnClickListener {

    private TextView share;
    private TextView ship;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_homedialiog;
    }

    @Override
    protected void initListener() {
        share.setOnClickListener(this);
        ship.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        share = f(R.id.gold_share);
        ship = f(R.id.skip);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.gold_share:

                break;
            case R.id.skip:
                finish();
                break;
        }
    }
}
