package com.example.newsapp.utils;

import android.content.Context;
import android.content.SharedPreferences;


import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by LiYong on 2019-11-04.
 */
public class SharePreferenceUtil {

    public static SharePreferenceUtil instance = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String spname = "User_Info";

    //双重检查锁定,保证不会被多次创建
    public static SharePreferenceUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (SharePreferenceUtil.class) {
                if (instance == null) {
                    instance = new SharePreferenceUtil(context);
                }
            }
        }
        return instance;
    }

    public SharePreferenceUtil(Context context) {
        //传入getApplicationContext()不要传入activity防止内存泄漏
        sharedPreferences = context.getSharedPreferences(spname, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void saveInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void saveBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void saveFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0.0f);
    }

    public void saveLong(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }
    //存储对象
    public void saveObject(String key, Object object) {

        try {
            //对象输出流转换为字节流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            //字节流通过base64加密成密文字符串
            String value = new String(Base64.encodeBase64(baos.toByteArray()));
            editor.putString(key, value);
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getObject(String key) {

        try {
            //base64解码
            String value = sharedPreferences.getString(key, "");
            byte[] base64Bytes = Base64.decodeBase64(value.getBytes());
            ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
            ObjectInputStream oos = new ObjectInputStream(bais);
            return (Object)oos.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
