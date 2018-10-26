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

import com.zhongbao.zhongbao.bean.LatestBean;

/**
 * Used for
 * Created by tuyz on 2018/10/14.
 */

public class LatestAdapter extends BaseAdapter {

    private Context context;
    private List<LatestBean> list = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public LatestAdapter(Context context, List<LatestBean> list) {
        this.context = context;
        this.list = list;
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

        LatestBean bean = list.get(i);
        view = mLayoutInflater.inflate(R.layout.adapter_latest,null);

        TextView mName = view.findViewById(R.id.goods_name);
        TextView mPrice =  view.findViewById(R.id.goods_price);
        TextView mPerson = view.findViewById(R.id.goods_person);
        TextView mTime = view.findViewById(R.id.goods_time);
        mName.setText(bean.getName());
        mPrice.setText(bean.getPrice());
        mPerson.setText(bean.getPerson());
        mTime.setText(bean.getTime());
        return view;
    }
}
