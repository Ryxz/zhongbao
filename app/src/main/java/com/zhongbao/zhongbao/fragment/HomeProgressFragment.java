package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.HomeGridAdapter;
import com.zhongbao.zhongbao.bean.HomePrograssBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;
import com.zhongbao.zhongbao.view.MyGridView;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class HomeProgressFragment extends Fragment {


    private View rootView;
    private MyGridView mGridView;
    private HomeGridAdapter adapter;
    private List<HomePrograssBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_prograss, container, false);
        initView(rootView);
        return rootView;
    }


    private void initView(View view) {
        mGridView = view.findViewById(R.id.gridview);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
//        if(null!=mGridView){
//            mGridView.setFocusable(true);
//        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        if(null!=mGridView){
//            mGridView.setFocusable(false);
//        }
    }

    private void initData() {
        adapter = new HomeGridAdapter(getList(), getActivity());
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (ButtonUtils.isFastClick()) {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE", list.get(position).getState());
                    startActivity(intent);
                }
            }
        });
    }

    private List<HomePrograssBean> getList() {
        list.clear();
        HomePrograssBean bean = new HomePrograssBean();
        bean.setName("香奈儿四件套高级定制");
        bean.setJindu("60");
        bean.setState("1");
        bean.setImageResId(R.mipmap.a);


        HomePrograssBean bean1 = new HomePrograssBean();
        bean1.setName("香奈儿四件套高级定制");
        bean1.setJindu("30");
        bean1.setState("2");
        bean1.setImageResId(R.mipmap.b);


        list.add(bean);
        list.add(bean1);
        list.add(bean1);
        list.add(bean1);
        return list;
    }
}
