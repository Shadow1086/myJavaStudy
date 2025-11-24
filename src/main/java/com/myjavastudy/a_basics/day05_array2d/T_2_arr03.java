package com.myjavastudy.a_basics.day05_array2d;

public class T_2_arr03 {
    public static void main(String[] args) {
        int[][] a = new int[][]
        {
            {1 , 2 , 3},
            {1 , 2 , 3},
            {1 , 2 , 3},
        };
        int[][] b = new int[][]
                {
                        {1 , 2 , 3},
                        {4 , 5 , 6},
                        {7 , 8 , 9},
                };
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
