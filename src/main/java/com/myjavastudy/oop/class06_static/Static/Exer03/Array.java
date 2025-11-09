package com.myjavastudy.oop.class06_static.Static.Exer03;

/**
 * ClassName: Array
 * Package: Class06.Static.Exer03
 * Description:
 * <p>
 * 工具类-----数组
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/8 20:37
 * {@code @Version} 1.0
 */

public class Array {
    /**
     * 利用冒泡进行排序
     *
     * @param arr 数组
     * @return 排完序之后的数组 !!!!的地址
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 求数组最大值
     *
     * @param arr 数组
     */
    public static void maxArr(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println("最大值为：" + max + "\n最大值索引：" + index);
    }

    /**
     * 求数组最小值
     *
     * @param arr 数组
     */
    public static void minArr(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("最小值为：" + min + "\n最小值索引：" + index);
    }

    /**
     * 求总和
     *
     * @param arr 数组
     * @return 总和
     */

    public static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 求平均值
     *
     * @param arr 数组
     * @return 平均值
     */
    public static double averageArr(int[] arr) {
        int sum = sumArr(arr);
        return ((double) sum / arr.length);
    }

    /**
     * 将数组倒叙
     *
     * @param arr 数组
     * @return 倒叙后的数组
     */
    public static int[] inversionArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    /**
     * 寻找用户输入的数字
     *
     * @param num 目标数字
     * @param arr 处理数组
     * @return 若存在则返回索引。不存在返回-1
     */
    public static int findArr(int num, int[] arr) {
        sort(arr);
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == num){
                return mid;
            }
            if (arr[(left + right) / 2] < num) {
                right = (left + right) / 2 - 1;
            } else if (arr[(left + right) / 2] > num) {
                left = (left + right) / 2 + 1;
            }
        }
        return -1;
    }


}
