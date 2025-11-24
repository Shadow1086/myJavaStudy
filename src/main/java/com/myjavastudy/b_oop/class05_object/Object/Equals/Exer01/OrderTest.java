package com.myjavastudy.b_oop.class05_object.Object.Equals.Exer01;

/**
 * ClassName: OrderTest
 * Package: Class05.Object.Equals.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 11:33
 * {@code @Version} 1.0
 */

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(1001,"orderAA");
        Order order2 = new Order(1001,"orderAA");
        System.out.println(order1.equals(order2));

        Order order3 = new Order(1001,new String("orderAA"));
        Order order4 = new Order(1001,new String("orderAA"));
        System.out.println(order3.equals(order4));
    }

}
