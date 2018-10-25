package com.zhongbao.goods;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.adapter.DuihuanAdapter;
import com.zhongbao.adapter.DuihuanTestAdapter;
import com.zhongbao.bean.DuihuanBean;
import com.zhongbao.login.LoginActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class DuihuanActivity extends BaseActivity {

    private ListView mDuihuanList;
    private RelativeLayout mBack;
    private String num;
    private DuihuanAdapter adapter;
    private List<DuihuanBean> list = new ArrayList<>();
    private int totalSize;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_duihuan;
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        num = intent.getStringExtra("num");
        mDuihuanList = f(R.id.duihuan_list);
        mBack = findViewById(R.id.back_left);
    }

    @Override
    protected void initData() {
        adapter = new DuihuanAdapter(this,getList(),list.size()-1);
        mDuihuanList.setAdapter(adapter);
    }

    private List<DuihuanBean> getList()
    {
        for(int i = 0;i<Integer.parseInt(num);i++)
        {
            DuihuanBean bean = new DuihuanBean();
            bean.setResId(R.mipmap.kouhong);
            bean.setType(0);
            list.add(bean);
        }
        Log.e("woyaokk","list.size:"+list.size());
        DuihuanBean bean = new DuihuanBean();
        bean.setType(1);
        list.add(bean);
        return list;
    }


}
