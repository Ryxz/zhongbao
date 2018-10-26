package com.zhongbao.zhongbao.my;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zhongbao.zhongbao.BaseActivity;
import com.zhongbao.zhongbao.R;

/**
 * Used for
 * Created by tuyz on 2018/10/22.
 */

public class ShareActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout mWeixin,mFriend,mQQ,mWeibo,mCancel;
    private Dialog dia;
    @Override
    protected int getLayoutID() {
        return R.layout.pop_layout;
    }

    @Override
    protected void initListener() {
        mWeixin.setOnClickListener(this);
        mFriend.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mWeibo.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mWeixin = f(R.id.weixin);
        mFriend = f(R.id.friend);
        mQQ = f(R.id.qq);
        mWeibo = f(R.id.weibo);
        mCancel = f(R.id.cancel);

        Context context = ShareActivity.this;
        dia = new Dialog(context, R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.dialog_img_layout);
        ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
        imageView.setBackgroundResource(R.mipmap.share_bg);
        //选择true的话点击其他地方可以使dialog消失，为false的话不会消失
        dia.setCanceledOnTouchOutside(true); // Sets whether this dialog is
        Window w = dia.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.x = 0;
        lp.y = 40;
        dia.onWindowAttributesChanged(lp);
        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dia.dismiss();
                    }
                });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.weixin:
                Toast.makeText(this,"分享微信",Toast.LENGTH_LONG).show();
                break;
            case R.id.friend:
                Toast.makeText(this,"分享朋友圈",Toast.LENGTH_LONG).show();
                break;
            case R.id.qq:
                Toast.makeText(this,"分享QQ好友",Toast.LENGTH_LONG).show();
                break;
            case R.id.weibo:
                Toast.makeText(this,"分享微博",Toast.LENGTH_LONG).show();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }
}
