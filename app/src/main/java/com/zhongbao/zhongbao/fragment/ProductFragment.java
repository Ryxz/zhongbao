package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
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

import com.zhongbao.zhongbao.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.CategoryAdapter;
import com.zhongbao.zhongbao.adapter.ProductAdapter;
import com.zhongbao.zhongbao.bean.Category;
import com.zhongbao.zhongbao.bean.Product;
import com.zhongbao.zhongbao.custom.ProductRecycleView;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.home.SearchActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;
import com.zhongbao.zhongbao.utils.JsonParseUtils;
import com.zhongbao.zhongbao.utils.RecycleViewDecoration;

public class ProductFragment extends Fragment implements OnClickListener {

  /**
   * 数据格式参考README.md中的内容
   */
  private static final String ALL_PRODUCT_JSON = "[{\n"
      + "\t\t\"categoryID\": \"1\",\n"
      + "\t\t\"categoryName\": \"全部\",\n"
      + "\t\t\"product\": [{\n"
      + "\t\t\t\t\"productID\": \"1\",\n"
      + "\t\t\t\t\"productName\": \"香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿香奈儿\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"30\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"2\",\n"
      + "\t\t\t\t\"productName\": \"香奈儿\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"10\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"3\",\n"
      + "\t\t\t\t\"productName\": \"香奈儿\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"80\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"4\",\n"
      + "\t\t\t\t\"productName\": \"香奈儿\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"90\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"5\",\n"
      + "\t\t\t\t\"productName\": \"香奈儿\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"100\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t}\n"
      + "\n"
      + "\t\t]\n"
      + "\t},\n"
      + "\t{\n"
          + "\t\t\"categoryID\": \"2\",\n"
          + "\t\t\"categoryName\": \"手机数码\",\n"
          + "\t\t\"product\": [{\n"
          + "\t\t\t\t\"productID\": \"1\",\n"
          + "\t\t\t\t\"productName\": \"电脑办公第一条数据\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"0\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"2\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"60\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"3\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"50\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"4\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"50\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"5\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"50\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"6\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"50\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t},\n"
          + "\t\t\t{\n"
          + "\t\t\t\t\"productID\": \"7\",\n"
          + "\t\t\t\t\"productName\": \"软键盘\",\n"
          + "\t\t\t\t\"productPrice\": \"1.00\",\n"
          + "\t\t\t\t\"surplusNumber\": \"50\",\n"
          + "\t\t\t\t\"totalNumber\": \"100\"\n"
          + "\t\t\t}\n"
          + "\t\t]\n"
          + "\t},\n"
          + "\t{\n"
      + "\t\t\"categoryID\": \"3\",\n"
      + "\t\t\"categoryName\": \"电脑办公\",\n"
      + "\t\t\"product\": [{\n"
      + "\t\t\t\t\"productID\": \"1\",\n"
      + "\t\t\t\t\"productName\": \"电脑办公第一条数据\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"0\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"2\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"60\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"3\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"4\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"5\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"6\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"7\",\n"
      + "\t\t\t\t\"productName\": \"软键盘\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t}\n"
      + "\t\t]\n"
      + "\t},\n"
      + "\t{\n"
      + "\t\t\"categoryID\": \"4\",\n"
      + "\t\t\"categoryName\": \"汽车\",\n"
      + "\t\t\"product\": [{\n"
      + "\t\t\t\t\"productID\": \"1\",\n"
      + "\t\t\t\t\"productName\": \"汽车1\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"20\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"2\",\n"
      + "\t\t\t\t\"productName\": \"汽车2\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"70\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"3\",\n"
      + "\t\t\t\t\"productName\": \"汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3汽车3\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"4\",\n"
      + "\t\t\t\t\"productName\": \"汽车4\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"80\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"5\",\n"
      + "\t\t\t\t\"productName\": \"汽车5\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"6\",\n"
      + "\t\t\t\t\"productName\": \"汽车6\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"5\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t},\n"
      + "\t\t\t{\n"
      + "\t\t\t\t\"productID\": \"7\",\n"
      + "\t\t\t\t\"productName\": \"汽车7\",\n"
      + "\t\t\t\t\"productPrice\": \"1.00\",\n"
      + "\t\t\t\t\"surplusNumber\": \"50\",\n"
      + "\t\t\t\t\"totalNumber\": \"100\"\n"
      + "\t\t\t}\n"
      + "\t\t]\n"
      + "\t}\n"
      + "\n"
      + "]";

  private List<Category> mCategoryList;

  private List<Product> mProductList = new ArrayList<>();

  private RecyclerView mRecycleViewCategory;

  private ProductRecycleView mRecycleViewProduct;

  private CategoryAdapter mCategoryAdapter;

  private ProductAdapter mProductAdapter;

  private ImageView search;

  private List<WeakReference<View>> mAllNavViews=new ArrayList<>();

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_product,container,false);
    initView(view);
    initData();
    return view;
  }

  private void addAllNavView(View view,int...ids){
    for (int id:ids){
      View initView=view.findViewById(id);
      if(id== R.id.tv_announce){//默认选中"全部"
        initView.setSelected(true);
      }
      initView.setOnClickListener(this);
      mAllNavViews.add(new WeakReference<View>(initView));
    }
  }

  private void initView(View view){
    addAllNavView(view,R.id.tv_all,R.id.tv_announce,R.id.tv_popularity,R.id.tv_new,R.id.tv_price);
    mRecycleViewCategory=view.findViewById(R.id.rv_category);
    mRecycleViewProduct=view.findViewById(R.id.rv_product);
    search = view.findViewById(R.id.search);
    mRecycleViewCategory.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    mRecycleViewProduct.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    mRecycleViewProduct.addItemDecoration(new RecycleViewDecoration(view.getContext()));
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
        if(null!=layoutManager && mRecycleViewProduct.isTouch()){
          int firstItemPosition = ((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();
          int lastItemPosition = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
          String firstCategoryID=mProductList.get(firstItemPosition).getCategoryID();
          String lastCategoryID=mProductList.get(lastItemPosition).getCategoryID();
          if(!firstCategoryID.equals(lastCategoryID) && (lastItemPosition==mProductAdapter.getItemCount()-1)){
            firstCategoryID=lastCategoryID;
          }
          mCategoryAdapter.setSelectCategoryID(firstCategoryID);
        }
      }
    });
  }

  /**
   * 如果筛选条件是查接口，查回来数据，调用这个方法就可以了
   */
  private void refreshProductData(String json){
    mProductList.clear();
    mCategoryList = JsonParseUtils.jsonToClassList(json, Category.class);
    if (null != mCategoryList) {
      for (Category category : mCategoryList) {
        List<Product> products = category.getProduct();
        for (Product product : products) {
          //更新分类ID
          product.setCategoryID(category.getCategoryID());
        }
        mProductList.addAll(products);
      }
    }
  }

  private void initData(){
    refreshProductData(ALL_PRODUCT_JSON);
    mCategoryAdapter=new CategoryAdapter(getActivity(),mCategoryList);
    mProductAdapter=new ProductAdapter(getActivity(),mProductList);
    mRecycleViewCategory.setAdapter(mCategoryAdapter);
    mRecycleViewProduct.setAdapter(mProductAdapter);

    mProductAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view) {

        if(ButtonUtils.isFastClick())
        {
          Intent intent = new Intent(getActivity(),GoodsDetailActivity.class);
          intent.putExtra("STATE","2");
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
        String categoryID=mCategoryList.get(position).getCategoryID();
        int scrollPosition=0;
        if(null==mRecycleViewProduct.getLayoutManager())return;
        for (Product product:mProductList){
          if(categoryID.equals(product.getCategoryID())){
            //不抢占落焦状态更新
            mRecycleViewProduct.setTouch(false);
            //设置落焦状态
            mCategoryAdapter.setSelectCategoryID(categoryID);
            //列表定位
            ((LinearLayoutManager)mRecycleViewProduct.getLayoutManager()).scrollToPositionWithOffset(scrollPosition,0);
            break;
          }
          ++scrollPosition;
        }
      }
    });
  }


  @Override
  public void onClick(View v) {
    //当前点击的view设置选中状态
    v.setSelected(true);
    switch (v.getId()){
      case R.id.tv_all:

        break;
      case R.id.tv_popularity:

        break;
      case R.id.tv_announce:

        break;
      case R.id.tv_new:

        break;
      case R.id.tv_price:

        break;
    }
    //设置导航栏其他view不是选中状态
    if(null!=mAllNavViews && mAllNavViews.size()>0){
      for (WeakReference<View> reference:mAllNavViews){
        View view=reference.get();
        if(null!=view && view.getId()!=v.getId()){
          view.setSelected(false);
        }
      }
    }
  }
}
