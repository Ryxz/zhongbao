package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongbao.zhongbao.MainActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.dialog.BuyGoodsDialog;
import com.zhongbao.zhongbao.goods.BuyGoodsActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class XianGouAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private List<String> nameList = new ArrayList<>();

    private Context context;
    private BuyGoodsDialog buyGoodsDialog;

    public XianGouAdapter(Context context,List<String> nameList) {
        this.nameList = nameList;
        this.context = context;
        buyGoodsDialog = new BuyGoodsDialog(context);
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
        ImageView img_pro = view.findViewById(R.id.img_pro);
        ViewGroup.LayoutParams lp = img_pro.getLayoutParams();
        lp.height = MainActivity.width/2;
        img_pro.setLayoutParams(lp);
        if (i == 1){
            img_pro.setImageResource(R.mipmap.ad2);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyGoodsDialog.show();
//                context.startActivity(new Intent(context, BuyGoodsActivity.class));
            }
        });
        mName.setText(nameList.get(i));
        return view;
    }
}
