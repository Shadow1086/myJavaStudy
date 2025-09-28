package Class01.Constructor02;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:35
 * {@code @Version} 1.0
 */

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1 =new TriAngle( 3 , 4);
        System.out.println("t1三角形的面积：" + t1.area());

        TriAngle t2 = new TriAngle();
        t2.setBase(4);
        t2.setHeight(5);
        System.out.println("t2三角形的面积：" + t2.area());
    }
}
