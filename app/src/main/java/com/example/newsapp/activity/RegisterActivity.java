package com.example.newsapp.activity;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.newsapp.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView login_tv;

    private TextView register_tv;

    @Override
    public int viewById() {
        return R.layout.activity_register;
    }

    @Override
    public void bindView() {
        login_tv = $(R.id.login_tv);
        register_tv = $(R.id.register_tv);

        login_tv.setOnClickListener(this);
        register_tv.setOnClickListener(this);
    }

    @Override
    public void afterView() {


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_tv) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.register_tv) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
