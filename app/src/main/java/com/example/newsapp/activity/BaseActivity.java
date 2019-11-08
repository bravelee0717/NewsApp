package com.example.newsapp.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by LiYong on 2019-11-07.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(viewById());
        bindView();
        afterView();

    }

    @LayoutRes
    public abstract int viewById();

    @UiThread
    public abstract void afterView();



    public void bindView() {

    }

    @SuppressWarnings("unchecked")
    public final <E extends View> E $(int id) {
        return (E) findViewById(id);
    }

}
