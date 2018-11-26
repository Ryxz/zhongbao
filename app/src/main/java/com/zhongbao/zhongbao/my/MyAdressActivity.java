package com.zhongbao.zhongbao.my;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.adapter.AdressAdapter;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.AdressBean;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.bean.UserInfoModel;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class MyAdressActivity extends BaseActivity implements View.OnClickListener {

    private ListView mAdressList;
    private AdressAdapter adressAdapter;

    private List<AdressBean> list = new ArrayList<>();

    @Override
    protected int getLayoutID() {
        return R.layout.activity_myadress;
    }


    @Override
    protected void initView() {
        mAdressList = f(R.id.adress_list);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.back_left).setOnClickListener(this);
        adressAdapter = new AdressAdapter(this, list);
        mAdressList.setAdapter(adressAdapter);
        getAddress();
    }

    public void getAddress() {
        getHttpService().my_addr(ZBApp.get().getUserId())
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel<List<AdressBean>>>(this) {
                    @Override
                    protected void onDoNext(BasicModel<List<AdressBean>> listBasicModel) {
                        if (listBasicModel.getCode().equals("200")) {
                            list.clear();
                            list.addAll(listBasicModel.getData());
                            adressAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MyAdressActivity.this, listBasicModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAddress();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                startActivity(new Intent(this, AddAdressActivity.class));
                break;
            case R.id.back_left:
                finish();
                break;

        }
    }
}
