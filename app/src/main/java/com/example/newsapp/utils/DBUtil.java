package com.example.newsapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.newsapp.model.DaoMaster;
import com.example.newsapp.model.DaoSession;
import com.example.newsapp.model.User;
import com.example.newsapp.model.UserDao;

import java.util.List;

/**
 * Created by LiYong on 2019-11-11.
 */
public class DBUtil {
    /**
     * Helper
     */
    private DaoMaster.DevOpenHelper mHelper;//获取Helper对象
    /**
     * DaoMaster
     */
    private DaoMaster mDaoMaster;
    /**
     * DaoSession
     */
    private DaoSession mDaoSession;
    /**
     * 上下文
     */
    private Context context;

    private static DBUtil dbUtil;
    private String DATABASE_NAME;


    public DBUtil(Context context) {
        this.context = context;
        DATABASE_NAME = "NEWS_APP";
        mHelper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
        mDaoMaster = new DaoMaster(getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
        }
        SQLiteDatabase db = mHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     *
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
        }
        SQLiteDatabase db = mHelper.getWritableDatabase();
        return db;
    }

    public static DBUtil getInstance(Context context) {
        if (dbUtil == null) {
            synchronized (DBUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DBUtil(context);
                }
            }
        }
        return dbUtil;
    }

    /**
     * UserDao
     */
    private UserDao getUserDao() {
        return mDaoSession.getUserDao();
    }

    /**
     * 会自动判定是插入还是替换
     *
     * @param user
     */
    public void insertOrReplace(User user) {
        getUserDao().insertOrReplace(user);
    }

    /**
     * 插入一条记录，表里面要没有与之相同的记录
     *
     * @param user
     */
    public long insert(User user) {
        return getUserDao().insert(user);
    }

    /**
     * 按条件查询数据
     */
    public User searchByWhere(String userName) {
        User users = (User) getUserDao().queryBuilder().where(UserDao.Properties.UserName.eq(userName)).build().unique();
        return users;
    }

    /**
     * 查询所有数据
     */
    public List<User> searchAll() {
        List<User> users = getUserDao().queryBuilder().list();
        return users;
    }

    /**
     * 根据用户名
     * 删除数据
     */
    public void delete(String userName) {
        getUserDao().queryBuilder().where(UserDao.Properties.UserName.eq(userName)).buildDelete().executeDeleteWithoutDetachingEntities();
    }


}
