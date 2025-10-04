package Class04.Exer02;

/**
 * ClassName: Practice01
 * Package: Class04.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 20:41
 * {@code @Version} 1.0
 */

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Animal());
        test.func(new Dog());       //多态
    }
    public void func(Animal animal){
        animal.eat();
        animal.jump();
    }

}

class Animal{
    public void eat(){
        System.out.println("动物进食");
    }
    public void jump(){
        System.out.println("动物跳");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃什么");
    }
    public void jump(){
        System.out.println("狗急跳墙");
    }
    public void watchDoor(){
        System.out.println("狗看门");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃猫粮");
    }
    public void jump(){
        System.out.println("猫跳");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }

}