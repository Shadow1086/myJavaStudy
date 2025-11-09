package Class07.SingleTon.Block.Exer01;

/**
 * ClassName: UserTest
 * Package: Class07.SingleTon.Block.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/9 20:17
 * {@code @Version} 1.0
 */

public class UserTest {
    public static void main(String[] args) {
        User u1 = new User();
        System.out.println(u1.getInfo());

        User u2 = new User("xiaoming" , "456789");
        System.out.println(u2.getInfo());

        User1 u3 = new User1();
        System.out.println(u3.getInfo());

        User1 u4 = new User1("xiaoming" , "456789");
        System.out.println(u4.getInfo());
    }

}
