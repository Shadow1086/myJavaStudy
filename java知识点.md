







### 使用Scanner获取不同类型数据的步骤：

1.导入import java.util.Scanner

2.提供或创建一个Scanner类的实例

3.调用Scanner类中的方法，获取指定类型的变量

4.关闭资源，调用Scanner类中的close（）

例如：

\```java

import java.util.Scanner;

public class Main {

​    public static void main(String[] args) {

​        Scanner scanner = new Scanner(System.in);

​        //布尔类型

​        Boolean isSingle = input.nextBoolean();

​        //单字符类型

​        char sex = input.next().charAt(0);

​        //字符串

​        String name = input.next();

​        scanner.close();

​    }

}

\``` 

\### Get_random:获取随机数

导入java.Math,使用Math.random()方法可以获取[0.0,1.0)

获取[a,b]之间的随机数：***\*_公式：(int) ( Math.random() \* (b - a + 1)) + a;_\****







# 1. 包装类

## 1.1 包装类：基本数据类型对应的引用类型

## 1.2 包装类都有什么

​    int -\> Integer
​    long -\> Long
​    short -\> Short
​    byte -\> Byte
​    float -\> Float
​    double -\> Double

​    boolean -\> Boolean
​    char -\> Character

## 1.3 包装类的作用

为了使得基本数据类型的变量具备引用数据类型变量的特征（比如：封装性，继承性，多态性，）我们给各个基本数据类型都提供了包装类

## 1.4 基本数据类型 与 包装类 之间的转换

### 1.4.1 为什么需要转换

> 一方面在有些场景下，需要使用基本数据类型对应的包装类的对象，此时就需要将基本数据类型转换为对应的包装类对象。
> 比如：ArrayList的add方法，要求的是Object类型的参数，而基本数据类型不能作为Object类型的参数。<br>
> 另一方面在有些场景下，需要使用基本数据类型对应的包装类的对象，此时就需要将基本数据类型转换为对应的包装类对象。

### 1.4.2 基本数据类型 与 包装类 之间的转换

基本数据类型 -\> 包装类： 1.使用包装类的构造器
2. 建议使用包装类的valueOf()方法

包装类 -\> 基本数据类型：1. 调用包装类的xxxValue()方法

自动拆箱：将包装类对象转换为基本数据类型
自动装箱：将基本数据类型转换为包装类对象

### 1.4.3 包装类 与 基本数据类型 之间的转换

1. 自动装箱：将基本数据类型转换为包装类对象
2. 自动拆箱：将包装类对象转换为基本数据类型

## 1.4 String 与基本数据类型，包装类之间的转换

## 1.5 重点

1. 自动装箱：将基本数据类型转换为包装类对象
2. 自动拆箱：将包装类对象转换为基本数据类型

3.包装类缓存对象

包装类             缓存对象
Byte                -128 \~ 127
Short               -128 \~ 127
Integer             -128 \~ 127
Long                没有缓存对象
Float               没有缓存对象
Double              -128 \~ 127
Boolean             true,false
Character           \u0000 \~ \uFFFF

案例：

```
    Integer m = 1;
    Integer n = 1;
    System.out.println(m == n);//true

    Integer x = 128;
    Integer y = 128;
    System.out.println(x == y);//false
```

# 2. 异常捕获与抛出

## 2.1 什么是异常
指的是程序在执行过程中，出现的非正常情况，如果不处理最终会导致JVM的非正常停止。

## 2.2 异常的抛出机制
Java中把不同的异常用不同的类表示，一旦发生某种异常，就`创建该异常类型的对象`，并且抛出（throw）。
然后程序员可以捕获(catch)到这个异常对象，并处理；如果没有捕获(catch)这个异常对象，那么这个异常
对象将会导致程序终止。

## 2.3 异常的体系结构

```
java.lang.Throwable:异常体系的根父类
    |---java.lang.Error:错误。Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。
                         一般不编写针对性的代码进行处理。
               |---- StackOverflowError、OutOfMemoryError



|---java.lang.Exception:异常。我们可以编写针对性的代码进行处理。
           |----编译时异常：(受检异常)在执行javac.exe命令时，出现的异常。
                |----- ClassNotFoundException            类未找到
                |----- FileNotFoundException               文件未找到
                |----- IOException                        输入输出异常
           |----运行时异常：(非受检异常)在执行java.exe命令时，出现的异常。
                |---- ArrayIndexOutOfBoundsException     角标越界
                |---- NullPointerException               空指针
                |---- ClassCastException                 类型转换
                |---- NumberFormatException              数字格式
                |---- InputMismatchException             输入不匹配
                |---- ArithmeticException                算术异常：比如分母不能为0
```



## 2.4 错误与异常

**Error：**Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。一般不编写针对性的代码进行处理。

- 例如：StackOverflowError（栈内存溢出）和OutOfMemoryError（堆内存溢出，简称OOM）。

**Exception:** 其它因编程错误或偶然的外在因素导致的一般性问题，需要使用针对性的代码进行处理，使程序继续运行。否则一旦发生异常，程序也会挂掉。例如：

- 空指针访问
- 试图读取不存在的文件
- 网络连接中断
- 数组角标越界

## 2.5 异常处理

### 2.5.1 try-catch-finally(抓抛模型)

#### 2.5.1.1 过程：

抛： 程序在执行的过程中，一旦出现异常，就会在出现异常的代码处，生成对应异常类的对象，并将此对象抛出。
```
 一旦抛出，此程序就不执行气候的代码了
```
抓：针对于过程1 中抛出的异常对象进行捕获处理，这个过程就叫做抓
```
 一旦将异常进行了处理，代码就可以继续执行。
```

#### 2.5.1.2 语法结构：
```java
try{
     .....//可能出现异常的代码
}catch(异常类型1 e){
     ......//当产生异常类型1时的处理措施
}catch(异常类型2 e){
     ......//当产生异常类型2时的处理措施
}finally(
     ......//无论是否发生异常，都无条件执行的语句
)

}
```



#### 2.5.1.3 注意：
1.如果声明了多个catch结构，不同的异常类型在不存在字符类的情况下，谁声明在上边，谁声明在下面都可以
   如果多个异常类型满足字符类的关系，则必须将子类声明在父类结构的上面，否则会报错
2.catch中异常处理的方式：
   1.自己编写提示语句
   2.printStackTrace()：打印异常的详细信息（推荐）
   3.e.getMessage():获取发生异常的原因（需要打印输出）
3.try中声明的变量，出了try之后，就不可以被使用了

#### 2.5.1.4 开发体会：
> 1. 对于运行时异常：
```
    开发中通常就不进行显示的处理了，一旦在程序执行中，出现了运行时异常，那么根据异常的信息更改就好
```
> 2. 对于编译时异常：
```
    开发中必须进行显示的处理，否则程序编译不通过。
```

#### 2.5.1.5 finally块
1. 将一定要被执行的代码声明在fianlly中。

2. 更深刻的理解：无论try中或vatch中是否存在仍未被处理的异常，无论try或catch中是否存在return语句等，
     ```
     finally中声明的语句都一定要被执行。
     ```

3. 如果运行时异常中，我们有要想一定被执行的语句，可以使用try-finally结构来处理。

#### 2.5.1.6 什么样的代码应该声明在finally中
> 在开发中，一些资源，如：输入输出流，网络连接，Socket连接，数据库连接等，我们在使用完毕后，需要显式关闭资源，不然GC可能不会自动的回收这些资源，进而导致内存的泄露
```
 为了保证这些资源在使用完以后，不管是否出现了未备注里的异常的情况下，这些异常都能被关闭，所以，我们必须将这些操作声明在finally中。
```

### 2.5.2 异常处理的方式三：throws + 异常类型

#### 2.5.2.1 格式：
```java
public void method() throws ExceptionType1,ExceptionType2,...{
     //方法体
}
```



#### 2.5.2.2 注意:

1. 是否真正的处理了异常？

    -\>从编译是否能通过的角度看，看成是给出了异常万一要是出现的时候的解决方案，此方案就是继续向上抛出

    -\>但是，throws方式仅是将可能出现的异常抛给了此方法的调用者，调用者仍然需要考虑如何处理相关异常，从这个角度来看并没有

2. **方法重写的要求：**

    -\>子类重写的方法抛出的异常类型可以与父类中被重写的方法抛出的异常类型相容，或是父类被重写的方法抛出的异常类型的子类



### 2.5.3 两种方法的选择

> 1. 如果程序代码中，涉及到资源的调用（流，数据库连接，网络连接等），则必须考虑吧使用try-catch结构来处理，保证不出现内存泄漏问题
> 
> 2. 如果父类被重写的方法中没有throws异常类型，则子类重写的方法中如果出现了异常，只能考虑使用try-catch进行处理。
> 3. 开发中方法a依次调用了方法b,c,d,等方法，方法b,c,d之间是递进关系，此时，如果方法b,c,d中有异常，我们通常选择使用throws，而方法a中通常选择使用try-catch结构



# 2. 多线程



## 2.1相关概念

### 2.1.1 程序，进程和线程的区分：

* **程序（program）**：为完成特定任务，用某种语言编写的`一组指令的集合`。即指`一段静态的代码`，静态对象。

* **进程（process）**：程序的一次执行过程，或是正在内存中运行的应用程序。如：运行中的QQ，运行中的网易音乐播放器。
     * 每个进程都有一个独立的内存空间，系统运行一个程序即是一个进程从创建、运行到消亡的过程。（生命周期）
     * 程序是静态的，进程是动态的
     * 进程作为`操作系统调度和分配资源的最小单位`（亦是系统运行程序的基本单位），系统在运行时会为每个进程分配不同的内存区域。
     * 现代的操作系统，大都是支持多进程的，支持同时运行多个程序。比如：现在我们上课一边使用编辑器，一边使用录屏软件，同时还开着画图板，dos窗口等软件。
* **线程（thread）**：进程可进一步细化为线程，是程序内部的`一条执行路径`。一个进程中至少有一个线程。

     - 一个进程同一时间若`并行`执行多个线程，就是支持多线程的。

     - 线程作为**CPU调度和执行的最小单位**。

     - 一个进程中的多个线程共享相同的内存单元，它们从同一个堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源可能就会带来`安全的隐患`。

### 2.1.2 线程调度策略

-   分时调度：所有线程**轮流使用**CPU的使用权，并且**平均分配**每个线程占用CPU的时间。
-   抢占式调度：让**优先级高**的线程以较大的概率优先使用CPU，如果线程的优先级相同，那么会随机选择一个（线程的随机性）

线程的优先级

### 2.1.3了解







## 2.2 线程的创建

### 2.2.1 方式一：继承Thread类

#### 2.2.1.1步骤：

1.   创建一个继承于Tread类的子类
2.   重写Thread中的run()   ------\>  将此线程要执行的操作，声明在此方法体内
3.   创建当前Thread的子类的对象
4.   通过对象调用start()方法 :  1.启动线程，2.调用当前线程中的run()

#### 2.2.1.2 例题：创建一个分线程1，用于遍历100以内的偶数

【拓展 】 再创建一个分线程2，用于遍历100以内的偶数



```java
// 偶数
class PrintNumberOu extends Thread {
  @Override
  public void **run**() {
    for (int i = 0; i <= 100; i += 2) {
      System.out.**println**(Thread.**currentThread**().**getName**() + "----->" + i);
    }
  }
}
```

### 2.2.2 方式二：实现Runnable接口

#### 2.2.2.1步骤：

1.   创建一个实现Runnable接口的类
2.   实现接口中的run()方法  ----\>  将此线程要执行的操作，声明在此方法体内
3.   创建当前实现类的对象
4.   将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
5.   Thread类的实例调用start():1.启动线程，2.调用当前线程中的run()

#### 2.2.2.2 例题：

创建一个分线程1，用于遍历100以内的奇数

```java
*// 1.  创建一个实现Runnable接口的类*

class PrintNumber implements Runnable{

*// 2.  实现接口中的run()方法  ---->  将此线程要执行的操作，声明在此方法体内*   
  @Override
  public void **run**(){
    for (int i = 1; i <= 100; i += 2) {
      System.out.**println**(Thread.**currentThread**().**getName**() + " : " + i);
    }
  }
}
```



## 2.3 两种线程创建方法的比较

共同点：1. 启动线程，使用的都是Thread类中定义的start()

·         2. 创建的线程对象，都是Thread类或其子类的实例 

不同点：一个是类的继承，一个是接口的实现

​    建议：建议使用事实现Runnable接口的方式

​         Runnable方式的好处： 1. 实现的方式，避免的类的单继承的局限性

                                   2. 更适合处理有共享数据的问题。

                                                                      3.  实现了数据和代码的分离。

联系：public class Thread implements Runnable（代理模式）



## 2.4 线程的常用结构

1.   线程中的构造器：

-   public Thread() : 分配一个新的线程对象。
-   public Thread(String name) : 分配一个指定名字的新的线程对象。
-   public Thread(Runnable target)  ： 指定创建现成的目标对象，它实现了Runnable接口的run方法
-   public Thread(Runnable target，  String name)  ：分配·一个带有指定目标新的线程对象并指定名字



2.   线程中的常用方法：

> start():启动线程，调用线程的run()
> 
> run(): 将线程要执行的操作，声明再run()中
> 
> currentThread():获取当前执行代码对应的线程
> 
> getname(): 获取线程名字
> 
> setName(): 设置线程名称
> 
> sleep(long millis ) :静态方法，调用时，可以是的当前线程睡眠指定的毫秒数
> 
> yield():一旦执行此方法，就释放CPU的执行权
> 
> join():在线程a中通过线程b调用join(),意味着a进入堵塞状态，直到线程B执行结束，线程a才结束阻塞状态，继续执行。
> 
> isAlive():判断当前线程是否存活

过时方法：

>   public final void stop():**已过时，*不建议使用***  强行结束一个线程的执行，直接进入死亡状态。
> 
>   void suspend() / void resume():可能造成死锁，不建议使用，相当于音乐的播放与暂停按键，必须成对存在。



## 2.5 线程的优先级：

getPriority():获取线程的优先级

Thread类的三个优先级常量：

-   MAX\_PRIORITY(10) : 最高优先级
-   MIN——PRIORITY(1): 最低优先级
-   NORM\_PRIORITY(5)：普通优先级

注意：优先级高也只是概率较大，并不一定优先。



## 2.6 线程的生命周期：



1.   JDK 5.0 之前

<img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20251017202546479.png" alt="image-20251017202546479" style="zoom:50%;" />

2.  

<img src="C:\Users\lenovo\Desktop\文件夹\java\尚硅谷_第10章_多线程\images\image-20220524203355448.png" alt="image-20220524203355448" style="zoom: 45%;" />

## 2.7 线程的安全问题及解决

1. 多线程卖票，出现的问题：出现了重票和错票
2. 错误原因：线程1 操作ticket的过程中，尚未结束的情况下，其他线程也参与进来，对ticket进行了操作
3. 解决方法：必须保证一个线程在操作ticket的过程中，其他线程必须等待，直到线程a操作结束之后，其他线程才可以进来继续操作
4. java是如何解决线程的安全问题的？使用线程的同步机制
     方式一：同步代码块
     synchronized(同步监视器){
     //需要被同步的代码  
     }
     说明：
> 需要被同步的代码，极为操作共享数据的代码。
> 共享数据：几多个线程都需要操作的数据，如：ticket
> 需要被同步的代码，在被synchronized包裹以后，就使得一个线程在操作这些代码的过程中，其他线程必须等待
> 同步监视器，俗称锁。那个线程获取了锁，那个线程就能执行需要被同步的代码
> 同步金时期，可以使用任何一个类的对象充当，但是，多个线程必须共用同一个同步监视器。
方式二：同步方法  
说明：
> 如果操作共享数据的代码完整的生命再来一个方法中，那么我们就可以将此方法声明为同步方法即可。
> 非静态的同步方法，默认同步监视器是this
> 静态的同步方法，默认同步监视器是当前类的本身 

## synchronized好处：解决了线程的安全问题

· 弊端：在操作共享数据时，多线程其实是串行执行的，意味着性能低。
· 





















# 数组

数组是一种存储多个相同类型元素的集合。数组的声明、初始化、访问、遍历、排序、查找等操作都可以用数组来实现。
数组的声明：
```java
int[] arr = new int[10]; // 声明一个长度为10的int型数组
```
数组的初始化：
```java
int[] arr = {1, 2, 3, 4, 5}; // 声明并初始化一个int型数组
```
数组的访问：
```java
arr[0] = 10; // 访问数组的第一个元素
```
数组的遍历：
```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```
数组的拷贝：
```java
int[] arr2 = Arrays.copyOf(arr, arr.length); // 使用Arrays类中的copyOf方法拷贝数组
```

数组的排序：
```java
Arrays.sort(arr); // 使用Arrays类中的sort方法对数组进行排序
```
数组的查找：
```java
int index = Arrays.binarySearch(arr, 3); // 使用Arrays类中的binarySearch方法查找数组中的元素
```

以上就是数组的基本操作。    

### 二维数组

二维数组是指数组中的元素是另一个数组。也称为二维矩阵。

二维数组为引用类型，在内存中是以**栈**和**堆**的形式存在的。

创建二维数组的语法如下：

```java
数据类型[][] 数组名 = new 数据类型[行数][列数];
```

其中，数据类型是数组元素的数据类型，数组名是数组的名称，行数和列数是数组的维度。               


例如：

```java
int[][] arr = new int[3][4];
```

上述代码创建了一个 3 行 4 列的二维数组。 

二维数组的初始化方式与一维数组相同，通过循环初始化。

```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        arr[i][j] = i * j;
    }
}
```

上述代码初始化二维数组 arr，将每个元素的值设置为 i * j。            
二维数组的访问方式与一维数组相同，通过下标访问。

```java
arr[0][1] = 5;
```

上述代码将二维数组 arr 的第一行第二列的值设置为 5。

### 一维数组的内存解析

1.java中的内存结构是如何划分的？<br>
    -将内存区域划分为五个部分：程序计数器，虚拟机栈，本地方法栈，堆，方法区<br>
    -与目前数组相关的内存结构：<br>
比如：int[] arr = new int[]{1,2,3};<br>
    -虚拟机栈：用于存放方法中声明的变量：比如arr

​    -堆：用于存放数组的实体，即数组中的所有元素，比如：1，2，3

### switch语句的使用：

基本语法：
```java
switch (表达式){
    case a:{        命令语句        }
    case b:{        命令语句        }
    case c:{        命令语句        }
    default
}
```

### switch的穿透：

当表达式符合某个case，但是语句中没有break时，其余的所有case和default都会执行
除非执行完或遇见break

文件简介：
* T_switch01:switch语法的示例。
* T_switch02:switch的穿透，求几月几日是一年中的多少天。









# 接口 interface

## 1.接口定义：

```java
interface 接口名 {
    // 常量
    // 抽象方法
}
```
## 2.接口特点：

- 接口中的所有变量默认是 public static final 的，即常量。
- 接口中的所有方法默认是 public abstract 的，即抽象方法。
- 接口不能实例化对象。
- 一个类可以实现多个接口，使用关键字 implements。
- 接口可以继承多个接口，使用关键字 extends。
- 接口中的方法没有方法体，必须由实现类来实现。同抽象类的抽象方法。
- 接口可以包含默认方法（default）和静态方法（static），但不能包含实例方法。
- 接口不能包含构造方法。
- 接口可以包含私有方法（private），用于接口内部的代码复用。

## 3.接口内部结构的说明：

   >可以声明：

​       >属性：必须使用public static final修饰

​       >方法：jdk8之前：声明抽象方法，修饰为public abstract

​            jdk8:声明静态方法，默认方法

​            jdk9:声明私有方法

   >不可以声明：构造器，代码块等。


4. 接口和类的关系
    实现关系
5. 格式：
    class 类名 extends superA implements 接口1,接口2,...{
        // 重写接口中的所有抽象方法
    }
    可以多实现<br>
    A 相较于Super来讲，叫做子类<br>
    A相较于接口来讲，叫做实现类<br>

6. 满足此关系之后，说明：

* 类可以实现多个接口
* 类针对于接口的多实现，一定程度上，弥补了Java单继承的局限性
* 类必须重写接口中的所有抽象方法，否则必须将类声明为抽象类

7. 接口与接口的关系
    继承关系，可以多继承<br>
    格式：
    interface 接口名1 extends 接口名A,接口名B,...{
        // ...
    }
8. 接口的多态性
    接口类型的变量，可以指向实现类对象
    接口名 变量名 = new 实现类名();
    接口类型的变量，只能调用接口中声明的方法
    体现了多态性


1.创建 接口实现类 的对象
2.创建 接口实现类 的匿名对象
3.创建 接口匿名实现类 的对象
4.创建 接口匿名实现类 的 匿名对象

9. 接口和抽象类的区别
    相同点：
        都不能实例化对象
        都可以包含抽象方法
    不同点：
        抽象类一定有构造器，接口没有构造器
        类与类之间是继承关系，类与接口之间是实现关系



# 线程

## 实现方法：

### 方法一：继承Thread类

```java
public class TestForThread extends Thread{
    public test(){
        this.setName("MyThread");//设置线程名字
    }
    @Override
    public void run(){
        while(true){
            // 输出线程的名字，与主线程名称相区分
            printThreadInfo();
            try{
                Thread.sleep(1000);	// 线程休眠一秒，即每一秒输出一次名字
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        new TestForThread().start();
        // 演示主线程main
        while(true){
            printThreadInfo();
            Thread.sleep(1000);
        }
    }
    private static void printThreadInfo(){
        System.out.println("当前线程名称："+Thread.currentThread().getName());
    }
}
```

### 方法二：实现Runnable接口

```java
public class TestForRunnable{
    @Override
    public void run(){
        while(true){
            printThreadInfo();
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    private static void printThreadInfo(){
        System.out.println("当前线程名称："+Thread.currentThread().getName());
    }
}

//创建线程
public class CreateTestForRunnable{
    public static void main(String[] args){
        TestForRunnable testForRunnable = new TestForRunnable();
        Thread threadForRunnable = new Thread(testForRunnable).setName("ThreadForRunnable");//单独设置线程名称
        threadForRunnable.start();
    }
}
```

## Volatile

说明：在线程中一旦用此修饰符修饰的变量一旦更改，其他所有线程都会立刻看到最新值

语法：

```java
private volatile boolean running;
while(running){
    //业务逻辑
}
public void stop(){
    running = false;	//其他线程调用后，while中的running立刻变为false,直接跳出循环
}
```



# 枚举

## 概念

说明：枚举是一个特殊的类，存储着特定的一些常量，比如一周的七天，一年的12个月



## 语法：

```java
public enum DAY{
    MON,TUE,WED,THU,FRI,SAT,SUN
}

//带有字段和构造器,相当于一个完整的类
public enum Status{
    SUCCESS(200,"OK"),
    NOT_FOUND(404,"NOT FOUND"),
    ERROR(500,"Internal Error");
    private final int code;
    private final String desc;
    
    Status(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){return code;}
    public String getDesc(){return desc;}
}
```

## 方法：

-   values() : 用来获取枚举中的所有常量值
-   ordinal(): 可以找到每个枚举常量的索引，就像数组索引一样
-   valueOf() : 返回值指定字符串值的枚举常量

示例(仍以上方DAY枚举类演示)：

```java
//获取所有枚举值常量
DAY[] arr = DAY.values();

// 迭代枚举
for(DAY day : arr){
    //获取索引
    System.out.println(day+" at index "+day.ordinal());
}
System.out.println(DAY.valueOf("THU"));	// 返回枚举常量，不存在的会报错：IllehalArgumentException
//返回：THU
```





## 应用：

### for循环中遍历

```java
for(Day day : DAY.values()){
    System.out.println(day);
}
```

### switch中

```java
String day = MON;
switch(day){
    case MON:
        System.out.println("周一");
        break;
    case TUE:
        System.out.println("周二");
        break;
    case WED:
        System.out.println("周三");
        break;
   // 以后的皆为此操作
}
```













# 1. hashMap

## 1.1 初始化

### 方法一：后续需要再一个个添加

```java
HashMap<数据类型 ，数据类型> 名称 =new HashMap<>(value = length); 
```

说明：value选填

### 方法二：初始化时便直接放入数据

```java
HashMap<数据类型 ，数据类型> 名称 =new HashMap<>(Map.of(可以放元素，全部用逗号隔开即可)); 
```

## 1.2 添加元素

```java
名称.put(key(键)，value(值));
```

说明：如果此键已有值，则会返回旧值并更新为新值。

```java
名称.putIfAbsent()
```

说明：该方法会判断key是否存在，如果存在且value不为空，则只会返回原来的value，否则会put进新值，并返回null.

## 1.3 删除元素

```java
remove(key) //删除成功，则会返回被删除的key对应的value,否则返回null.
```

```java
remove(key,value) //删除成功，返回true,否则返回false
```

## 1.4 获取元素

```java
map.get("key");
```

说明：获取key对应的value

```java
map.getOrDault("key","value");

//常见方法：统计字符频率
Map<Character , Integer> map = new HashMap();
for(char c :"Hello".toCharArray()){
 map.put(c,map.getOrDefault(c,0) + 1);
}
```

说明：如果map中key对应的值不为null，则返回key对应的值，如果为null，则返回第二个参数value(默认值)

## 1.5 一些其他的用法

### 1.5.1 检查方法

```java
boolean result = map.containsKey(key);
```

说明：返回值为boolean,检查map中是否有指定的key键,true-\>存在，false-\>不存在。

### 1.5.2 条件更新方法

```java
//replace -- 替换已存在的键的值
map.replace("key" , "value");
//replace(key,oldValue,newValue),仅当键值都匹配时才会替换为newValue
map.replace("key","oldValue","newValue");
```

### 1.5.3 遍历方法

```java
//遍历键值对
for(Map.Entry<String ,Integet> entry : map.entrySet()){
 String key = entry.getKey();
 Integer value = entry.getValue();
 System.out.println(key + ": " + value);
}

//只遍历键
for(String key : map.keySet()){
 System.out.println(key);
}
//只遍历值
for(Integer value : map.values()){
 System.out.println(value);
}

//使用Lambda表达式（java 8+）
map.forEach((key , value)->{
 System.out.pritnln(key + ": " + value);
});
```

### 1.5.4 将两个map合并

```java
map1.putAll(map2); //将map2合并至map1中，注意map2本身并不会改变
```

# 2. 栈

## 2.1 实例化

```java
import java.util.Stack;
Stack<Integer> stack = new stack<Integer>()
```

说明：\<\>中的内容是数据类型，如：Character,

## 2.2 常见方法

说明：stack类继承于vector类，所有包含有vector中的所有方法。

```java
//判断是否为空
stack.empty();

//取出栈顶值，不出栈
stack.peek();

//进栈
stack.push(object); 

//出栈
stack.pop();

//搜索,返回对象在堆栈中的位置，以1为基数，注意不是0
stack.search(object)
```

# 3. 不定长度数组-ArrayList

## 3.1 什么是ArrayList

ArrayList是动态数组，解决了普通数组在定义时长度被限制了的缺点。
适用情况： 当你不知道这个数组中有多少元素。

## 3.2 初始化

```java
import java.util.ArrayList;
ArrayList< String > arr = new ArrayList<>();
//说明：<>中填写数据类型，普通数据类型要使用其范型：int -> Integer ...
ArrayList<Integer> arrNum = new ArrayList<>(1,2,3,4);
//也可以这样在初始化时就添加元素
```

## 3.3 增删元素

```java
//在末尾添加
arr.add("橘子");//arr = {"橘子"}
arr.add("香蕉")；//arr = {"橘子",“香蕉”}、

//在指定位置添加元素
arr.add(1,"苹果");

//添加整个集合，到末尾
ArrayList<String> arr1 = new ArrayList<>("橙子")；
arr.addAll(arr1);//arr = {“橘子”,"苹果","香蕉","橙子"}

//remove(Object o) - 删除第一次出现的指定元素，返回是否成功
arr.remove("橘子")//arr = {"苹果","香蕉","橙子"}
// remove(int index) - 删除指定位置的元素，返回被删除的元素
arr.remove(0);
//removeAll(Collection c) - 删除集合中的所有元素
arr.removeAll(Arrays.asList("葡萄","橙子"));
//clear() - 清空所有元素
arr.clear();
```

## 3.4 访问元素

```java
//get(int index) - 获取指定位置的元素
arr.get(0);

//indexOf(Object obj) - 返回第一次出现的索引，不存在返回 -1
arr.indexOf(obj);
arr.indexOf("橙子")

// lastIndexOf(Object obj) - 返回最后一次出现的索引
arr.lastIndexOf(obj);
arr.lastIndexOf("橙子")；
```

## 3.5 修改元素

```java
//set(int index, E e) - 替换指定位置的元素
arr.set(1,"西瓜");
```

## 3.6 检查操作

```java
//size() - 返回元素个数
int size = arr.size();

//isEmpty() - 判断是否为空
boolean empty = arr.isEmpty();

//contains(Object o) - 判断是否包含指定元素
boolean contaions = arr.contains("苹果")；

//containsAll(Collection c) - 判断是否包含指定集合的所有元素
boolean containsAll = arr.containsAll(Arrays.asList("苹果","橘子"));
```

## 3.7 转换操作

```java
// toArray() - 转换为数组
arr.toArray();

// toArray(T[](#) a) - 转换为指定类型的数组
String[] array2 = arr.toArray(new String[0]);
```

## 3.8 浅拷贝

```java
//clone() - 浅拷贝
ArrayList<Integer> cloned = arr.clone();
```

# 4 常见API

## 4.1 String类

### 4.1.1 String 类的理解

#### 4.1.1.1 类的声明

```java
public final class String
 implements java.io.Serializable, Comparable<String>, CharSequence
```

> final:String类是不可以被继承的
> Serializable:可序列化的接口。凡是实现此接口的对象就可以通过网络或本地流进行数据的传输。
> Comparable\<String\> :凡是实现此接口的类，其对象都可以比较大小
> CharSequence:

#### 4.1.1.2 内部生命的属性

JDK8中：

```java
private final char value[];
```

> 字符串真正存储数据的容器，本质上是字符的数组（类似于C++）
> final：指明此value一旦被初始化，其地址就不可变了。

JDK9：

```java
private final byte[] value;
```

> 官方的说法：大多数的String对象都包含的是Latin-1类型，只需要一个字节就可以存储了，所以如果是Latin-1类型就使用一个字节来存储，若是汉字之类的，则就使用两个字节来存储
> 本质上：为了节省内存空间，做了优化

#### 4.1.1.3 字符串常量存储的位置

> - 字符串常量都存储在字符串常量池（StringTable）中
> - 字符串常量池中不允许存放两个相同的常量
> - 字符串常量池，在不同的JDK版本中，存放的位置不同
>   - JDK7之前：存放在方法区中
>   - JDK7及以后：存放在堆空间中

#### 4.1.1.4 String的不可变性的理解

1. 当对字符串变量重新赋值时，需要重新制定一个字符串常量的位置进行复制，不能在原有的位置修改
2. 当对现有的字符串进行拼接操作时，需要重新开辟一个内存空间，不能直接对原有值进行修改
3. 当调用字符串的replace方法来替换现有的某个字符时需要重新开辟空间保存修改以后的字符串，不能在原有的位置修改

#### 4.1.1.5 String实例化的两种方式

1. `String s1 = "hello";`
2. `String s2 = new String("hello");`

**问题：`String s2 = new String("hello");` 创建了几个对象？**

- 两个对象：
  - 一个是在堆空间中new的对象
  - 另一个是在字符串常量池中生成的字面量

#### 4.1.1.6 String的连接操作

- **情况一**：常量 + 常量 → 结果仍然存储在字符串常量池中
- **情况二**：常量 + 变量 / 变量 + 变量 → 都会new，创建一个新的字符串，返回字符串对象的地址
- **情况三**：调用字符串的 `intern()` → intern方法返回的是字符串常量池中字面值的地址
- **情况四**：了解：`concat()` → 不管是常量调用此方法，还是变量调用，同样不管参数是常量还是变量，总之，调用完此方法，都返回了一个新new的对象

#### 4.1.1.7 构造器和方法

##### 4.1.1.7.1 构造器

- `public String()`
- `public String(String original)`
- `public String(char[] value)`
- `public String(char[] value, int offset, int count)`
- `public String(byte[] bytes)`
- `public String(byte[] bytes, String charsetName)`

##### 4.1.1.7.2 方法

**一般方法（比较等）：**

- `boolean isEmpty()`：字符串是否为空
- `int length()`：返回字符串的长度
- `String concat(xx)`：拼接
- `boolean equals(Object obj)`：比较字符串是否相等，区分大小写
- `boolean equalsIgnoreCase(Object obj)`：比较字符串是否相等，不区分大小写
- `int compareTo(String other)`：比较字符串大小，区分大小写，按照Unicode编码值比较大小
- `int compareToIgnoreCase(String other)`：比较字符串大小，不区分大小写
- `String toLowerCase()`：将字符串中大写字母转为小写
- `String toUpperCase()`：将字符串中小写字母转为大写
- `String trim()`：去掉字符串前后空白符
- `public String intern()`：结果在常量池中共享

**查找：**

- `boolean contains(xx)`：是否包含xx
- `int indexOf(xx)`：从前往后找当前字符串中xx，即如果有返回第一次出现的下标，要是没有返回-1
- `int indexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
- `int lastIndexOf(xx)`：从后往前找当前字符串中xx，即如果有返回最后一次出现的下标，要是没有返回-1
- `int lastIndexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

**截取字符串：**

- `String substring(int beginIndex)`：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串
- `String substring(int beginIndex, int endIndex)`：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串

**与数组有关：**

- `char charAt(index)`：返回index位置的字符
- `char toCharArray()`：将此字符串转换为一个新的字符数组返回
- `static String valueOf(char data)`：返回指定数组中表示该字符序列的 String
- `static String valueOf(char data, int offset, int count)`：返回指定数组中表示该字符序列的 String
- `static String copyValueOf(char data)`：返回指定数组中表示该字符序列的 String
- `static String copyValueOf(char data, int offset, int count)`：返回指定数组中表示该字符序列的 String
- `boolean startsWith(xx)`：测试此字符串是否以指定的前缀开始
- `boolean startsWith(String prefix, int toffset)`：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
- `boolean endsWith(xx)`：测试此字符串是否以指定的后缀结束

**替换：**

- `String replace(char oldChar, char newChar)`：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。不支持正则
- `String replace(CharSequence target, CharSequence replacement)`：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
- `String replaceAll(String regex, String replacement)`：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
- `String replaceFirst(String regex, String replacement)`：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

### 4.1.2 String StringBuffer StringBuilder

#### 4.1.2.1 三个类的对比

> - **String**：不可变的字符序列
> - **StringBuffer**：可变的字符序列，JDK1.0声明，线程安全，效率低
> - **StringBuilder**：可变的字符序列，JDK5.0声明，线程不安全，效率高

**共同点**：底层使用 `char[]`（JDK8及之前），底层使用 `byte[]`（JDK9及以后）

#### 4.1.2.3 StringBuffer/StringBuilder的可变性分析

**对于String：**

```java
String s1 = new String(); 
// char[] value = new char[0];
String s2 = new String("abc"); 
// char[] value = new char[]{'a','b','c'};
```

**针对于StringBuilder来说：**

内部的属性：

```java
char[] value;    // 存储字符序列
int count;       // 实际存储的字符的个数

// 初始化便拥有16个字符的长度，用来以后增加字符
StringBuilder sBuffer1 = new StringBuilder();
// char[] value = new char[16]
StringBuilder sBuffer2 = new StringBuilder("abc")
// char[] value = new char[16 + "abc".length]

sBuffer1.append("ac");    // value[0] = 'a',value[1] = 'c'
sBuffer1.append("b");     // value[2] = 'b'

// 但不断的添加字符，一旦count要超过value.length时，就需要扩容，默认扩容为原有容量的2倍+2，并将原来的value数组中的元素复制到新的数组中
```

#### 4.1.2.4 选择

- 如果开发中需要频繁的针对于字符串进行增删改等操作，建议使用StringBuffer/StringBuilder来替换String，因为使用String效率低
- 如果开发中，不涉及到线程安全问题，建议使用StringBuilder来替换StringBuffer，因为使用StringBuilder效率高
- 如果开发中大体确定要操作的字符的个数，建议使用带int capacity参数的构造器，因为可以避免底层多次扩容操作，性能更高

#### 4.1.2.5 StringBuilder/StringBuffer中常用的方法

**方法列表：**

- `StringBuffer append(xx)`：提供了很多的append()方法，用于进行字符串追加的方式拼接
- `StringBuffer delete(int start, int end)`：删除[start,end)之间字符
- `StringBuffer deleteCharAt(int index)`：删除[index]位置字符
- `StringBuffer replace(int start, int end, String str)`：替换[start,end)范围的字符序列为str
- `void setCharAt(int index, char c)`：替换[index]位置字符
- `char charAt(int index)`：查找指定index位置上的字符
- `StringBuffer insert(int index, xx)`：在[index]位置插入xx
- `int length()`：返回存储的字符数据的长度
- `StringBuffer reverse()`：反转

**操作分类：**

- **增**：`append(xx)`
- **删**：`delete(int start, int end)`、`deleteCharAt(int index)`
- **改**：`replace(int start, int end, String str)`、`setCharAt(int index, char c)`
- **查**：`charAt(int index)`
- **插**：`insert(int index, xx)`
- **长度**：`int length()`
- **翻转**：`reverse()`

## 4.2 日期时间类--Date,Calendar

### 总结与概述：

1.   Date:一般只用于存储当前时间，格式不美观，使用方式：

```java
Date now = new Date();
System.out.println(now);	// Sat Jun 14 10:30:00 CST 2025
```

2.   SimpleDateFormat:格式化显示时间，美观，可以和String互相转换

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss);
Date now = new Date();
String time = sdf.format(now);
```

常见的格式：

> yyyy → 年（2025）
> MM   → 月（06）
> dd   → 日（14）
> HH   → 时（10）24小时制
> mm   → 分（30）
> ss   → 秒（00）

2.   Calendar:对时间进行操作：



### 4.2.0 JDK8之前

### 4.2.1 Date

#### 4.2.1.1 System类中的currentTimeMillis()

获取当前时间对应的毫秒数，long类型，时间戳

- 当前时间与1970年1月1日0时0分0秒之间的毫秒数
- 常用来计算时间差

#### 4.2.1.2 两个Date类

**类层次结构：**

- `java.util.Date`
  - 两个构造器的使用
  - 两个方法的使用：`toString()`方法、`long getTime()`：获得毫秒数
  - `java.sql.Date`：对应着数据库中的date类，只有一个幖参数的构造器

```java
@Test
public void test01(){
    Date date1 = new Date();        //创建一个基于当前系统时间的Date实例
    System.out.println(date1.toString());//Sat Nov 08 18:04:21 CST 2025
    long milliTimes = date1.getTime();      //对应的毫秒数为： 1762596261612
    System.out.println("对应的毫秒数为： " + milliTimes);

    Date date2 = new Date(1762595931658L);//创建基于时间戳的Date实例
    System.out.println(date2.toString());   //Sat Nov 08 17:58:51 CST 2025

}
```

```
@Test
public void test02(){
    java.sql.Date date1 = new java.sql.Date(1762595931658L);
    System.out.println(date1.toString());   //2025-11-08

    System.out.println(date1.getTime());    //1762595931658

}
```

#### 4.2.1.3 SimpleDateFormat：可以自定义格式的类

SimpleDateFormat类：用于日期时间的格式化和解析

- **格式化**：日期 → 字符串
- **解析**：字符串 → 日期

```java
@Test
public void test03() throws ParseException{
    SimpleDateFormat sdf = new SimpleDateFormat();
    //格式化：日期----->字符串
    Date date1 = new Date();
    String strDate = sdf.format(date1);
    System.out.println(strDate);        //   2025/11/8 18:09


    //解析： 字符串----->日期
    Date date2 = sdf.parse("2025/11/8 18:09");
    System.out.println(date2);
}
```

```java
/**
 * 使用自己规定的格式
 */
@Test
public void test04() throws ParseException{
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
//格式化：日期----->字符串    
    //规定时间格式为：  EEE, d MMM yyyy HH:mm:ss Z
    sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date1 = new Date();
    String strDate = sdf.format(date1);
    System.out.println(strDate);        
    // EEE, d MMM yyyy HH:mm:ss Z  ------> 周六, 8 11月 2025 18:14:04 +0800
    // yyyy-MM-dd hh:mm:ss   ----->  2025-11-08 06:16:05

 //解析： 字符串----->日期    
    Date date2 = sdf.parse("2025-11-08 06:16:05");
 //只能传yyyy-MM-dd hh:mm:ss格式，别的格式识别不了

    System.out.println(date2);         
 //Sat Nov 08 06:16:05 CST 2025
}
```

### 4.2.4 Calendar

**Calendar：日历类**

1. **实例化**：由于Calendar是一个抽象类，所以我们需要创建其子类的实例，这里我们通过Calendar的静态方法 `getInstance()` 即可获取
2. **常用方法**：`get(int field)` / `set(int field, xx)` / `add(int field, xx)` / `getTime()` / `setTime()`

```java
@Test
public void test05(){
    // 实例化
    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getClass());        
//class java.util.GregorianCalendar

    //测试方法
    //get(int field)
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");     //这个月的第8天
    System.out.println("今年的第"+calendar.get(Calendar.DAY_OF_YEAR)+"天");          //今年的第312天

    //set(int field,xx)
    calendar.set(Calendar.DAY_OF_MONTH,23);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //这个月的第23天

    //add(int field,xx)
    calendar.add(Calendar.DAY_OF_MONTH,3);
    calendar.add(Calendar.DAY_OF_MONTH,-5);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //这个月的第21天  (加了三天，又减了五天)

    //getTime()
    System.out.println(calendar.getTime());     //Fri Nov 21 18:42:24 CST 2025,返回的是Date类

    //setTime()：使用指定的Date重置Calenda
    Date date1 = new Date();
    calendar.setTime(date1);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //相当于重置了，还是第8天
}
```

### 4.2.01 JDK8及以后，新的日期时间API

#### 本地日期时间：LocalDate , LocalTime ,LocalDateTime --\>类似于Calendar

- **实例化**：`now()` / `of(xx, xx, xx)`
- **方法**：`get()` / `withXxx()` / `plusXxx()` / `minusXxx()`

#### Instant:瞬时，时间戳---\>类似于Date

- **实例化**：`now()` / `ofEpochMilli()`
- **方法**：`toEpochMilli()`

#### DateTimeFormatter. ----\> 类似于SimpleDateFormat

用于格式化和解析LocalDate , LocalTime ,LocalDateTime

## 4.3 比较器comparable

### 1. 实现对象的排序，可以考虑两种方式：自然排序，定制排序

### 2.方式一 - 自然排序：实现Comparable接口的方式

实现步骤：

1. 具体的类A实现Comparable接口
2. 重写Comparable接口中的compareTo(Object obj)方法，在此方法中指明比较类A的对象的大小的标准
3. 创建类A的多个实例，进行大小的比较或排序。

### 3. 方式二 - 定制排序：java.util.Comparator

实现步骤：

1. 创建一个实现了Comparator接口的实现类
2. 实现类要求重写Comparator接口中的抽象方法compare(Object o1,Object o2),在此方法中指明要比较大小的对象的大小关系（比如：String类，Product类）
3. 创建此实现类A的对象，并将此对象传入到相关方法的参数位置即可（比如：Arrays,sort(...   , 类A的实例)）

### 4. 对比两种方式

1. 角度一：

 - 自然排序：单一的，唯一的
 - 定制排序：灵活的，多样的
- 角度二：

 - 自然排序：一劳永逸
 - 定制排序：临时的
- 细节：

 - 自然排序：对应的接口是Comparable，对应的抽象方法：compareTo(Object obj)
 - 定制排序：对应的接口是Comparator，对应的抽象方法：compare(Object o1,Object o2)



# 5. 集合框架

### 5.1 Collection

#### 5.1.1 内存层面需要针对于多个数据进行存储。此时可以考虑的容器：数组、集合

#### 5.1.2 数组存储多个数据方面的特点

**数组的特点：**

- 数组一旦初始化，其长度就是确定的
- 数组中的多个元素是依次紧密排序的，有序的，可重复的
- **优点**：数组一旦初始化完成，其元素的类型就是确定的，不是此类型的元素就不能添加到此数组中

```java
int[] arr = new int[10];
arr[0] = 1;
arr[1] = "AA";  // 编译报错

Object[] arr1 = new Object[10];
arr1[0] = new String();
```

- 元素的类型可以是基本数据类型，也可以是引用数据类型

**数组存储多个数据方面的弊端：**

- 数组一旦初始化，其长度就不可变了
- 数组中存储数据特点的单一性。对于无序的、不可重复的常见的多个数据就无能为力了
- 数组中可用的方法、属性都极少。具体的需求都需要自己来组织相关的代码逻辑
- 针对于数组中元素的删除、插入操作，性能较差

### 5.2 Java集合框架体系（java.util包下）

**java.util.Collection**：存储一个一个的数据

- **子接口List**：存储有序的、可重复的数据（动态数组）
  - ArrayList（主要实现类）、LinkedList、Vector
- **子接口Set**：存储无序的、不可重复的数据（高中学习的集合）
  - HashSet（主要实现类）、LinkedHashSet、TreeSet

**java.util.Map**：存储一对一对的数据（key-value键值对，(x1,y1), (x2,y2) → y = f(x)，类似于高中的函数）

- HashMap（主要实现类）、LinkedHashMap、TreeMap、Hashtable、Properties

### 5.3 Collection常用方法

```java
// 添加单个元素
add(Object obj)

// 添加other集合中的所有元素对象到当前集合中，即this = this ∪ other
addAll(Collection coll)

// 判断当前集合是否为空集合
isEmpty()

// 获取当前集合中实际存储的元素个数
size()

// 判断当前集合中是否存在一个与obj对象equals返回true的元素
contains(Object obj)

// 判断coll集合中的元素是否在当前集合中都存在
containsAll(Collection coll)

// 判断当前集合与obj是否相等
equals(Object obj)

// 从当前集合中删除两个集合中不同的元素，仅保留当前集合与coll集合的交集，即this = this ∩ coll
retainAll(Collection coll)

// 删除所有元素
clear()

// 从当前集合中删除第一个找到的与Obj对象equals返回true的元素
remove(Object obj)

// 删除所有与coll集合中相同的元素
removeAll(Collection coll)

// 返回当前集合的哈希值
hashCode()

// 将当前集合转换为数组
toArray()
//-----------------------------------详细看5.6
// 返回当前集合的迭代器
iterator()
```

### 5.4 集合和数组之间的相互转换

集合 -----\> 数组：toArray()
数组 -----\> 集合：调用Arrays的静态方法asList()

### 5.5 向Collection中添加元素的要求:

要求元素所属的类一定要重写equals()
原因:
因为Collection中的相关方法(比如contains()/remove())在使用时，要调用元素所在类的equals()

### 5.6 迭代器

#### 5.6.1 迭代器的作用？（Interator）

用来遍历集合元素的。

#### 5.6.2 如何获取迭代器对象？

```java
while( iterator.hasNext()){
    System.out.println(iterator.next());
}
```

#### 5.6.3 如何实现遍历（代码遍历）



#### 5.6.4 增强for循环的使用（foreach,JDK5新特性）

##### 5.6.4.1 作用



##### 5.6.4.2 格式：





# 6. File 和 IO 流

## 概括总结：

**关于八个流的使用情况：**

Stream ---\>字节(byte)----\>非文本文件，如图片，视频等

Reader/Writer ----\>字符(char)-----\>文本文件，如txt,csv等

Buffered ----\>加缓冲-----\>效率高，能读写一整行

**为什么缓冲可以加快效率？**

> 不加buffered时，每读一个字节就访问一次硬盘
> 
> 加了buffered后，分批次先读到内存缓存区，最后从内存中写到硬盘中，故而减少了和硬盘的交互次数，加快效率

**关于嵌套关系**

固定写法：

```	java
new Buffered___(new File___("文件路径"));
```



```java
┌─────────────────────────────────────────┐
│  Buffered 流（外层）                      │
│  ┌─────────────────────────────────┐    │
│  │  File 流（内层）                  │    │
│  │  ┌─────────────────────────┐    │    │
│  │  │       实际文件           │    │    │
│  │  └─────────────────────────┘    │    │
│  └─────────────────────────────────┘    │
└─────────────────────────────────────────┘

内层：负责连接文件（能读写，但慢）
外层：负责加缓冲（批量读写，快
```

1.  **字节流：** 

	-   BufferedInputStream  ---包装-----\>  FileInputStream  -----连接-----\>  文件

	-   BufferedOutputStream ---包装---\>  FileOutputStream---连接---\>  文件

2.   **字符流：** 
	 -   BufferedReader  ---包装---\>  FileReader  ---连接---  文件 
	 -   BufferedWriter  ---包装---\>  FileWriter  ---连接---\> 文件



## 6.1 File 类的实例化和常用方法

### 6.1.1 什么是 File 类？

> File 类位于 `java.io` 包下，File 类的一个对象，对应着操作系统的一个文件或一个文件目录。

File 类的理解：

- File 类的一个对象，对应于操作系统下的一个文件或一个文件目录（或文件夹）
- File 类中声明了新建、删除、获取名称、重命名等方法，但并没有涉及到文件内容的读写操作，要想实现文件内容的读写，就需要使用 IO 流
- File 类的对象，通常是/为 /O 流操/的文件的端点出现的
  - 代码层面：将 File 类的对象作为参数传递到 IO 流相关类的构造器中

### 6.1.2 内部 API 的使用说明

#### 6.1.2.1 构造器

- `public File(String pathname)`：以 pathname 为路径创建 File 对象，可以是绝对路径或者相对路径，如果 pathname 是相对路径，则默认的当前路径在系统属性 user.dir 中存储
- `public File(String parent, String child)`：以 parent 为父路径，child 为子路径创建 File 对象
- `public File(File parent, String child)`：根据一个父 File 对象和子文件路径创建 File 对象

#### 6.1.2.2 常用方法

##### 6.1.2.2.1 获取文件和目录基本信息

- `public String getName()`：获取名称
- `public String getPath()`：获取路径
- `public String getAbsolutePath()`：获取绝对路径
- `public File getAbsoluteFile()`：获取绝对路径表示的文件
- `public String getParent()`：获取上层文件目录路径。若无，返回 null
- `public long length()`：获取文件长度（即：字节数）。不能获取目录的长度
- `public long lastModified()`：获取最后一次的修改时间，毫秒值

##### 6.1.2.2.2 列出目录的下一级

- `public String[] list()`：返回一个 String 数组，表示该 File 目录中的所有子文件或目录
- `public File[] listFiles()`：返回一个 File 数组，表示该 File 目录中的所有的子文件或目录

##### 6.1.2.2.3 File 类的重命名功能

- `public boolean renameTo(File dest)`：把文件重命名为指定的文件路径

##### 6.1.2.2.4 判断功能的方法

- `public boolean exists()`：此 File 表示的文件或目录是否实际存在
- `public boolean isDirectory()`：此 File 表示的是否为目录
- `public boolean isFile()`：此 File 表示的是否为文件
- `public boolean canRead()`：判断是否可读
- `public boolean canWrite()`：判断是否可写
- `public boolean isHidden()`：判断是否隐藏

##### 6.1.2.2.5 创建、删除功能

- `public boolean createNewFile()`：创建文件。若文件存在，则不创建，返回 false
- `public boolean mkdir()`：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
- `public boolean mkdirs()`：创建文件目录。如果上层文件目录不存在，一并创建
- `public boolean delete()`：删除文件或者文件夹

**删除注意事项：**

- Java 中的删除不走回收站
- 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录

#### 6.1.2.3 查找以某个特定后缀结尾或开头的文件

```java
// 方法一
File dir = new File("#");
String[] fileList = dir.list();
for (String s : fileList) {
    if (s.endsWith("后缀")) {
        System.out.println(s);
    }
}

// 方法二
File dir = new File("#");
String[] fileList = dir.list(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        // 若文件是以后缀结尾的，则添加到 fileList 列表中
        return name.endsWith("后缀");
    }
});
for (String name : fileList) {
    System.out.println(name);
}
```

## 6.2 IO 流



### 6.2.1 IO流的概述和File流的使用：

**IO流的分类：**

-   流向的不同：输入流，输出流
-   处理单位的不同：字节流，字符流
-   流的角色的不同：处理流，节点流

| 抽象基类 | 输入流         | 输出流          |
| :--: | :---------: | :----------: |
| 字节流  | InputStream | OutputStream |
| 字符流  | Reader      | Writer       |

说明：本章虽然涉及到的流很多，但是使用流来进行数据的读写操作是非常标准和规范的

**基础IO流框架：**

| 抽象基类         | 4个节点流（也称为文件流）    | 4个缓冲流（处理流的一种）        |
| :----------: | :--------------: | :------------------: |
| InputStream  | FileInputStream  | BufferedInputStream  |
| OutputStream | FileOutputStream | BufferedOutputStream |
| Reader       | FileReader       | BufferedReader       |
| Writer       | FileWriter       | BufferedWriter       |

#### `FileReader`和`FileWriter`的使用

**执行步骤：**

1.  创建读取或写出的file对象
2.  创建输出流（`FileReader`）/输入流(`FileWriter`)
3.  实现具体输入输出操作
	-   读入：`read(char[] cbuffer)`
	-   写出：`write(char[] cbuffer , int fromIndex , int length)`
		-   `fromIndex`:从何处开始写入
		-   `Length:`写出的长度是多少，防止超出实际存储的数据
4.  关闭资源，防止内存泄漏
	-   需要判断一下是否为空

**注意点：**

1.  因为涉及到流资源的关闭，需要使用`try-catch-finally`进行关闭
2.  对于输入流(`FileReader`)：要求FIle对象对应的物理磁盘上的文件必须存在，否则会抱`FileNotFoundException`异常
3.  对于输出流(`FileWriter`)：FIle对象对应的物理磁盘上的文件不一定存在，需要注意构造器的使用：
	-   `FileWrite(File file , boolean true/false)`：boolean是决定`当文件存在`时是**覆盖文件**还是**追加内容**
		-   `true`:是追加内容
		-   `false`：是覆盖文件
		-   默认是`false`
	-   若文件存在时，则自动创建文件，并将数据写出到此文件中

#### `FileInputStream`和`FileOutputStream`的使用

步骤完全同上，就改个名称即可

**注意：**

-   对于字符流，只能用来操作文本文件，不能用来处理非文本文件的。
-   对于字节流，通常是用来处理非文本文件的。但是，如果涉及到文本文件的复制操作，也可以使用字节流。

**说明：**

-   文本文件：.txt 、.java 、.c、.cpp、.py等
-   非文本文件：.doc、.xls 、.jpg 、.pdf、.mp3、.mp4、.avi 等

### 6.2.2 缓冲流:BufferedInputStream/BufferedOutputStream------BufferedReader/BufferedWriter

**作用：** 提升文件读写的效率

**4个缓冲流及使用方法：**

| 类型          | 缓冲流                    | 使用的方法                                                      |
| :---------: | :--------------------: | :--------------------------------------------------------: |
| 处理非文本文件的字节流 | `BufferedInputStream`  | `read(byte[] buffer)`                                      |
| 处理非文本文件的字节流 | `BufferedOutputStream` | `write(byte[] buffer, 0, len)` / `flush()`                 |
| 处理文本文件的字符流  | `BufferedReader`       | `read(char[] cbuffer)` / `readLine()`                      |
| 处理文本文件的字符流  | `BufferedWriter`       | `write(char[] cbuffer, 0, len)`/`write(String)`/ `flush()` |

**实现的步骤：**

1. 创建File的对象、流的对象（包括文件流、缓冲流）

2. 使用缓冲流实现 读取数据 或 写出数据的过程（重点）
	- 读取：`int read(char[] cbuf/byte[] buffer)` : 每次将数据读入到cbuf/buffer数组中，并返回读入到数组中的字符的个数
	- 写出：
		- `void write(String str)` / `write(char[] cbuf)`：将str或cbuf写出到文件中
		- `void write(byte[] buffer)` 将byte[]()写出到文件中

3. 关闭资源

**注意：**

1.  缓冲流不能单独使用，需要包裹着文件流才可以使用
2.  关闭资源时，需要先关闭缓冲流，但是关闭缓冲流之后文件流会被自动关闭
3.  Flush() ：一个刷新的方法，
	-   作用：每次调用此方法，都会主动的将内存中的数据写入到磁盘中
	-   解释：如果不写此方法，当资源被关闭的时候，才会将数据写入目标文件，调用此方法就是在过程中分好多次写入到目标文件中

### 6.2.3 转换流:InputStreamReader/OutputStreamWriter

#### 转换流：

1.  作用：
	-   实现**字节**与**字符**之间的转换
2.  API：
	-   `InputStreamReader`:将一个输入型的字节流转换为输入型的字符流
	-   `OutputStreamWriter`:将一个输出型的字符流转换为输出型的字节流

### 6.2.4 数据流（了解）:DataOutputStream/DataInputStream

1.   作用：只可以读写基本数据类型的变量。不能读写引用数据类型的变量
2.   数据流：
	 1.   `DataOutputStream` : 可以讲内存中的**基本数据类型**的变量，`String`类型的变量写出到具体的文件中
	 2.   `DataInputStream` : 将文件中保存的数据还原为内存中的**基本数据类型**的变量，`String`的变量

### 6.2.5 对象流：ObjectInputStream/ObjectOutputStream

#### API：

-   `ObjectInputStream`
-   `ObjectOutputStream`

#### 作用：

可以读写**基本数据类型**的变量，**引用数据类型**的变量。

#### 对象的序列化机制：

>   对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。当其他程序获取了这种二进制流，就可以恢复成原来的Java对象。

#### 如下的两个过程所使用的流：

-   序列化过程(读)：`ObjectOutputStream`，将内存中的Java对象 保存在文件中/通过网络传输出去

-   反序列化过程(写)：`ObjectInputStream`，将文件中的数据/网络传输过来的数据 还原为内存中的Java对象

**自定义的类要实现序列化机制，需要满足：**

-   自定义类需要实现接口：`Serializable`,不需要重写什么方法，属于一个标识接口
-   要求自定义类声明一个全局常量：`static final long serialVersioinUID=42L`(42L需要改，只要和别的类的这个变量不一致就可以了)，用来唯一的标识当前的类，相当于类的身份证。
-   要求自定义类的各个属性也必须是可序列化的
	-   对于基本数据类型的属性：默认就是可以序列化的
	-   对于引用数据类型的属性：要求实现`Serializable`接口,声明UID常量

**注意点：**

-   如果不声明全局常量，系统会自动生成一个针对于当前类的`serialVersionUID`。如果修改此类的话，就会导致`serialVersionUID`变化，两者的`UID`不同，进而导致反序列化时会出现`InvalidClassException`异常
-   类中的属性如果声明为`transient / static`则不会实现序列化

### 其他流

1.  **标准输入/输出流**

	-   `System.in`:标准的输入流，默认从键盘输入
	-   `System.out`:标准的输出 流，默认从显示器输出（也可以理解为控制台输出）

	通过调用如下的方法，修改输入流和输出流的位置：

	-   setIn(InputStream is)
	-   setOut(PrintStream ps)

2.   **打印流**

# 7.正则表达式

## 7.1 概念：

用于匹配字符串符不符合某一规则，比如：

-   在获取用户的手机号时，是不是满足只有11位数字并且没有其余字符
-   在获取用户的邮箱时，是不是满足xxxxxx@xxx.xx的格式

## 7.2 基本语法：

![][image-1]

## 7.3 正则表达式的使用方法：

方法一(每次匹配都需要编译一次，如果使用次数多则会降低性能，线程不安全)：

```java
String pattern = "";			//正则表达式
String targetString = "";		//将要被判断是否匹配正则表达式的字符串
boolean matches = Pattern.matches(pattern,targetString);	//符合的话返回true,反之返回false
```

方法二(使用pattern和matcher类，预编译，pattern类线程安全)：

```java
Pattern pattern = Pattern.compile("");		//正则表达式
Matcher matcher = pattern.matches("");		//被判断的字符串
if(matcher.matches()){						//结果，同上，符合ture,不符合false;
    return true;
}eles		return false;
```

示例：

```java
Pattern pattern = Pattern.compile("1\\d{10}");
Matcher matcher = pattern.matcher("18493850935");
if(matcher.matches()){
    System.out.println("电话号格式正确");
}eles{
    System.out.println("电话号格式不正确，请重新检查");
}
```

优点：

-   当每次需要使用pattern这个正则表达式的时候，就可以直接使用，已经预编译过了，所以会减少内存的使用，提升性能

## 7.4 非贪婪匹配

说明：

-   尽可能少的匹配，比如一个字符串可以分为两段可以匹配正则表达式的字符串，那么就会在第一个匹配的字符串处分割开来

示例：

字符串："\<b\>one\</b\>\<b\>two\</b\>"，

正则表达式：

1.  正则表达式(\<b\>.\*\</b\>) : 会匹配："\<b\>one\</b\>\<b\>two\</b\>"
2.  正则表达式(\<b\>.\*?\</b\>) : 会匹配 : "\<b\>one\</b\>" , "\<b\>two\</b\>"

**非贪婪的常见语法：**

-   \* -\> \*?  ： 0 次或更多，非贪婪
-   \+. -\> +?   ：1 次或更多，非贪婪
-   ？ -\> ?? ：0/1次
-   {m , n}  -\> {m , n} : m到n次 





# 8.日志处理---SLF4J

## 8.1 依赖

使用maven管理java项目时，在pom.xml中添加：

```xml
<!-- 日志DLF4J的具体实现依赖 -->
<dependency>
	<groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
<version>1.5.21</version>
```

**说明：**
-   SLF4J 是一个接口，定义了应该实现的功能
-   Logback 则是具体的实现，根据SLF4J提供的接口实现具体的方法

## 8.2 日志的信息等级

-   ERROR ：错误事件可能导致应用无法继续运行的重要错误
-   WARN：潜在的有害情况(但是并没有影响到应用的运行)
-   INFO：重要业务进程信息
-   DEBUG：调试信息
-   TRACE：比DEBUG更细致的信息

## 8.3 具体实现

```java
public class test{
    private static final Logger logger = LoggerFactory.getLogger(test.class);
    public void method(){
        try{
            # 实现的业务代码
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }
}
```

## 8.4 配置文件

**说明：**

-   用来指明日志存储的位置以及信息输出的等级和格式

**示例：**

`logback.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<configuration>
    <!-- 控制台输出 -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <charset>UTF-8</charset>
            <!--	控制台中日志输出的样式		-->
            <pattern>%d{HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- 文件输出 -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!--	logs/app.log : 日志文件保存路径     -->
        <file>appLogs/app.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>logs/app.%d{yyyy-MM-dd}.log</fileNamePattern>
            <!--            日志保留的时间(天)         -->
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <!--            文件中日志输出样式          -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
	<!--  日志输出的等级，INFO及以上的信息	-->
    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>

</configuration>
```















# 字符串 String

## 字符串的分割-----



[image-1]:	https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/Hb51Xg.png