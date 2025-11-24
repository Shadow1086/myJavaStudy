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
2. 角度二：

 - 自然排序：一劳永逸
 - 定制排序：临时的
3. 细节：

 - 自然排序：对应的接口是Comparable，对应的抽象方法：compareTo(Object obj)
 - 定制排序：对应的接口是Comparator，对应的抽象方法：compare(Object o1,Object o2)



#  5. 集合框架

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

集合 -----> 数组：toArray()
数组 -----> 集合：调用Arrays的静态方法asList()

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

## 6.1 File 类的实例化和常用方法

### 6.1.1 什么是 File 类？

> File 类位于 `java.io` 包下，File 类的一个对象，对应着操作系统的一个文件或一个文件目录。

### 6.1.2 内部 API 的使用说明

#### 构造器

- `public File(String pathname)`：以 pathname 为路径创建 File 对象，可以是绝对路径或者相对路径，如果 pathname 是相对路径，则默认的当前路径在系统属性 user.dir 中存储
- `public File(String parent, String child)`：以 parent 为父路径，child 为子路径创建 File 对象
- `public File(File parent, String child)`：根据一个父 File 对象和子文件路径创建 File 对象

#### 常用方法

##### 1. 获取文件和目录基本信息

- `public String getName()`：获取名称
- `public String getPath()`：获取路径
- `public String getAbsolutePath()`：获取绝对路径
- `public File getAbsoluteFile()`：获取绝对路径表示的文件
- `public String getParent()`：获取上层文件目录路径。若无，返回 null
- `public long length()`：获取文件长度（即：字节数）。不能获取目录的长度
- `public long lastModified()`：获取最后一次的修改时间，毫秒值

##### 2. 列出目录的下一级

- `public String[] list()`：返回一个 String 数组，表示该 File 目录中的所有子文件或目录
- `public File[] listFiles()`：返回一个 File 数组，表示该 File 目录中的所有的子文件或目录

##### 3. File 类的重命名功能

- `public boolean renameTo(File dest)`：把文件重命名为指定的文件路径

##### 4. 判断功能的方法

- `public boolean exists()`：此 File 表示的文件或目录是否实际存在
- `public boolean isDirectory()`：此 File 表示的是否为目录
- `public boolean isFile()`：此 File 表示的是否为文件
- `public boolean canRead()`：判断是否可读
- `public boolean canWrite()`：判断是否可写
- `public boolean isHidden()`：判断是否隐藏

##### 5. 创建、删除功能

- `public boolean createNewFile()`：创建文件。若文件存在，则不创建，返回 false
- `public boolean mkdir()`：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
- `public boolean mkdirs()`：创建文件目录。如果上层文件目录不存在，一并创建
- `public boolean delete()`：删除文件或者文件夹

**删除注意事项：**

- Java 中的删除不走回收站
- 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录























