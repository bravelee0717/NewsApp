package com.example.newsapp.fragment;


import com.example.newsapp.R;

/**
 *  我的
 */
public class MineFragment extends BaseFragment {

    public static MineFragment getInstance(){
        return new MineFragment();
    }
    @Override
    public int viewById() {
        return R.layout.fragment_mine;
    }

    @Override
    public void afterView() {

    }

}
