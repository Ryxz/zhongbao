package com.zhongbao.my;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class AboutActivity extends Activity implements View.OnClickListener {

    private List<String> titleList = new ArrayList<>();
    private  ListView mAboutListView;

    private AbouthideAdapter adapter;
    public int clickPosition = -1;
    private RelativeLayout mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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
        initData();
        mAboutListView = findViewById(R.id.about_list);
        mBack = findViewById(R.id.back_left);
        mBack.setOnClickListener(this);
        adapter = new AbouthideAdapter();
        mAboutListView.setAdapter(adapter);
    }

    private void initData()
    {
        titleList.add("什么是云购?");
        titleList.add("什么是云购?云购是如何产生的?");
        titleList.add("幸运云购和商品获得者是如何计算出来的?");
        titleList.add("如何参入云购");
        titleList.add("三分钟倒计时是什么意思");
        for(int i = 0;i<5;i++)
        {
            titleList.add("什么是云购?");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_left:
                finish();
                break;
        }
    }

    class AbouthideAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return titleList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final MyViewHolder vh;
            if (convertView == null) {
                convertView = View.inflate(AboutActivity.this, R.layout.adapter_about_item, null);
                vh = new MyViewHolder();
                vh.textTV = convertView.findViewById(R.id.about_item_tv);
                vh.arrow = convertView.findViewById(R.id.about_show_relative);

                vh.hideTextTv = convertView.findViewById(R.id.adapter_hide_tv);
                vh.aboutHideView = convertView.findViewById(R.id.about_hide_linear);
                vh.mArrowRight = convertView.findViewById(R.id.about_arrow_right);
                vh.mArrowBottom = convertView.findViewById(R.id.about_arrow_bottom);
                convertView.setTag(vh);
            } else {
                vh = (MyViewHolder) convertView.getTag();
            }

            vh.textTV.setText(titleList.get(position));

            //刷新adapter的时候，getview重新执行，此时对在点击中标记的position做处理
            if (clickPosition == position) {//当条目为刚才点击的条目时
                if (vh.arrow.isSelected()) {//当条目状态图标为选中时，说明该条目处于展开状态，此时让它隐藏，并切换状态图标的状态。
                    vh.mArrowRight.setVisibility(View.VISIBLE);
                    vh.mArrowBottom.setVisibility(View.GONE);
                    vh.aboutHideView.setVisibility(View.GONE);
                    clickPosition=-1;//隐藏布局后需要把标记的position去除掉，否则，滑动listview让该条目划出屏幕范围，
                    // 当该条目重新进入屏幕后，会重新恢复原来的显示状态。经过打log可知每次else都执行一次 （条目第二次进入屏幕时会在getview中寻找他自己的状态，相当于重新执行一次getview）
                    //因为每次滑动的时候没标记得position填充会执行click
                } else {//当状态条目处于未选中时，说明条目处于未展开状态，此时让他展开。同时切换状态图标的状态。
                    vh.mArrowRight.setVisibility(View.GONE);
                    vh.mArrowBottom.setVisibility(View.VISIBLE);
                    vh.aboutHideView.setVisibility(View.VISIBLE);
                }
//                ObjectAnimator//
//                        .ofInt(vh.ll_hide, "rotationX", 0.0F, 360.0F)//
//                        .setDuration(500)//
//                        .start();
                // vh.selectorImg.setSelected(true);
            }
            else {//当填充的条目position不是刚才点击所标记的position时，让其隐藏，状态图标为false。
                //每次滑动的时候没标记得position填充会执行此处，把状态改变。所以如果在以上的if (vh.selectorImg.isSelected()) {}中不设置clickPosition=-1；则条目再次进入屏幕后，还是会进入clickposition==position的逻辑中
                //而之前的滑动（未标记条目的填充）时，执行此处逻辑，已经把状态图片的selected置为false。所以上面的else中的逻辑会在标记过的条目第二次进入屏幕时执行，如果之前的状态是显示，是没什么影响的，再显示一次而已，用户看不出来，但是如果是隐藏状态，就会被重新显示出来
                vh.aboutHideView.setVisibility(View.GONE);
                vh.mArrowRight.setVisibility(View.VISIBLE);
                vh.mArrowBottom.setVisibility(View.GONE);
            }

            vh.arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickPosition = position;//记录点击的position
                    notifyDataSetChanged();//刷新adapter重新填充条目。在重新填充的过程中，被记录的position会做展开或隐藏的动作，具体的判断看上面代码
                    //在此处需要明确的一点是，当adapter执行刷新操作时，整个getview方法会重新执行，也就是条目重新做一次初始化被填充数据。
                    //所以标记position，不会对条目产生影响，执行刷新后 ，条目重新填充当，填充至所标记的position时，我们对他处理，达到展开和隐藏的目的。
                    //明确这一点后，每次点击代码执行逻辑就是 onclick（）---》getview（）
                }
            });
            return convertView;
        }

        class MyViewHolder {
            View itemView;
            TextView textTV,hideTextTv;
            RelativeLayout arrow;
            LinearLayout aboutHideView;
            ImageView mArrowRight,mArrowBottom;

            /*public MyViewHolder(View itemView) {
                this.itemView = itemView;
                textTV = itemView.findViewById(R.id.about_item_tv);
                arrow = itemView.findViewById(R.id.about_show_relative);

                hideTextTv = itemView.findViewById(R.id.adapter_hide_tv);
                aboutHideView = itemView.findViewById(R.id.about_hide_linear);
                mArrowRight = itemView.findViewById(R.id.about_arrow_right);
                mArrowBottom = itemView.findViewById(R.id.about_arrow_bottom);
            }*/
        }

    }
}
