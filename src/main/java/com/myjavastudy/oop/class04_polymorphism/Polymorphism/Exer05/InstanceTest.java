package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer05;

/**
 * ClassName: InstanceTest
 * Package: Class04.Exer05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 09:54
 * {@code @Version} 1.0
 */

public class InstanceTest {
    public void method(Person p) {
        System.out.println(p.getInfo());
        if (p instanceof Graduate) {
            System.out.println("a Graduate student");
        }
        if (p instanceof Student) {
            System.out.println("a student");
        }

        if (p instanceof Person) {
            System.out.println("a person");
        }


    }
}


