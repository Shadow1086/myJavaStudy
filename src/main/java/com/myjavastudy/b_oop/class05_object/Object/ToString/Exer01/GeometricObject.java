package com.myjavastudy.b_oop.class05_object.Object.ToString.Exer01;

/**
 * ClassName: GeometricObject
 * Package: Class05.Object.ToString.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 17:33
 * {@code @Version} 1.0
 */

public class GeometricObject {
    protected String color;
    protected double weight;

    public GeometricObject() {
        this.color = "White";
        this.weight = 1.0;
    }

    public GeometricObject(String color, double weight) {
        this.color = "White";
        this.weight = 1.0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
