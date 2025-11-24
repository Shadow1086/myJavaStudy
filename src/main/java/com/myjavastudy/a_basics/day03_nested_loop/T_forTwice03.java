package com.myjavastudy.a_basics.day03_nested_loop;

//打印乘法表
public class T_forTwice03 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int m = 1; m <= i; m++) {
                System.out.print(i + " * " + m + " = " + (i * m));
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }
}
