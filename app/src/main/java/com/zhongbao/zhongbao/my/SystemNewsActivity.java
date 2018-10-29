package com.zhongbao.zhongbao.my;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.SystemNewsAdapter;
import com.zhongbao.zhongbao.bean.SystemNewsBean;

/**
 * Used for
 * Created by tuyz on 2018/10/12.
 */

public class SystemNewsActivity extends BaseActivity implements View.OnClickListener {

    private ListView mSystemNews;
    private List<SystemNewsBean> list = new ArrayList<>();
    private SystemNewsAdapter adapter;
    private RelativeLayout mBack;
    private RelativeLayout mClear, mRead;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_system_news;
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
        mClear.setOnClickListener(this);
        mRead.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mSystemNews = f(R.id.system_news_list);
        mBack = f(R.id.back_left);
        mClear = f(R.id.clear_rela);
        mRead = f(R.id.read_rela);

        mSystemNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).isShow()) {
                    list.get(position).setShow(false);
                }
                Intent intent = new Intent(SystemNewsActivity.this, NewsDetailActivity.class);
                intent.putExtra("time", list.get(position).getTime());
                intent.putExtra("content", list.get(position).getNewsContent());
                intent.putExtra("title", list.get(position).getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        if (adapter != null) {
            adapter.notifyDataSetInvalidated();
        }
        super.onResume();
    }

    @Override
    protected void initData() {
        adapter = new SystemNewsAdapter(getList(), this);
        mSystemNews.setAdapter(adapter);
    }

    private List<SystemNewsBean> getList() {
        SystemNewsBean bean = new SystemNewsBean();
        bean.setShow(true);
        bean.setTime("2018-09-23 11:20:32");
        bean.setNewsContent("欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入" +
                "众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭");
        bean.setName("欢迎你加入众宝大家庭");

        SystemNewsBean bean1 = new SystemNewsBean();
        bean1.setShow(true);
        bean1.setTime("2018-10-02 9:13:12");
        bean1.setNewsContent("欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入" +
                "众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭");
        bean1.setName("你真的是一个好人啊");

        SystemNewsBean bean2 = new SystemNewsBean();
        bean2.setShow(false);
        bean2.setTime("2018-10-02 9:13:12");
        bean2.setNewsContent("欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入" +
                "众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭");
        bean2.setName("欢迎你加入众宝大家庭");

        SystemNewsBean bean3 = new SystemNewsBean();
        bean3.setShow(false);
        bean3.setTime("2018-10-02 9:13:12");
        bean3.setNewsContent("欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入" +
                "众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭");
        bean3.setName("欢迎你加入众宝大家庭");

        SystemNewsBean bean4 = new SystemNewsBean();
        bean4.setShow(false);
        bean4.setTime("2018-09-23 11:20:32");
        bean4.setNewsContent("欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入" +
                "众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭" +
                "欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭欢迎您加入众宝大家庭");
        bean4.setName("欢迎你加入众宝大家庭");

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_left:
                finish();
                break;
            case R.id.clear_rela:
                if (list.size() > 0) {
                    list.removeAll(list);
                }
                adapter.notifyDataSetInvalidated();
                break;
            case R.id.read_rela:
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setShow(false);
                    }
                    adapter.notifyDataSetInvalidated();
                }
                break;
        }
    }
}
