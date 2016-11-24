package com.example.upon.test.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.upon.test.R;
import com.example.upon.test.adapter.MyFragmentAdapter;
import com.example.upon.test.adapter.MyViewPagerAdapter;
import com.example.upon.test.ui.fragment.FinderActivity;
import com.example.upon.test.ui.fragment.MineActivity;
import com.example.upon.test.ui.fragment.ShopActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Created by UPON
 * 邮箱：upon_88@163.com
 * 时间： 2016/10/12
 */
public class BaseActivity extends FragmentActivity {

    //private View view1, view2, view3;//需要滑动的页卡
    //private List<View> viewList;//把需要滑动的页卡添加到这个list中
    private ViewPager viewPager;//viewpager
    private List<Fragment> fragmentList;
    private int moveOne;
    ImageView image_line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initTabView();

    }

    public void initTabView() {

       /*LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.activity_shop, null);
        view2 = lf.inflate(R.layout.activity_mine, null);
        view3 = lf.inflate(R.layout.activity_finder, null);

        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewPager = (ViewPager) findViewById(R.id.vPager);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(viewList);
        viewPager.setAdapter(myViewPagerAdapter);*/
        initImage();
        initFrame();

    }
/*
* 重新设定Image线的宽度
* */
    private void initImage() {
        image_line = (ImageView) findViewById(R.id.tab_line);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        /***重新设置下划线的宽度 */
        ViewGroup.LayoutParams lp = image_line.getLayoutParams();
        lp.width = screenW / 3;
        image_line.setLayoutParams(lp);
        moveOne = lp.width; // 滑动一个页面的距离
    }
/*
* 滑动
* */
    private void movePositionX(int toPosition) { // TODO Auto-generated method stub
        float curTranslationX = image_line.getTranslationX();
        float toPositionX = moveOne * toPosition;
        ObjectAnimator animator = ObjectAnimator.ofFloat(image_line, "translationX", curTranslationX, toPositionX);
        animator.setDuration(500);
        animator.start();
    }
/*
* 初始化ViewPager
* */
    public void initFrame() {

        FinderActivity mFinder = new FinderActivity();
        MineActivity mMine = new MineActivity();
        ShopActivity mShop = new ShopActivity();

        fragmentList = new ArrayList<>();

        fragmentList.add(mShop);
        fragmentList.add(mFinder);
        fragmentList.add(mMine);

        viewPager = (ViewPager) findViewById(R.id.vPager);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myFragmentAdapter);

        initFrameOnClick();

    }
/*
* 所有的点击事件
* */
    private void initFrameOnClick() {

        final LinearLayout linearLayout_shop = (LinearLayout) findViewById(R.id.linearLayout_shop);
        final LinearLayout linearLayout_sale = (LinearLayout) findViewById(R.id.linearLayout_sale);
        final LinearLayout linearLayout_car = (LinearLayout) findViewById(R.id.linearLayout_car);

        linearLayout_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        linearLayout_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        linearLayout_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        linearLayout_shop.setBackgroundColor(Color.parseColor("#ff0bcdff"));
                        linearLayout_sale.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        linearLayout_car.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        movePositionX(0);
                        break;
                    case 1:
                        linearLayout_shop.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        linearLayout_sale.setBackgroundColor(Color.parseColor("#ff0bcdff"));
                        linearLayout_car.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        movePositionX(1);
                        break;
                    case 2:
                        linearLayout_shop.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        linearLayout_sale.setBackgroundColor(Color.parseColor("#ff00bbff"));
                        linearLayout_car.setBackgroundColor(Color.parseColor("#ff0bcdff"));
                        movePositionX(2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




}
