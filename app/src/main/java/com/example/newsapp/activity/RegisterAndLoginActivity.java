package com.example.newsapp.activity;


import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newsapp.R;

public class RegisterAndLoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView login_tv;

    private TextView register_tv;


    @Override
    public int viewById() {
        return R.layout.activity_register_login;
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
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.register_tv) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}
