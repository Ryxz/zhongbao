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

public class JoinRecordAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;

    private List<GoodsDetailBean> list = new ArrayList<>();
    private Context context;

    public JoinRecordAdapter(List<GoodsDetailBean> list, Context context) {
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

        GoodsDetailBean bean = list.get(position);
        convertView = mLayoutInflater.inflate(R.layout.adapter_join_record,null);
        TextView mName = convertView.findViewById(R.id.join_name);
        TextView mIp = convertView.findViewById(R.id.join_ip);
        TextView mTime = convertView.findViewById(R.id.join_time);

        mName.setText(bean.getName());
        mIp.setText(bean.getIpId());
        mTime.setText(bean.getTime());

        return convertView;
    }
}
