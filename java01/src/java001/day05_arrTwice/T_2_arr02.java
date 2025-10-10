package java001.day05_arrTwice;

import java.util.Scanner;

//输出n行数字三角形
public class T_2_arr02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入三角形行数：");
        int num = scan.nextInt();
        //建立二维数组
        int[][] a = new int[num][num];
    //初始化数组
        int temp = 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = temp;
                temp ++;
            }
        }
    //访问并输出数组
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
