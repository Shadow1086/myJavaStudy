package com.myjavastudy.a_basics.day03_nested_loop;

import java.util.Scanner;

//金字塔问题

public class T_forTwice01 {
    public static void main(String[] args) {
        //金字塔：每行有2n-1个 * ，
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入金字塔高度：");
        int num = scan.nextInt();
        //确定金字塔行数
        for (int i = 0; i < num; i++) {
            for (int m = num - 1 - i; m >= 0; m--) {      //打印空格
                System.out.print(" ");
            }
            for (int n = 0; n <= (2*i); n++) {               //打印*
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
