package com.zhongbao.zhongbao.my;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.AdressAdapter;
import com.zhongbao.zhongbao.bean.AdressBean;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class MyAdressActivity extends BaseActivity implements View.OnClickListener {

    private ListView mAdressList;
    private AdressAdapter adressAdapter;
    private AdressBean adressBean,adressBean1,adressBean2;
    private TextView mAdd;
    private RelativeLayout mBack;

    private List<AdressBean> list = new ArrayList<>();
    @Override
    protected int getLayoutID() {
        return R.layout.activity_myadress;
    }

    @Override
    protected void initListener() {
        mAdd.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mAdressList = f(R.id.adress_list);
        mAdd = f(R.id.add_btn);
        mBack = f(R.id.back_left);
        adressAdapter = new AdressAdapter(this,getList());
        mAdressList.setAdapter(adressAdapter);
    }

    @Override
    protected void initData() {
        mAdressList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i = 0;i<list.size();i++)
                {
                    list.get(i).setShow(false);
                }
                list.get(position).setShow(true);
                adressAdapter.notifyDataSetChanged();
            }
        });
    }

    private List<AdressBean> getList()
    {
        adressBean = new AdressBean();
        adressBean.setName("张三");
        adressBean.setPhone("18362969772");
        adressBean.setAdress("江苏省南京市栖霞区文范路9号康桥圣菲");
        adressBean.setShow(true);

        adressBean1 = new AdressBean();
        adressBean1.setName("张三");
        adressBean1.setPhone("18362969772");
        adressBean1.setAdress("江苏省南京市栖霞区文范路9号康桥圣菲");
        adressBean1.setShow(false);

        adressBean2 = new AdressBean();
        adressBean2.setName("张三");
        adressBean2.setPhone("18362969772");
        adressBean2.setAdress("江苏省南京市栖霞区文范路9号康桥圣菲");
        adressBean2.setShow(false);

        list.add(adressBean);
        list.add(adressBean1);
        list.add(adressBean2);

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add_btn:
                startActivity(new Intent(this,AddAdressActivity.class));
                break;
            case R.id.back_left:
                finish();
                break;

        }
    }
}
