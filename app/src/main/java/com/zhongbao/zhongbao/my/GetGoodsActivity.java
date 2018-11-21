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

import com.zhongbao.zhongbao.adapter.GetGoodsAdapter;
import com.zhongbao.zhongbao.bean.GetGoodsBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class GetGoodsActivity extends BaseActivity implements View.OnClickListener {

    private List<GetGoodsBean> list = new ArrayList<>();
    private ListView mListView;
    private GetGoodsAdapter adapter;
    private RelativeLayout mBack;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_get_goods;
    }

    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mListView = f(R.id.getgoods_list);
        mBack = f(R.id.back_left);
    }

    protected void initData() {
        adapter = new GetGoodsAdapter(this,getList(),shareClickListener);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(ButtonUtils.isFastClick())
                {
                    Intent intent = new Intent(GetGoodsActivity.this, GoodsDetailActivity.class);
                    intent.putExtra("STATE","1");
                    startActivity(intent);
                }
            }
        });

    }

    private View.OnClickListener shareClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };



    public void share()
    {

    }

    private List<GetGoodsBean> getList()
    {
        GetGoodsBean bean = new GetGoodsBean();
        bean.setName("张三  189765655");
        bean.setAdress("江苏省南京市");
        bean.setChangeType(1);

        GetGoodsBean bean1 = new GetGoodsBean();
        bean1.setName("李四  189765652");
        bean1.setAdress("黑龙江省哈尔滨市黑龙江省哈尔滨市");
        bean1.setChangeType(2);

        GetGoodsBean bean2 = new GetGoodsBean();
        bean2.setName("王二麻子 1897656522");
        bean2.setAdress("安徽省安庆市");
        bean2.setChangeType(3);


        GetGoodsBean bean3 = new GetGoodsBean();
        bean3.setName("赵武  189765234");
        bean3.setAdress("江苏省南京市");
        bean3.setChangeType(2);


        GetGoodsBean bean4 = new GetGoodsBean();
        bean4.setName("刘流  1897656566");
        bean4.setAdress("江苏省南京市");
        bean4.setChangeType(2);

        GetGoodsBean bean5 = new GetGoodsBean();
        bean5.setName("秦始皇  1897656512");
        bean5.setAdress("江苏省南京市");
        bean5.setChangeType(3);

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_left:
                finish();
                break;
        }
    }
}
