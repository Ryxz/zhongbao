package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.youth.banner.Banner;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.adapter.FirstAdapter;
import com.zhongbao.zhongbao.base.BaseFragment;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.base.GlideImageLoader;
import com.zhongbao.zhongbao.base.HeaderRecyclerView;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.GoodsDetailBean;
import com.zhongbao.zhongbao.bean.HomeBean;
import com.zhongbao.zhongbao.dialog.WinningInfoDialog;
import com.zhongbao.zhongbao.goods.NoviceActivity;
import com.zhongbao.zhongbao.home.SearchActivity;
import com.zhongbao.zhongbao.home.XianGouActivity;
import com.zhongbao.zhongbao.my.AddAdressActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.my.PayActivity;
import com.zhongbao.zhongbao.my.SystemNewsActivity;
import com.zhongbao.zhongbao.my.TAcenterActivity;
import com.zhongbao.zhongbao.view.HomePopwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstFragment extends BaseFragment implements View.OnClickListener, OnRefreshListener {
    private HeaderRecyclerView recycler_first;
    private FirstAdapter firstAdapter;
    private List<GoodsDetailBean> list = new ArrayList<>();
    private View headview;
    private LinearLayout mShaidan, mXinpin, mXiangou, mXinshou, mPay,mSkipCenter;
    private Banner f1_banner;
    private RelativeLayout mSearch,rbPrice;
    private TextView mShowPop,mAll, mEd,mIng;
    private ImageView homeNewsIv,homeType,imgUp,imgDown;
    private LinearLayout mLabone, mLabtwo, mLabThree;
    SwipeToLoadLayout swipeToLoadLayout;
    private WinningInfoDialog winningInfoDialog;
    private LinearLayout ll_vertical;
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list3 = new ArrayList<>();
    private ViewFlipper viewFlipper;
    private List<String> imgList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler_first = getActivity().findViewById(R.id.recycler_first);
        mSearch = getActivity().findViewById(R.id.search);
        mShowPop = getActivity().findViewById(R.id.pop_show);
        mShowPop.setOnClickListener(this);
        homeNewsIv = getActivity().findViewById(R.id.home_news_iv);
        homeType = getActivity().findViewById(R.id.home_type);
        mSearch.setOnClickListener(this);
        recycler_first.setLayoutManager(new GridLayoutManager(getContext(),2));
        firstAdapter = new FirstAdapter(getContext(),list);
        recycler_first.setAdapter(firstAdapter);

        headview = LayoutInflater.from(getContext()).inflate(R.layout.item_fragment01_headview, recycler_first, false);
        recycler_first.addHeaderView(headview);
        swipeToLoadLayout = getActivity().findViewById(R.id.swipeToLoadLayout);

        swipeToLoadLayout.setTargetView(recycler_first);
        swipeToLoadLayout.setRefreshHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.layout_twitter_header, swipeToLoadLayout, false));
        swipeToLoadLayout.setOnRefreshListener(this);

        mShaidan = headview.findViewById(R.id.home_shaidan);
        mXinpin = headview.findViewById(R.id.home_xinpin);
        mXiangou = headview.findViewById(R.id.home_xiangou);
        mXinshou = headview.findViewById(R.id.home_xinshou);
        mPay = headview.findViewById(R.id.home_pay);
        mShaidan.setOnClickListener(this);
        mXinpin.setOnClickListener(this);
        mXiangou.setOnClickListener(this);
        mXinshou.setOnClickListener(this);
        mPay.setOnClickListener(this);

        f1_banner = headview.findViewById(R.id.f1_banner);

        mSkipCenter = headview.findViewById(R.id.skip_center);
        mSkipCenter.setOnClickListener(this);
        homeType.setOnClickListener(this);
        homeNewsIv.setOnClickListener(this);

        mAll = headview.findViewById(R.id.rb_all);
        mIng = headview.findViewById(R.id.rb_ing);
        mEd = headview.findViewById(R.id.rb_ed);
        rbPrice = headview.findViewById(R.id.rb_price);
        mLabone = headview.findViewById(R.id.lab_one);
        mLabtwo = headview.findViewById(R.id.lab_two);
        mLabThree = headview.findViewById(R.id.lab_three);
        imgUp = headview.findViewById(R.id.img_up);
        imgDown = headview.findViewById(R.id.img_down);

        mAll.setOnClickListener(this);
        mIng.setOnClickListener(this);
        rbPrice.setOnClickListener(this);
        viewFlipper = headview.findViewById(R.id.filpper);
        winningInfoDialog = new WinningInfoDialog(getContext(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winningInfoDialog.dismiss();
            }
        });
        winningInfoDialog.show();
        viewFlipper.getVerticalScrollbarPosition();
        getData("","");
    }
    Map<String,String> map = new HashMap<>();

    public void getData(String isnew,String is_price){
        if (!TextUtils.isEmpty(isnew)){
            map.put("is_new",isnew);
        }else if (!TextUtils.isEmpty(is_price)){
            map.put("is_price",is_price);
        }
        getHttpService().index(map)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<HomeBean>>(getContext()) {
                    @Override
                    protected void onDoNext(BasicModel<HomeBean> basicModel) {
                        imgList.clear();
                        String images = basicModel.getData().getLunbo().get(0).getGoods_imgss();
                        String[] image=images.split(";");
                        for (int i = 0;i<image.length;i++){
                            imgList.add("http://39.98.62.92/static/uploads/"+image[i]);
                        }
                        f1_banner.setImages(imgList)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                        list.clear();
                        list.addAll(basicModel.getData().getList());
                        firstAdapter.notifyDataSetChanged();
                        list1.clear();
                        list2.clear();
                        list3.clear();
                        for (int i = 0;i<basicModel.getData().getPrise().size();i++){
                            list1.add("恭喜");
                            list2.add(basicModel.getData().getPrise().get(i).getUsername());
                            list3.add("购买了"+basicModel.getData().getPrise().get(i).getName());
                        }
                        verText();
//                        Toast.makeText(getContext(), basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void verText(){
        for (int i = 0; i < 3; i++) {
            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.item_flipper, null);
            TextView tv1 = view1.findViewById(R.id.tv_1);
            TextView tv2 = view1.findViewById(R.id.tv_2);
            TextView tv3 = view1.findViewById(R.id.tv_3);
            tv1.setText(list1.get(i));
            tv2.setText(list2.get(i));
            tv3.setText(list3.get(i));
            viewFlipper.addView(view1);
        }
        viewFlipper.startFlipping();
    }

    boolean isUp = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_all:
                getData("","");
                setLabState(v.getId());
                firstAdapter.setAdapterType(1);
                break;
            case R.id.rb_price:
                firstAdapter.setAdapterType(2);
                if (isUp){
                    getData("","desc");
                    imgUp.setImageResource(R.mipmap.go_top);
                    imgDown.setImageResource(R.mipmap.go_bottom_select);
                    isUp = false;
                }else {
                    getData("","asc");
                    imgUp.setImageResource(R.mipmap.go_top_select);
                    imgDown.setImageResource(R.mipmap.go_bottom);
                    isUp = true;
                }
                setLabState(v.getId());
                break;
            case R.id.rb_ing:
                getData("1","");
                firstAdapter.setAdapterType(3);
                setLabState(v.getId());
                break;
            case R.id.home_shaidan:
                startActivity(new Intent(getActivity(), MyBaskActivity.class));
                break;
            case R.id.home_xiangou:
                startActivity(new Intent(getActivity(), XianGouActivity.class));
                break;
            case R.id.home_xinshou:
                startActivity(new Intent(getActivity(), NoviceActivity.class));
                break;

            case R.id.home_xinpin:
                getContext().sendBroadcast(new Intent("changeNews"));
//                startActivity(new Intent(getActivity(), XinpinActivity.class));
                break;

            case R.id.home_pay:
                startActivity(new Intent(getActivity(), PayActivity.class));
                break;
            case R.id.skip_center:
                startActivity(new Intent(getActivity(), TAcenterActivity.class));
                break;
            case R.id.home_type:
                HomePopwindow pop = new HomePopwindow(getActivity());
                pop.showAsDropDown(mShowPop);
                break;
            case R.id.home_news_iv:
                startActivity(new Intent(getActivity(), SystemNewsActivity.class));
                break;
            case R.id.search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
        }
    }

    private void setLabState(int id) {
        if (id ==  R.id.rb_all) {
            mAll.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mLabone.setVisibility(View.VISIBLE);
        }else {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.INVISIBLE);
        }
        if (id == R.id.rb_ing) {
            mIng.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mLabtwo.setVisibility(View.VISIBLE);
        }else {
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mLabtwo.setVisibility(View.INVISIBLE);
        }
        if (id == R.id.rb_price) {
            mEd.setTextColor(getResources().getColor(R.color.bg_toolbar));
            mLabThree.setVisibility(View.VISIBLE);
        }else {
            mEd.setTextColor(getResources().getColor(R.color.text_dray));
            mLabThree.setVisibility(View.INVISIBLE);
        }
        onRefresh();
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.setRefreshing(false);
    }
}
