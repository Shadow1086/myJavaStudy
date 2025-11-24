package com.myjavastudy.b_oop.class07_advanced.SingleTon.Abstract.Apply01;


/**
 * ClassName: Person
 * Package: Class07.SingleTon.Abstract.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/10 21:28
 * {@code @Version} 1.0
 */
public abstract class Person {
    String name;
    int age;

    public Person(){};

    public Person(String name ,int age){
        this.name  = name;
        this.age = age;
    }

    //两个抽象方法
    public abstract void eat();

    public abstract void sleep();
}
