package com.myjavastudy.a_basics.day05_array_advanced;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:数组缩容
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */

//{1,2,3,4,5,6,7},现需删除数组中索引为4的元素
public class ArrayExer03 {
    //方法一：创建一个新的数组，将原数组的值赋值给新数组
    public static void test1() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        int deleteIndex = 4;
        int[] newarr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (i < deleteIndex) {
                newarr[i] = arr[i];
            } else {
                newarr[i] = arr[i + 1];
            }
        }
        for (int num : newarr) {
            System.out.print(num + "\t");
        }
    }

    //方法二
    public static void test2() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        int deleteIndex = 4;
        for (int i = deleteIndex; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i + 1];
            }

        }
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }
}
