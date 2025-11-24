package com.myjavastudy.a_basics.day05_array_advanced;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:数组反转存储的三种方法
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
//实现数组元素的反转存储
public class ArrayExer01 {
    //方法一
    public static void test1() {
        int[] arr = new int[]{34, 54, 3, 2, 65, 7, 34, 5, 76, 34, 67};
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    //方法二：开辟了新的内存空间不推荐
    public static void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr.length - i - 1] = arr[i];
        }
        for (int num : newArr) {
            System.out.print(num + "\t");
        }
    }

    //方法三:双指针，极其推荐
    public static void test3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        //双指针向中间靠拢,注意终止条件，不能是i!=j,需要看数组元素个数是奇数还是偶数
        for (int i = 0, j = arr.length - 1; i < j ; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        test3();
    }
}
