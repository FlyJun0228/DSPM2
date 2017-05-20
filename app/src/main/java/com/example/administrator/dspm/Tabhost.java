package com.example.administrator.dspm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.dspm.Adapter.MyAdapter;
import com.example.administrator.dspm.Adapter.MyPageChangerListener;
import com.example.administrator.dspm.Fragment.Daily;
import com.example.administrator.dspm.Fragment.More;
import com.example.administrator.dspm.Fragment.Plan;
import com.example.administrator.dspm.Fragment.Sport;

import java.util.ArrayList;
import java.util.List;

public class Tabhost extends AppCompatActivity {
    private FragmentTabHost fragmentTabHost;
    private View view = null;
    private LayoutInflater layoutInflater;
    private List<Tab> list = new ArrayList<Tab>(4);
    private ViewPager viewPager;
    private List<Fragment> FragmentList = new ArrayList<Fragment>(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        layoutInflater = LayoutInflater.from(this);
        initTab();
    }
    private void initTab(){
        fragmentTabHost = (FragmentTabHost)findViewById(R.id.id_tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.id_viewpager);
        Tab tabplan = new Tab(R.string.plan,R.drawable.planchange,Plan.class);
        Tab tabdayily = new Tab(R.string.daily,R.drawable.dailychange,Daily.class);
        Tab tabsport = new Tab(R.string.Sport,R.drawable.sportchange,Sport.class);
        Tab tabmore = new Tab(R.string.More,R.drawable.morechange, More.class);
        list.add(tabdayily);
        list.add(tabsport);
        list.add(tabplan);
        list.add(tabmore);
        for (Tab tab : list){
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(getString(tab.getTitle()))
                    .setIndicator(getItemview(tab));
            fragmentTabHost.addTab(spec,tab.getFragment(),null);
        }
        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        initFragment();
    }
   public void initFragment(){
       FragmentList.add(new Daily());
       FragmentList.add(new Sport());
       FragmentList.add(new Plan());
       FragmentList.add(new More());
       viewPager = (ViewPager)findViewById(R.id.id_viewpager);
       viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),FragmentList));
       viewPager.addOnPageChangeListener(new MyPageChangerListener(fragmentTabHost));
       fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
           @Override
           public void onTabChanged(String s) {
               int p = fragmentTabHost.getCurrentTab();
               viewPager.setCurrentItem(p);
           }
       });
   }
    private View getItemview(Tab tab){
        view = layoutInflater.inflate(R.layout.item_view,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.id_imageview);
        TextView textView = (TextView)view.findViewById(R.id.id_textview);
        imageView.setImageResource(tab.getImg());
        textView.setText(tab.getTitle());
        return view;
    }
}
