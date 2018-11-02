package com.zhongbao.zhongbao.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.zhongbao.zhongbao.R;

@SuppressLint("AppCompatCustomView")
public class MyRadioButton extends RadioButton {
    private Drawable drawable;
    public MyRadioButton(Context context) {
        super(context);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawable = getResources().getDrawable(R.drawable.radio_choose);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRadioButton);//获取我们定义的属性
//        drawable = typedArray.getDrawable(R.styleable.MyRadioButton_drawableTop);
        drawable.setBounds(0, 0, 50, 50);
        setCompoundDrawables(null, null, drawable, null);

 }
}