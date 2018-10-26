package com.zhongbao.zhongbao.login;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.PagerMainAdapter;
import com.zhongbao.zhongbao.fragment.AccountLoginFragment;
import com.zhongbao.zhongbao.fragment.PhoneLoginFragment;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager vp;
    private RadioGroup rg;
    private int[] rbs = {R.id.rb_all, R.id.rb_ing};
    private List<Fragment> mFragments;
    private RadioButton mAll,mIng;
    private RelativeLayout mLabone,mLabtwo;
    private RelativeLayout mBack;
    private RelativeLayout mRegister;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        mRegister.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbs.length; i++)
                {
                    if (rbs[i] != checkedId) continue;
                    //加载滑动
                    vp.setCurrentItem(i);
                    setLabState(checkedId);
                }
            }
        });

        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
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

        mLabone = f(R.id.lab_one);
        mLabtwo = f(R.id.lab_two);

        mBack = f(R.id.back_left);

        mRegister = f(R.id.to_register);

        mBack.setOnClickListener(this);
    }

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
    protected void initData() {
        mFragments=new ArrayList<>();
        AccountLoginFragment one=new AccountLoginFragment();
        PhoneLoginFragment two=new PhoneLoginFragment();
        mFragments.add(one);
        mFragments.add(two);

        // 设置填充器
        vp.setAdapter(new PagerMainAdapter(getSupportFragmentManager(),mFragments));
        // 设置缓存页面数
        vp.setOffscreenPageLimit(2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_left:
                finish();
                break;
            case R.id.to_register:
                startActivity(new Intent(this,RegisterActivity.class));
                finish();
                break;
        }
    }
}
