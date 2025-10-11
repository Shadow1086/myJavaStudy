package Class08.Interface.Apply01;


/**
 * ClassName: Flyable
 * Package: Class08.Interface.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:06
 * {@code @Version} 1.0
 */
public interface Flyable {
    //全局变量
    public static final int MIN_SPEED = 0;

    //接口中的变量必须为全局变量，不使用public static final修饰也仍是全局静态变量
    //即可以省略public static final
    int MAX_SPEED = 7900;

    //方法也可以省略public abstract
    public abstract void fly();


}
