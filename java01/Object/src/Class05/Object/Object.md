Object类

1.说明：

* 明确：java.lang.Object
*
* 任意一个Java类（除了Object）都直接或间接的继承于Object类
*
* Object 类称为Java类的根父类
*
* Object类中声明的结构（属性，方法等）都有通用性
  > Object类中没有声明属性<br>
  >Object类提供了一个空参的构造器<br>
  >重点关注：Object类中声明的11个方法<br>

2. Object类中声明的11个方法：

* finalize() throws Throwable：调用机制：在GC要回收此对象时，调用如下的方法，此类重写此方法，可以在对象被销毁前，做一些清理工作。可能导致内部出现循环引用，导致此对象不能被回收。
* equals(Object obj)：指示其他某个对象是否与此对象“相等”
* toString()：返回该对象的字符串表示
* clone() throws CloneNotSupportedException：创建并返回此对象的一个副本

* getClass()：返回对象的运行时类
* hashCode()：返回对象的哈希码值
* notify()：唤醒在此对象监视器上等待的单个线程
* notifyAll()：唤醒在此对象监视器上等待的所有线程
* wait() throws InterruptedException：导致当前线程等待，直到另一个线程调用此对象的 notify() 方法或 notifyAll() 方法
* wait(long timeout) throws InterruptedException：导致当前线程等待，直到另一个线程调用此对象的 notify() 方法或 notifyAll()
  方法，或者超过指定的时间量
* wait(long timeout, int nanos) throws InterruptedException：导致当前线程等待，直到另一个线程调用此对象的 notify() 方法或
  notifyAll() 方法，或者超过指定的时间量

常用方法：
* 重点方法：equals(Object obj)、toString()、
* 了解方法：clone(),finalize()

3.equals(Object obj)方法
* 说明：指示其他某个对象是否与此对象“相等”,默认比较两个对象的地址
* Object类中equals()方法的源码：
```java
public boolean equals(Object obj) {
    return (this == obj);
}
```
* 需求：比较两个对象的属性值是否相等
* 解决：需要重写equals()方法
* 重写equals()方法的注意事项：
  > 1. 方法名必须是equals
  > 2. 参数类型必须是Object类型

对于像String,Date,File和包装类等类都重写了Object类中的equals()方法，用于比较两个对象的实体内容是否相等。

3.4 开发中使用说明：
> 实际开发中，针对于自定义的类，常常会判断两个对象是否equals()，而此时主要是判断两个对象的属性值是否相等。
所以：我们要重写Object类的equals()方法。
> 如何重写:
> 手动自己实现
> 调用IDEA自动实现（推荐）