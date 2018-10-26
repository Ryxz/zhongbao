package com.zhongbao.zhongbao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.BaseFraAdapter;

/**
 * Used for
 * Created by tuyz on 2018/10/17.
 */

public class BaskFragment extends Fragment {

    private ListView mList;
    private BaseFraAdapter adapter;

    private List<String> nameList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bask,container,false);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        mList = view.findViewById(R.id.list_bask);
        adapter = new BaseFraAdapter(getActivity(),getList());
        mList.setAdapter(adapter);
    }

    private List<String> getList()
    {
        nameList.add("香奈儿四件套你值得拥有");
        nameList.add("大西瓜四件套你值得拥有");
        nameList.add("小苹果四件套你值得拥有");
        return nameList;
    }
}
