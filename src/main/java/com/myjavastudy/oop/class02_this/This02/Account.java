package com.myjavastudy.oop.class02_this.This02;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 13:11
 * {@code @Version} 1.0
 */

public class Account {
    private double balance;//余额

    public Account() {
    }

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    //存钱
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("存钱成功，存入" + amt + "元");
        } else {
            System.out.println("存钱失败");
        }
    }

    //取钱
    public void withdraw(double num) {
        if (num > 0) {
            if (balance >= num) {
                balance -= num;
                System.out.println("取出" + num + "元成功，余额：" + this.balance);
            }else{
                System.out.println("余额不足");
            }
        } else {
            System.out.println("输入有误");
        }
    }
}
