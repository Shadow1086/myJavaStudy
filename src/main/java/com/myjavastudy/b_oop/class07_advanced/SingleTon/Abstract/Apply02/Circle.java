package com.myjavastudy.b_oop.class07_advanced.SingleTon.Abstract.Apply02;


/**
 * ClassName: Test
 * Package: Class07.SingleTon.Abstract.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/10 21:28
 * {@code @Version} 1.0
 */
public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return 3.14 * Math.pow(radius, 2);
    }

    @Override
    public double circumference() {
        return 2 * 3.14 * radius;
    }

    @Override
    public void showInfo() {
        System.out.printf("圆的周长为：%.2f,面积为：%.2f %n", circumference(), findArea());
    }
}
