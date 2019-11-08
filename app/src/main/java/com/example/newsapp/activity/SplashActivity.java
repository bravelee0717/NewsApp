package com.example.newsapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.utils.SharePreferenceUtil;
import com.example.newsapp.utils.StringUtil;

public class SplashActivity extends AppCompatActivity {

    private TextView tvSkipAd;
    private Handler handler;
    private boolean stopThread = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvSkipAd = findViewById(R.id.tvSkipAd);
        initHandler();
        initTimeCount();
        tvSkipAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread = true;
                start();
            }
        });

    }


    @SuppressLint("HandlerLeak")
    private void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        tvSkipAd.setText("跳过(2)");
                        break;
                    case 1:
                        tvSkipAd.setText("跳过(1)");
                        break;
                    case 2:
                        tvSkipAd.setText("跳过(0)");
                        if (stopThread) {
                            return;
                        } else {
                            start();
                        }
                        break;
                }
            }
        };
    }

    private void start() {
        boolean is_login = SharePreferenceUtil.getInstance(this.getApplicationContext()).getBoolean(StringUtil.IS_LOGIN);
        if (is_login) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(SplashActivity.this, RegisterAndLoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initTimeCount() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 3; i++) {
                    Message message = new Message();
                    try {
                        Thread.sleep(1000);
                        message.what = i;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
