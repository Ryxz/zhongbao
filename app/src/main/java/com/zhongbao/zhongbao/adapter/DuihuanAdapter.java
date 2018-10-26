package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.DuihuanBean;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class DuihuanAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<DuihuanBean> list;
    private int num;

    public DuihuanAdapter(Context mContext, List<DuihuanBean> list,int num) {
        this.mContext = mContext;
        this.list = list;
        this.num = num;
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
        DuihuanBean bean = list.get(i);
        firstHolder firstHolder = null;
        secondHolder secondHolder = null;
        if(bean.getType()== 1)
        {
            firstHolder = new firstHolder();
            view = mLayoutInflater.inflate(R.layout.duihuan_foot_layout,null);
            firstHolder.mNum = view.findViewById(R.id.total);
            TextView mNum = view.findViewById(R.id.total);
            firstHolder.mNum.setText("共计: "+num*10+"钻石");
        }else
            {
                secondHolder = new secondHolder();
                view = mLayoutInflater.inflate(R.layout.adapter_duihuan,null);
                ImageView mIv = view.findViewById(R.id.buy_good_iv);
                mIv.setImageResource(bean.getResId());
            }
        return view;
    }

    class firstHolder
    {
        TextView mNum;
    }

    class secondHolder
    {
        ImageView mIv;
    }
}
