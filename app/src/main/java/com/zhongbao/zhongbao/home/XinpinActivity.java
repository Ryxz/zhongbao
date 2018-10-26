package com.zhongbao.zhongbao.home;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;

import com.zhongbao.zhongbao.adapter.RecordAdapter;
import com.zhongbao.zhongbao.bean.ListViewItem;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class XinpinActivity extends BaseActivity {

    private ListView listView;

    private RecordAdapter recordAdapter;

    private RelativeLayout mBack;

    private ArrayList<ListViewItem> viewItemsArraylists;     //Arraylist主要装载的是传给适配器的数据集合
    @Override
    protected int getLayoutID() {
        return R.layout.activity_xinpin;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        mBack = f(R.id.back_left);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = findViewById(R.id.ingrecord_listview);
        recordAdapter = new RecordAdapter(this,getDatas());
        listView.setAdapter(recordAdapter);
    }

    @Override
    protected void initData() {

    }

    /**
     * 这里我们用三种不同的样式进行测试
     **/
    private ArrayList<ListViewItem> getDatas() {

        viewItemsArraylists = new ArrayList<ListViewItem>();
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        viewItemsArraylists.add(new ListViewItem(2, null));
        return viewItemsArraylists;
    }
}
