package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer06;

/**
 * ClassName: Woman
 * Package: Class04.Exer06
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 10:03
 * {@code @Version} 1.0
 */

public class Woman extends Person{
    public void eat(){
        System.out.println("女人小口的吃饭");
    }

    public void toilet(){
        System.out.println("女人去女厕所");
    }

    public void makeup(){
        System.out.println("厕后补补妆");
    }
    
}
