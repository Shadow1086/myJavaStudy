package Class03.Extend02;

/**
 * ClassName: Practice01
 * Package: Class03.Extend01.Extend02
 * Description:
 * 圆
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 18:58
 * {@code @Version} 1.0
 */

public class Circle {
    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }
}

