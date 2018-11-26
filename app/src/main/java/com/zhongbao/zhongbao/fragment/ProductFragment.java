package com.zhongbao.zhongbao.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zhongbao.zhongbao.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.CategoryAdapter;
import com.zhongbao.zhongbao.adapter.ProductAdapter;
import com.zhongbao.zhongbao.base.BaseFragment;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.base.GlideImageLoader;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.Category;
import com.zhongbao.zhongbao.bean.HomeBean;
import com.zhongbao.zhongbao.bean.Product;
import com.zhongbao.zhongbao.bean.TypeBean;
import com.zhongbao.zhongbao.custom.ProductRecycleView;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.home.SearchActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;
import com.zhongbao.zhongbao.utils.JsonParseUtils;
import com.zhongbao.zhongbao.utils.RecycleViewDecoration;
import com.zhongbao.zhongbao.view.CrosheTabView;

public class ProductFragment extends BaseFragment {

    private List<TypeBean> typeList = new ArrayList<>();

    private List<Product> mProductList = new ArrayList<>();

    private RecyclerView mRecycleViewCategory;

    private ProductRecycleView mRecycleViewProduct;

    private CategoryAdapter mCategoryAdapter;

    private ProductAdapter mProductAdapter;

    private ImageView search;
    private LinearLayout llProduct;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_product;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mRecycleViewCategory = findViewById(R.id.rv_category);
        mRecycleViewProduct =findViewById(R.id.rv_product);
        search =findViewById(R.id.search);
        llProduct =findViewById(R.id.ll_product);
        mRecycleViewCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleViewProduct.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecycleViewProduct.addItemDecoration(new RecycleViewDecoration(getContext()));
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        /*
         * 用于切换左侧分类选中的
         */
        mRecycleViewProduct.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //修复点击和滑动冲突，分类落焦不对，以及最后一个分类只有一条数据，无法落焦分类问题
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (null != layoutManager && mRecycleViewProduct.isTouch()) {
                    int firstItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    int lastItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    String firstCategoryID = mProductList.get(firstItemPosition).getCategoryID();
                    String lastCategoryID = mProductList.get(lastItemPosition).getCategoryID();
                    if (!firstCategoryID.equals(lastCategoryID) && (lastItemPosition == mProductAdapter.getItemCount() - 1)) {
                        firstCategoryID = lastCategoryID;
                    }
                    mCategoryAdapter.setSelectCategoryID(firstCategoryID);
                }
            }
        });

        //选项卡固定个数
        String[] titles = new String[]{"即将揭晓", "人气", "最新","价格"};
        int[] unSelect = new int[]{0, 0, 0,0};
        int[] Select = new int[]{0, 0, 0,0};
        crosheTabView = new CrosheTabView(getContext(), titles, unSelect, Select, getResources().getColor(R.color.bg_toolbar), getResources().getColor(R.color.black), new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
//                dealersCapLei = String.valueOf(position);
//                getWallet(1);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        llProduct.addView(crosheTabView);
        registerBoradcastReceiver();
        getLeft();
    }
    private CrosheTabView crosheTabView;

    public void registerBoradcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("changeNews");

        getActivity().registerReceiver(myBroadcastReceive, intentFilter);
    }

    public BroadcastReceiver myBroadcastReceive = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("changeNews")) {
                crosheTabView.setTab(2);
            } else if (action.equals("changeLeft")) {
                String classId = intent.getStringExtra("classId");
            }else if (action.equals("refresh")){
            }
        }
    };


//    /**
//     * 如果筛选条件是查接口，查回来数据，调用这个方法就可以了
//     */
//    private void refreshProductData(String json) {
//        mProductList.clear();
//        typeList = JsonParseUtils.jsonToClassList(json, Category.class);
//        if (null != typeList) {
//            for (Category category : typeList) {
//                List<Product> products = category.getProduct();
//                for (Product product : products) {
//                    //更新分类ID
//                    product.setCategoryID(category.getCategoryID());
//                }
//                mProductList.addAll(products);
//            }
//        }
//    }
//

    /**
     * 左边分类
     */
    public void getLeft(){
        getHttpService().goodstype()
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<List<TypeBean>>>() {
                    @Override
                    protected void onDoNext(BasicModel<List<TypeBean>> listBasicModel) {
                        typeList.clear();
                        typeList.addAll(listBasicModel.getData());
                        initData();
                    }
                });
    }

    private void initData() {
//        refreshProductData(ALL_PRODUCT_JSON);
        mCategoryAdapter = new CategoryAdapter(getActivity(), typeList);
        mProductAdapter = new ProductAdapter(getActivity(), mProductList);
        mRecycleViewCategory.setAdapter(mCategoryAdapter);
        mRecycleViewProduct.setAdapter(mProductAdapter);

        mProductAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {

                if (ButtonUtils.isFastClick()) {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE", "2");
                    startActivity(intent);
                }
            }
        });


        /*
         * 设置分类点击
         */
        mCategoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                String categoryID = String.valueOf(typeList.get(position).getId());
                int scrollPosition = 0;
                mCategoryAdapter.setSelectCategoryID(String.valueOf(typeList.get(position).getId()));
//                if (null == mRecycleViewProduct.getLayoutManager()) return;
//                for (Product product : mProductList) {
//                    if (categoryID.equals(product.getCategoryID())) {
//                        //不抢占落焦状态更新
//                        mRecycleViewProduct.setTouch(false);
//                        //设置落焦状态
//
//                        //列表定位
//                        ((LinearLayoutManager) mRecycleViewProduct.getLayoutManager()).scrollToPositionWithOffset(scrollPosition, 0);
//                        break;
//                    }
//                    ++scrollPosition;
//                }
            }
        });
    }

}
