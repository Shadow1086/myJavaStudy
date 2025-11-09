package com.myjavastudy.oop.class07_advanced.SingleTon.Abstract.Apply02;

/**
 * ClassName: Rectangle
 * Package: Class07.SingleTon.Abstract.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 10:02
 * {@code @Version} 1.0
 */

public class Rectangle extends GeometricObject {
    private double length;
    private double weight;

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
    }

    @Override
    public double findArea() {
        return length * weight;
    }

    @Override
    public double circumference() {
        return 2 * (length + weight);
    }

    @Override
    public void showInfo() {
        System.out.printf("长方形的周长为：%.2f,面积为：%.2f %n", circumference(), findArea());
    }
}
