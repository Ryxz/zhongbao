package com.zhongbao.zhongbao.home;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.XianGouAdapter;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class XianGouActivity extends BaseActivity implements View.OnClickListener {

    private List<String> nameList = new ArrayList<>();

    private GridView mGrid;

    private XianGouAdapter adapter;

    private RelativeLayout mBack;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_xiangou;
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mGrid = f(R.id.xiangou_grid);
        mBack = f(R.id.back_left);
    }

    @Override
    protected void initData() {
        adapter = new XianGouAdapter(this, getList());
        mGrid.setAdapter(adapter);
        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(XianGouActivity.this, GoodsDetailActivity.class);
                intent.putExtra("STATE", "2");
                startActivity(intent);
            }
        });
    }

    private List<String> getList() {
        nameList.add("香奈儿四件套高级定制");
        nameList.add("Mac定制");
        nameList.add("大理石高级定制");
        nameList.add("大理石高级定制");
        nameList.add("大理石高级定制");
        return nameList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_left:
                finish();
                break;
        }
    }
}
