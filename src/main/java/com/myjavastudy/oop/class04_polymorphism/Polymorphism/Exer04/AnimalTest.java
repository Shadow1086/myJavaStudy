package com.myjavastudy.oop.class04_polymorphism.Polymorphism.Exer04;

/**
 * ClassName: AnimalTest
 * Package: Class04.Exer04
 * Description:
 * <p>
 * 修改AnimalTest类的方法，在判断Animal是Dog或Cat时，
 * 向下转型，并调用各自特有的方法。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 20:41
 * {@code @Version} 1.0
 */

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.adopt(new Cat());
    }

    public void adopt(Animal animal) {
    //强行转换
        if(animal instanceof Dog){
            Dog dog = (Dog)animal;
            dog.watchDoor();
        }else if(animal instanceof Cat){
            Cat cat = new Cat();
            cat.catchMouse();
        }

    }

}

class Animal {
    public void eat() {
        System.out.println("动物进食");
    }

    public void jump() {
        System.out.println("动物跳");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃什么");
    }

    public void jump() {
        System.out.println("狗急跳墙");
    }

    public void watchDoor() {
        System.out.println("狗看门");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃猫粮");
    }

    public void jump() {
        System.out.println("猫跳");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }

}