package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.youth.banner.Banner;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.adapter.FirstAdapter;
import com.zhongbao.zhongbao.base.GlideImageLoader;
import com.zhongbao.zhongbao.base.HeaderRecyclerView;
import com.zhongbao.zhongbao.dialog.WinningInfoDialog;
import com.zhongbao.zhongbao.goods.NoviceActivity;
import com.zhongbao.zhongbao.home.SearchActivity;
import com.zhongbao.zhongbao.home.XianGouActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.my.PayActivity;
import com.zhongbao.zhongbao.my.SystemNewsActivity;
import com.zhongbao.zhongbao.my.TAcenterActivity;
import com.zhongbao.zhongbao.view.HomePopwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements View.OnClickListener, OnRefreshListener {
    private HeaderRecyclerView recycler_first;
    private FirstAdapter firstAdapter;
    private List<String> list = new ArrayList<>();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_first,null, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540804165171&di=78ff2a5841113f0bf7d3752f425640fd&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F011f4b57eb26bfa84a0e282bc61d8a.jpg%401280w_1l_2o_100sh.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541399307&di=896baa14d64884f26d9955376ff084f6&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01139a59b0a09fa801211d25eaa714.jpg%402o.jpg");
        f1_banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
        f1_banner.start();
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
        list1.add("恭喜");
        list1.add("恭喜");
        list1.add("恭喜");
        list2.add("小麦");
        list2.add("小米");
        list2.add("小哥");
        list3.add("购买了大礼包");
        list3.add("购买了永恒之星");
        list3.add("购买了香奈儿");

        winningInfoDialog = new WinningInfoDialog(getContext(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winningInfoDialog.dismiss();
            }
        });
        winningInfoDialog.show();
        viewFlipper.getVerticalScrollbarPosition();


        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_flipper, null);
            TextView tv1 = view.findViewById(R.id.tv_1);
            TextView tv2 = view.findViewById(R.id.tv_2);
            TextView tv3 = view.findViewById(R.id.tv_3); tv1.setText(list1.get(i));
            tv2.setText(list2.get(i));
            tv3.setText(list3.get(i));
            viewFlipper.addView(view);
        }
        viewFlipper.startFlipping();

        getData();
    }

    public void getData(){
        firstAdapter.notifyDataSetChanged();
    }

    boolean isUp = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_all:
                setLabState(v.getId());
                firstAdapter.setAdapterType(1);
                break;
            case R.id.rb_price:
                firstAdapter.setAdapterType(2);
                if (isUp){
                    imgUp.setImageResource(R.mipmap.go_top);
                    imgDown.setImageResource(R.mipmap.go_bottom_select);
                    isUp = false;
                }else {
                    imgUp.setImageResource(R.mipmap.go_top_select);
                    imgDown.setImageResource(R.mipmap.go_bottom);
                    isUp = true;
                }
                setLabState(v.getId());
                break;
            case R.id.rb_ing:
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
