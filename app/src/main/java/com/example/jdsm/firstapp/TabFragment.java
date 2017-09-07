package com.example.jdsm.firstapp;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jdsm on 2017/7/27.
 */

public class TabFragment extends BaseFragment {
    public static final int ZHU_YE=0;
    public static final int FU_YE=1;
    private int type;
    @BindView(R.id.tab_layout)
    public TabLayout tab;

    @BindView(R.id.view_pager)
    public ViewPager viewPager;

    public String[] title={"Zhihu","Android"};
    public List<BaseFragment> fragments;
    @Override
    protected void setLayoutId() {
        layoutId=R.layout.tab_main;
    }

    public static TabFragment newInstance(int type){
        TabFragment fragment=new TabFragment();
        Bundle arg=new Bundle();
        arg.putInt("type",type);
        fragment.setArguments(arg);
        return fragment;
    }
    @Override
    protected void initView() {
        fragments=new ArrayList<>();
        type=getArguments().getInt("type");
        if (type==ZHU_YE){

            fragments.add(ZhihuFragment.newInstance());
            fragments.add(AndroidFragment.newInstance());
        }

        viewPager.setAdapter(new PAdapter(getChildFragmentManager()));
        tab.setupWithViewPager(viewPager);
    }
     class PAdapter extends FragmentPagerAdapter{

         public PAdapter(FragmentManager fm) {
             super(fm);
         }

         @Override
         public Fragment getItem(int position) {
             Log.d("MainActivity",""+"b");
             return fragments.get(position);
         }

         @Override
         public int getCount() {
             return fragments.size();
         }

         @Override
         public CharSequence getPageTitle(int position) {
             return title[position];
         }
     }
}
