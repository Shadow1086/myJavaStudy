# Java知识点整理

## 目录

1. 基础语法
2. 面向对象
3. 常用API
4. 集合框架
5. 异常处理
6. 多线程
7. 枚举
8. File和IO流
9. 正则表达式
10. 日志处理

---

# 1. 基础语法

## 1.1 Scanner输入

### 1.1.1 使用Scanner获取不同类型数据的步骤

1. 导入 `import java.util.Scanner`
2. 提供或创建一个Scanner类的实例
3. 调用Scanner类中的方法,获取指定类型的变量
4. 关闭资源,调用Scanner类中的close()

### 1.1.2 示例代码

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 布尔类型
        Boolean isSingle = scanner.nextBoolean();
        
        // 单字符类型
        char sex = scanner.next().charAt(0);
        
        // 字符串
        String name = scanner.next();
        
        scanner.close();
    }
}
```

## 1.2 Switch语句

### 1.2.1 基本语法

```java
switch (表达式) {
    case a: {
        // 命令语句
    }
    case b: {
        // 命令语句
    }
    case c: {
        // 命令语句
    }
    default: {
        // 默认语句
    }
}
```

### 1.2.2 Switch的穿透

当表达式符合某个case,但是语句中没有break时,其余的所有case和default都会执行,除非执行完或遇见break。

## 1.3 数组

### 1.3.1 一维数组

数组是一种存储多个相同类型元素的集合。

#### 1.3.1.1 数组的声明

```java
int[] arr = new int[10]; // 声明一个长度为10的int型数组
```

#### 1.3.1.2 数组的初始化

```java
int[] arr = {1, 2, 3, 4, 5}; // 声明并初始化一个int型数组
```

#### 1.3.1.3 数组的访问

```java
arr[0] = 10; // 访问数组的第一个元素
```

#### 1.3.1.4 数组的遍历

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

#### 1.3.1.5 数组的拷贝

```java
int[] arr2 = Arrays.copyOf(arr, arr.length); // 使用Arrays类中的copyOf方法拷贝数组
```

#### 1.3.1.6 数组的排序

```java
Arrays.sort(arr); // 使用Arrays类中的sort方法对数组进行排序
```

#### 1.3.1.7 数组的查找

```java
int index = Arrays.binarySearch(arr, 3); // 使用Arrays类中的binarySearch方法查找数组中的元素
```

### 1.3.2 二维数组

二维数组是指数组中的元素是另一个数组,也称为二维矩阵。

#### 1.3.2.1 创建二维数组

```java
数据类型[][] 数组名 = new 数据类型[行数][列数];
```

例如:

```java
int[][] arr = new int[3][4];
```

上述代码创建了一个3行4列的二维数组。

#### 1.3.2.2 二维数组的初始化

```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        arr[i][j] = i * j;
    }
}
```

#### 1.3.2.3 二维数组的访问

```java
arr[0][1] = 5;
```

上述代码将二维数组arr的第一行第二列的值设置为5。

### 1.3.3 一维数组的内存解析

#### 1.3.3.1 Java中的内存结构

将内存区域划分为五个部分:程序计数器、虚拟机栈、本地方法栈、堆、方法区

与数组相关的内存结构:

比如: `int[] arr = new int[]{1,2,3};`

- **虚拟机栈**:用于存放方法中声明的变量,比如arr
- **堆**:用于存放数组的实体,即数组中的所有元素,比如:1,2,3

## 1.4 获取随机数

### 1.4.1 使用Math.random()

导入java.Math,使用Math.random()方法可以获取[0.0,1.0)范围内的随机数。

### 1.4.2 获取指定范围的随机数

获取[a,b]之间的随机数:

**公式**: `(int)(Math.random() * (b - a + 1)) + a;`

---

# 2. 面向对象

## 2.1 接口(Interface)

### 2.1.1 接口定义

```java
interface 接口名 {
    // 常量
    // 抽象方法
}
```

### 2.1.2 接口特点

- 接口中的所有变量默认是 `public static final` 的,即常量
- 接口中的所有方法默认是 `public abstract` 的,即抽象方法
- 接口不能实例化对象
- 一个类可以实现多个接口,使用关键字 `implements`
- 接口可以继承多个接口,使用关键字 `extends`
- 接口中的方法没有方法体,必须由实现类来实现,同抽象类的抽象方法
- 接口可以包含默认方法(default)和静态方法(static),但不能包含实例方法
- 接口不能包含构造方法
- 接口可以包含私有方法(private),用于接口内部的代码复用

### 2.1.3 接口内部结构的说明

**可以声明:**

- 属性:必须使用 `public static final` 修饰
- 方法:
  - JDK8之前:声明抽象方法,修饰为 `public abstract`
  - JDK8:声明静态方法、默认方法
  - JDK9:声明私有方法

**不可以声明:**构造器、代码块等

### 2.1.4 接口和类的关系

#### 2.1.4.1 实现关系

格式:

```java
class 类名 extends SuperA implements 接口1, 接口2, ... {
    // 重写接口中的所有抽象方法
}
```

说明:

- 可以多实现
- A相较于Super来讲,叫做子类
- A相较于接口来讲,叫做实现类

#### 2.1.4.2 满足此关系之后的要求

- 类可以实现多个接口
- 类针对于接口的多实现,一定程度上弥补了Java单继承的局限性
- 类必须重写接口中的所有抽象方法,否则必须将类声明为抽象类

### 2.1.5 接口与接口的关系

继承关系,可以多继承

格式:

```java
interface 接口名1 extends 接口名A, 接口名B, ... {
    // ...
}
```

### 2.1.6 接口的多态性

接口类型的变量可以指向实现类对象:

```java
接口名 变量名 = new 实现类名();
```

接口类型的变量只能调用接口中声明的方法,体现了多态性。

### 2.1.7 接口对象的创建方式

1. 创建接口实现类的对象
2. 创建接口实现类的匿名对象
3. 创建接口匿名实现类的对象
4. 创建接口匿名实现类的匿名对象

### 2.1.8 接口和抽象类的区别

#### 2.1.8.1 相同点

- 都不能实例化对象
- 都可以包含抽象方法

#### 2.1.8.2 不同点

- 抽象类一定有构造器,接口没有构造器
- 类与类之间是继承关系,类与接口之间是实现关系

---

# 3. 常用API

## 3.1 包装类

### 3.1.1 包装类:基本数据类型对应的引用类型

### 3.1.2 包装类都有什么

```
int     -> Integer
long    -> Long
short   -> Short
byte    -> Byte
float   -> Float
double  -> Double
boolean -> Boolean
char    -> Character
```

### 3.1.3 包装类的作用

为了使得基本数据类型的变量具备引用数据类型变量的特征(比如:封装性、继承性、多态性),我们给各个基本数据类型都提供了包装类。

### 3.1.4 基本数据类型与包装类之间的转换

#### 3.1.4.1 为什么需要转换

一方面,在有些场景下需要使用基本数据类型对应的包装类的对象,此时就需要将基本数据类型转换为对应的包装类对象。比如:ArrayList的add方法要求的是Object类型的参数,而基本数据类型不能作为Object类型的参数。

另一方面,在有些场景下需要使用基本数据类型,此时就需要将包装类对象转换为基本数据类型。

#### 3.1.4.2 基本数据类型与包装类之间的转换

**基本数据类型 -> 包装类:**

1. 使用包装类的构造器
2. 建议使用包装类的valueOf()方法

**包装类 -> 基本数据类型:**

1. 调用包装类的xxxValue()方法

**自动装箱:**将基本数据类型转换为包装类对象

**自动拆箱:**将包装类对象转换为基本数据类型

### 3.1.5 String与基本数据类型、包装类之间的转换

(内容保留原文档相关部分)

### 3.1.6 重点:包装类缓存对象

| 包装类      | 缓存对象                |
| ----------- | ----------------------- |
| Byte        | -128 ~ 127              |
| Short       | -128 ~ 127              |
| Integer     | -128 ~ 127              |
| Long        | -128 ~ 127              |
| Float       | 没有缓存对象            |
| Double      | 没有缓存对象            |
| Boolean     | true, false             |
| Character   | \u0000 ~ \u007F         |

案例:

```java
Integer m = 1;
Integer n = 1;
System.out.println(m == n); // true

Integer x = 128;
Integer y = 128;
System.out.println(x == y); // false
```

## 3.2 String类

### 3.2.1 String类的理解

#### 3.2.1.1 类的声明

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence
```

说明:

- `final`:String类是不可以被继承的
- `Serializable`:可序列化的接口。凡是实现此接口的对象就可以通过网络或本地流进行数据的传输
- `Comparable<String>`:凡是实现此接口的类,其对象都可以比较大小
- `CharSequence`:字符序列接口

#### 3.2.1.2 内部声明的属性

**JDK8中:**

```java
private final char value[];
```

说明:

- 字符串真正存储数据的容器,本质上是字符的数组(类似于C++)
- `final`:指明此value一旦被初始化,其地址就不可变了

**JDK9及以后:**

```java
private final byte[] value;
```

说明:

- 官方的说法:大多数的String对象都包含的是Latin-1类型,只需要一个字节就可以存储了,所以如果是Latin-1类型就使用一个字节来存储,若是汉字之类的,则就使用两个字节来存储
- 本质上:为了节省内存空间,做了优化

#### 3.2.1.3 字符串常量存储的位置

- 字符串常量都存储在字符串常量池(StringTable)中
- 字符串常量池中不允许存放两个相同的常量
- 字符串常量池在不同的JDK版本中存放的位置不同:
  - JDK7之前:存放在方法区中
  - JDK7及以后:存放在堆空间中

#### 3.2.1.4 String的不可变性的理解

1. 当对字符串变量重新赋值时,需要重新指定一个字符串常量的位置进行赋值,不能在原有的位置修改
2. 当对现有的字符串进行拼接操作时,需要重新开辟一个内存空间,不能直接对原有值进行修改
3. 当调用字符串的replace方法来替换现有的某个字符时,需要重新开辟空间保存修改以后的字符串,不能在原有的位置修改

#### 3.2.1.5 String实例化的两种方式

1. `String s1 = "hello";`
2. `String s2 = new String("hello");`

**问题:`String s2 = new String("hello");` 创建了几个对象?**

两个对象:

- 一个是在堆空间中new的对象
- 另一个是在字符串常量池中生成的字面量

#### 3.2.1.6 String的连接操作

- **情况一**:常量 + 常量 → 结果仍然存储在字符串常量池中
- **情况二**:常量 + 变量 / 变量 + 变量 → 都会new,创建一个新的字符串,返回字符串对象的地址
- **情况三**:调用字符串的 `intern()` → intern方法返回的是字符串常量池中字面值的地址
- **情况四**:了解:`concat()` → 不管是常量调用此方法还是变量调用,同样不管参数是常量还是变量,总之调用完此方法都返回了一个新new的对象

### 3.2.2 String类的常用方法

#### 3.2.2.1 构造器

- `public String()`
- `public String(String original)`
- `public String(char[] value)`
- `public String(char[] value, int offset, int count)`
- `public String(byte[] bytes)`
- `public String(byte[] bytes, String charsetName)`

#### 3.2.2.2 一般方法(比较等)

- `boolean isEmpty()`:字符串是否为空
- `int length()`:返回字符串的长度
- `String concat(xx)`:拼接
- `boolean equals(Object obj)`:比较字符串是否相等,区分大小写
- `boolean equalsIgnoreCase(Object obj)`:比较字符串是否相等,不区分大小写
- `int compareTo(String other)`:比较字符串大小,区分大小写,按照Unicode编码值比较大小
- `int compareToIgnoreCase(String other)`:比较字符串大小,不区分大小写
- `String toLowerCase()`:将字符串中大写字母转为小写
- `String toUpperCase()`:将字符串中小写字母转为大写
- `String trim()`:去掉字符串前后空白符
- `public String intern()`:结果在常量池中共享

#### 3.2.2.3 查找

- `boolean contains(xx)`:是否包含xx
- `int indexOf(xx)`:从前往后找当前字符串中xx,即如果有返回第一次出现的下标,要是没有返回-1
- `int indexOf(String str, int fromIndex)`:返回指定子字符串在此字符串中第一次出现处的索引,从指定的索引开始
- `int lastIndexOf(xx)`:从后往前找当前字符串中xx,即如果有返回最后一次出现的下标,要是没有返回-1
- `int lastIndexOf(String str, int fromIndex)`:返回指定子字符串在此字符串中最后一次出现处的索引,从指定的索引开始反向搜索

#### 3.2.2.4 截取字符串

- `String substring(int beginIndex)`:返回一个新的字符串,它是此字符串的从beginIndex开始截取到最后的一个子字符串
- `String substring(int beginIndex, int endIndex)`:返回一个新字符串,它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串

#### 3.2.2.5 与数组有关

- `char charAt(index)`:返回index位置的字符
- `char[] toCharArray()`:将此字符串转换为一个新的字符数组返回
- `static String valueOf(char[] data)`:返回指定数组中表示该字符序列的String
- `static String valueOf(char[] data, int offset, int count)`:返回指定数组中表示该字符序列的String
- `static String copyValueOf(char[] data)`:返回指定数组中表示该字符序列的String
- `static String copyValueOf(char[] data, int offset, int count)`:返回指定数组中表示该字符序列的String
- `boolean startsWith(xx)`:测试此字符串是否以指定的前缀开始
- `boolean startsWith(String prefix, int toffset)`:测试此字符串从指定索引开始的子字符串是否以指定前缀开始
- `boolean endsWith(xx)`:测试此字符串是否以指定的后缀结束

#### 3.2.2.6 替换

- `String replace(char oldChar, char newChar)`:返回一个新的字符串,它是通过用newChar替换此字符串中出现的所有oldChar得到的。不支持正则
- `String replace(CharSequence target, CharSequence replacement)`:使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
- `String replaceAll(String regex, String replacement)`:使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
- `String replaceFirst(String regex, String replacement)`:使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串

### 3.2.3 String、StringBuffer、StringBuilder

#### 3.2.3.1 三个类的对比

- **String**:不可变的字符序列
- **StringBuffer**:可变的字符序列,JDK1.0声明,线程安全,效率低
- **StringBuilder**:可变的字符序列,JDK5.0声明,线程不安全,效率高

**共同点**:底层使用 `char[]`(JDK8及之前),底层使用 `byte[]`(JDK9及以后)

#### 3.2.3.2 StringBuffer/StringBuilder的可变性分析

**对于String:**

```java
String s1 = new String(); 
// char[] value = new char[0];
String s2 = new String("abc"); 
// char[] value = new char[]{'a','b','c'};
```

**针对于StringBuilder来说:**

内部的属性:

```java
char[] value;    // 存储字符序列
int count;       // 实际存储的字符的个数

// 初始化便拥有16个字符的长度,用来以后增加字符
StringBuilder sBuffer1 = new StringBuilder();
// char[] value = new char[16]
StringBuilder sBuffer2 = new StringBuilder("abc");
// char[] value = new char[16 + "abc".length]

sBuffer1.append("ac");    // value[0] = 'a', value[1] = 'c'
sBuffer1.append("b");     // value[2] = 'b'

// 但不断地添加字符,一旦count要超过value.length时,就需要扩容,默认扩容为原有容量的2倍+2,并将原来的value数组中的元素复制到新的数组中
```

#### 3.2.3.3 选择

- 如果开发中需要频繁地针对于字符串进行增删改等操作,建议使用StringBuffer/StringBuilder来替换String,因为使用String效率低
- 如果开发中不涉及到线程安全问题,建议使用StringBuilder来替换StringBuffer,因为使用StringBuilder效率高
- 如果开发中大体确定要操作的字符的个数,建议使用带int capacity参数的构造器,因为可以避免底层多次扩容操作,性能更高

#### 3.2.3.4 StringBuilder/StringBuffer中常用的方法

**方法列表:**

- `StringBuffer append(xx)`:提供了很多的append()方法,用于进行字符串追加的方式拼接
- `StringBuffer delete(int start, int end)`:删除[start,end)之间字符
- `StringBuffer deleteCharAt(int index)`:删除[index]位置字符
- `StringBuffer replace(int start, int end, String str)`:替换[start,end)范围的字符序列为str
- `void setCharAt(int index, char c)`:替换[index]位置字符
- `char charAt(int index)`:查找指定index位置上的字符
- `StringBuffer insert(int index, xx)`:在[index]位置插入xx
- `int length()`:返回存储的字符数据的长度
- `StringBuffer reverse()`:反转

**操作分类:**

- **增**:`append(xx)`
- **删**:`delete(int start, int end)`、`deleteCharAt(int index)`
- **改**:`replace(int start, int end, String str)`、`setCharAt(int index, char c)`
- **查**:`charAt(int index)`
- **插**:`insert(int index, xx)`
- **长度**:`int length()`
- **翻转**:`reverse()`

## 3.3 日期时间类

### 3.3.1 总结与概述

1. **Date**:一般只用于存储当前时间,格式不美观

```java
Date now = new Date();
System.out.println(now); // Sat Jun 14 10:30:00 CST 2025
```

2. **SimpleDateFormat**:格式化显示时间,美观,可以和String互相转换

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date now = new Date();
String time = sdf.format(now);
```

常见的格式:

- yyyy → 年(2025)
- MM   → 月(06)
- dd   → 日(14)
- HH   → 时(10)24小时制
- mm   → 分(30)
- ss   → 秒(00)

3. **Calendar**:对时间进行操作

### 3.3.2 JDK8之前的日期时间API

#### 3.3.2.1 System类中的currentTimeMillis()

获取当前时间对应的毫秒数,long类型,时间戳

- 当前时间与1970年1月1日0时0分0秒之间的毫秒数
- 常用来计算时间差

#### 3.3.2.2 Date类

**类层次结构:**

- `java.util.Date`
  - 两个构造器的使用
  - 两个方法的使用:`toString()`方法、`long getTime()`:获得毫秒数
  - `java.sql.Date`:对应着数据库中的date类,只有一个带参数的构造器

```java
@Test
public void test01() {
    Date date1 = new Date();        // 创建一个基于当前系统时间的Date实例
    System.out.println(date1.toString()); // Sat Nov 08 18:04:21 CST 2025
    long milliTimes = date1.getTime();      // 对应的毫秒数为: 1762596261612
    System.out.println("对应的毫秒数为: " + milliTimes);

    Date date2 = new Date(1762595931658L); // 创建基于时间戳的Date实例
    System.out.println(date2.toString());   // Sat Nov 08 17:58:51 CST 2025
}
```

```java
@Test
public void test02() {
    java.sql.Date date1 = new java.sql.Date(1762595931658L);
    System.out.println(date1.toString());   // 2025-11-08

    System.out.println(date1.getTime());    // 1762595931658
}
```

#### 3.3.2.3 SimpleDateFormat:可以自定义格式的类

SimpleDateFormat类:用于日期时间的格式化和解析

- **格式化**:日期 → 字符串
- **解析**:字符串 → 日期

```java
@Test
public void test03() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat();
    // 格式化:日期 → 字符串
    Date date1 = new Date();
    String strDate = sdf.format(date1);
    System.out.println(strDate);        // 2025/11/8 18:09

    // 解析:字符串 → 日期
    Date date2 = sdf.parse("2025/11/8 18:09");
    System.out.println(date2);
}
```

```java
/**
 * 使用自己规定的格式
 */
@Test
public void test04() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    // 格式化:日期 → 字符串    
    // 规定时间格式为: EEE, d MMM yyyy HH:mm:ss Z
    sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date1 = new Date();
    String strDate = sdf.format(date1);
    System.out.println(strDate);        
    // EEE, d MMM yyyy HH:mm:ss Z  → 周六, 8 11月 2025 18:14:04 +0800
    // yyyy-MM-dd hh:mm:ss   → 2025-11-08 06:16:05

    // 解析:字符串 → 日期    
    Date date2 = sdf.parse("2025-11-08 06:16:05");
    // 只能传yyyy-MM-dd hh:mm:ss格式,别的格式识别不了

    System.out.println(date2);         
    // Sat Nov 08 06:16:05 CST 2025
}
```

#### 3.3.2.4 Calendar

**Calendar:日历类**

1. **实例化**:由于Calendar是一个抽象类,所以我们需要创建其子类的实例,这里我们通过Calendar的静态方法 `getInstance()` 即可获取
2. **常用方法**:`get(int field)` / `set(int field, xx)` / `add(int field, xx)` / `getTime()` / `setTime()`

```java
@Test
public void test05() {
    // 实例化
    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getClass());        
    // class java.util.GregorianCalendar

    // 测试方法
    // get(int field)
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH) + "天");     // 这个月的第8天
    System.out.println("今年的第" + calendar.get(Calendar.DAY_OF_YEAR) + "天");          // 今年的第312天

    // set(int field, xx)
    calendar.set(Calendar.DAY_OF_MONTH, 23);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH) + "天");    // 这个月的第23天

    // add(int field, xx)
    calendar.add(Calendar.DAY_OF_MONTH, 3);
    calendar.add(Calendar.DAY_OF_MONTH, -5);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH) + "天");    // 这个月的第21天  (加了三天,又减了五天)

    // getTime()
    System.out.println(calendar.getTime());     // Fri Nov 21 18:42:24 CST 2025,返回的是Date类

    // setTime():使用指定的Date重置Calendar
    Date date1 = new Date();
    calendar.setTime(date1);
    System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH) + "天");    // 相当于重置了,还是第8天
}
```

### 3.3.3 JDK8及以后的日期时间API

#### 3.3.3.1 本地日期时间:LocalDate、LocalTime、LocalDateTime

类似于Calendar

- **实例化**:`now()` / `of(xx, xx, xx)`
- **方法**:`get()` / `withXxx()` / `plusXxx()` / `minusXxx()`

#### 3.3.3.2 Instant:瞬时、时间戳

类似于Date

- **实例化**:`now()` / `ofEpochMilli()`
- **方法**:`toEpochMilli()`

#### 3.3.3.3 DateTimeFormatter

类似于SimpleDateFormat

用于格式化和解析LocalDate、LocalTime、LocalDateTime

## 3.4 比较器

### 3.4.1 实现对象的排序

可以考虑两种方式:自然排序、定制排序

### 3.4.2 方式一 - 自然排序:实现Comparable接口的方式

**实现步骤:**

1. 具体的类A实现Comparable接口
2. 重写Comparable接口中的compareTo(Object obj)方法,在此方法中指明比较类A的对象的大小的标准
3. 创建类A的多个实例,进行大小的比较或排序

### 3.4.3 方式二 - 定制排序:java.util.Comparator

**实现步骤:**

1. 创建一个实现了Comparator接口的实现类
2. 实现类要求重写Comparator接口中的抽象方法compare(Object o1, Object o2),在此方法中指明要比较大小的对象的大小关系(比如:String类、Product类)
3. 创建此实现类A的对象,并将此对象传入到相关方法的参数位置即可(比如:Arrays.sort(..., 类A的实例))

### 3.4.4 对比两种方式

**角度一:**

- 自然排序:单一的、唯一的
- 定制排序:灵活的、多样的

**角度二:**

- 自然排序:一劳永逸
- 定制排序:临时的

**细节:**

- 自然排序:对应的接口是Comparable,对应的抽象方法:compareTo(Object obj)
- 定制排序:对应的接口是Comparator,对应的抽象方法:compare(Object o1, Object o2)

---

# 4. 集合框架

## 4.1 集合框架概述

### 4.1.1 数组存储多个数据方面的特点

**数组的特点:**

- 数组一旦初始化,其长度就是确定的
- 数组中的多个元素是依次紧密排序的,有序的,可重复的
- **优点**:数组一旦初始化完成,其元素的类型就是确定的,不是此类型的元素就不能添加到此数组中
- 元素的类型可以是基本数据类型,也可以是引用数据类型

**数组存储多个数据方面的弊端:**

- 数组一旦初始化,其长度就不可变了
- 数组中存储数据特点的单一性。对于无序的、不可重复的常见的多个数据就无能为力了
- 数组中可用的方法、属性都极少。具体的需求都需要自己来组织相关的代码逻辑
- 针对于数组中元素的删除、插入操作,性能较差

### 4.1.2 Java集合框架体系(java.util包下)

**java.util.Collection**:存储一个一个的数据

- **子接口List**:存储有序的、可重复的数据(动态数组)
  - ArrayList(主要实现类)、LinkedList、Vector
- **子接口Set**:存储无序的、不可重复的数据(高中学习的集合)
  - HashSet(主要实现类)、LinkedHashSet、TreeSet

**java.util.Map**:存储一对一对的数据(key-value键值对,(x1,y1), (x2,y2) → y = f(x),类似于高中的函数)

- HashMap(主要实现类)、LinkedHashMap、TreeMap、Hashtable、Properties

## 4.2 Collection接口

### 4.2.1 Collection常用方法

```java
// 添加单个元素
add(Object obj)

// 添加other集合中的所有元素对象到当前集合中,即this = this ∪ other
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

// 从当前集合中删除两个集合中不同的元素,仅保留当前集合与coll集合的交集,即this = this ∩ coll
retainAll(Collection coll)

// 删除所有元素
clear()

// 从当前集合中删除第一个找到的与obj对象equals返回true的元素
remove(Object obj)

// 删除所有与coll集合中相同的元素
removeAll(Collection coll)

// 返回当前集合的哈希值
hashCode()

// 将当前集合转换为数组
toArray()

// 返回当前集合的迭代器
iterator()
```

### 4.2.2 集合和数组之间的相互转换

- 集合 → 数组:`toArray()`
- 数组 → 集合:调用Arrays的静态方法`asList()`

### 4.2.3 向Collection中添加元素的要求

要求元素所属的类一定要重写equals()

**原因:**因为Collection中的相关方法(比如contains()/remove())在使用时,要调用元素所在类的equals()

### 4.2.4 迭代器

#### 4.2.4.1 迭代器的作用(Iterator)

用来遍历集合元素的。

#### 4.2.4.2 如何获取迭代器对象

```java
Iterator iterator = collection.iterator();
```

#### 4.2.4.3 如何实现遍历

```java
while(iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

#### 4.2.4.4 增强for循环的使用(foreach,JDK5新特性)

**格式:**

```java
for (元素类型 元素变量 : 集合或数组) {
    // 使用元素变量
}
```

## 4.3 HashMap

### 4.3.1 初始化

#### 4.3.1.1 方法一:后续需要再一个个添加

```java
HashMap<数据类型, 数据类型> 名称 = new HashMap<>(length); 
```

说明:length选填

#### 4.3.1.2 方法二:初始化时便直接放入数据

```java
HashMap<数据类型, 数据类型> 名称 = new HashMap<>(Map.of(可以放元素,全部用逗号隔开即可)); 
```

### 4.3.2 添加元素

```java
名称.put(key(键), value(值));
```

说明:如果此键已有值,则会返回旧值并更新为新值。

```java
名称.putIfAbsent(key, value)
```

说明:该方法会判断key是否存在,如果存在且value不为空,则只会返回原来的value,否则会put进新值,并返回null。

### 4.3.3 删除元素

```java
remove(key) // 删除成功,则会返回被删除的key对应的value,否则返回null
```

```java
remove(key, value) // 删除成功,返回true,否则返回false
```

### 4.3.4 获取元素

```java
map.get("key");
```

说明:获取key对应的value

```java
map.getOrDefault("key", "value");

// 常见方法:统计字符频率
Map<Character, Integer> map = new HashMap<>();
for (char c : "Hello".toCharArray()) {
    map.put(c, map.getOrDefault(c, 0) + 1);
}
```

说明:如果map中key对应的值不为null,则返回key对应的值,如果为null,则返回第二个参数value(默认值)

### 4.3.5 一些其他的用法

#### 4.3.5.1 检查方法

```java
boolean result = map.containsKey(key);
```

说明:返回值为boolean,检查map中是否有指定的key键,true → 存在,false → 不存在。

#### 4.3.5.2 条件更新方法

```java
// replace -- 替换已存在的键的值
map.replace("key", "value");
// replace(key, oldValue, newValue),仅当键值都匹配时才会替换为newValue
map.replace("key", "oldValue", "newValue");
```

#### 4.3.5.3 遍历方法

```java
// 遍历键值对
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    System.out.println(key + ": " + value);
}

// 只遍历键
for (String key : map.keySet()) {
    System.out.println(key);
}

// 只遍历值
for (Integer value : map.values()) {
    System.out.println(value);
}

// 使用Lambda表达式(Java 8+)
map.forEach((key, value) -> {
    System.out.println(key + ": " + value);
});
```

#### 4.3.5.4 将两个map合并

```java
map1.putAll(map2); // 将map2合并至map1中,注意map2本身并不会改变
```

## 4.4 栈(Stack)

### 4.4.1 实例化

```java
import java.util.Stack;
Stack<Integer> stack = new Stack<Integer>();
```

说明:<>中的内容是数据类型,如:Character

### 4.4.2 常见方法

说明:Stack类继承于Vector类,所以包含有Vector中的所有方法。

```java
// 判断是否为空
stack.empty();

// 取出栈顶值,不出栈
stack.peek();

// 进栈
stack.push(object); 

// 出栈
stack.pop();

// 搜索,返回对象在堆栈中的位置,以1为基数,注意不是0
stack.search(object)
```

## 4.5 ArrayList(不定长度数组)

### 4.5.1 什么是ArrayList

ArrayList是动态数组,解决了普通数组在定义时长度被限制了的缺点。

**适用情况:**当你不知道这个数组中有多少元素。

### 4.5.2 初始化

```java
import java.util.ArrayList;
ArrayList<String> arr = new ArrayList<>();
// 说明:<>中填写数据类型,普通数据类型要使用其泛型:int -> Integer ...
ArrayList<Integer> arrNum = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
// 也可以这样在初始化时就添加元素
```

### 4.5.3 增删元素

```java
// 在末尾添加
arr.add("橘子"); // arr = {"橘子"}
arr.add("香蕉"); // arr = {"橘子", "香蕉"}

// 在指定位置添加元素
arr.add(1, "苹果");

// 添加整个集合,到末尾
ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("橙子"));
arr.addAll(arr1); // arr = {"橘子", "苹果", "香蕉", "橙子"}

// remove(Object o) - 删除第一次出现的指定元素,返回是否成功
arr.remove("橘子"); // arr = {"苹果", "香蕉", "橙子"}

// remove(int index) - 删除指定位置的元素,返回被删除的元素
arr.remove(0);

// removeAll(Collection c) - 删除集合中的所有元素
arr.removeAll(Arrays.asList("葡萄", "橙子"));

// clear() - 清空所有元素
arr.clear();
```

### 4.5.4 访问元素

```java
// get(int index) - 获取指定位置的元素
arr.get(0);

// indexOf(Object obj) - 返回第一次出现的索引,不存在返回-1
arr.indexOf(obj);
arr.indexOf("橙子");

// lastIndexOf(Object obj) - 返回最后一次出现的索引
arr.lastIndexOf(obj);
arr.lastIndexOf("橙子");
```

### 4.5.5 修改元素

```java
// set(int index, E e) - 替换指定位置的元素
arr.set(1, "西瓜");
```

### 4.5.6 检查操作

```java
// size() - 返回元素个数
int size = arr.size();

// isEmpty() - 判断是否为空
boolean empty = arr.isEmpty();

// contains(Object o) - 判断是否包含指定元素
boolean contains = arr.contains("苹果");

// containsAll(Collection c) - 判断是否包含指定集合的所有元素
boolean containsAll = arr.containsAll(Arrays.asList("苹果", "橘子"));
```

### 4.5.7 转换操作

```java
// toArray() - 转换为数组
arr.toArray();

// toArray(T[] a) - 转换为指定类型的数组
String[] array2 = arr.toArray(new String[0]);
```

### 4.5.8 浅拷贝

```java
// clone() - 浅拷贝
ArrayList<Integer> cloned = (ArrayList<Integer>) arr.clone();
```

---

