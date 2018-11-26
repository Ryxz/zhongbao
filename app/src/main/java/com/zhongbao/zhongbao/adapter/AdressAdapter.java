package com.zhongbao.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.List;

import com.zhongbao.zhongbao.bean.AdressBean;
import com.zhongbao.zhongbao.my.AddAdressActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class AdressAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<AdressBean> list;

    public AdressAdapter(Context mContext, List<AdressBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        AdressBean adressBean = list.get(position);
        convertView = mLayoutInflater.inflate(R.layout.adapter_adress_item, null);
        TextView mName = convertView.findViewById(R.id.adress_name);
        TextView mPhone = convertView.findViewById(R.id.adress_phone);
        TextView mLocation = convertView.findViewById(R.id.adress_location);
        TextView mMoren = convertView.findViewById(R.id.moren_adress);
        mName.setText(adressBean.getRealname());
        mPhone.setText(adressBean.getMobile());
        mLocation.setText(adressBean.getAddress());
        if (list.get(position).getIs_default() == 1) {
            mMoren.setVisibility(View.VISIBLE);
        } else {
            mMoren.setVisibility(View.GONE);
        }
        convertView.findViewById(R.id.relayout_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, AddAdressActivity.class).putExtra("addressBean", (Parcelable) list.get(position)));
            }
        });
        return convertView;
    }
}
