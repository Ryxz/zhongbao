package com.zhongbao.zhongbao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zhongbao.zhongbao.dialog.WinningInfoDialog;
import com.zhongbao.zhongbao.R;

import java.util.ArrayList;
import java.util.List;

import com.zhongbao.zhongbao.adapter.HomeGridAdapter;
import com.zhongbao.zhongbao.adapter.ViewPagerAdapter;
import com.zhongbao.zhongbao.bean.HomePrograssBean;
import com.zhongbao.zhongbao.goods.GoodsDetailActivity;
import com.zhongbao.zhongbao.goods.NoviceActivity;
import com.zhongbao.zhongbao.home.SearchActivity;
import com.zhongbao.zhongbao.home.XianGouActivity;
import com.zhongbao.zhongbao.home.XinpinActivity;
import com.zhongbao.zhongbao.my.MyBaskActivity;
import com.zhongbao.zhongbao.my.PayActivity;
import com.zhongbao.zhongbao.my.SystemNewsActivity;
import com.zhongbao.zhongbao.my.TAcenterActivity;
import com.zhongbao.zhongbao.utils.ButtonUtils;
import com.zhongbao.zhongbao.view.HomePopwindow;
import com.zhongbao.zhongbao.view.Xcircleindicator;

/**
 * Used for
 * Created by tuyz on 2018/10/8.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private ImageView mHomeNews;

    private List<Fragment> mFragments;
    private TextView mAll, mIng;
    private TextView mEd;
    private LinearLayout mLabone, mLabtwo, mLabThree;
    private LinearLayout mPrice;
    private LinearLayout mShaidan, mXinpin, mXiangou, mXinshou, mPay;


    ViewPager viewPager;
    ViewPagerAdapter adapter;
    List<Integer> data;
    List<String> titleData;
    int currentPage = 0;
    boolean viewPagerScrollStatus = false; //标志位,当在手动翻页时,自动翻页暂停

    //    TextView  indicator;
    private RelativeLayout mSearch;
    private ImageView mHomeType;
    private GridView mGridView;
    private HomeGridAdapter madapter;
    private List<HomePrograssBean> list = new ArrayList<>();
    private Xcircleindicator mXcircleindicator;
    private LinearLayout top, bottom;
    private LinearLayout mSkipCenter;
    private TextView mTitle;
    private ImageView iTop, iBottom;

    private WinningInfoDialog winningInfoDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (!viewPagerScrollStatus) {
                viewPager.setCurrentItem(++currentPage);
            }
            handler.sendEmptyMessageDelayed(1, 4000);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        return rootView;
    }

    private HomeProgressFragment one;
    private SBTwoFragment two;
    private SBFragment three;
    private FrameLayout mLayout;
    private TextView mShowPop;
    private LinearLayout mTitleHome;
    private RadioGroup mJiantou;
    private RadioButton mTopRb;
    private RadioButton mBottomRb;

    private void initData() {
        mFragments = new ArrayList<>();
        one = new HomeProgressFragment();
        OngoingFragment two = new OngoingFragment();
        SBFragment three = new SBFragment();
        mFragments.add(one);
        mFragments.add(two);
        mFragments.add(three);
//        initFirstFragment();

        madapter = new HomeGridAdapter(getList(), getActivity());
        mGridView.setAdapter(madapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (ButtonUtils.isFastClick()) {
                    Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                    intent.putExtra("STATE", list.get(position).getState());
                    startActivity(intent);
                }
            }
        });

        winningInfoDialog = new WinningInfoDialog(getContext(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winningInfoDialog.dismiss();
            }
        });
        winningInfoDialog.show();
    }

    private List<HomePrograssBean> getList() {
        if (list != null) {
            list.clear();
        }
        HomePrograssBean bean = new HomePrograssBean();
        bean.setName("香奈儿四件套高级定制");
        bean.setJindu("60");
        bean.setState("1");
        bean.setImageResId(R.mipmap.a);


        HomePrograssBean bean1 = new HomePrograssBean();
        bean1.setName("香奈儿四件套高级定制");
        bean1.setJindu("30");
        bean1.setState("2");
        bean1.setImageResId(R.mipmap.b);


        list.add(bean);
        list.add(bean1);
        list.add(bean1);
        list.add(bean);
        return list;
    }

    ScrollView mScrollView;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mScrollView != null) {
            mScrollView.post(new Runnable() {
                @Override
                public void run() {

                    viewPager.setFocusable(true);
                    viewPager.setFocusableInTouchMode(true);
                    viewPager.requestFocus();
//                    if(mScrollView.getScaleY() != 0)
//                    {
//                        mScrollView.scrollTo(0,0);
//                    }
                }
            });
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initView(View view) {
        mTitleHome = view.findViewById(R.id.home_title);
//        top = com.zhongbao.zhongbao.view.findViewById(R.id.top_shaixuan);
//        bottom = com.zhongbao.zhongbao.view.findViewById(R.id.bottom_shaixuan);
        mScrollView = view.findViewById(R.id.scrollView);
        mGridView = view.findViewById(R.id.gridview_home);
        viewPager = view.findViewById(R.id.viewpager);
//        indicator = (TextView) com.zhongbao.zhongbao.view.findViewById(R.id.banner_indicator);
        mXcircleindicator = (Xcircleindicator) view.findViewById(R.id.banner_indicator);
        mHomeType = view.findViewById(R.id.home_type);
        mSkipCenter = view.findViewById(R.id.skip_center);
        mSearch = view.findViewById(R.id.search);
        mShowPop = view.findViewById(R.id.show_pop);
        mTitle = view.findViewById(R.id.text_title);
//        iTop = com.zhongbao.zhongbao.view.findViewById(R.id.top_iv);
//        iBottom = com.zhongbao.zhongbao.view.findViewById(R.id.bottom_iv);
        mShowPop.setOnClickListener(this);
        data = new ArrayList<>();
        titleData = new ArrayList<>();

        data.add(R.mipmap.a);
        titleData.add("4.哦");
        data.add(R.mipmap.mine_head);
        titleData.add("1.怎么了");
        data.add(R.mipmap.b);
        titleData.add("1.怎么了");
        data.add(R.mipmap.a);
        titleData.add("1.怎么了");
        data.add(R.mipmap.mine_head);
        titleData.add("1.怎么了");
        data.add(R.mipmap.a);
        titleData.add("1.怎么了");
        data.add(R.mipmap.mine_head);
        titleData.add("1.怎么了");
        data.add(R.mipmap.b);
        titleData.add("1.怎么了");
        data.add(R.mipmap.mine_head);
        titleData.add("1.怎么了");

        adapter = new ViewPagerAdapter(data);
        viewPager.setAdapter(adapter);
        mXcircleindicator.initData(data.size(), 0);
        mXcircleindicator.setCurrentPage(0);

        mSkipCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TAcenterActivity.class));
            }
        });

//        top.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View com.zhongbao.zhongbao.view) {
//                iTop.setBackgroundResource(R.mipmap.go_top_select);
//                iBottom.setBackgroundResource(R.mipmap.go_bottom);
//            }
//        });
//
//        bottom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View com.zhongbao.zhongbao.view) {
//
//            }
//        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //头尾衔接,无限循环
                mXcircleindicator.setCurrentPage(position);
                if (position == data.size() - 1) {
                    currentPage = 0;
                } else {
                    currentPage = position;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPagerScrollStatus = false;
                    viewPager.setCurrentItem(currentPage, false);
//                    indicator.setText(currentPage + "/" + (titleData.size() - 2));
                } else {
                    viewPagerScrollStatus = true;
                }
            }
        });
        handler.sendEmptyMessageDelayed(1, 4000);

        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {

                int width = page.getWidth();
                //我们给不同状态的页面设置不同的效果
                //通过position的值来分辨页面所处于的状态
                if (position < -1) {//滑出的页面
                    page.setScrollX((int) (width * 0.75 * -1));
                } else if (position <= 1) {//[-1,1]
                    if (position < 0) {//[-1,0]
                        page.setScrollX((int) (width * 0.75 * position));
                    } else {//[0,1]
                        page.setScrollX((int) (width * 0.75 * position));
                    }
                } else {//即将滑入的页面
                    page.setScrollX((int) (width * 0.75));
                }
            }
        });

        mLayout = view.findViewById(R.id.home_frame_layout);
        mAll = view.findViewById(R.id.rb_all);
        mIng = view.findViewById(R.id.rb_ing);
        mEd = view.findViewById(R.id.rb_ed);

        mJiantou = view.findViewById(R.id.radio_jiantou);

        mLabone = view.findViewById(R.id.lab_one);
        mLabtwo = view.findViewById(R.id.lab_two);
        mLabThree = view.findViewById(R.id.lab_three);
        mPrice = view.findViewById(R.id.price_rela);
        mHomeNews = view.findViewById(R.id.home_news_iv);
        mShaidan = view.findViewById(R.id.home_shaidan);
        mXinpin = view.findViewById(R.id.home_xinpin);
        mXiangou = view.findViewById(R.id.home_xiangou);
        mXinshou = view.findViewById(R.id.home_xinshou);
        mPay = view.findViewById(R.id.home_pay);
        mTopRb = view.findViewById(R.id.top_rb);
        mBottomRb = view.findViewById(R.id.bottom_rb);
        initData();
        initListener();

        mJiantou.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.top_rb) {
                    mTopRb.setChecked(true);
                    mBottomRb.setChecked(false);
                } else {
                    mTopRb.setChecked(false);
                    mBottomRb.setChecked(true);
                }
            }
        });
    }

    private void initFirstFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (one == null) {
            one = new HomeProgressFragment();
        }
        transaction.replace(R.id.home_frame_layout, one);
        transaction.commit();
    }

    private void initSecondFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        if (two == null) {
            two = new SBTwoFragment();
        }
        transaction.replace(R.id.home_frame_layout, two);
        transaction.commit();
    }


    private void initThirdFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        if (three == null) {
            three = new SBFragment();
        }
        transaction.replace(R.id.home_frame_layout, three);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (one != null) {
            transaction.hide(one);
        }
        if (two != null) {
            transaction.hide(two);
        }
        if (three != null) {
            transaction.hide(three);
        }

    }

    private void initListener() {
        mPrice.setOnClickListener(this);
        mAll.setOnClickListener(this);
        mIng.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mShaidan.setOnClickListener(this);
        mXinpin.setOnClickListener(this);
        mXiangou.setOnClickListener(this);
        mXinshou.setOnClickListener(this);
        mHomeType.setOnClickListener(this);
        mPay.setOnClickListener(this);
//        top.setOnClickListener(this);
//        bottom.setOnClickListener(this);
        mHomeNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SystemNewsActivity.class));
            }
        });
    }

    private void setLabState(int id) {
        if (id == R.id.rb_all) {
            mAll.setTextColor(getResources().getColor(R.color.bottom_tab_select));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mEd.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.VISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
            mLabThree.setVisibility(View.INVISIBLE);
        } else if (id == R.id.rb_ing) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.bottom_tab_select));
            mEd.setTextColor(getResources().getColor(R.color.text_dray));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.VISIBLE);
            mLabThree.setVisibility(View.INVISIBLE);
        } else if (id == R.id.price_rela) {
            mAll.setTextColor(getResources().getColor(R.color.text_dray));
            mIng.setTextColor(getResources().getColor(R.color.text_dray));
            mEd.setTextColor(getResources().getColor(R.color.bottom_tab_select));
            mLabone.setVisibility(View.INVISIBLE);
            mLabtwo.setVisibility(View.INVISIBLE);
            mLabThree.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_shaidan:
                startActivity(new Intent(getActivity(), MyBaskActivity.class));
                break;
            case R.id.home_xiangou:
                startActivity(new Intent(getActivity(), XianGouActivity.class));
                break;
            case R.id.home_xinshou:
                startActivity(new Intent(getActivity(), NoviceActivity.class));
                break;

            case R.id.home_xinpin:
                startActivity(new Intent(getActivity(), XinpinActivity.class));
                break;

            case R.id.home_pay:
                startActivity(new Intent(getActivity(), PayActivity.class));
                break;
            case R.id.search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.home_type:
                HomePopwindow pop = new HomePopwindow(getActivity());
                pop.showAsDropDown(mShowPop);
                break;
            case R.id.rb_all:
                mLayout.setVisibility(View.VISIBLE);
                initFirstFragment();
                mGridView.setVisibility(View.GONE);

                setLabState(view.getId());
                break;
            case R.id.price_rela:
                mLayout.setVisibility(View.VISIBLE);
                mGridView.setVisibility(View.GONE);
                initThirdFragment();
                setLabState(view.getId());
                break;
            case R.id.rb_ing:
                mLayout.setVisibility(View.VISIBLE);
                initSecondFragment();
                mGridView.setVisibility(View.GONE);
                setLabState(view.getId());
                break;
//            case R.id.top_shaixuan:
//                iTop.setBackgroundResource(R.mipmap.go_top);
//                iBottom.setBackgroundResource(R.mipmap.go_bottom_select);
//                break;
//
//            case R.id.bottom_shaixuan:
//                iTop.setBackgroundResource(R.mipmap.go_top_select);
//                iBottom.setBackgroundResource(R.mipmap.go_bottom);
//                break;
        }
    }
}
