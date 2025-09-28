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
    private int base;
    //高
    private int height;

//默认构造函数
    public TriAngle() {
    }

    public TriAngle(int base, int height) {
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

    public void setBase(int base) {
        if (base > 0) {
            this.base = base;
        } else {
            System.out.println("输入base有误");
        }
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("输入height有误");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getBase() {
        return base;
    }

    public double area() {
        double result = (double)(base * height) / 2;
        return result;
    }

}
