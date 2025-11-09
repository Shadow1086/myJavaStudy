package com.myjavastudy.basics.day07_utils;

import java.util.Scanner;
import java.util.Arrays;

//使用Scanner获取不同类型数据的步骤：
//1.导入import java.util.Scanner
//2.提供或创建一个Scanner类的实例
//3.调用Scanner类中的方法，获取指定类型的变量
//4.关闭资源，调用Scanner类中的close（）

//案例L:要求录入个人相关信息：网名，年龄，单身情况,体重，性别
public class T_Scanner01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入网名：");
        String name = input.next();

        System.out.println("请输入年龄：");
        int age = input.nextInt();

        System.out.println("请输入体重：");
        int weight = input.nextInt();

        System.out.println("你是否单身（单身：true，不单身：false）：");
        Boolean isSingle = input.nextBoolean();

        System.out.println("请输入您的性别（男或女）：");
        char sex = input.next().charAt(0);

        input.close();
    }
}
