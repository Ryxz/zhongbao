package com.zhongbao.zhongbao.adapter;

import android.content.Context;
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
import com.zhongbao.zhongbao.dialog.BuyGoodsDialog;

import java.util.ArrayList;
import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstView> {
    private List<String> list = new ArrayList<>();
    Context context;
    private BuyGoodsDialog buyGoodsDialog;

    public FirstAdapter(Context context,List<String> list){
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
        if (position == 0){
            if (type == 1){
                firstView.prograss_img.setImageResource(R.mipmap.ad1);
                firstView.jinduPr.setProgress(10);
                firstView.jindu.setText("10%");
            }else if (type == 2){
                firstView.prograss_img.setImageResource(R.mipmap.ad2);
                firstView.jinduPr.setProgress(20);
                firstView.jindu.setText("20%");
            }else if (type == 3){
                firstView.prograss_img.setImageResource(R.mipmap.ad3);
                firstView.jindu.setText("30%");
                firstView.jinduPr.setProgress(30);
            }
        }
        if (position == 1){
            if (type == 1){
                firstView.prograss_img.setImageResource(R.mipmap.ad2);
                firstView.jinduPr.setProgress(20);
                firstView.jindu.setText("20%");
            }else if (type == 2){
                firstView.prograss_img.setImageResource(R.mipmap.ad3);
                firstView.jindu.setText("30%");
                firstView.jinduPr.setProgress(30);
            }else if (type == 3){
                firstView.prograss_img.setImageResource(R.mipmap.ad3);
                firstView.jindu.setText("30%");
                firstView.jinduPr.setProgress(30);
            }

        }
        if (position == 2){
            if (type == 1){
                firstView.prograss_img.setImageResource(R.mipmap.ad4);
                firstView.jinduPr.setProgress(20);
                firstView.jindu.setText("20%");
            }else if (type == 2){
                firstView.prograss_img.setImageResource(R.mipmap.ad2);
                firstView.jinduPr.setProgress(20);
                firstView.jindu.setText("20%");
            }else if (type == 3){
                firstView.prograss_img.setImageResource(R.mipmap.ad1);
                firstView.jinduPr.setProgress(10);
                firstView.jindu.setText("10%");
            }
        }
        ViewGroup.LayoutParams lp = firstView.prograss_img.getLayoutParams();
        lp.height = MainActivity.width/2-1;
        firstView.prograss_img.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    int type;
    public void setAdapterType(int type){
        this.type = type;
        notifyDataSetChanged();
    }


    public class FirstView extends RecyclerView.ViewHolder{
        private ImageView prograss_img;
        private ImageView add;
        private ProgressBar jinduPr;
        private TextView jindu;

        public FirstView(@NonNull View itemView) {
            super(itemView);
            prograss_img = itemView.findViewById(R.id.prograss_img);
            add = itemView.findViewById(R.id.add);
            jinduPr = itemView.findViewById(R.id.jindu_pr);
            jindu = itemView.findViewById(R.id.jindu);
        }
    }

}
