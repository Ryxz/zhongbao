package com.zhongbao.zhongbao.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;


public class WinningInfoDialog extends Dialog {
    private TextView skip;
    private Context context;

    public WinningInfoDialog(@NonNull Context context, View.OnClickListener skipListener) {
        super(context, R.style.DialogStyle);
        this.context = context;
        setContentView(R.layout.activity_homedialiog);
        skip = findViewById(R.id.skip);
        skip.setOnClickListener(skipListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = getScreenHeight((Activity)context);
        int statusBarHeight = getStatusBarHeight(context);
        int dialogHeight = screenHeight - statusBarHeight;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : dialogHeight);
    }

//    @Override
//    public void show() {
//        super.show();
//        /**
//         * 设置宽度全屏，要设置在show的后面
//         */
//        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//        layoutParams.gravity= Gravity.CENTER;
//        layoutParams.width= WindowManager.LayoutParams.MATCH_PARENT;
//        layoutParams.height= WindowManager.LayoutParams.MATCH_PARENT;
//        getWindow().getDecorView().setPadding(0, 0, 0, 0);
//        getWindow().setAttributes(layoutParams);
//
//    }

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
}
