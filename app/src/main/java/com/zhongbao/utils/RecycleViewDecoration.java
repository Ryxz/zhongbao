package com.zhongbao.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

import com.zhongbao.zhongbao.R;

public class RecycleViewDecoration extends RecyclerView.ItemDecoration {

  private Drawable mDrawable;

  public RecycleViewDecoration(Context context){
    mDrawable = context.getResources().getDrawable(R.color.item_decoration);
  }

  @Override
  public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
      @NonNull RecyclerView parent, @NonNull State state) {
    super.getItemOffsets(outRect, view, parent, state);
    outRect.top=5;
    outRect.bottom=5;//自己设置分割线高度
  }

  @Override
  public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull State state) {
    drawVertical(c,parent);
  }
  //绘制纵向 item 分割线
  private void drawVertical(Canvas canvas, RecyclerView parent) {
    final int left = parent.getPaddingLeft();
    final int right = parent.getWidth() - parent.getPaddingRight();

    final int childCount = parent.getChildCount();
    for (int i = 0; i < childCount; i++) {
      final View child = parent.getChildAt(i);
      final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
          .getLayoutParams();
      //以下计算主要用来确定绘制的位置
      final int top = child.getBottom() + params.bottomMargin;
      final int bottom = top + mDrawable.getIntrinsicHeight();
      mDrawable.setBounds(left, top, right, bottom);
      mDrawable.draw(canvas);
    }
  }
}
