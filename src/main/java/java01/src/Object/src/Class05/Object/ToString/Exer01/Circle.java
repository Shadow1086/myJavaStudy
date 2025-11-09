package Class05.Object.ToString.Exer01;

/**
 * ClassName: Circle
 * Package: Class05.Object.ToString.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 17:33
 * {@code @Version} 1.0
 */

public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return 3.14 * radius * radius;
    }
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object instanceof Circle circle){
            return this.radius == circle.radius;
        }
        return  false;
    }
    @Override
    public String toString(){
        return ("Circles [radius = " + radius + "]");
    }
}
