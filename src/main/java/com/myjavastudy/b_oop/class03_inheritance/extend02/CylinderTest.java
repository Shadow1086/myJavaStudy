package com.myjavastudy.b_oop.class03_inheritance.extend02;

/**
 * ClassName: Practice01
 * Package: Class03.Extend01.Extend02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 21:45
 * {@code @Version} 1.0
 */

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(2,3);
        System.out.println("体积："+cylinder.findVolume());
    }

}
