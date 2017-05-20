package com.example.administrator.dspm.Adapter;

import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;

/**
 * Created by Administrator on 2017/4/16.
 */

public class MyPageChangerListener implements ViewPager.OnPageChangeListener {
    private FragmentTabHost fragmentTabHost;

    public MyPageChangerListener(FragmentTabHost fragmentTabHost){
        this.fragmentTabHost = fragmentTabHost;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        fragmentTabHost.setCurrentTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
