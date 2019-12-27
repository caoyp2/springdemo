package com.ittest.springdemo.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int gender;

    public User(){

    }
    public User(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
