package com.myjavastudy.basics.day01_flowcontrol;

import java.util.Scanner;
//switch的穿透：
//case后不加break；
//2018年给定日期，求这是多少天

public class T_switch02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = input.nextInt();

        System.out.println("请输入天数：");
        int day = input.nextInt();
        int sum = 0;
        switch (month) {
            case 12: sum += 30;
            case 11: sum += 31;
            case 10: sum += 30;
            case 9: sum += 31;
            case 8: sum += 31;
            case 7: sum += 30;
            case 6: sum += 31;
            case 5: sum += 30;
            case 4: sum += 31;
            case 3: sum += 29;
            case 2: sum += 31;
            case 1: sum += day;
        }
        System.out.println(month + "月"+ day+ "日是2018年的第" + sum  + "天");
    }
}
