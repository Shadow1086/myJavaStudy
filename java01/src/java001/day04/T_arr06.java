package java001.day04;

import java.util.Scanner;

public class T_arr06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int num = input.nextInt();
        int[] a = new int[num];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }
        System.out.print("请输入离开的人的序号：");
        final int getOut = input.nextInt();
        int index = a.length - 1;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == getOut) {
                index = j;
                break;
            }
        }
        for (int k = index; k < a.length - 1; k++) {
            a[k] = a[k + 1];
        }
        for(int l = 0;l<a.length - 1;l++){
            System.out.print(a[l] + "  ");
        }
    }
}
