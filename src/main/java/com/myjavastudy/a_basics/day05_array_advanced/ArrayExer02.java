package com.myjavastudy.a_basics.day05_array_advanced;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:数组扩容
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
//现有数组{1, 2, 3, 4, 5};将数组长度扩容一倍，并添加10，20，30

public class ArrayExer02 {
    public static void test1() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        //扩容一倍
//        int[] newArr = new int[arr.length * 2];
        int[] newArr = new int[arr.length << 1];
        //将原有数组元素赋值给新的数组
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        //添加元素，一个个写
        newArr[arr.length] = 10;
        newArr[arr.length + 1] = 20;
        newArr[arr.length + 2] = 30;

        //将原本的数组释放掉，垃圾回收器会处理掉原来的数组
        arr = newArr;
        for (int num : arr) {
            System.out.print(num + "\t");
        }

    }

    public static void main(String[] args) {
        test1();
    }
}
