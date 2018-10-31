package com.aspsine.swipetoloadlayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ant.liao.GifView;
import com.aspsine.swipetoloadlayout.R;
import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout;

/**
 * Created by Aspsine on 2015/9/9.
 */
public class TwitterRefreshGifHeaderView extends SwipeRefreshHeaderLayout implements View.OnClickListener {

//    private ImageView ivArrow;
//
//    private ImageView ivSuccess;
//
//    private TextView tvRefresh;
//
//    private ProgressBar progressBar;
    private GifView gif2;

    private int mHeaderHeight;

    private Animation rotateUp;

    private Animation rotateDown;

    private boolean rotated = false;
    private boolean isPullDowning = true;//判断是否正在下拉

    public TwitterRefreshGifHeaderView(Context context) {
        this(context, null);
    }

    public TwitterRefreshGifHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwitterRefreshGifHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHeaderHeight = getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_twitter);
        rotateUp = AnimationUtils.loadAnimation(context, R.anim.rotate_up);
        rotateDown = AnimationUtils.loadAnimation(context, R.anim.rotate_down);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        gif2 = (GifView) findViewById(R.id.gif2);

        // 设置Gif图片源
        gif2.setGifImage(R.drawable.headrefresh);
        // 添加监听器
        gif2.setOnClickListener(this);
       // 设置显示的大小，拉伸或者压缩
        gif2.setShowDimension(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        // 设置加载方式：先加载后显示：GifImageType.WAIT_FINISH、边加载边显示：GifImageType.SYNC_DECODER、只显示第一帧再显示：GifImageType.COVER
        gif2.setGifImageType(GifView.GifImageType.COVER);
//        tvRefresh = (TextView) findViewById(R.id.tvRefresh);
//        ivArrow = (ImageView) findViewById(R.id.ivArrow);
//        ivSuccess = (ImageView) findViewById(R.id.ivSuccess);
//        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    public void onRefresh() {
//        gif2.setVisibility(VISIBLE);
//        ivSuccess.setVisibility(GONE);
//        ivArrow.clearAnimation();
//        ivArrow.setVisibility(GONE);
//        progressBar.setVisibility(VISIBLE);
//        tvRefresh.setText("正在刷新");
    }

    @Override
    public void onPrepare() {
        Log.d("TwitterRefreshHeader", "onPrepare()");
    }

    private final String TAG = this.getClass().getSimpleName();

    private int num = 0;
//
    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            num++;
//            Log.i(TAG, "刷新次数：" + num);
//            if (ivArrow.getVisibility() != View.VISIBLE) {
//
//                Log.i(TAG, "显示箭头");
//                ivArrow.setVisibility(VISIBLE);
//                progressBar.setVisibility(GONE);
//                ivSuccess.setVisibility(GONE);
//            }
            if (y > mHeaderHeight) {
                if (!rotated) {
//                    tvRefresh.setText("放开刷新");
                    isPullDowning = true;
                    Log.i(TAG, "触发动画rotateUp：");
//                    ivArrow.clearAnimation();
//                    ivArrow.startAnimation(rotateUp);
                    rotated = true;
                }
            } else if (y < mHeaderHeight) {
                if (rotated) {
                    Log.i(TAG, "触发动画rotateDown：");
//                    ivArrow.clearAnimation();
//                    ivArrow.startAnimation(rotateDown);
                    rotated = false;
                }
                if (isPullDowning) {
//                    tvRefresh.setText("下拉刷新");
                    isPullDowning = false;
                    Log.i(TAG, "下拉刷新：");
                }
            }
        }
    }

    @Override
    public void onRelease() {
        Log.d("TwitterRefreshHeader", "onRelease()");
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "完成：");
        rotated = false;
//        ivSuccess.setVisibility(VISIBLE);
//        ivArrow.clearAnimation();
//        ivArrow.setVisibility(GONE);
//        progressBar.setVisibility(GONE);
//        tvRefresh.setText("完成");
    }

    @Override
    public void onReset() {
        Log.i(TAG, "重置：");
        rotated = false;
//        ivSuccess.setVisibility(GONE);
//        ivArrow.clearAnimation();
//        ivArrow.setVisibility(GONE);
//        progressBar.setVisibility(GONE);
    }

    @Override
    public void onClick(View v) {

    }
}
