package com.example.newsapp.utils;

/**
 * Created by LiYong on 2019-11-13.
 */
public class UserInfo {
    private static UserInfo mUserInfo;
    private String username;
    private String password;


    public static UserInfo getInstance() {
        if (mUserInfo == null) {
            synchronized (UserInfo.class) {
                if (mUserInfo == null) {
                    mUserInfo = new UserInfo();
                }
            }
        }
        return mUserInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
