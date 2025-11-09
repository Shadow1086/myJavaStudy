package com.myjavastudy.oop.class05_object.Object.Equals.Apply;

/**
 * ClassName: Account
 * Package: Class05.Object.Equals.Apply
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 11:22
 * {@code @Version} 1.0
 */

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Account account)) return false;
        return Double.compare(balance, account.balance) == 0;
    }

}
