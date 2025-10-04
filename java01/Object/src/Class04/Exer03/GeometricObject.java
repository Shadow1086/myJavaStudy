package Class04.Exer03;

/**
 * ClassName: Practice01
 * Package: Class04.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:15
 * {@code @Version} 1.0
 */

public class GeometricObject {
    protected String color;

    //权重，不是重量
    protected double weight;

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
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

    public double area(){
        return (Double)null;
    }

}
