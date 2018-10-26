package com.zhongbao.zhongbao.goods;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class BuyGoodsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView reduce,add;
    private RelativeLayout clear;
    private TextView mFirstAdd,mSecondAdd,mThirdAdd,mNum,tijiao;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_buy_goods;
    }

    @Override
    protected void initListener() {
        reduce.setOnClickListener(this);
        add.setOnClickListener(this);
        mFirstAdd.setOnClickListener(this);
        mSecondAdd.setOnClickListener(this);
        mThirdAdd.setOnClickListener(this);
        tijiao.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        clear = f(R.id.clear);
        reduce = f(R.id.buy_reduce);
        add = f(R.id.buy_add);
        mFirstAdd = f(R.id.first_add);
        mSecondAdd = f(R.id.second_add);
        mThirdAdd = f(R.id.third_add);
        mNum = f(R.id.buy_num);
        tijiao = f(R.id.tijiao);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buy_reduce:
                if(Integer.parseInt(mNum.getText().toString())>0)
                {
                    mNum.setText(Integer.parseInt(mNum.getText().toString())-1+"");
                }else
                {
                    mNum.setText("0");
                }
                break;
            case R.id.buy_add:
                mNum.setText(Integer.parseInt(mNum.getText().toString())+1+"");
                break;
            case R.id.first_add:
                mNum.setText("5");
                break;
            case R.id.second_add:
                mNum.setText("50");
                break;
            case R.id.third_add:
                mNum.setText("100");
                break;
            case R.id.tijiao:
                Intent intent = new Intent(this,DuihuanActivity.class);
                intent.putExtra("num",mNum.getText().toString());
                startActivity(intent);
                break;
            case R.id.clear:

                finish();
                break;
        }
    }
}
