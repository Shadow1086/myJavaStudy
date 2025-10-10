package Class04.Polymorphism.Exer03;

/**
 * ClassName: Practice01
 * Package: Class04.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:17
 * {@code @Version} 1.0
 */

public class GeometricTest {
    /**
     * 比较两个几何图形的面积是否相等
     * @param geo1  几何图形
     * @param geo2  几何图形
     */
    public void equalsArea(GeometricObject geo1,GeometricObject geo2){
        if(geo1.area()> geo2.area()){
            System.out.println("geo1 > geo2");
        }else if(geo1.area() < geo2.area()){
            System.out.println("geo1 < geo2");
        }else{
            System.out.println("geo1 = geo2");
        }
    }

    /**
     * 显示几何图形的面积
     * @param geometricObject   几何图形
     */
    public void displayGeometricObject(GeometricObject geometricObject){
        System.out.println("area = " + geometricObject.area());
    }
}
