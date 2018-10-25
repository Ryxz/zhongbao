package com.zhongbao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.bean.SearchBean;
import com.zhongbao.home.SearchActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/15.
 */

public class SearchHistoryAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<SearchBean> list = new ArrayList<>();
    private Context context;

    public SearchHistoryAdapter(List<SearchBean> list, Context context) {
        this.list = list;
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SearchBean bean = list.get(i);
        int type = bean.getType();
            switch (type)
            {
                case 0:
                    view = mLayoutInflater.inflate(R.layout.adapter_search_first_item,null);
                    break;

                case 1:
                    view = mLayoutInflater.inflate(R.layout.adapter_search_second_item,null);
                    TextView mName = view.findViewById(R.id.search_name);
                    mName.setText(bean.getName());
                    break;

                case 2:
                    view = mLayoutInflater.inflate(R.layout.adapter_search_third_item,null);
                    TextView mClear = view.findViewById(R.id.search_clear);
                    mClear.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(list!=null)
                            {
                                list.clear();
                                notifyDataSetChanged();
                            }
                        }
                    });
                    break;
            }
        return view;
    }
}
