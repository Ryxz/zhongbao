package com.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.goods.BuyGoodsActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class XianGouAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<String> nameList = new ArrayList<>();

    private Context context;

    public XianGouAdapter(Context context,List<String> nameList) {
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

        view = mLayoutInflater.inflate(R.layout.adapter_xiangou,null);
        TextView mName = view.findViewById(R.id.xiangou_name);
        ImageView add = view.findViewById(R.id.goods_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BuyGoodsActivity.class));
            }
        });
        mName.setText(nameList.get(i));
        return view;
    }
}
