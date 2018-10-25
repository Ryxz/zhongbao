package com.zhongbao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import com.zhongbao.bean.ListViewItem;
import com.zhongbao.my.MyNumberActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class RecordAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context context;
    private ArrayList<ListViewItem> listDatas;

    public RecordAdapter(Context context, ArrayList<ListViewItem> listDatas) {
        this.context = context;
        this.listDatas = listDatas;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return listDatas.get(position).type;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewItem listViewItem = listDatas.get(position);
        int type = getItemViewType(position);
        ViewHolderFirstType viewHolderfirstType = null;
        ViewHolderSecondType viewHoldersecondType = null;
        ViewHolderThirdType viewHolderThreeType = null;
//        if(convertView == null)
//        {
            switch (type)
            {
                case 0:
                    viewHolderfirstType = new ViewHolderFirstType();
                    convertView = mLayoutInflater.inflate(R.layout.adapter_record_first_style,null);

//                    convertView.setTag(1, viewHolderfirstType);
                    break;

                case 1:
                    viewHoldersecondType = new ViewHolderSecondType();
                    convertView = mLayoutInflater.inflate(R.layout.adapter_record_second_style,null);
//                    convertView.setTag(2,viewHoldersecondType);
                    break;

                case 2:
                    viewHolderThreeType = new ViewHolderThirdType();
                    convertView = mLayoutInflater.inflate(R.layout.adapter_record_third_style,null);
//                    convertView.setTag(3,viewHolderThreeType);
                    break;
            }
//        }else
//        {
            switch (type)
            {
                case 0:
//                    viewHolderfirstType = (ViewHolderFirstType) convertView.getTag(1);
                    break;
                case 1:
//                    viewHoldersecondType = (ViewHolderSecondType) convertView.getTag(2);
                    break;
                case 2:
//                    viewHolderThreeType = (ViewHolderThirdType) convertView.getTag(3);
                    break;
//            }
        }
        TextView mPhone = convertView.findViewById(R.id.phone_num);
        mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MyNumberActivity.class));
            }
        });
        return convertView;
    }

    class ViewHolderFirstType
    {
        TextView first_style_tv;
    }

    class ViewHolderSecondType
    {
        TextView second_style_tv;
        TextView second_style_price;
    }

    class ViewHolderThirdType
    {
        TextView third_style_tv;
        TextView third_style_price;
        TextView third_style_name;
    }

}
