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

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class NumberAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private List<String> nameList = new ArrayList<>();

    private Context context;

    public NumberAdapter(Context context,List<String> nameList) {
        this.nameList = nameList;
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = mLayoutInflater.inflate(R.layout.adapter_my_num,null);
        TextView mName = view.findViewById(R.id.num_tv);
        mName.setText(nameList.get(i));
        return view;
    }
}
