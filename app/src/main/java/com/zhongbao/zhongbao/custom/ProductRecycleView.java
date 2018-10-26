package com.zhongbao.zhongbao.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ProductRecycleView extends RecyclerView {

  public ProductRecycleView(@NonNull Context context) {
    super(context);
  }

  public ProductRecycleView(@NonNull Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public ProductRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  //默认设置为true
  private boolean isTouch=true;

  public boolean isTouch() {
    return isTouch;
  }

  public void setTouch(boolean touch) {
    isTouch = touch;
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    isTouch =true;
    return super.dispatchTouchEvent(ev);
  }



}
