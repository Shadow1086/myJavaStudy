package com.myjavastudy.interview.oop;

/**
 * ClassName: Practice01
 * Package: Class03.interview01
 * Description:
 *
 * 面试题，关于构造函数的调用。
 *
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 23:00
 * {@code @Version} 1.0
 */

public class Interview01 {
    public static void main(String[] args) {
        new A(new B());
    }
}

class A {
    public A() {
        System.out.println("A");
    }

    public A(B b) {
        this();
        System.out.println("AB");
    }
}

//class B {
//    public B() {
//        System.out.println("B");
//    }
//}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

