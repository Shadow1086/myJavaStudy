package Class10._enum.Exer01;
/**
 * ClassName: BankTest01
 * Description:
 * 
 * 利用枚举类实现单例模式
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-12 22:05:06
 * {@code @Version} 1.0
 */
public class BankTest01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.XIAO_LI);
    }
    
}


enum Bank{
    CPB;
}

enum GirlFriend{

    XIAO_LI(20);

    private final String name;
    private final int age;

    private GirlFriend(int age){
        this.name = "XIAO_LI";
        this.age = age;
    }
}