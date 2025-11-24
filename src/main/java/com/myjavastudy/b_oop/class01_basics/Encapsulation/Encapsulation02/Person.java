package com.myjavastudy.b_oop.class01_basics.Encapsulation.Encapsulation02;

class Person {
    //属性
    private int age;
    String name;
    //方法

    //构造器：可以重载。
    public Person(int a,String name){
        age = a;
        this.name = name;
    }
    public Person(int a){
        age = a;
    }
    public Person(String name){
        this.name = name;
    }

    //设置
    public void setAge(int num) {
        if (num > 0 && num < 120) {
            age = num;
        } else {
            System.out.println("输入数据有误");
        }
    }

    //读取
    public int getAge() {
        return age;
    }
}