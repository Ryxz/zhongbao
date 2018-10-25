package com.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.adapter.LatestAdapter;
import com.zhongbao.bean.LatestBean;
import com.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.utils.ButtonUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class LatestFragment extends Fragment {
    private View rootView;
    private ListView mListView;
    private List<LatestBean> list = new ArrayList<>();
    private LinearLayout top;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lateast, container, false);
        initView(rootView);
        return rootView;
    }


    private void initView(View view)
    {
        top = view.findViewById(R.id.top_lineaer);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ButtonUtils.isFastClick())
                {
                    Intent intent = new Intent(getActivity(),GoodsDetailActivity.class);
                    intent.putExtra("STATE","2");
                    startActivity(intent);
                }
            }
        });
        mListView = view.findViewById(R.id.latest_list);
        initData();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(ButtonUtils.isFastClick())
                {
                    Intent intent = new Intent(getActivity(),GoodsDetailActivity.class);
                    intent.putExtra("STATE",list.get(i).getState());
                    startActivity(intent);
                }
            }
        });
    }

    private void initData()
    {
        LatestAdapter adapter = new LatestAdapter(getActivity(),getList());
        mListView.setAdapter(adapter);
    }


    private List<LatestBean> getList()
    {
        LatestBean bean = new LatestBean();
        bean.setName("香奈儿四件套你值得拥有");
        bean.setPrice("商品价格:  ¥100");
        bean.setPerson("50人次");
        bean.setState("1");
        bean.setTime("揭晓时间: 2018-09-29 18:02:28");

        LatestBean bean1 = new LatestBean();
        bean1.setName("香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有");
        bean1.setPrice("商品价格:  ¥80");
        bean1.setPerson("30人次");
        bean1.setState("2");
        bean1.setTime("揭晓时间: 2018-09-26 18:06:28");


        LatestBean bean2 = new LatestBean();
        bean2.setName("香奈儿四件套你值得拥有香奈儿四件套你值得拥有");
        bean2.setPrice("商品价格:  ¥70");
        bean2.setPerson("100人次");
        bean2.setState("3");
        bean2.setTime("揭晓时间: 2016-09-29 18:02:28");


        LatestBean bean3 = new LatestBean();
        bean3.setName("香奈儿四件套你值得拥有");
        bean3.setPrice("商品价格:  ¥100");
        bean3.setState("2");
        bean3.setPerson("54人次");
        bean3.setTime("揭晓时间: 2018-09-12 18:02:28");


        LatestBean bean4 = new LatestBean();
        bean4.setName("香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有香奈儿四件套你值得拥有");
        bean4.setPrice("商品价格:  ¥100");
        bean4.setState("1");
        bean4.setPerson("50人次");
        bean4.setTime("揭晓时间: 2018-12-29 18:02:28");


        LatestBean bean5 = new LatestBean();
        bean5.setName("香奈儿四件套你值得拥有香奈儿四件套你值得拥有");
        bean5.setPrice("商品价格:  ¥70");
        bean5.setPerson("23人次");
        bean5.setState("1");
        bean5.setTime("揭晓时间: 2018-09-29 18:02:28");

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        return list;
    }
}
