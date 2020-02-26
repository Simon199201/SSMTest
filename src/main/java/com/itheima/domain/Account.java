package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    //账号
    private String name;
    //余额
    private double sum;
    //用户id
    private int uid;

    public int getId() {
        return id;
    }

    private User user;
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                ", uid=" + uid +
                ", user=" + user.toString() +
                '}';
    }
}
