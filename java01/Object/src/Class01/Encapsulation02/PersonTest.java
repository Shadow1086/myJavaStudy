package Class01.Encapsulation02;


/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description: 定义两个类，Person和PersonTest，用setAge设置人的合法年龄，用getAge返回人的年龄。
 * 在PersonTest类中实例化Person类的对象，调用setAge和getAge方法，体会java的封装性。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 13:55
 * {@code @Version} 1.0
 */

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(46);
        System.out.println("设置的年龄为：" + p1.getAge());
    }

}
