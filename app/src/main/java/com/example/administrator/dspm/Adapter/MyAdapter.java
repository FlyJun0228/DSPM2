package com.example.administrator.dspm.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/16.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment> views;
    public MyAdapter(FragmentManager fragmentManager, List<Fragment> list){
        super(fragmentManager);
        this.views = list;
    }
    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }
}
