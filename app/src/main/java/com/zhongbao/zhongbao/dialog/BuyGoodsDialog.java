package com.zhongbao.zhongbao.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.goods.DuihuanActivity;


public class BuyGoodsDialog extends Dialog implements View.OnClickListener {
    private Context context;

    private ImageView reduce,add;
    private RelativeLayout clear;
    private TextView mFirstAdd,mSecondAdd,mThirdAdd,mNum,tijiao;

    public BuyGoodsDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
        this.context = context;
        setContentView(R.layout.activity_buy_goods);
        clear = findViewById(R.id.clear);
        reduce = findViewById(R.id.buy_reduce);
        add = findViewById(R.id.buy_add);
        mFirstAdd = findViewById(R.id.first_add);
        mSecondAdd = findViewById(R.id.second_add);
        mThirdAdd = findViewById(R.id.third_add);
        mNum = findViewById(R.id.buy_num);
        tijiao = findViewById(R.id.tijiao);

        reduce.setOnClickListener(this);
        add.setOnClickListener(this);
        mFirstAdd.setOnClickListener(this);
        mSecondAdd.setOnClickListener(this);
        mThirdAdd.setOnClickListener(this);
        tijiao.setOnClickListener(this);
        clear.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = getScreenHeight((Activity)context);
        int statusBarHeight = getStatusBarHeight(context);
        int dialogHeight = screenHeight - statusBarHeight;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
        getWindow().setGravity(Gravity.BOTTOM);
    }


    private static int getScreenHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_reduce:
                if (Integer.parseInt(mNum.getText().toString()) > 0) {
                    mNum.setText(Integer.parseInt(mNum.getText().toString()) - 1 + "");
                } else {
                    mNum.setText("0");
                }
                break;
            case R.id.buy_add:
                mNum.setText(Integer.parseInt(mNum.getText().toString()) + 1 + "");
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
                Intent intent = new Intent(context, DuihuanActivity.class);
                intent.putExtra("num", mNum.getText().toString());
                context.startActivity(intent);
                break;
            case R.id.clear:
                dismiss();
                break;
        }
    }
}
