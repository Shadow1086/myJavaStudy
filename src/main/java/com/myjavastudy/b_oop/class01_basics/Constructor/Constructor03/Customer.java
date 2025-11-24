package com.myjavastudy.b_oop.class01_basics.Constructor.Constructor03;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:初始化Customer
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:59
 * {@code @Version} 1.0
 */

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    //构造器
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
}
