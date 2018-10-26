package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.bean.SystemNewsBean;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class SystemNewsAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    List<SystemNewsBean> list = new ArrayList<>();
    private Context context;

    public SystemNewsAdapter(List<SystemNewsBean> list, Context context) {
        this.list = list;
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SystemNewsBean bean = list.get(position);
        convertView = mLayoutInflater.inflate(R.layout.adapter_system_news,null);


        TextView mNoread = convertView.findViewById(R.id.no_read_tv);
        TextView mSystemNews = convertView.findViewById(R.id.system_news);
        if(bean.isShow())
        {
            mNoread.setVisibility(View.VISIBLE);
        }else
        {
            mNoread.setVisibility(View.GONE);
        }

        mSystemNews.setText(bean.getName());
        return convertView;
    }
}
