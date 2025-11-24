package com.myjavastudy.a_basics.day03_nested_loop;

public class T_forTwice02 {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int m = 1; m <= i + 1; m++) {
                System.out.print(num);
                num ++;
            }
            System.out.println();
        }
    }
}
