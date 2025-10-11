package Class07.SingleTon.Abstract.Apply02;

/**
 * ClassName: GeometricObject
 * Package: Class07.SingleTon.Abstract.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 10:00
 * {@code @Version} 1.0
 */

public abstract class GeometricObject {
    //求面积（只能考虑提供方法的声明，而没有办法提供方法体，所以适合声明为抽象方法
    public abstract double findArea();
    //求周长（同上
    public abstract double circumference();

    public abstract void showInfo();
}
