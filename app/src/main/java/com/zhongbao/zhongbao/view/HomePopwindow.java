package com.zhongbao.zhongbao.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zhongbao.zhongbao.R;

import com.zhongbao.zhongbao.my.HelpActivity;
import com.zhongbao.zhongbao.my.QrcodeActivity;
import com.zhongbao.zhongbao.my.ZbRecordActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */
    public class HomePopwindow extends PopupWindow {
        private LinearLayout mRecord,mQr,mHelp;
        public HomePopwindow(final Context context) {
            super(context);
            setOutsideTouchable(true);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            View contentView = LayoutInflater.from(context).inflate(R.layout.pop_home,
                    null, false);
            mRecord = contentView.findViewById(R.id.yungou_record);
            mQr = contentView.findViewById(R.id.qr_share);
            mHelp = contentView.findViewById(R.id.home_help);

            mRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ZbRecordActivity.class));
                }
            });

            mQr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, QrcodeActivity.class));
                }
            });

            mHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, HelpActivity.class));
                }
            });

            setContentView(contentView);
        }

    }
