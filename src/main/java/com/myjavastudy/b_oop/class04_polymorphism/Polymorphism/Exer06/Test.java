package com.myjavastudy.b_oop.class04_polymorphism.Polymorphism.Exer06;

/**
 * ClassName: Test
 * Package: Class04.Exer06
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 10:07
 * {@code @Version} 1.0
 */

public class Test {
    public static void main(String[] args) {
        PersonTest test =  new PersonTest();
        Person p1 = new Woman();
        Person p2 = new Man();
        test.meeting(p1,p2);
    }
    
}
