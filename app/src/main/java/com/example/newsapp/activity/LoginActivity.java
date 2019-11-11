package com.example.newsapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.model.User;
import com.example.newsapp.utils.DBUtil;

import java.util.List;

public class LoginActivity extends BaseActivity {

    private Button login_bt;
    private EditText username_et;
    private EditText password_et;

    @Override
    public void bindView() {
        login_bt = $(R.id.login);
        username_et = $(R.id.username);
        password_et = $(R.id.password);
    }

    @Override
    public int viewById() {
        return R.layout.activity_login;
    }

    @Override
    public void afterView() {
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = DBUtil.getInstance(LoginActivity.this).searchByWhere(username_et.getText().toString().trim());
                if (user != null) {
                    if (user.getPassword().equals(password_et.getText().toString().trim())) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "用户名错误", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
