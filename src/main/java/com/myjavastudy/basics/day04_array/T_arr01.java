package com.myjavastudy.basics.day04_array;
import java.util.Scanner;
public class T_arr01 {
    public static void main(String[] args){
//数组定义与赋值
        int[] a = new int[10];
        Scanner input= new Scanner(System.in);
//给数组赋值
        for(int i = 0;i<a.length;i++){
            a[i] = input.nextInt();
        }
    }
}
