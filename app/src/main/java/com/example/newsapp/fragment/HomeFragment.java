package com.example.newsapp.fragment;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {


    TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();


    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public void bindView(View rootView) {
        tabLayout = $(rootView, R.id.my_tablayout);
        viewPager = $(rootView, R.id.my_viewpager);
    }

    @Override
    public int viewById() {
        return R.layout.fragment_home;
    }

    @Override
    public void afterView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        getFragments();
        getTitles();
        viewPager.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
    }

    private void getTitles() {
        titles.add("科技");
        titles.add("娱乐");
        titles.add("体育");
        titles.add("军事");
        titles.add("教育");
    }
    private void getFragments() {
        fragments.add(NewsDetailFragment.newInstance(0));
        fragments.add(NewsDetailFragment.newInstance(1));
        fragments.add(NewsDetailFragment.newInstance(2));
        fragments.add(NewsDetailFragment.newInstance(3));
        fragments.add(NewsDetailFragment.newInstance(4));
    }
}
