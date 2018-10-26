package com.zhongbao.zhongbao.goods;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.fragment.HistoryPersonFragment;
import com.zhongbao.zhongbao.fragment.JoinRecordFragment;
import com.zhongbao.zhongbao.my.MyBaskActivity;
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
    private TextView mAll,mIng;
    private LinearLayout mLabone,mLabtwo;
    private RelativeLayout mBack;
    private RelativeLayout mShaidan;
    private ImageView backHome;
    private String state = "3";
    private TextView goodstate;
    private LinearLayout kaijiang;
    private LinearLayout bukaijiang;
    private RelativeLayout daojishiTime;
    private ImageView goodType;
    private ScrollView mScrollView;
    private TextView shi,fen,miao;
    private LinearLayout mTop;
    private   long  time=400;

    private JoinRecordFragment one;
    private HistoryPersonFragment two;



    @Override
    public void onResume() {
        super.onResume();
        mTop.setFocusable(true);
        mTop.setFocusableInTouchMode(true);
        mTop.requestFocus();
//        mScrollView.post(new Runnable() {
//            @Override
//            public void run() {
//             mScrollView.scrollTo(0,0);
//            }
//        });
    }


    @Override
    public void onPause() {
        super.onPause();
    }



    @Override
    protected int getLayoutID() {
        return R.layout.activity_goods_detail;
    }

    @Override
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
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                for (int i = 0; i < rbs.length; i++)
//                {
//                    if (rbs[i] != checkedId) continue;
//                    //加载滑动
//                    vp.setCurrentItem(i);
//                    setLabState(checkedId);
//                }
//            }
//        });

//        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
//        {
//            @Override
//            public void onPageSelected(int position) {
//                vp.resetHeight(position);
//                rg.check(rbs[position]);
//                setLabState(rbs[position]);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                mScrollView.smoothScrollTo(0, 0);
//            }
//        });

//        rg.check(rbs[0]);
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        state = intent.getStringExtra("STATE");

        mScrollView = f(R.id.scrollView_goods);
//        vp = f(R.id.vp);
//        rg = f(R.id.rg);


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
        handler.postDelayed(runnable, 1000);
    }

    private void  initFirstFragment()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(one == null)
        {
            one = new JoinRecordFragment();
        }
        transaction.replace(R.id.goods_frame_layout, one);
        transaction.commit();
    }

    private void  initSecondFragment()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(two == null)
        {
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
                if(i==0){
                    if(split[0].length()<2)
                    {
                        shi.setText("0"+split[0]);
                    }else
                    {
                        shi.setText(split[0]);
                    }

                }
                if(i==1){

                    if(split[1].length()<2)
                    {
                        fen.setText("0"+split[1]);
                    }else
                    {
                        fen.setText(split[1]);
                    }
                }
                if(i==2){
                    if(split[2].length()<2)
                    {
                        miao.setText("0"+split[2]);
                    }else
                    {
                        miao.setText(split[2]);
                    }
                }

            }
            if(time>0){
                handler.postDelayed(this, 1000);
            }
        }
    };

    public  String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue() ;
        if (second > 60) {
            minute = second / 60;         //取整
            second = second % 60;         //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour+"："+minute+"："+second;
        return strtime;

    }


    @Override
    protected void initData() {


        if(state.equals("1"))
        {
            kaijiang.setVisibility(View.VISIBLE);
            bukaijiang.setVisibility(View.GONE);
            goodstate.setText("倒计时");
            daojishiTime.setVisibility(View.VISIBLE);
            goodstate.setBackgroundResource(R.mipmap.good_state_daojishi);
        }else if(state.equals("2"))
        {
            kaijiang.setVisibility(View.GONE);
            bukaijiang.setVisibility(View.VISIBLE);
            goodstate.setText("进行中");
            daojishiTime.setVisibility(View.GONE);
            goodstate.setBackgroundResource(R.mipmap.good_state_ing);
        }else
        {
            daojishiTime.setVisibility(View.GONE);
            kaijiang.setVisibility(View.VISIBLE);
            bukaijiang.setVisibility(View.GONE);
            goodstate.setText("已开奖");
            goodstate.setBackgroundResource(R.mipmap.good_state_end);
        }


        mFragments=new ArrayList<>();
        JoinRecordFragment one=new JoinRecordFragment();
        HistoryPersonFragment two=new HistoryPersonFragment();
        mFragments.add(one);
        mFragments.add(two);
        initFirstFragment();
        // 设置填充器
//        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(),mFragments));
        // 设置缓存页面数
//        vp.setOffscreenPageLimit(2);
    }

    /**
     *
     * 提供子fragment调用方法，解决listview高度不自适应出现多余空白
     */
//    public  void setChildObjectForPosition(View com.zhongbao.zhongbao.view,int poistion){
//        vp.setObjectForPosition(com.zhongbao.zhongbao.view,poistion);
//    }

    private void setLabState(int id)
    {
        if(id == R.id.rb_all)
        {
            mAll.setTextColor(getResources().getColor(R.color.bottom_tab_select));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.VISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
        }else if(id == R.id.rb_ing)
        {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.bottom_tab_select));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.VISIBLE);
        }else if(id == R.id.rb_ed)
        {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
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