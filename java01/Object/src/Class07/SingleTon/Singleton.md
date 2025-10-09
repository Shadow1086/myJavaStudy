
1.何为单例模式<br>
单例模式(Singleton Pattern)是一种设计模式，确保一个类只有一个实例，并提供一个全局访问点来获取该实例。
它通常用于需要全局共享资源或配置的场景，例如数据库连接池、日志记录器等。

2.单例模式的实现<br>
单例模式的实现通常包括以下几个关键点：
1. 私有化构造函数：防止外部通过new关键字创建类的实例。
2. 静态变量：用于保存类的唯一实例。
3. 静态方法：提供一个全局访问点来获取类的唯一实例。
3.单例模式的实现方式<br>
1. 饿汉式单例模式<br>
饿汉式单例模式在类加载时就创建了唯一实例，线程安全，但可能会浪费资源。
```java
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
```
2. 懒汉式单例模式<br>
懒汉式单例模式在第一次调用getInstance()方法时创建实例，节省资源，但需要考虑线程安全问题。
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

#### 饿汉式 vs 懒汉式

饿汉式：

- 特点：`立即加载`，即在使用类的时候已经将对象创建完毕。
- 优点：实现起来`简单`；没有多线程安全问题。
- 缺点：当类被加载的时候，会初始化static的实例，静态变量被创建并分配内存空间，
从这以后，这个static的实例便一直占着这块内存，直到类被卸载时，静态变量被摧毁，并释放所占有的内存。
因此在某些特定条件下会`耗费内存`。

懒汉式：

- 特点：`延迟加载`，即在调用静态方法时实例才被创建。
- 优点：实现起来比较简单；当类被加载的时候，static的实例未被创建并分配内存空间，当静态方法第一次被调用时，初始化实例变量，
并分配内存，因此在某些特定条件下会`节约内存`。
- 缺点：在多线程环境中，这种实现方法是完全错误的，`线程不安全`，根本不能保证单例的唯一性。
    - 说明：在多线程章节，会将懒汉式改造成线程安全的模式。
    - 解决方案：使用`synchronized`关键字修饰静态方法，保证同一时刻只有一个线程能进入该方法。(超纲)
3. 双重检查锁定<br>
双重检查锁定在懒汉式的基础上进行了优化，减少了同步的开销。
```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }   
        }
        return instance;
    }
}
```
4. 静态内部类<br>
静态内部类方式利用了类加载的机制，既实现了懒加载，又保证了线程安全。
```java
public class Singleton {
    private Singleton() {}
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
5. 枚举单例模式<br>
枚举单例模式是最简洁且线程安全的实现方式，防止反序列化破坏单例。
```java
public enum Singleton {
    INSTANCE;
    public void someMethod() {
        // 方法实现
    }
}
```
应用实例：
- Windows的Task Manager (任务管理器)就是很典型的单例模式
- Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
- Application 也是单例的典型应用

总结<br>
单例模式是一种常用的设计模式，适用于需要全局唯一实例的场景。选择合适的实现方式取决于具体需求，如资源使用、线程安全等因素。
