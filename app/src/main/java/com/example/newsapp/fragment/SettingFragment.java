package com.example.newsapp.fragment;


import com.example.newsapp.R;

/**
 * 设置
 */
public class SettingFragment extends BaseFragment {


    public static SettingFragment getInstance(){
        return new SettingFragment();
    }

    @Override
    public int viewById() {
        return R.layout.fragment_setting;
    }

    @Override
    public void afterView() {

    }


}
