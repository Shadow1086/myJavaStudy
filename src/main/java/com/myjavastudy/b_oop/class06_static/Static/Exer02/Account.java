package com.myjavastudy.b_oop.class06_static.Static.Exer02;

/**
 * ClassName: Account
 * Package: Class06.Static.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/8 20:24
 * {@code @Version} 1.0
 */

public class Account {
    private static double rate;
    private static double minBalance = 1.0;
    private static int init = 1001;
    private int id;
    private String password;
    private double balance;

    public Account() {
        this.id = init;
        init ++;
        password = "000000";
    }

    public Account(String password, double balance) {
        this.password = password;
        this.balance = balance;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        Account.rate = rate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        Account.minBalance = minBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return("Account{id : " + id + "\tbalance : " + balance + "\tpassword : " + password + "}");
    }


}
