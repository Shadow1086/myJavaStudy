package com.myjavastudy.project.customer;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 *
 * 客户类
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/1 22:05
 * {@code @Version} 1.0
 */

public class Customer {
//属性：
    private String name;
    private int age;
    private char sex;
    private String phone;
    private String email;

    //构造器
    public Customer() {
    }

    public Customer(String name, int age, char sex, long tele, String phone, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //初始化赋值
    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(char sex) {
        if (sex == '男' || sex == '女') {
            this.sex = sex;
        } else {
            System.out.println("输入的性别有误");
        }

    }
}
