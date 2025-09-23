# day04：关于数组的知识点的讲解

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

关于文件里各个文件的内容：
- explain.md：本文件，主要讲解数组的知识点。
- T_arr01:数组的声明与赋值。
- T_arr02:例题，输入五个学生的成绩，输出其中最高分和最低分。
- T_arr03:数组的排序。使用了Arrays类中的sort方法。
- T_arr04:例题：摘苹果。利用了排序，数组的直接赋值，以及增强for循环的使用。
- T_arr05:数组的插入数据。分为三步骤：1.找位置，循环找位置。2.元素后移，倒着移动。3.重新赋值。
- T_arr06:数组的删除数据。