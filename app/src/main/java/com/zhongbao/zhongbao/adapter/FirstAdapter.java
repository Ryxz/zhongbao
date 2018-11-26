package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.bean.GoodsDetailBean;
import com.zhongbao.zhongbao.dialog.BuyGoodsDialog;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;
import com.zhongbao.zhongbao.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstView> {
    private List<GoodsDetailBean> list;
    Context context;
    private BuyGoodsDialog buyGoodsDialog;

    public FirstAdapter(Context context,List<GoodsDetailBean> list){
        this.context = context;
        this.list = list;
        buyGoodsDialog = new BuyGoodsDialog(context);
    }


    @NonNull
    @Override
    public FirstView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_home_prograss_item,viewGroup,false);
        return new FirstView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstView firstView, int position) {
        firstView.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyGoodsDialog.show();
            }
        });
        firstView.prograss_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonUtils.isFastClick()) {
                    Intent intent = new Intent(context, GoodsDetailActivity.class);
                    intent.putExtra("STATE", "2");
                    context.startActivity(intent);
                }
            }
        });
        firstView.prograss_img.setImageResource(R.mipmap.ad1);
        int progress = Integer.valueOf(list.get(position).getRate().substring(0,list.get(position).getRate().length()-1));
        firstView.jinduPr.setProgress(progress);
        firstView.jindu.setText(list.get(position).getRate());
        firstView.tvGoodName.setText(list.get(position).getName());
        firstView.tvTitle.setText(list.get(position).getTitle());

        GlideUtils.loadImage(firstView.prograss_img,list.get(position).getImage());
        ViewGroup.LayoutParams lp = firstView.prograss_img.getLayoutParams();
        lp.height = MainActivity.width/2-1;
        firstView.prograss_img.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    int type=1;
    public void setAdapterType(int type){
        this.type = type;
        notifyDataSetChanged();
    }


    public class FirstView extends RecyclerView.ViewHolder{
        private ImageView prograss_img,add;
        private ProgressBar jinduPr;
        private TextView jindu,tvGoodName,tvTitle;

        public FirstView(@NonNull View itemView) {
            super(itemView);
            prograss_img = itemView.findViewById(R.id.prograss_img);
            add = itemView.findViewById(R.id.add);
            jinduPr = itemView.findViewById(R.id.jindu_pr);
            jindu = itemView.findViewById(R.id.jindu);
            tvGoodName = itemView.findViewById(R.id.tv_goodName);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

}
