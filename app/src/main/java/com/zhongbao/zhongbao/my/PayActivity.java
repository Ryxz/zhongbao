package com.zhongbao.zhongbao.my;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class PayActivity extends Activity implements View.OnClickListener {

    private RelativeLayout mBack;

    private RadioGroup mGroup;

    private RadioButton mOne, mTwo, mThree, mFour, mFive;

    private ImageView aliPayIv;
    private ImageView wechatIv;
    private EditText pay_money_et;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
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
        mOne = findViewById(R.id.radio_one);
        mTwo = findViewById(R.id.radio_two);
        mThree = findViewById(R.id.radio_three);
        mFour = findViewById(R.id.radio_four);
        mFive = findViewById(R.id.radio_five);
        pay_money_et  = findViewById(R.id.pay_money_et);
        aliPayIv = findViewById(R.id.ali_pay_iv);
        wechatIv = findViewById(R.id.wechat_pay_iv);

        findViewById(R.id.ll_ali_pay).setOnClickListener(this);
        findViewById(R.id.ll_wx_pay).setOnClickListener(this);
        mOne.setOnClickListener(this);
        mTwo.setOnClickListener(this);
        mThree.setOnClickListener(this);
        mFour.setOnClickListener(this);
        mFive.setOnClickListener(this);


        mBack = findViewById(R.id.back_left);
        mBack.setOnClickListener(this);
        mGroup = findViewById(R.id.radio_group);
//        mGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_ali_pay:
                aliPayIv.setImageResource(R.mipmap.yuan_ok);
                wechatIv.setImageResource(R.mipmap.yuan);
                break;
            case R.id.ll_wx_pay:
                aliPayIv.setImageResource(R.mipmap.yuan);
                wechatIv.setImageResource(R.mipmap.yuan_ok);
                break;
            case R.id.back_left:
                finish();
                break;
            case R.id.radio_one:
                select(1);
                pay_money_et.setText("100");
                break;
            case R.id.radio_two:
                select(2);
                pay_money_et.setText("200");
                break;
            case R.id.radio_three:
                select(3);
                pay_money_et.setText("300");
                break;
            case R.id.radio_four:
                select(4);
                pay_money_et.setText("1000");
                break;
            case R.id.radio_five:
                select(5);
                pay_money_et.setText("200");
                break;
        }
    }


    public void select(int position) {
        if (position == 1) {
            mOne.setBackgroundResource(R.drawable.mine_pay);
            mOne.setTextColor(getResources().getColor(R.color.bg_toolbar));
        } else {
            mOne.setBackgroundResource(R.drawable.mine_noselect);
            mOne.setTextColor(getResources().getColor(R.color.text_dray));
        }

        if (position == 2) {
            mTwo.setBackgroundResource(R.drawable.mine_pay);
            mTwo.setTextColor(getResources().getColor(R.color.bg_toolbar));
        } else {
            mTwo.setBackgroundResource(R.drawable.mine_noselect);
            mTwo.setTextColor(getResources().getColor(R.color.text_dray));
        }
        if (position == 3) {
            mThree.setBackgroundResource(R.drawable.mine_pay);
            mThree.setTextColor(getResources().getColor(R.color.bg_toolbar));
        } else {
            mThree.setBackgroundResource(R.drawable.mine_noselect);
            mThree.setTextColor(getResources().getColor(R.color.text_dray));
        }
        if (position == 4) {
            mFour.setBackgroundResource(R.drawable.mine_pay);
            mFour.setTextColor(getResources().getColor(R.color.bg_toolbar));
        } else {
            mFour.setBackgroundResource(R.drawable.mine_noselect);
            mFour.setTextColor(getResources().getColor(R.color.text_dray));
        }
        if (position == 5) {
            mFive.setBackgroundResource(R.drawable.mine_pay);
            mFive.setTextColor(getResources().getColor(R.color.bg_toolbar));
        } else {
            mFive.setBackgroundResource(R.drawable.mine_noselect);
            mFive.setTextColor(getResources().getColor(R.color.text_dray));
        }
    }

}
