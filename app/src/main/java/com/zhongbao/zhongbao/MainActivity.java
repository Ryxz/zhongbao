package com.zhongbao.zhongbao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.List;

import com.zhongbao.fragment.GoodsFragment;
import com.zhongbao.fragment.HomeFragment;
import com.zhongbao.fragment.LatestFragment;
import com.zhongbao.fragment.MyFrament;
import com.zhongbao.fragment.ProductFragment;
import com.zhongbao.fragment.ShopCarFragment;
import com.zhongbao.home.HomeDialogActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mShopCar;
    private LinearLayout mHome,mGoods,mLateast,mMine;
    private ImageView mHomeIv,mGoodsIv,mLateastIv,mShopIv,mMineIv;
    private  TextView mHomeTv,mGoodsTv,mLateastTv,mShopTv,mMineTv;
    private HomeFragment homeFragment;
    private ProductFragment productFragment;
    private LatestFragment latestFragment;
    private ShopCarFragment shopCarFragment;
    private MyFrament myFrament;


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        mHome.setOnClickListener(this);
        mGoods.setOnClickListener(this);
        mLateast.setOnClickListener(this);
        mShopCar.setOnClickListener(this);
        mMine.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mHome = f(R.id.home_linear);
        mGoods = f(R.id.goods_linear);
        mLateast = f(R.id.lateast_linear);
        mShopCar = f(R.id.shopcar_linear);
        mMine = f(R.id.mine_linear);

        mHomeIv = f(R.id.home_iv);
        mGoodsIv = f(R.id.goods_iv);
        mLateastIv = f(R.id.latest_iv);
        mShopIv = f(R.id.shop_iv);
        mMineIv = f(R.id.my_iv);

        mHomeTv = f(R.id.home_tv);
        mGoodsTv = f(R.id.goods_tv);
        mLateastTv = f(R.id.lateast_tv);
        mShopTv = f(R.id.shop_tv);
        mMineTv = f(R.id.mine_tv);
        startActivity(new Intent(this,HomeDialogActivity.class));
        initFirstFragment();
    }

    private void  initFirstFragment()
    {
        initIVTVData(1);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //隐藏所有fragment
        hideFragment(transaction);
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(homeFragment == null){
            homeFragment = new HomeFragment();
            transaction.add(R.id.main_frame_layout, homeFragment);
        }
        //显示需要显示的fragment
        transaction.show(homeFragment);
        //提交事务
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void  initSecondFragment()
    {
        initIVTVData(2);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(productFragment == null){
            productFragment = new ProductFragment();
            transaction.add(R.id.main_frame_layout, productFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(productFragment);
        //提交事务
        transaction.commit();
    }


    private void  initThirdFragment()
    {
        initIVTVData(3);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(latestFragment == null){
            latestFragment = new LatestFragment();
            transaction.add(R.id.main_frame_layout, latestFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(latestFragment);
        //提交事务
        transaction.commit();
    }


    private void  initFourFragment()
    {
        initIVTVData(4);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(shopCarFragment == null){
            shopCarFragment = new ShopCarFragment();
            transaction.add(R.id.main_frame_layout, shopCarFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(shopCarFragment);
        //提交事务
        transaction.commit();
    }

    private void  initFiveFragment()
    {
        initIVTVData(5);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(myFrament == null){
            myFrament = new MyFrament();
            transaction.add(R.id.main_frame_layout, myFrament);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(myFrament);
        //提交事务
        transaction.commit();
    }

    private void initIVTVData(int position)
    {
        switch (position)
        {
            case 1:
                mHomeIv.setImageResource(R.mipmap.zb_home_select);
                mHomeTv.setTextColor(getResources().getColor(R.color.bg_toolbar));
                mGoodsIv.setImageResource(R.mipmap.zb_goods);
                mGoodsTv.setTextColor(getResources().getColor(R.color.text_dray));
                mLateastIv.setImageResource(R.mipmap.zb_latest);
                mLateastTv.setTextColor(getResources().getColor(R.color.text_dray));
                mShopIv.setImageResource(R.mipmap.zb_shopcar);
                mShopTv.setTextColor(getResources().getColor(R.color.text_dray));
                mMineIv.setImageResource(R.mipmap.zb_my);
                mMineTv.setTextColor(getResources().getColor(R.color.text_dray));
                break;
            case 2:
                mHomeIv.setImageResource(R.mipmap.zb_home);
                mHomeTv.setTextColor(getResources().getColor(R.color.text_dray));
                mGoodsIv.setImageResource(R.mipmap.zb_goods_select);
                mGoodsTv.setTextColor(getResources().getColor(R.color.bg_toolbar));
                mLateastIv.setImageResource(R.mipmap.zb_latest);
                mLateastTv.setTextColor(getResources().getColor(R.color.text_dray));
                mShopIv.setImageResource(R.mipmap.zb_shopcar);
                mShopTv.setTextColor(getResources().getColor(R.color.text_dray));
                mMineIv.setImageResource(R.mipmap.zb_my);
                mMineTv.setTextColor(getResources().getColor(R.color.text_dray));
                break;
            case 3:
                mHomeIv.setImageResource(R.mipmap.zb_home);
                mHomeTv.setTextColor(getResources().getColor(R.color.text_dray));
                mGoodsIv.setImageResource(R.mipmap.zb_goods);
                mGoodsTv.setTextColor(getResources().getColor(R.color.text_dray));
                mLateastIv.setImageResource(R.mipmap.zb_lateast_select);
                mLateastTv.setTextColor(getResources().getColor(R.color.bg_toolbar));
                mShopIv.setImageResource(R.mipmap.zb_shopcar);
                mShopTv.setTextColor(getResources().getColor(R.color.text_dray));
                mMineIv.setImageResource(R.mipmap.zb_my);
                mMineTv.setTextColor(getResources().getColor(R.color.text_dray));
                break;

            case 4:
                mHomeIv.setImageResource(R.mipmap.zb_home);
                mHomeTv.setTextColor(getResources().getColor(R.color.text_dray));
                mGoodsIv.setImageResource(R.mipmap.zb_goods);
                mGoodsTv.setTextColor(getResources().getColor(R.color.text_dray));
                mLateastIv.setImageResource(R.mipmap.zb_latest);
                mLateastTv.setTextColor(getResources().getColor(R.color.text_dray));
                mShopIv.setImageResource(R.mipmap.zb_shopcar_select);
                mShopTv.setTextColor(getResources().getColor(R.color.bg_toolbar));
                mMineIv.setImageResource(R.mipmap.zb_my);
                mMineTv.setTextColor(getResources().getColor(R.color.text_dray));
                break;
            case 5:
                mHomeIv.setImageResource(R.mipmap.zb_home);
                mHomeTv.setTextColor(getResources().getColor(R.color.text_dray));
                mGoodsIv.setImageResource(R.mipmap.zb_goods);
                mGoodsTv.setTextColor(getResources().getColor(R.color.text_dray));
                mLateastIv.setImageResource(R.mipmap.zb_latest);
                mLateastTv.setTextColor(getResources().getColor(R.color.text_dray));
                mShopIv.setImageResource(R.mipmap.zb_shopcar);
                mShopTv.setTextColor(getResources().getColor(R.color.text_dray));
                mMineIv.setImageResource(R.mipmap.zb_my_selcet);
                mMineTv.setTextColor(getResources().getColor(R.color.bg_toolbar));
                break;
        }



    }




    private void hideFragment(FragmentTransaction transaction )
    {
        if(homeFragment !=null)
        {
            transaction.hide(homeFragment);
        }
        if(productFragment !=null)
        {
            transaction.hide(productFragment);
        }
        if(latestFragment !=null)
        {
            transaction.hide(latestFragment);
        }
        if(shopCarFragment !=null)
        {
            transaction.hide(shopCarFragment);
        }
        if(myFrament !=null)
        {
            transaction.hide(myFrament);
        }
    }

    @Override
    protected void initData() {

    }

    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.home_linear:
                if(!getVisibleFragment().equals(homeFragment))
                {
                    initFirstFragment();
                }

                break;
            case R.id.goods_linear:
                initSecondFragment();
                break;
            case R.id.lateast_linear:
                initThirdFragment();
                break;
            case R.id.shopcar_linear:
                initFourFragment();
                break;
            case R.id.mine_linear:
                initFiveFragment();
                break;
        }
    }
}
