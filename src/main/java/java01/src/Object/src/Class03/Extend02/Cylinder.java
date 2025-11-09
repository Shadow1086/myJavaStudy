package Class03.Extend02;

/**
 * ClassName: Practice01
 * Package: Class03.Extend01.Extend02
 * Description:
 * 圆柱体
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 18:58
 * {@code @Version} 1.0
 */

public class Cylinder extends Circle{
    private double length;

    public Cylinder(double radius,double length){
        super(radius);
        this.length = length;
    }

    public Cylinder() {
        length  = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return super.findArea() * length;
    }
}
