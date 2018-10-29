package com.zhongbao.zhongbao.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class QrcodeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView shut;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void initListener() {
        shut.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        shut = f(R.id.shut_clear);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.shut_clear:
                finish();
                break;
        }
    }
}
