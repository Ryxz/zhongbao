package com.zhongbao.zhongbao.my;

import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.NumberAdapter;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class MyNumberActivity extends BaseActivity {

    private List<String> nameList = new ArrayList<>();

    private GridView mGrid;
    private RelativeLayout mBack;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_my_number;
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
        mGrid = f(R.id.gird_num);
        mBack = f(R.id.back_left);
    }

    @Override
    protected void initData() {
        NumberAdapter adapter = new NumberAdapter(this,getList());
        mGrid.setAdapter(adapter);
    }

    private List<String> getList()
    {
        nameList.add("123213");
        nameList.add("123213");
        nameList.add("121213");
        nameList.add("123123");
        nameList.add("323212");
        nameList.add("222321");
        nameList.add("213132");
        nameList.add("131413");
        nameList.add("212311");
        nameList.add("123131");
        return nameList;
    }
}
