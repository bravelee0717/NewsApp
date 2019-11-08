package com.example.newsapp.model;

/**
 * Created by LiYong on 2019-11-07.
 */
public class NewsModel {
    private String title;
    private int resId;
    private String time;

    public String getTitle() {
        return title;
    }

    public NewsModel(String title, int resId, String time) {
        this.title = title;
        this.resId = resId;
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
