package com.zhongbao.zhongbao.my;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;
import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.base.BaseSubscriber;
import com.zhongbao.zhongbao.bean.AdressBean;
import com.zhongbao.zhongbao.bean.BasicModel;
import com.zhongbao.zhongbao.listener.OnOptionsSelectResultListener;
import com.zhongbao.zhongbao.view.CroshePickerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class AddAdressActivity extends BaseActivity implements View.OnClickListener {

    private EditText mNameEt, mPhoneEt, mAdressDetailEt;
    private ImageView mRadio;
    private TextView tv_address;
    boolean isChoose = true;
    private String is_default = "0";
    private AdressBean addressBean;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_add_adress;
    }

    @Override
    protected void initView() {
        addressBean = getIntent().getParcelableExtra("addressBean");
        findViewById(R.id.back_left).setOnClickListener(this);
        mNameEt = findViewById(R.id.name_et);
        tv_address = findViewById(R.id.tv_address);
        tv_address.setOnClickListener(this);
        mPhoneEt = findViewById(R.id.phone_et);
        mAdressDetailEt = findViewById(R.id.adress_detail_et);
        mRadio = findViewById(R.id.moren_radio);
        findViewById(R.id.add_adress_btn).setOnClickListener(this);
        findViewById(R.id.add_adress_btn).setOnClickListener(this);
        mRadio.setOnClickListener(this);
        if (addressBean!=null){
            mNameEt.setText(addressBean.getRealname());
            mPhoneEt.setText(addressBean.getMobile());
            mAdressDetailEt.setText(addressBean.getAddress());
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_left:
                finish();
                break;
            case R.id.add_adress_btn:
                addAddress();
                break;
            case R.id.moren_radio:
                if (isChoose) {
                    mRadio.setImageResource(R.mipmap.login_true);
                    is_default = "1";
                    isChoose = false;
                } else {
                    is_default = "0";
                    mRadio.setImageResource(R.mipmap.shopcar_noselect);
                    isChoose = true;
                }
                break;
            case R.id.tv_address:
                CroshePickerView.getInstance()
                        .showCityPickerView(this, new OnOptionsSelectResultListener() {
                            @Override
                            public void cityInfo(String province, String city, String area) {
                                tv_address.setText(province+city+area+" ");
                            }
                        });
                break;
        }
    }


    public void addAddress(){
        Map<String,String> map = new HashMap<>();
        map.put("uid",ZBApp.get().getUserId());
        map.put("address",getTextStr(R.id.tv_address)+getTextStr(R.id.adress_detail_et));
        map.put("is_default",is_default);
        map.put("mobile",getTextStr(R.id.phone_et));
        map.put("realname",getTextStr(R.id.name_et));
        getHttpService().add_address(map)
                .compose(this.apply())
                .subscribe(new BaseSubscriber<BasicModel>() {
                    @Override
                    protected void onDoNext(BasicModel basicModel) {
                        if (basicModel.getCode().equals("200")){
                            finish();
                        }
                        Toast.makeText(AddAdressActivity.this, basicModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if(isChecked)
//        {
//            mRadio.setBackgroundResource(R.mipmap.login_true);
//        }else
//        {
//                mRadio.setBackgroundResource(R.mipmap.shopcar_noselect);
//        }
//    }
}
