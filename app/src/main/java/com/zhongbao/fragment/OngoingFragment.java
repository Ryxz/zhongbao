package com.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;

import com.zhongbao.adapter.RecordAdapter;
import com.zhongbao.bean.ListViewItem;
import com.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.utils.ButtonUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class OngoingFragment extends Fragment {

    private ListView listView;

    private RecordAdapter recordAdapter;

    private ArrayList<ListViewItem> viewItemsArraylists;     //Arraylist主要装载的是传给适配器的数据集合

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onging,container,false);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        listView = view.findViewById(R.id.ingrecord_listview);
        recordAdapter = new RecordAdapter(getActivity(),getDatas());
        listView.setAdapter(recordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(ButtonUtils.isFastClick())
                {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE","1");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
//        if(null!=listView){
//            listView.setFocusable(false);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        listView.setFocusable(true);
//        listView.setFooterDividersEnabled(true);
//        if(null!=listView){
//            listView.setFocusable(true);
//        }
    }

    /**
     * 这里我们用三种不同的样式进行测试
     **/
    private ArrayList<ListViewItem> getDatas() {

        viewItemsArraylists = new ArrayList<ListViewItem>();
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        return viewItemsArraylists;
    }
}
