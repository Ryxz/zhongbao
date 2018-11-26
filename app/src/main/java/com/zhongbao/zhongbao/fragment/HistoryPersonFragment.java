package com.zhongbao.zhongbao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.HistoryPersonAdapter;
import com.zhongbao.zhongbao.bean.GoodsDetailBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.view.MyListView;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class HistoryPersonFragment extends Fragment {

    private View rootView;
    private MyListView listView;
    private HistoryPersonAdapter adapter;
    private List<GoodsDetailBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_history_person, container, false);
        GoodsDetailActivity activity  = (GoodsDetailActivity)getActivity();
//        activity.setChildObjectForPosition(rootView,0);
        initView(rootView);
        return rootView;
    }

    private void initView(View view)
    {
        listView = view.findViewById(R.id.his_list);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initData()
    {
        adapter = new HistoryPersonAdapter(getActivity(),getList());
        listView.setAdapter(adapter);
    }

    private List<GoodsDetailBean> getList()
    {
        GoodsDetailBean bean = new GoodsDetailBean();
//        bean.setName("获奖者:东海小仙女");
//        bean.setIpId("IP:172.79.104.14");
//        bean.setTime("参与10次  2018-10-12  13:12:50:123");
//        bean.setUserId("用户ID:1234(用户唯一不变标识)");
//        bean.setJoinNum("68");
//        bean.setGoldNum("100400");
//
//        GoodsDetailBean bean1 = new GoodsDetailBean();
//        bean1.setName("获奖者:北海小王子");
//        bean1.setIpId("IP:117.127.104.14");
//        bean1.setTime("参与10次  2018-08-27  13:12:50:123");
//        bean1.setUserId("用户ID:4321(用户唯一不变标识)");
//        bean1.setJoinNum("68");
//        bean1.setGoldNum("100400");
//
//
//        GoodsDetailBean bean2 = new GoodsDetailBean();
//        bean2.setName("获奖者:东海小仙女");
//        bean2.setIpId("IP:117.127.104.14");
//        bean2.setTime("参与10次  2018-08-27  13:12:50:123");
//        bean2.setUserId("用户ID:1234(用户唯一不变标识)");
//        bean2.setJoinNum("68");
//        bean2.setGoldNum("100400");
//

        list.add(bean);
//        list.add(bean1);
//        list.add(bean2);

        return list;

    }

}
