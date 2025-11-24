package com.myjavastudy.b_oop.class02_this.This02;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * 客户类
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 13:17
 * {@code @Version} 1.0
 */

public class Customer {
    private String firstName;   //名
    private String lastName;    //姓
    private Account account;
//构造器；

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //set  and  get

    public String getFirstName() {
        return firstName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getLastName() {
        return lastName;
    }

}
