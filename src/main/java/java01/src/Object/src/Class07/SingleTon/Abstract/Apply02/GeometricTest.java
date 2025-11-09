package Class07.SingleTon.Abstract.Apply02;

/**
 * ClassName: Test
 * Package: Class07.SingleTon.Abstract.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 10:10
 * {@code @Version} 1.0
 */

public class GeometricTest {
    public static void main(String[] args) {
        Circle circle = new Circle(1.3);
        circle.showInfo();

        Rectangle rectangle = new Rectangle(1.2,1.5);
        rectangle.showInfo();
    }

}
