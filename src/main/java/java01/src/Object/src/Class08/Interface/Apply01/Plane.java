package Class08.Interface.Apply01;

/**
 * ClassName: Plane
 * Package: Class08.Interface.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:15
 * {@code @Version} 1.0
 */

public class Plane implements Flyable,Attackable{
    @Override
    public void fly(){
        System.out.println("fly方法重写");
    }

    @Override
    public void attack(){
        System.out.println("attack方法重写");
    }
}
