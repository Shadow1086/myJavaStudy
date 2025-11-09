final关键字


总结：
- final修饰类：类不能被继承
- final修饰方法：方法不能被重写
- final修饰变量：变量的值不能被修改，变成了常量，一旦赋值就不能修改：
如果某个成员变量用final修饰后，没有set方法， 并且必须初始化（可以显式赋值、或在初始化块赋值、实例变量还可以在构造器中赋值）


### 5.1final的意义

final：最终的，不可更改的

### 5.2 final的使用

#### 5.2.1 final修饰类

表示这个类不能被继承，没有子类。提高安全性，提高程序的可读性。

例如：String类、System类、StringBuffer类

```java
final class Eunuch{//太监类
	
}
class Son extends Eunuch{//错误
	
}
```

#### 5.2.2 final修饰方法

表示这个方法不能被子类重写。

例如：Object类中的getClass()

```java
class Father{
	public final void method(){
		System.out.println("father");
	}
}
class Son extends Father{
	public void method(){//错误
		System.out.println("son");
	}
}
```

#### 5.2.3 final修饰变量

final修饰某个变量（成员变量或局部变量），一旦赋值，它的值就不能被修改，即常量，常量名建议使用大写字母。

例如：final double MY_PI = 3.14;

> 如果某个成员变量用final修饰后，没有set方法，
并且必须初始化（可以显式赋值、或在初始化块赋值、实例变量还可以在构造器中赋值）

- 修饰成员变量

```java
public final class Test {
    public static int totalNumber = 5;
    public final int ID;

    public Test() {
        ID = ++totalNumber; // 可在构造器中给final修饰的“变量”赋值
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.ID);
    }
}

```

- 修饰局部变量：

```java
public class TestFinal {
    public static void main(String[] args){
        final int MIN_SCORE ;
        MIN_SCORE = 0;
        final int MAX_SCORE = 100;
        MAX_SCORE = 200; //非法
    }
}
```

- 错误演示：

```java
class A {
    private final String INFO = "atguigu";  //声明常量

    public void print() {
        //The final field A.INFO cannot be  assigned
        //INFO = "尚硅谷"; 
    }
}

```

