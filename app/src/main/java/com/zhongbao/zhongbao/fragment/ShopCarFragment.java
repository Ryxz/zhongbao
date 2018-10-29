package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.ShopCarAdapter;
import com.zhongbao.zhongbao.bean.ShopCarBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class ShopCarFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private View rootView;
    private ListView mListView;
    private ShopCarAdapter adapter;
    private List<ShopCarBean> list = new ArrayList<>();
    private CheckBox mTotalCheck;
    private TextView mBuy;
    private RelativeLayout mEdit;
    private TextView editTv;
    private TextView mNum;
    private TextView mPrice;
    private int a = 0;
    private int b = 0;
    public boolean isItem = false;


    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1://点击全选框
                    if (a != 0 || b != 0) {
                        a = 0;
                        b = 0;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getChecked() == 1) {
                            a = a + 1;

                            int total = Integer.parseInt(list.get(i).getNum());
                            b = total + b;
                        }
                    }

                    if (isShowTotal()) {
                        mTotalCheck.setChecked(true);
//                        curIsAll = true;
                    }

                    mPrice.setText("合计: " + b + "钻石");
                    mNum.setText("共" + a + "个商品");
                    break;
                case 2:
                    mTotalCheck.setChecked(true);
                    break;
                case 3:
                    isItem = true;
                    mTotalCheck.setChecked(false);
                    break;

            }
            return false;
        }
    });

    private boolean isShowTotal() {
        int a = 0;
        if (list.size()==0)return false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChecked() == 1) {
                a = a + 1;
            }
        }

        if (a == list.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shopcar, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view) {
        mNum = view.findViewById(R.id.total_num);
        mPrice = view.findViewById(R.id.total_price);
        mListView = view.findViewById(R.id.car_list);
        mTotalCheck = view.findViewById(R.id.total_check);
        mBuy = view.findViewById(R.id.buy_btn);
        mEdit = view.findViewById(R.id.shopcar_edit);
        editTv = view.findViewById(R.id.edit);
        getList();
        initData();
        initListener();
    }

    private void initData() {
        mHandler.sendEmptyMessage(1);
        adapter = new ShopCarAdapter(getActivity(), list, mHandler);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (ButtonUtils.isFastClick()) {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE", "2");
                    startActivity(intent);
                }
            }
        });
    }

    private void initListener() {
        mTotalCheck.setOnClickListener(this);
        mTotalCheck.setOnCheckedChangeListener(this);
        mBuy.setOnClickListener(this);
        mEdit.setOnClickListener(this);
    }

    private void getList() {
        ShopCarBean bean = new ShopCarBean();
        bean.setName("香奈儿四件套1");
        bean.setPrice("商品价格:  ¥58");
        bean.setNum("1");
        bean.setResId(R.mipmap.ad1);
        bean.setShow(false);
        bean.setChecked(0);

        ShopCarBean bean1 = new ShopCarBean();
        bean1.setName("香奈儿四件套2");
        bean1.setPrice("商品价格:  ¥58");
        bean1.setNum("12");
        bean1.setResId(R.mipmap.ad2);
        bean1.setShow(false);
        bean1.setChecked(0);

        ShopCarBean bean2 = new ShopCarBean();
        bean2.setName("香奈儿3的");
        bean2.setPrice("商品价格:  ¥18");
        bean2.setNum("20");
        bean2.setResId(R.mipmap.ad3);
        bean2.setShow(false);
        bean2.setChecked(0);

        ShopCarBean bean3 = new ShopCarBean();
        bean3.setName("香奈儿4");
        bean3.setPrice("商品价格:  ¥58");
        bean3.setNum("26");
        bean3.setResId(R.mipmap.ad1);
        bean3.setShow(false);
        bean3.setChecked(0);

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_btn:
                if (mBuy.getText().toString().equals("立即购买")) {

                } else {
                    mHandler.sendEmptyMessage(1);
                    if (!list.isEmpty()) {

//                        int size=list.size();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getChecked() == 1) {
                                list.remove(i);
                                i--;
                            }
                        }
                    }
                    if (list.size() < 1) {
                        mTotalCheck.setChecked(false);
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.shopcar_edit:
                if (list.size() < 1) {
                    mTotalCheck.setChecked(false);
                }
                if (mBuy.getText().toString().equals("立即购买")) {
                    mBuy.setText("删除");
                    editTv.setText("完成");
                } else {
                    mBuy.setText("立即购买");
                    editTv.setText("编辑");
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isItem) {
            if (isChecked) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setChecked(1);
                    }
                }
            } else {

                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setChecked(0);
                    }
                }
            }


            mHandler.sendEmptyMessage(1);
            adapter.notifyDataSetChanged();
        }
        isItem = false;
    }
}
