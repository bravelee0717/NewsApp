package com.example.newsapp.activity;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.newsapp.R;

public class InternetImgActivity extends BaseActivity {


    private ImageView img;

    @Override
    public int viewById() {
        return R.layout.activity_internet_img;
    }

    @Override
    public void bindView() {
        img = $(R.id.my_img);
    }

    @Override
    public void afterView() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.text_zhaoyun)
                .error(R.mipmap.text_zhugeliang);
        Glide.with(this)
                .asBitmap()
                .load("http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg")
                .apply(options)
                .into(img);
    }
}
