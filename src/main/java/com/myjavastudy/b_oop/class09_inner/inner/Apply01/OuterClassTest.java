package com.myjavastudy.b_oop.class09_inner.inner.Apply01;

/**
 * ClassName: OuterClassTest
 * Package: Class09.inner.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 17:43
 * {@code @Version} 1.0
 */

public class OuterClassTest {
    public static void main(String[] args) {
        //1.创建Person的静态的成员内部类的实例
        Person.Dog dog = new Person.Dog();
        dog.eat();

        //2.创建Person的非静态的成员内部类的实例
        Person p1 = new Person();
        Person.Bird bird = p1.new Bird();
        bird.eat();
        bird.show("atm");
        bird.show1();
    }
}


class Person{
    String name = "Tom";
    int age = 1;


    //静态的成员内部类
    static class Dog{
        public void eat(){
            System.out.println("dog 吃骨头");
        }
    }

    //非静态的成员内部类
    class Bird{
        String name = "bird";
        public void eat(){
            System.out.println("鸟吃鸟粮");
        }
        public void show(String name){
            System.out.println("age = " + age);
            System.out.println("name = " + name);
            System.out.println("this.name = " + this.name);
            System.out.println("Person.this.name = " + Person.this.name);

        }
        public void show1(){
            eat();
            this.eat();
            Person.this.eat();
        }
    }

    public void eat(){
        System.out.println("人吃饭");
    }

       public void method(){
        //局部内部类
        class InnerClass1{

        }
    }
}