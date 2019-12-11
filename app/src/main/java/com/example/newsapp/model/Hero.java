package com.example.newsapp.model;

/**
 * Created by LiYong on 2019-12-11.
 */
public class Hero {
    private String name;
    private int res_id;

    public Hero(String name, int res_id) {
        this.name = name;
        this.res_id = res_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
}
