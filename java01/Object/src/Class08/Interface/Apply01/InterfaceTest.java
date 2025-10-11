package Class08.Interface.Apply01;

/**
 * ClassName: InterfaceTest
 * Package: Class08.Interface.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:02
 * {@code @Version} 1.0
 */

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane plane1 = new Plane();
        plane1.fly();
        plane1.attack();

        //接口多态性，只可以调用Flyable中的方法。
        Flyable f1 = new Plane();
        f1.fly();

    }
}


