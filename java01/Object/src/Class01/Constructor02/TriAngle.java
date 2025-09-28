package Class01.Constructor02;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:29
 * {@code @Version} 1.0
 */

public class TriAngle {
    //底边长
    private double base;
    //高
    private double height;

//默认构造函数
    public TriAngle() {
    }

    public TriAngle(double base, double height) {
        if (base > 0) {
            this.base = base;
        } else {
            System.out.println("输入base有误");
        }
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("输入height有误");
        }
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else {
            System.out.println("输入base有误");
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("输入height有误");
        }
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public double area() {
        return (base * height) / 2;
    }

}
