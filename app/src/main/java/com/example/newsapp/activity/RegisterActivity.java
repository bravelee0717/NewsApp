package com.example.newsapp.activity;


import android.view.View;

import com.example.newsapp.R;
import com.example.newsapp.widget.IconTextView;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private IconTextView back;
    private IconTextView right;
    private IconTextView title;

    @Override
    public int viewById() {
        return R.layout.activity_register;
    }

    @Override
    public void bindView() {
        back = $(R.id.top_back);
        right = $(R.id.top_right);
        title = $(R.id.top_title);

        back.setOnClickListener(this);
        right.setOnClickListener(this);
    }

    @Override
    public void afterView() {
        title.setText("注册页面");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.top_back) {
            onBackPressed();
        } else if (id == R.id.top_right) {

        }
    }


}
