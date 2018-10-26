package com.zhongbao.zhongbao.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zhongbao.zhongbao.R;


public class ShareDialog extends Dialog implements View.OnClickListener {
    private RelativeLayout mWeixin,mFriend,mQQ,mWeibo,mCancel;

    private Context context;

    public ShareDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
        this.context = context;
        setContentView(R.layout.pop_layout);
        mWeixin = findViewById(R.id.weixin);
        mFriend = findViewById(R.id.friend);
        mQQ = findViewById(R.id.qq);
        mWeibo = findViewById(R.id.weibo);
        mCancel = findViewById(R.id.cancel);
        mWeixin.setOnClickListener(this);
        mFriend.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mWeibo.setOnClickListener(this);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = getScreenHeight((Activity)context);
        int statusBarHeight = getStatusBarHeight(context);
        int dialogHeight = screenHeight - statusBarHeight;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
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
            case R.id.weixin:
                Toast.makeText(context,"分享微信",Toast.LENGTH_LONG).show();
                break;
            case R.id.friend:
                Toast.makeText(context,"分享朋友圈",Toast.LENGTH_LONG).show();
                break;
            case R.id.qq:
                Toast.makeText(context,"分享QQ好友",Toast.LENGTH_LONG).show();
                break;
            case R.id.weibo:
                Toast.makeText(context,"分享微博",Toast.LENGTH_LONG).show();
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }
}
