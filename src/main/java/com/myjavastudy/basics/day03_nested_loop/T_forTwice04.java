package com.myjavastudy.basics.day03_nested_loop;

import java.util.Scanner;

//求 1 × 1 × 1 × 1 + 2 × 2 ×2 × 2 + 3 × 3 × 3 × 3 + ・・・+ n×n×n×n 的和是多少？

public class T_forTwice04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int sum = 0;          //加的和
        int sum1 = 1;           //乘的积
        for (int i = 1; i <= num; i++) {
            for (int n = 1; n <= 4; n++) {
                sum1 *= i;
            }
            sum += sum1;
            sum1 = 1;
        }
        System.out.println("结果为：" + sum);

    }
}
