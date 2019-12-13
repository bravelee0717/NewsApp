package com.example.newsapp.activity;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.newsapp.R;

public class InternetImgActivity extends BaseActivity {


    private ImageView img;
    private int position;

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
        position = getIntent().getIntExtra("position", 0);
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.text_zhaoyun)
                .error(R.mipmap.text_zhugeliang);
        if (position == 0) {
            Glide.with(this)
                    .asGif()
                    .load(R.mipmap.gif1)
                    .apply(options)
                    .into(img);
        } else if (position == 1) {
            Glide.with(this)
                    .asGif()
                    .load(R.mipmap.gif2)
                    .apply(options)
                    .into(img);
        } else if (position == 2) {
            Glide.with(this)
                    .load(R.mipmap.huizhang)
                    .apply(options)
                    .into(img);
        } else if (position == 3) {
            Glide.with(this)
                    .load(R.mipmap.meizi)
                    .apply(options)
                    .into(img);
        } else {
            //加载网络图片
            Glide.with(this)
                    .asBitmap()
                    .load("http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg")
                    .apply(options)
                    .into(img);
        }
    }
}
