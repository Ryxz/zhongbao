package com.zhongbao.zhongbao.my;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.BaskAdapter;
import com.zhongbao.zhongbao.bean.MyBaskBean;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class MyBaskActivity extends BaseActivity implements View.OnClickListener {

    private ListView mBaskList;

    private BaskAdapter baskAdapter;

    private RelativeLayout mBack;

    private List<MyBaskBean> list = new ArrayList<>();

    @Override
    protected int getLayoutID() {
        return R.layout.activity_mybask;
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mBaskList = f(R.id.bask_list);
        mBack = f(R.id.back_left);
    }

    @Override
    protected void initData() {
        baskAdapter = new BaskAdapter(getList(),this);
        mBaskList.setAdapter(baskAdapter);
    }

    private List<MyBaskBean> getList()
    {
        MyBaskBean myBaskBean = new MyBaskBean();
        myBaskBean.setName("东海小仙女");
        myBaskBean.setIntroduce("6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean.setTime("刚刚");

        MyBaskBean myBaskBean1 = new MyBaskBean();
        myBaskBean1.setName("刘事");
        myBaskBean1.setIntroduce("家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean1.setTime("1小时前");

        MyBaskBean myBaskBean2 = new MyBaskBean();
        myBaskBean2.setName("吴气");
        myBaskBean2.setIntroduce("这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean2.setTime("11小时前");

        MyBaskBean myBaskBean3 = new MyBaskBean();
        myBaskBean3.setName("东海小仙女");
        myBaskBean3.setIntroduce("这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean3.setTime("昨天");


        MyBaskBean myBaskBean4 = new MyBaskBean();
        myBaskBean4.setName("东方红");
        myBaskBean4.setIntroduce("6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean4.setTime("前天");


        MyBaskBean myBaskBean5 = new MyBaskBean();
        myBaskBean5.setName("东海小仙女");
        myBaskBean5.setIntroduce("6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean5.setTime("一月前");

        MyBaskBean myBaskBean6 = new MyBaskBean();
        myBaskBean6.setName("东海小仙女");
        myBaskBean6.setIntroduce("家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean6.setTime("2017年");


        MyBaskBean myBaskBean7 = new MyBaskBean();
        myBaskBean7.setName("东海小仙女");
        myBaskBean7.setIntroduce("6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦家里正好用到，这次希望可以中一次手机6带纸巾很不错哦，家里正好用到，这次希望可以中一次手机6带纸巾很不错哦");
        myBaskBean7.setTime("2017年");

        list.add(myBaskBean);
        list.add(myBaskBean1);
        list.add(myBaskBean2);
        list.add(myBaskBean3);
        list.add(myBaskBean4);
        list.add(myBaskBean5);
        list.add(myBaskBean6);
        list.add(myBaskBean7);

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
