package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer03;

/**
 * ClassName: Practice01
 * Package: Class04.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:16
 * {@code @Version} 1.0
 */

public class Circle extends GeometricObject {

    private double radius;


    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * 对Area方法的重写，以便进行对象的多态化
     *
     * @return 圆的面积
     */
    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}
