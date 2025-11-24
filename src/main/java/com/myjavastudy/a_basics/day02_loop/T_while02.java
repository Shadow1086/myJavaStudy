package com.myjavastudy.a_basics.day02_loop;

public class T_while02 {
    public static void main(String [] args){
        int num = 6;
        int sum = 0;
        while(num <= 180){
            sum += num;
            num += 6;
        }
        System.out.println("6 + 12 + 18 +...+ 180 = "+sum);
    }
}
