day06中的文件摘要：
- [day06_Readme.md](day06_Readme.md)：本文件，介绍了day06的内容。
- [T_class01_Dog.java](T_class01_Dog.java)：一个简单的类，用于描述狗的属性和行为。
- T_class02_Car.java：一个简单的类，用于描述汽车。
- T_class03_Login.java：模拟用户登录的类。类的初始化和数组的结合。





java类和对象知识点：
1. 类：类是创建对象的蓝图，它定义了对象的属性和行为。
2. 对象：对象是类的实例，它是类的具体实现。
3. 实例变量：实例变量是对象独有的属性，它存储了对象的状态。
4. 构造方法：构造方法是类的特殊方法，它在对象被创建时被调用。
5. 成员变量：成员变量是类的属性，它存储了对象的状态。
写法：
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}
```

6. 成员方法：成员方法是类的行为，它定义了对象可以执行的操作。
7. 访问权限：访问权限是类的属性和方法的访问权限，它决定了谁可以访问这些属性和方法。
8. 继承：继承是一种代码复用技术，它允许创建新的类，继承已有的类，并添加新的功能。
实例：
```java
public class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public void study() {
        System.out.println(name + " is studying in " + major + " major.");
    }
}    
``` 
9.多态：多态是指一个对象可以有多个形态，而这些形态都可以被同一个方法调用。
示例：
```java
public class Animal {
    public void eat() {
        System.out.println("Animal is eating.");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking.");
    }
}    
```
10. 抽象类：抽象类是一种特殊的类，它不能实例化，只能作为基类被继承。
示例：
```java
public abstract class Shape {
    public abstract void draw();
}

public class Rectangle extends Shape {
    public void draw() {
        System.out.println("Rectangle is being drawn.");
    }
}

public class Circle extends Shape {
    public void draw() {
        System.out.println("Circle is being drawn.");
    }
}
```
11.接口：接口是一种特殊的抽象类，它只定义方法签名，而不提供方法的实现。
示例：
```java
public interface Shape {
    void draw();
}

public class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle is being drawn.");
    }
}

public class Circle implements Shape {
    public void draw() {
        System.out.println("Circle is being drawn.");
    }
}
```
12. 包：包是一种组织代码的机制，它允许不同类、接口、枚举、注解和其他包中的类、接口、枚举、注解等进行分组。
13. 异常：异常是程序运行时发生的错误，它可以被捕获并处理。
示例：
```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
``` 

