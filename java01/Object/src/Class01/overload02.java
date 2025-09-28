package Class01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:max()重载求最大值
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
/*
* 定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方法求两个double值中的
最大值，第三个方法求三个double值中的最大值，并分别调用三个方法。
 */
public class overload02 {
    static int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    static double max(double num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    static double max(double num1, double num2, double num3) {
        double max = num1;
        if (num2 > max) max = num2;
        if (num3 > max) max = num3;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(1,2));
        System.out.println(max(5.0,2.0));
        System.out.println(max(1.0,5.0,3.0));
    }


}
