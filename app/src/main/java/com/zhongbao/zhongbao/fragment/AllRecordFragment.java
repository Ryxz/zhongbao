package com.zhongbao.zhongbao.fragment;

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

import com.zhongbao.zhongbao.adapter.RecordAdapter;
import com.zhongbao.zhongbao.bean.ListViewItem;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class AllRecordFragment extends Fragment {

    private ListView listView;

    private RecordAdapter recordAdapter;

    private ArrayList<ListViewItem> viewItemsArraylists;     //Arraylist主要装载的是传给适配器的数据集合

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allrecord,container,false);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        listView = view.findViewById(R.id.allrecord_listview);
        recordAdapter = new RecordAdapter(getActivity(),getDatas());
        listView.setAdapter(recordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(ButtonUtils.isFastClick())
                {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE","2");
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 这里我们用三种不同的样式进行测试
     **/
     private ArrayList<ListViewItem> getDatas() {

         viewItemsArraylists = new ArrayList<ListViewItem>();
         viewItemsArraylists.add(new ListViewItem(0, null));
         viewItemsArraylists.add(new ListViewItem(1, null));
         viewItemsArraylists.add(new ListViewItem(2, null));
         viewItemsArraylists.add(new ListViewItem(2, null));
         viewItemsArraylists.add(new ListViewItem(2, null));
         viewItemsArraylists.add(new ListViewItem(0, null));
         viewItemsArraylists.add(new ListViewItem(2, null));
         viewItemsArraylists.add(new ListViewItem(1, null));
         viewItemsArraylists.add(new ListViewItem(1, null));
         return viewItemsArraylists;
     }

}
