package com.myjavastudy.b_oop.class05_object.Object.ToString.Exer01;

/**
 * ClassName: Test
 * Package: Class05.Object.ToString.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 17:41
 * {@code @Version} 1.0
 */

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.3);
        Circle c2 = new Circle(2.3);

        System.out.println(c1.equals(c2));
        System.out.println(c1.toString());


    }

}
