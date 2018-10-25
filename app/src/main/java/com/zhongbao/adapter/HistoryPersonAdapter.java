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

import com.zhongbao.bean.GoodsDetailBean;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class HistoryPersonAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;

    private List<GoodsDetailBean> list = new ArrayList<>();
    private Context context;

    public HistoryPersonAdapter(Context context,List<GoodsDetailBean> list) {
        this.context = context;
        this.list = list;
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

        GoodsDetailBean bean = list.get(position);
        convertView = mLayoutInflater.inflate(R.layout.adapter_history_person,null);
        TextView mName = convertView.findViewById(R.id.his_name);
        TextView mId = convertView.findViewById(R.id.his_id);
        TextView mNum = convertView.findViewById(R.id.his_num);
        TextView mPerson = convertView.findViewById(R.id.his_person);

        mName.setText(bean.getName());
        mId.setText(bean.getUserId());
        mNum.setText(bean.getGoldNum());
        mPerson.setText(bean.getJoinNum());
        return convertView;
    }
}
