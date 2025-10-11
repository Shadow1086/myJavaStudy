package Class08.Interface.Exer02;

/**
 * ClassName: InterfaceTest
 * Package: Class08.Interface.Exer02
 * Description:定义一个接口用来实现两个对象的比较。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 15:48
 * {@code @Version} 1.0
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle comparableCircle = new ComparableCircle();
        ComparableCircle comparableCircle1 = new ComparableCircle();
        comparableCircle1.setRadius(1.5);
        comparableCircle.setRadius(1.6);
        System.out.println(comparableCircle1.compareTo(comparableCircle));

        CompareRectangle compareRectangle = new CompareRectangle(1.2,2.3);
        CompareRectangle compareRectangle1 = new CompareRectangle(1.5,2.6);
        System.out.println(compareRectangle1.compareTo(compareRectangle));
    }
}
