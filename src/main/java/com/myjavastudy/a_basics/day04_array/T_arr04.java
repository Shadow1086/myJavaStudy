package com.myjavastudy.a_basics.day04_array;

import java.util.Arrays;
//陶陶家的院子里有一棵苹果树，每到秋天树上就会结出 10 个苹果。
// 苹果成熟的时候，陶陶就会跑去摘苹果。
// 陶陶有一张 30 厘米高的板凳，当她不能直接用手摘到苹果的时候，就会踩到板凳上再试试。
//现在已知 10 个苹果到地面的高度，以及陶陶把手伸直的时候能够达到的最大高度，
// 请帮陶陶算一下她能够摘到的苹果的数目。假设她碰到苹果，苹果就会掉下来。
//100 200 150 140 129 134 167 198 200 111
//        110

public class T_arr04 {
    public static void main(String[] args) {
        //直接赋值：：：
        int[] a = new int[]{
                100, 200, 150, 140, 129, 134, 167, 198, 200, 111
        };
        Arrays.sort(a);
        int counter = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (140 > a[i]) counter += 1;
//        }

        //加强的for循环，和C++一样
        for (int num : a) {
            if (140 >= num) counter += 1;
        }
        System.out.println("十个苹果中，可以摘到" + counter + "个。");
    }
}
