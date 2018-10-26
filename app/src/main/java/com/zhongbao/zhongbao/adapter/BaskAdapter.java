package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.MyBaskBean;
import com.zhongbao.zhongbao.dialog.ShareDialog;
import com.zhongbao.zhongbao.my.ShareActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class BaskAdapter extends BaseAdapter {

    private List<MyBaskBean> list;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private ShareDialog shareDialog;

    public BaskAdapter(List<MyBaskBean> list, Context context) {
        this.list = list;
        this.context = context;
        shareDialog = new ShareDialog(context);
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
        convertView = mLayoutInflater.inflate(R.layout.adapter_bask_item,null);
        TextView name = convertView.findViewById(R.id.name);
        TextView time = convertView.findViewById(R.id.time);
        TextView introduce = convertView.findViewById(R.id.introduce);
        TextView zan = convertView.findViewById(R.id.zan);
        TextView share = convertView.findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDialog.show();
//                context.startActivity(new Intent(context, ShareActivity.class));
            }
        });


        name.setText(list.get(position).getName());
        introduce.setText(list.get(position).getIntroduce());
        time.setText(list.get(position).getTime());

        return convertView;
    }
}
