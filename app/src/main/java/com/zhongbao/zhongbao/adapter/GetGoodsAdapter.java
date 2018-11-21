package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.GetGoodsBean;
import com.zhongbao.zhongbao.dialog.ShareDialog;
import com.zhongbao.zhongbao.my.GetGoodsActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class GetGoodsAdapter extends BaseAdapter {

    private List<GetGoodsBean> list;

    private LayoutInflater mLayoutInflater;

    private GetGoodsActivity context;

    private View.OnClickListener click;

    public GetGoodsAdapter(GetGoodsActivity context, List<GetGoodsBean> list, View.OnClickListener onClickListener) {
        this.context = context;
        this.list = list;
        this.click = onClickListener;
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

        GetGoodsBean bean = list.get(position);
        convertView = mLayoutInflater.inflate(R.layout.adapter_get_goods_item,null);

        TextView name = convertView.findViewById(R.id.name);
        TextView changeState = convertView.findViewById(R.id.change_state);
        TextView adress = convertView.findViewById(R.id.adress);
        final TextView shouhuo_type = convertView.findViewById(R.id.shouhuo_type);
        TextView fahuo_type = convertView.findViewById(R.id.fahuo_type);
        LinearLayout share_linear = convertView.findViewById(R.id.share_linear);

        name.setText(bean.getName());
        adress.setText(bean.getAdress());

        if(bean.getChangeType()==1)
        {
            changeState.setText("修改");
            fahuo_type.setVisibility(View.GONE);
            shouhuo_type.setVisibility(View.VISIBLE);
        }else if(bean.getChangeType()==2)
        {
            changeState.setText("查看物流");
            fahuo_type.setVisibility(View.VISIBLE);
            shouhuo_type.setVisibility(View.VISIBLE);
        }else
        {
            changeState.setVisibility(View.GONE);
            fahuo_type.setVisibility(View.VISIBLE);
            shouhuo_type.setVisibility(View.VISIBLE);
            fahuo_type.setText("订单完成");
            shouhuo_type.setText("立即晒单");
        }


        shouhuo_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shouhuo_type.getText().equals("立即晒单"))
                {
                    context.startActivity(new Intent(context, MyBaskActivity.class));
                }
            }
        });

        share_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分享

//               context.startActivity(new Intent(context, ShareActivity.class));
                shareDialog.show();
            }
        });
        shareDialog = new ShareDialog(context);
        return convertView;
    }


    ShareDialog shareDialog;
}
