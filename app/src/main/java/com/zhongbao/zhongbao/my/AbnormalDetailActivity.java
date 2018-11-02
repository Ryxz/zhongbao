package com.zhongbao.zhongbao.my;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

public class AbnormalDetailActivity extends BaseActivity{

    private RadioGroup radio_abnormal1,radio_abnormal2,radio_abnormal3,radio_abnormal4,radio_abnormal5;
    private int detailStyle = 0;
    private RadioButton radio1;


    @Override
    protected int getLayoutID() {
        return R.layout.layout_abnormal_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        radio1 = findViewById(R.id.radio1);
        //定义底部标签图片大小和位置
        Drawable drawable_news = getResources().getDrawable(R.drawable.radio_choose);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_news.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        radio1.setCompoundDrawables(null,null , drawable_news, null);

        radio_abnormal1 = findViewById(R.id.radio_abnormal1);
        radio_abnormal2 = findViewById(R.id.radio_abnormal2);
        radio_abnormal3 = findViewById(R.id.radio_abnormal3);
        radio_abnormal4 = findViewById(R.id.radio_abnormal4);
        radio_abnormal5 = findViewById(R.id.radio_abnormal5);

        detailStyle = getIntent().getIntExtra("detailStyle",0);
        if (detailStyle == 1){
            radio_abnormal1.setVisibility(View.VISIBLE);
        }else if (detailStyle == 2){
            radio_abnormal2.setVisibility(View.VISIBLE);
        }else if (detailStyle == 3){
            radio_abnormal3.setVisibility(View.VISIBLE);
        }else if (detailStyle == 4){
            radio_abnormal4.setVisibility(View.VISIBLE);
        }else {
            radio_abnormal5.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void initData() {

    }
}
