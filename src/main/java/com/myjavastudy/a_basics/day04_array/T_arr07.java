package com.myjavastudy.a_basics.day04_array;

import java.util.Scanner;

//二分查找
//例子：猜数字
public class T_arr07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("输入1~100之间的数字：");
        final int numFinal = input.nextInt();           //目标数字


        int left = 1, right = 100;
        while (left <= right) {
            int mid = (left + right) / 2;
            //猜对了
            if (mid == numFinal) {
                System.out.println( mid + "\t恭喜你 猜对了");
                break;
            }
            //猜大了
            if (mid > numFinal) {
                right = mid - 1;
                System.out.println(mid + "\t猜大了");
            }
            //猜小了
            if(mid<numFinal){
                System.out.println(mid + "\t猜小了");
                left = mid + 1;
            }
        }
    }
}
