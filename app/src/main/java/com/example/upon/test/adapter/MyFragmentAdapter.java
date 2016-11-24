package com.example.upon.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：Created by UPON
 * 邮箱：upon_88@163.com
 * 时间： 2016/10/26
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm); // TODO Auto-generated constructor stub
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int arg0) { // TODO Auto-generated method stub
        return fragmentList.get(arg0);
    }

    @Override
    public int getCount() { // TODO Auto-generated method stub
        return fragmentList.size();
    }
}

