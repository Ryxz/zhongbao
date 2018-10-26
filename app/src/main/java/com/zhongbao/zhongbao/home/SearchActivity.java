package com.zhongbao.zhongbao.home;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.SearchHistoryAdapter;
import com.zhongbao.zhongbao.bean.SearchBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;

/**
 * Used for
 * Created by tuyz on 2018/10/15.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private ListView mListView;
    private EditText mEt;
    private TextView mCancel;
    private List<SearchBean> list = new ArrayList<>();
    private SearchHistoryAdapter adapter;

    @Override
    protected int getLayoutID() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
            window.setStatusBarColor(getResources().getColor(R.color.dray_line));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        return R.layout.activity_search;
    }

    @Override
    protected void initListener() {
        mCancel.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mListView = f(R.id.search_history_list);
        mEt = f(R.id.searct_et);
        mCancel = f(R.id.search_cancel);
    }

    @Override
    protected void initData() {
        adapter = new SearchHistoryAdapter(getList(), this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SearchActivity.this, GoodsDetailActivity.class);
                intent.putExtra("STATE", "3");
                startActivity(intent);
            }
        });
    }

    private List<SearchBean> getList() {
        SearchBean bean = new SearchBean();
        bean.setName("");
        bean.setType(0);

        SearchBean bean1 = new SearchBean();
        bean1.setName("香蕉");
        bean1.setType(1);

        SearchBean bean2 = new SearchBean();
        bean2.setName("牛奶");
        bean2.setType(1);

        SearchBean bean3 = new SearchBean();
        bean3.setName("");
        bean3.setType(2);

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        return list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_cancel:
                finish();
                break;
        }
    }
}
