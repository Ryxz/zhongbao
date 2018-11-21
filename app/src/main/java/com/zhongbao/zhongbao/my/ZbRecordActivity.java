package com.zhongbao.zhongbao.my;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.PagerMainAdapter;
import com.zhongbao.zhongbao.fragment.AllRecordFragment;
import com.zhongbao.zhongbao.fragment.EndRecordFragment;
import com.zhongbao.zhongbao.fragment.OngoingFragment;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class ZbRecordActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager vp;
    private RadioGroup rg;
    private int[] rbs = {R.id.rb_all, R.id.rb_ing, R.id.rb_ed};
    private List<Fragment> mFragments;
    private RadioButton mAll, mIng, mEd;
    private LinearLayout mLabone, mLabtwo, mLabThree;
    private RelativeLayout mBack;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_zbrecord;
    }

    protected void initListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbs.length; i++) {
                    if (rbs[i] != checkedId) continue;
                    //加载滑动
                    vp.setCurrentItem(i);
                    setLabState(checkedId);
                }
            }
        });

        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                rg.check(rbs[position]);
                setLabState(rbs[position]);
            }
        });

        rg.check(rbs[0]);
    }

    @Override
    protected void initView() {
        vp = f(R.id.vp);
        rg = f(R.id.rg);

        mAll = f(R.id.rb_all);
        mIng = f(R.id.rb_ing);
        mEd = f(R.id.rb_ed);

        mLabone = f(R.id.lab_one);
        mLabtwo = f(R.id.lab_two);
        mLabThree = f(R.id.lab_three);

        mBack = f(R.id.back_left);

        mBack.setOnClickListener(this);
    }

    private void setLabState(int id) {
        if (id == R.id.rb_all) {
            mAll.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mEd.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.VISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
            mLabThree.setVisibility(View.INVISIBLE);
        } else if (id == R.id.rb_ing) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mEd.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.VISIBLE);
            mLabThree.setVisibility(View.INVISIBLE);
        } else if (id == R.id.rb_ed) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mEd.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
            mLabThree.setVisibility(View.VISIBLE);
        }
    }

    protected void initData() {
        mFragments = new ArrayList<>();
        AllRecordFragment one = new AllRecordFragment();
        OngoingFragment two = new OngoingFragment();
        EndRecordFragment three = new EndRecordFragment();
        mFragments.add(one);
        mFragments.add(two);
        mFragments.add(three);

        // 设置填充器
        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(), mFragments));
        // 设置缓存页面数
        vp.setOffscreenPageLimit(2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_left:
                finish();
                break;
        }
    }
}
