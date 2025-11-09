package com.myjavastudy.oop.class03_inheritance.super02;

/**
  * ClassName: Account
 * Package: Class03.Super02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 21:55
 * {@code @Version} 1.0
 */

public class Account {

    private int id;
    protected double balance;
    private double annualInterestRate;

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //返回月利率
    public double getMonthlyInterest(){
                return balance * annualInterestRate / 12;
    }
    //取款
    public void withdraw(double amount){
        if(amount<=balance&&amount>0){
            balance -= amount;
            System.out.println("success : " + amount);
        }else{
            System.out.println("fail");
        }
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("success : add" + amount);
        }else{
            System.out.println("fail");
        }
    }
}
