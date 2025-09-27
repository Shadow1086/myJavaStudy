package java001.day04_arr;

import java.util.Scanner;

//数组的赋值以及排序（求最大值最小值）
public class T_arr02 {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }
        for (int m = 0; m < (a.length - 1); m++) {
            for (int n = m + 1; n < a.length; n++) {
                if (a[m] > a[n]) {
                    int temp = a[m];
                    a[m] = a[n];
                    a[n] = temp;
                }
            }
        }
        System.out.println("最大成绩为：" + a[a.length - 1]);
        input.close();
    }
}
