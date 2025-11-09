package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer01;

/**
 * ClassName: Practice01
 * Package: Class04.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 20:20
 * {@code @Version} 1.0
 */

public class Women extends Person{
    boolean isBeauty;

    public void eat(){
        System.out.println("女人应该少吃，减肥");
    }

    public void walk(){
        System.out.println("女人窈窕的走路");
    }

    public void goShopping(){
        System.out.println("女人喜欢逛街...");
    }
    
}
