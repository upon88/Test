package com.example.upon.test.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * 作者：Created by UPON
 * 邮箱：upon_88@163.com
 * 时间： 2016/10/26
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> pagelist;


    public MyViewPagerAdapter(List<View> pagelist) {
        this.pagelist = pagelist;
    }

    @Override
    public int getCount() {
        return pagelist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pagelist.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(pagelist.get(position));

        return pagelist.get(position);

    }


}
