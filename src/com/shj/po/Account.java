package com.shj.po;

import java.util.Date;

public class Account {
    private int account_id;
    private String  type;
    private float money;
    private Date time;
    private String beizhu;

    private User user;

    public Account() {
    }

    public Account(String type, float money, Date time,String beizhu, User user) {
        this.type = type;
        this.money = money;
        this.time = time;
        this.beizhu=beizhu;
        this.user = user;
    }

    public Account(int account_id, String type, float money, Date time, String beizhu, User user) {
        this.account_id = account_id;
        this.type = type;
        this.money = money;
        this.time = time;
        this.beizhu=beizhu;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", time=" + time +
                ", beizhu='" + beizhu + '\'' +
                ", user=" + user +
                '}';
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
