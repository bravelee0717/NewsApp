package com.example.newsapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LiYong on 2019-11-26.
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id ;

    private String name;
    private int sex;
    private int age;
    private int class_id;
    private int grade_id;
    @Generated(hash = 1044416059)
    public Student(Long id, String name, int sex, int age, int class_id,
            int grade_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.class_id = class_id;
        this.grade_id = grade_id;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getClass_id() {
        return this.class_id;
    }
    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
    public int getGrade_id() {
        return this.grade_id;
    }
    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }
}
