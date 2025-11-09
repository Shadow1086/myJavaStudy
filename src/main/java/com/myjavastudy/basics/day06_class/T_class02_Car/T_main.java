package com.myjavastudy.basics.day06_class.T_class02_Car;

import java.util.Scanner;

public class T_main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "奔驰";
        c1.color = "黑色";
        c1.price = 100000;
        c1.show();

        Scanner input = new Scanner(System.in);
        Car c2 = new Car();

        System.out.print("请输入汽车品牌：");
        c2.brand = input.next();

        System.out.print("请输入汽车颜色：");
        c2.color = input.next();

        System.out.print("请输入汽车价格：");
        c2.price = input.nextInt();

        c2.show();
        input.close();

    }
}
