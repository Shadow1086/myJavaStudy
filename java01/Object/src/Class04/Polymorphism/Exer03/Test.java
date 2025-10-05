package Class04.Polymorphism.Exer03;

/**
 * ClassName: Practice01
 * Package: Class04.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:56
 * {@code @Version} 1.0
 */

public class Test {
    public static void main(String[] args) {
        GeometricTest geometricTest = new GeometricTest();
//多态性，但是直接自动向上转换了
        Circle c1 = new Circle(2.3,"红",1.0);
        geometricTest.displayGeometricObject(c1);
//动态绑定，编译和与运行不是同一个方法。
        Circle c2 = new Circle(3.3,"红",1.0);
        geometricTest.displayGeometricObject(c2);


        GeometricObject geo1 = new Circle(1.5,"红",1.2);
        GeometricObject geo2 = new MyRectangle("红",1.5,1.0,1.2);

        geometricTest.equalsArea(geo1,geo2);
        geometricTest.equalsArea(c1,c2);
    }

}
