package com.myjavastudy.b_oop.class01_basics.Encapsulation.Encapsulation01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:封装性的案例01
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 13:25
 * {@code @Version} 1.0
 */

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "金蟾";
        //legs声明为private，是私有的，出了Animal类以外就不能再调用了
//        animal.legs =4;
        animal.setlegs(4);
        System.out.println("name = " + animal.name + ",legs = " + animal.getLegs());
    }

}

