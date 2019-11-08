package com.example.newsapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by LiYong on 2019-11-08.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
    }
}
