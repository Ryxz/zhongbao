package com.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.bean.HomePrograssBean;
import com.zhongbao.goods.BuyGoodsActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class HomeGridAdapter extends BaseAdapter {

    private List<HomePrograssBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;

    public HomeGridAdapter(List<HomePrograssBean> list, Context context) {
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

        HomePrograssBean bean = list.get(position);

        convertView = mLayoutInflater.inflate(R.layout.adapter_home_prograss_item,null);

        ImageView imageView = convertView.findViewById(R.id.prograss_img);
        TextView name = convertView.findViewById(R.id.name);
        TextView jindu = convertView.findViewById(R.id.jindu);
        ProgressBar jinduPr = convertView.findViewById(R.id.jindu_pr);
        ImageView add = convertView.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BuyGoodsActivity.class));
            }
        });

        imageView.setImageResource(bean.getImageResId());
        name.setText(bean.getName());
        jindu.setText(bean.getJindu()+"%");

        int temp = Integer.parseInt(bean.getJindu());
        jinduPr.setProgress(temp);
        return convertView;
    }
}
