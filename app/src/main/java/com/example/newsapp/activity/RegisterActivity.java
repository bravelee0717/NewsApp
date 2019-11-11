package com.example.newsapp.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.model.User;
import com.example.newsapp.utils.DBUtil;
import com.example.newsapp.widget.IconTextView;

import java.util.List;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private IconTextView back;
    private IconTextView right;
    private IconTextView title;
    private EditText username_et;
    private EditText password_et;
    private EditText reptpassword_et;

    @Override
    public int viewById() {
        return R.layout.activity_register;
    }

    @Override
    public void bindView() {
        back = $(R.id.top_back);
        right = $(R.id.top_right);
        title = $(R.id.top_title);
        username_et = $(R.id.username);
        password_et = $(R.id.password);
        reptpassword_et = $(R.id.repeat_password);

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
            String username = username_et.getText().toString();
            String password = password_et.getText().toString();
            String reptpassword = reptpassword_et.getText().toString();
            if (!password.equals(reptpassword)) {
                Toast.makeText(this, "两次输入密码不一致,请重新输入", Toast.LENGTH_SHORT).show();
                return;
            }
            User user = new User();
            user.setUserName(username.trim());
            user.setPassword(password.trim());
            User userdb = DBUtil.getInstance(this).searchByWhere(username.trim());
            if (userdb != null) {
                Toast.makeText(this, "用户名已被注册", Toast.LENGTH_SHORT).show();
                return;
            }
            DBUtil.getInstance(this).insert(user);
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();

        }
    }


}
