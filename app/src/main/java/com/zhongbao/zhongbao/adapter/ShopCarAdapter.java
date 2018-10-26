package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.ShopCarBean;

/**
 * Used for
 * Created by tuyz on 2018/10/10.
 */

public class ShopCarAdapter extends BaseAdapter {

    private Context context;

    private List<ShopCarBean> list;

    private LayoutInflater mLayoutInflater;
    private Handler mHandler;

    public ShopCarAdapter(Context context, List<ShopCarBean> list, Handler mHandler) {
        this.context = context;
        this.list = list;
        this.mHandler = mHandler;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ShopCarBean bean = list.get(position);
        ShopCarViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ShopCarViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.adapter_shop_car_item, null);
            viewHolder.name = convertView.findViewById(R.id.shopcar_name);
            viewHolder.shopClick = convertView.findViewById(R.id.shop_click);
            viewHolder.pic = convertView.findViewById(R.id.pic_iv);
            viewHolder.price = convertView.findViewById(R.id.price_shop);
            viewHolder.reduce = convertView.findViewById(R.id.reduce);
            viewHolder.add = convertView.findViewById(R.id.add);
            viewHolder.goodsNum = convertView.findViewById(R.id.goods_num);
            viewHolder.mCheck = convertView.findViewById(R.id.check_rela);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ShopCarViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(bean.getName());
        viewHolder.price.setText(bean.getPrice());
        viewHolder.goodsNum.setText(bean.getNum());
        viewHolder.pic.setImageResource(bean.getResId());

//        if(com.zhongbao.zhongbao.bean.isShow())
//        {
//            viewHolder.mCheck.setVisibility(View.VISIBLE);
//        }else
//        {
//            viewHolder.mCheck.setVisibility(View.GONE);
//        }

        if (bean.getChecked() == 1) {
            viewHolder.shopClick.setImageResource(R.mipmap.login_true);
        } else {
            viewHolder.shopClick.setImageResource(R.mipmap.shopcar_noselect);
        }

        viewHolder.reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.getNum().equals("1")) {
                    mHandler.sendEmptyMessage(1);
                    list.remove(list.get(position));
                } else {
                    mHandler.sendEmptyMessage(1);
                    bean.setNum("" + (Integer.parseInt(bean.getNum()) - 1));
                }
                notifyDataSetChanged();
            }
        });

        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(1);
                bean.setNum("" + (Integer.parseInt(bean.getNum()) + 1));
                notifyDataSetChanged();
            }
        });

        viewHolder.mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.getChecked() == 1) {
                    bean.setChecked(0);
                    mHandler.sendEmptyMessage(1);

                } else {
                    bean.setChecked(1);
                    mHandler.sendEmptyMessage(1);
                }
                notifyDataSetChanged();
            }
        });

        return convertView;

    }

    class ShopCarViewHolder {
        TextView name;
        ImageView shopClick;
        ImageView pic;
        TextView price;
        ImageView reduce;
        ImageView add;
        TextView goodsNum;
        RelativeLayout mCheck;
    }
}
