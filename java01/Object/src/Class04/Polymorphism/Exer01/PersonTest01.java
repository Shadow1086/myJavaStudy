package Class04.Polymorphism.Exer01;

/**
 * ClassName: Practice01
 * Package: Class04.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 20:26
 * {@code @Version} 1.0
 */

public class PersonTest01 {
    public static void main(String[] args) {
        //多态性之前的场景：
        Person p1 = new Person();
        Man m1 = new Man();

        //多态性：子类对象的多态性
        Person p2 = new Man();
        //多态性的应用：   虚拟方法的调用
        //在多态的场景下，调用方法时
            //编译时，认为方法是左边声明的父类的类型的方法，即被重写的方法
            //执行时：实际执行的时子类重写父类的方法。
        //  编译看左边，运行看右边。
        p2.eat();       //man类，编译器以为是Person类
        p2.walk();      //man类
    }

}
