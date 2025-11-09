package Class05.Object.ToString;

/**
 * ClassName: ToStringTest
 * Package: Class05.Object.ToString.Exer
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 12:28
 * {@code @Version} 1.0
 */

public class ToStringTest {
    public static void main(String[] args) {
        User u1 = new User("tom", 12);
        System.out.println(u1.toString());  //Class05.Object.ToString.User@b1bc7ed
        System.out.println(u1);             //Class05.Object.ToString.User@b1bc7ed
    }

}

class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {name = " + name + ",age = " + age + "}";
    }


}
