package com.myjavastudy.b_oop.class05_object.Object.Equals.Apply;

import java.util.Objects;

/**
 * ClassName: Customer
 * Package: Class05.Object.Equals.Apply
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 11:22
 * {@code @Version} 1.0
 */

public class Customer {
    private String name;
    private int age;
    private Account acct;

    public Customer() {
    }

    public Customer(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAcct() {
        return acct;
    }

    public void setAcct(Account acct) {
        this.acct = acct;
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer customer)) return false;
        return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(acct, customer.acct);
    }


}
