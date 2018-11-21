package com.zhongbao.zhongbao.goods;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zhongbao.zhongbao.base.GlideImageLoader;
import com.zhongbao.zhongbao.fragment.HistoryPersonFragment;
import com.zhongbao.zhongbao.fragment.JoinRecordFragment;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.utils.GlideUtils;
import com.zhongbao.zhongbao.utils.Util;
import com.zhongbao.zhongbao.view.HomePopwindow;

/**
 * Used for
 * Created by tuyz on 2018/10/11.
 */

public class GoodsDetailActivity extends BaseActivity implements View.OnClickListener {

    //    private ViewPagerForScrollView vp;
//    private RadioGroup rg;
    private int[] rbs = {R.id.rb_all, R.id.rb_ing};
    private List<Fragment> mFragments;
    private TextView mAll, mIng;
    private LinearLayout mLabone, mLabtwo;
    private RelativeLayout mBack;
    private LinearLayout mShaidan;
    private ImageView backHome;
    private String state = "3";
    private TextView goodstate;
    private LinearLayout kaijiang;
    private LinearLayout bukaijiang;
    private RelativeLayout daojishiTime;
    private ImageView goodType;
    private ScrollView mScrollView;
    private TextView shi, fen, miao;
    private LinearLayout mTop;
    private long time = 400;

    private JoinRecordFragment one;
    private HistoryPersonFragment two;
    private Banner banner;

    private List<String> list = new ArrayList<>();

    private int fadingHeight = 600; // 当ScrollView滑动到什么位置时渐变消失（根据需要进行调整）
    private Drawable drawable; // 顶部渐变布局需设置的Drawable
    private RelativeLayout layout_top_search;//导航栏
    private static final int START_ALPHA = 0;//scrollview滑动开始位置
    private static final int END_ALPHA = 255;//scrollview滑动结束位置


    @Override
    public void onResume() {
        super.onResume();
        mTop.setFocusable(true);
        mTop.setFocusableInTouchMode(true);
        mTop.requestFocus();
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    protected int getLayoutID() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            //设置修改状态栏
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            //设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
//            window.setStatusBarColor(getResources().getColor(R.color.white));
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }

        // 5.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return R.layout.activity_goods_detail;
    }

    protected void initListener() {
        mBack.setOnClickListener(this);
        mShaidan.setOnClickListener(this);
        goodType.setOnClickListener(this);
        mAll.setOnClickListener(this);
        mIng.setOnClickListener(this);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @SuppressLint("NewApi")
    @Override
    protected void initView() {

        Intent intent = getIntent();
        state = intent.getStringExtra("STATE");

        mScrollView = f(R.id.scrollView_goods);
        banner = f(R.id.banner);

        mAll = f(R.id.rb_all);
        mIng = f(R.id.rb_ing);

        mLabone = f(R.id.lab_one);
        mLabtwo = f(R.id.lab_two);
        mTop = f(R.id.top_pic);

        backHome = f(R.id.goods_home_iv);
        goodstate = f(R.id.goods_state_tv);
        mBack = f(R.id.back_left);

        mShaidan = f(R.id.goods_home_rela);
        kaijiang = f(R.id.kaijiang_linear);
        bukaijiang = f(R.id.bukaijiang_linear);
        daojishiTime = f(R.id.daojiashi_time);
        goodType = f(R.id.goods_type_iv);

        shi = f(R.id.shi);
        fen = f(R.id.fen);
        miao = f(R.id.miao);
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540804165171&di=78ff2a5841113f0bf7d3752f425640fd&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F011f4b57eb26bfa84a0e282bc61d8a.jpg%401280w_1l_2o_100sh.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541399307&di=896baa14d64884f26d9955376ff084f6&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01139a59b0a09fa801211d25eaa714.jpg%402o.jpg");
        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
        banner.start();
        handler.postDelayed(runnable, 1000);


        layout_top_search = findViewById(R.id.good_title);
        drawable = getResources().getDrawable(R.color.scrollwhite);
        drawable.setAlpha(START_ALPHA);
        layout_top_search.setBackgroundDrawable(drawable);
        layout_top_search.getBackground().mutate().setAlpha(0);
        mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > fadingHeight) {
                    scrollY = fadingHeight; // 当滑动到指定位置之后设置颜色为纯色，之前的话要渐变---实现下面的公式即可
                } else if (scrollY < 0) {
                    scrollY = 0;
                } else {

                }
                drawable.setAlpha(scrollY * (END_ALPHA - START_ALPHA) / fadingHeight + START_ALPHA);

            }
        });
    }



    private void initFirstFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (one == null) {
            one = new JoinRecordFragment();
        }
        transaction.replace(R.id.goods_frame_layout, one);
        transaction.commit();
    }

    private void initSecondFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (two == null) {
            two = new HistoryPersonFragment();
        }
        transaction.replace(R.id.goods_frame_layout, two);
        transaction.commit();
    }


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            String formatLongToTimeStr = formatLongToTimeStr(time);
            String[] split = formatLongToTimeStr.split("：");
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    if (split[0].length() < 2) {
                        shi.setText("0" + split[0]);
                    } else {
                        shi.setText(split[0]);
                    }

                }
                if (i == 1) {

                    if (split[1].length() < 2) {
                        fen.setText("0" + split[1]);
                    } else {
                        fen.setText(split[1]);
                    }
                }
                if (i == 2) {
                    if (split[2].length() < 2) {
                        miao.setText("0" + split[2]);
                    } else {
                        miao.setText(split[2]);
                    }
                }

            }
            if (time > 0) {
                handler.postDelayed(this, 1000);
            }
        }
    };

    public String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue();
        if (second > 60) {
            minute = second / 60;         //取整
            second = second % 60;         //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour + "：" + minute + "：" + second;
        return strtime;

    }


    protected void initData() {


        if (state == null) state = "";
        if (state.equals("1")) {
            kaijiang.setVisibility(View.VISIBLE);
            bukaijiang.setVisibility(View.GONE);
            goodstate.setText("倒计时");
            daojishiTime.setVisibility(View.VISIBLE);
            goodstate.setBackgroundResource(R.mipmap.good_state_daojishi);
        } else if (state.equals("2")) {
            kaijiang.setVisibility(View.GONE);
            bukaijiang.setVisibility(View.VISIBLE);
            goodstate.setText("进行中");
            daojishiTime.setVisibility(View.GONE);
            goodstate.setBackgroundResource(R.mipmap.good_state_ing);
        } else {
            daojishiTime.setVisibility(View.GONE);
            kaijiang.setVisibility(View.VISIBLE);
            bukaijiang.setVisibility(View.GONE);
            goodstate.setText("已开奖");
            goodstate.setBackgroundResource(R.mipmap.good_state_end);
        }


        mFragments = new ArrayList<>();
        JoinRecordFragment one = new JoinRecordFragment();
        HistoryPersonFragment two = new HistoryPersonFragment();
        mFragments.add(one);
        mFragments.add(two);
        initFirstFragment();
        // 设置填充器
//        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(),mFragments));
        // 设置缓存页面数
//        vp.setOffscreenPageLimit(2);
    }

    /**
     * 提供子fragment调用方法，解决listview高度不自适应出现多余空白
     */
//    public  void setChildObjectForPosition(View com.zhongbao.zhongbao.view,int poistion){
//        vp.setObjectForPosition(com.zhongbao.zhongbao.view,poistion);
//    }
    private void setLabState(int id) {
        if (id == R.id.rb_all) {
            mAll.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.VISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
        } else if (id == R.id.rb_ing) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.VISIBLE);
        } else if (id == R.id.rb_ed) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_left:
                finish();
                break;
            case R.id.goods_home_rela:
//                if(ButtonUtils.isFastClick())
//                {
                startActivity(new Intent(this, MyBaskActivity.class));
//                }

                break;
            case R.id.goods_type_iv:
                HomePopwindow pop = new HomePopwindow(this);
                pop.showAsDropDown(goodType);
                break;
            case R.id.rb_all:
                initFirstFragment();
                setLabState(view.getId());
                break;

            case R.id.rb_ing:
                setLabState(view.getId());
                initSecondFragment();
                break;
        }
    }
}
