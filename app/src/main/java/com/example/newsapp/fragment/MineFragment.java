package com.example.newsapp.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.newsapp.R;
import com.example.newsapp.activity.RegisterAndLoginActivity;
import com.example.newsapp.utils.SharePreferenceUtil;

/**
 * 我的
 */
public class MineFragment extends BaseFragment {

    private Button exit_bt;

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public int viewById() {
        return R.layout.fragment_mine;
    }

    @Override
    public void bindView(View rootView) {
        exit_bt = $(rootView, R.id.exit_login);
    }

    @Override
    public void afterView() {
        exit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePreferenceUtil.getInstance(getActivity()).clear();
                Intent intent = new Intent(getActivity(), RegisterAndLoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

}
