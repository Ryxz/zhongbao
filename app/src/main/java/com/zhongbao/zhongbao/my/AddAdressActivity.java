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

import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class AddAdressActivity extends Activity implements View.OnClickListener {

    private RelativeLayout mBack;
    private EditText mNameEt,mAdressEt,mPhoneEt,mAdressDetailEt;
    private ImageView mRadio;
    private TextView mTrue;
    boolean a = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adress);
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.bg_toolbar));
        }
        initView();
    }

    private void initView()
    {
        mBack = findViewById(R.id.back_left);
        mNameEt = findViewById(R.id.name_et);
        mAdressEt = findViewById(R.id.adress_et);
        mPhoneEt = findViewById(R.id.phone_et);
        mAdressDetailEt = findViewById(R.id.adress_detail_et);
        mRadio = findViewById(R.id.moren_radio);
        mTrue = findViewById(R.id.add_adress_btn);
        initLintener();
    }

    private void initLintener()
    {
        mBack.setOnClickListener(this);
        mTrue.setOnClickListener(this);
        mRadio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_left:
                finish();
                break;
            case R.id.add_adress_btn:
                finish();
                break;
            case R.id.moren_radio:

                if(a)
                {
                    mRadio.setBackgroundResource(R.mipmap.login_true);
                    a = false;
                }else
                    {
                        mRadio.setBackgroundResource(R.mipmap.shopcar_noselect);
                        a = true;
                    }


                break;
        }
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
