package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer01;

/**
 * ClassName: Practice01
 * Package: Class04.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 20:19
 * {@code @Version} 1.0
 */

public class Man extends Person{
    boolean isSmoking;

    int id = 1002;

    public void eat(){
        System.out.println("男人多吃肉，长肌肉");
    }

    public void walk(){
        System.out.println("男人笔挺的走路");
    }

    public void earnMoney(){
        System.out.println("男人挣钱养家");
    }


}
