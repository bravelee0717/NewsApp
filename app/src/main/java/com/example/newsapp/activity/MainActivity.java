package com.example.newsapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.newsapp.R;
import com.example.newsapp.fragment.BaseFragment;
import com.example.newsapp.fragment.HomeFragment;
import com.example.newsapp.fragment.MineFragment;
import com.example.newsapp.fragment.SettingFragment;
import com.example.newsapp.widget.CheckedTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private List<BaseFragment> mFragmentLists = new ArrayList<>();
    private LinearLayout home_ly;
    private LinearLayout setting_ly;
    private LinearLayout mine_ly;
    private int lastPosition = 0;

    private ImageView home_iv;
    private ImageView setting_iv;
    private ImageView mine_iv;
    private CheckedTextView home_ctv;
    private CheckedTextView setting_ctv;
    private CheckedTextView mine_ctv;


    @Override
    public int viewById() {
        return R.layout.activity_main;
    }

    @Override
    public void afterView() {
        initFragments();
        home_iv.setBackgroundResource(R.mipmap.home_index_checked);
        home_ctv.setTextColor(getResources().getColor(R.color._ff3b30));
        switchFragment(null, mFragmentLists.get(lastPosition));
    }

    @Override
    public void bindView() {
        home_ly = $(R.id.home_ly);
        setting_ly = $(R.id.setting_ly);
        mine_ly = $(R.id.mine_ly);

        home_iv = $(R.id.home_iv);
        setting_iv = $(R.id.setting_iv);
        mine_iv = $(R.id.mine_iv);
        home_ctv = $(R.id.home_ctv);
        setting_ctv = $(R.id.setting_ctv);
        mine_ctv = $(R.id.mine_ctv);

        home_ly.setOnClickListener(this);
        setting_ly.setOnClickListener(this);
        mine_ly.setOnClickListener(this);
    }

    private void initFragments() {
        mFragmentLists.add(HomeFragment.getInstance());
        mFragmentLists.add(SettingFragment.getInstance());
        mFragmentLists.add(MineFragment.getInstance());
    }

    public void switchFragment(Fragment from, Fragment to) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (from == null) {
            if (to != null) {
                transaction.replace(R.id.content, to).commit();
            }
        } else {
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.content, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }

        }

    }

    private void clearStyle() {
        home_iv.setBackgroundResource(R.mipmap.home_index);
        setting_iv.setBackgroundResource(R.mipmap.home_student);
        mine_iv.setBackgroundResource(R.mipmap.home_mine);
        home_ctv.setTextColor(getResources().getColor(R.color._444444));
        setting_ctv.setTextColor(getResources().getColor(R.color._444444));
        mine_ctv.setTextColor(getResources().getColor(R.color._444444));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.home_ly) {
            if (lastPosition == 0) {
                return;
            }
            clearStyle();
            home_iv.setBackgroundResource(R.mipmap.home_index_checked);
            home_ctv.setTextColor(getResources().getColor(R.color._ff3b30));
            switchFragment(mFragmentLists.get(lastPosition), mFragmentLists.get(0));
            lastPosition = 0;
        } else if (id == R.id.setting_ly) {
            if (lastPosition == 1) {
                return;
            }
            clearStyle();
            setting_iv.setBackgroundResource(R.mipmap.home_student_checked);
            setting_ctv.setTextColor(getResources().getColor(R.color._ff3b30));
            switchFragment(mFragmentLists.get(lastPosition), mFragmentLists.get(1));
            lastPosition = 1;
        } else if (id == R.id.mine_ly) {
            if (lastPosition == 2) {
                return;
            }
            clearStyle();
            mine_iv.setBackgroundResource(R.mipmap.home_mine_checked);
            mine_ctv.setTextColor(getResources().getColor(R.color._ff3b30));
            switchFragment(mFragmentLists.get(lastPosition), mFragmentLists.get(2));
            lastPosition = 2;
        }
    }
}
