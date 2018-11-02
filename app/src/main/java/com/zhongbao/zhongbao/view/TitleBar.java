package com.zhongbao.zhongbao.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;


public class TitleBar extends Toolbar {
    private TextView mTvTitle;
    private TextView mTvLeft;
    private TextView mTvRight;
    private ImageView mIvRight;
    private ImageView mIvLeft;

    public TitleBar(Context context) {
        super(context);
        init(context, null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.title_bar, this, true);
        mTvTitle = findViewById(R.id.tv_title);
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);
        mIvRight = findViewById(R.id.iv_right);
        mIvLeft = findViewById(R.id.iv_back);
        mIvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getContext() instanceof Activity) {
                    ((Activity) v.getContext()).onBackPressed();
                }
            }
        });
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            mIvLeft.setVisibility(typedArray.getBoolean(R.styleable.TitleBar_display_as_home, false)
                    ? GONE : VISIBLE);
            boolean show_bottom_line = typedArray.getBoolean(R.styleable.TitleBar_show_bottom_line, true);
            showBottomLine(show_bottom_line);
            String rightText = typedArray.getString(R.styleable.TitleBar_right_text);
            setRightText(rightText);
            int rightTextColor = typedArray.getColor(R.styleable.TitleBar_right_text_color, -1);
            if (rightTextColor != -1) {
                mTvRight.setTextColor(rightTextColor);
            }


            String leftText = typedArray.getString(R.styleable.TitleBar_left_text);
            setLeftText(leftText);
            int leftTextColor = typedArray.getColor(R.styleable.TitleBar_left_text_color, -1);
            if (leftTextColor != -1) {
                mTvLeft.setTextColor(leftTextColor);
            }

            TypedArray taToolBar = context.obtainStyledAttributes(attrs, android.support.v7.appcompat.R.styleable.Toolbar);
            int titleTextColor = -1;
            for (int i = 0; i < attrs.getAttributeCount(); i++) {
                String attrName = attrs.getAttributeName(i);
                if (attrName.contains("titleTextColor")) {
                    titleTextColor = attrs.getAttributeResourceValue(i, -1);
                }
            }
            if (titleTextColor != -1) {
                setTitleTextColor(getResources().getColor(titleTextColor));
            }
            taToolBar.recycle();

            Drawable drawable = typedArray.getDrawable(R.styleable.TitleBar_right_icon);
            if (drawable != null) {
                mIvRight.setImageDrawable(drawable);
                mIvRight.setVisibility(VISIBLE);
            }

            Drawable leftDrawable = typedArray.getDrawable(R.styleable.TitleBar_left_icon);
            if (leftDrawable != null) {
                mIvLeft.setImageDrawable(leftDrawable);
            }
            typedArray.recycle();
        }
    }

    @Override
    public void setTitle(int resId) {
        super.setTitle(resId);
        if (mTvTitle != null) {
            mTvTitle.setText(resId);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
    }

    @Override
    public void setTitleTextColor(int color) {
        super.setTitleTextColor(color);
        if (mTvTitle != null) {
            mTvTitle.setTextColor(color);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTvTitle.setText(getTitle());
        setContentInsetsAbsolute(0, 0);
    }

    public void setRightClickListener(OnClickListener clickListener) {
        mTvRight.setOnClickListener(clickListener);
    }

    public void setLeftIcon(int drawableRes) {
        mIvLeft.setImageResource(drawableRes);
    }

    public void showBottomLine(boolean isShow) {
        findViewById(R.id.line).setVisibility(isShow ? VISIBLE : GONE);
    }

    public void setDisplayAsHome() {
        findViewById(R.id.iv_back).setVisibility(GONE);
    }

    public void setRightText(String rightText) {
        mTvRight.setText(rightText);
    }

//    public void setRightImage(int id){
//        mIvRight.setImageResource(id);
//        mIvRight.setVisibility(VISIBLE);
//    }

    public void setLeftClickListener(OnClickListener onClickListener) {
        mTvLeft.setOnClickListener(onClickListener);
    }

    public TextView getTvRight() {
        return mTvRight;
    }

    public void setLeftText(String leftText) {
        mTvLeft.setText(leftText);
    }

}
