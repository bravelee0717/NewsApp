package com.example.newsapp.fragment;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.newsapp.R;
import com.example.newsapp.widget.searchview.ICallBack;
import com.example.newsapp.widget.searchview.SearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {


    TabLayout tabLayout;
    ViewPager viewPager;
    //初始化搜索框变量
    SearchView searchView;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();


    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public void bindView(View rootView) {
        tabLayout = $(rootView, R.id.my_tablayout);
        viewPager = $(rootView, R.id.my_viewpager);
        searchView = $(rootView, R.id.search_view);
    }

    @Override
    public int viewById() {
        return R.layout.fragment_home;
    }

    @Override
    public void afterView() {
        // 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

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
