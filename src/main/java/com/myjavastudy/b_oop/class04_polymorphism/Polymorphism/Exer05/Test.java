package com.myjavastudy.b_oop.class04_polymorphism.Polymorphism.Exer05;

/**
 * ClassName: Test
 * Package: Class04.Exer05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 09:56
 * {@code @Version} 1.0
 */

public class Test {
    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        Person p1 = new Person();
        Person p2 = new Student();
        Person p3 = new Graduate();
        System.out.println("p1:");
        test.method(p1);
        System.out.println("p2:");
        test.method(p2);
        System.out.println("p3:");
        test.method(p3);
    }

}
