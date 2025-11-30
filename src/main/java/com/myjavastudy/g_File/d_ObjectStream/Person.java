package com.myjavastudy.g_File.d_ObjectStream;

import java.io.Serializable;

/**
 * ClassName: b_Person
 * Description:
 * 
 * 探讨自定义类要实现序列化的要求
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-30 14:25:39
 */
public class Person implements Serializable {
    transient String name;
    int age;
    int id;
    Account account;

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    @SuppressWarnings("unused")
    private static final long serialVersoinUID = 12412123L;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", id=" + id + ", account=" + account + "]";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static long getSerialversoinuid() {
        return serialVersoinUID;
    }

}

class Account implements Serializable {
    double balance;
    private static final long serialVersionUID = 3267849893847L;
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

}
