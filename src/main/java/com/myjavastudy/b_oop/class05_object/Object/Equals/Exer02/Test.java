package com.myjavastudy.b_oop.class05_object.Object.Equals.Exer02;

/**
 * ClassName: Test
 * Package: Class05.Object.Equals.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 12:23
 * {@code @Version} 1.0
 */

public class Test {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(1000,12,1);
        MyDate m2 = new MyDate(1000,12,1);
        System.out.println(m1.equals(m2));
    }

}
