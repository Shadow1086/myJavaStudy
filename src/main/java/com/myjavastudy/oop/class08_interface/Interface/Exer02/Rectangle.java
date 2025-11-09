package com.myjavastudy.oop.class08_interface.Interface.Exer02;

/**
 * ClassName: Rectangle
 * Package: Class08.Interface.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:13
 * {@code @Version} 1.0
 */

public class Rectangle {
    private double length;
    private double weight;

    public Rectangle() {
    }

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
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

    public double findArea(){
        return length * weight;
    }
}
