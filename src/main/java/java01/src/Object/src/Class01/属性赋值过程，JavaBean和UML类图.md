# 1 ，**类中属性赋值过程**

## **1**、在类的属性中，可以有哪些位置给属性赋值？

① 默认初始化

② 显式初始化：在定义类的时候就给属性赋值。

③ 构造器中初始化

④ 通过"对象.属性"或"对象.方法"的方式，给属性赋值

## **2**、这些位置执行的先后顺序是怎样？

顺序：① - ② - ③ - ④（后面的把前面的覆盖）

## 3、以上方法可以赋值的次数

- 上述中的①、②、③在对象创建过程中，只执行一次。
- ④ 是在对象创建后执行的，可以根据需求多次执行。

## 4.补充

- 在java源代码被编译后，转换得到的***字节码文件中将构造器视为<init>方法***





# **11.2 JavaBean**

## 1.JavaBean是一种Java语言写成的可重用组件。

​	好比你做了一个扳手，这个扳手会在很多地方被拿去用。这个扳手也提供多种功能(你可以拿

​	这个扳手扳、锤、撬等等)，而这个扳手就是一个组件。

## 2.所谓JavaBean，是指符合如下标准的Java类：

- 类是公共的
- 有一个无参的公共的构造器
- 有属性，且有对应的get、set方法

3.用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行

打包，并且其他的开发者可以通过内部的JSP页面、Servlet、其他JavaBean、applet程序或者应用来

使用这些对象。用户可以认为JavaBean提供了一种随时随地的复制和粘贴的功能，而不用关心任何

改变。

4.《Think in Java》中提到，JavaBean最初是为Java GUI的可视化编程实现的。你拖动IDE构建工具创

建一个GUI 组件（如多选框），其实是工具给你创建Java类，并提供将类的属性暴露出来给你修改

调整，将事件监听器暴露出来。



## 5.示例：

```java
public class JavaBean {

	private String name; // 属性一般定义为private
	private int age;

	public JavaBean() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
	public String getName() {
		return name;
	}

public void setName(String n) {
	name = n;
	}
}
```



# **11.3 UML**类图

- UML（Unified Modeling Language，统一建模语言），用来描述 **软件模型** 和 **架构** 的图形化语言。

- 常用的UML工具软件有 PowerDesinger 、 Rose 和 Enterprise Architect 。

- UML工具软件不仅可以绘制软件开发中所需的各种图表，还可以生成对应的源代码。

- 在软件开发中，使用 UML类图 可以更加直观地描述类内部结构（类的属性和操作）以及类之间的关

  系（如关联、依赖、聚合等）。

  - +表示 public 类型， - 表示 private 类型，#表示protected类型

  - 方法的写法: 方法的类型(+、-) 方法名(参数名： 参数类型)：返回值类型

  - 斜体表示抽象方法或类。

<img src="C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250928194421393.png" alt="image-20250928194421393" style="zoom:60%;" />













