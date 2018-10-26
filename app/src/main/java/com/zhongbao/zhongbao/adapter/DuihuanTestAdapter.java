package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.DuihuanBean;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class DuihuanTestAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<DuihuanBean> list;

    public DuihuanTestAdapter(Context mContext, List<DuihuanBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder viewHolder = null;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            view  = mLayoutInflater.inflate(R.layout.adapter_duihuan,null);
            view.setTag(viewHolder);
        }else
            {
                viewHolder = (ViewHolder) view.getTag();
            }

        return view;
    }

    class ViewHolder
    {

    }
}
