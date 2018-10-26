package com.zhongbao.zhongbao.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

/**
 * @author : Syuan
 * e-mail : 893110793@qq.com
 * @date : 2018/10/26 20:06
 * description
 */
public class ShufflingInfoAdapter extends RecyclerView.Adapter<ShufflingInfoAdapter.MyViewHolder> {
    List<String> list;

    public ShufflingInfoAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_shuffing_info, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String[] strings=list.get(position).split(",");
        holder.tv_name.setText(strings[0]);
        holder.tv_prize.setText(strings[1]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_name,tv_prize;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_prize = (TextView) itemView.findViewById(R.id.tv_prize);
        }

    }
}
