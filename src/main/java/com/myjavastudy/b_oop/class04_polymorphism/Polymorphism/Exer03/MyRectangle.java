package com.myjavastudy.b_oop.class04_polymorphism.Polymorphism.Exer03;

/**
 * ClassName: Practice01
 * Package: Class04.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:16
 * {@code @Version} 1.0
 */

public class MyRectangle extends GeometricObject{
    private double length;
    private  double weight;

    public MyRectangle(String color, double weight, double length, double weight1) {
        super(color, weight);
        this.length = length;
        this.weight = weight1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public double area(){
        return length * weight;
    }
}
