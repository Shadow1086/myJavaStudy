package com.myjavastudy.a_basics.day04_array;

import java.util.Scanner;

//数组的元素插入和删除

//有一个升序排序的成绩数组，其中成绩值为78,87,95,98,100。
// 增加一个学生的成绩，插入数组中后，保证数组元素依然升序排列。
public class T_arr05 {
    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = 78;
        nums[1] = 87;
        nums[2] = 95;
        nums[3] = 98;
        nums[4] = 100;

        Scanner input = new Scanner(System.in);
        //定义一个变量，保存新插入的分数
        int score = input.nextInt();
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (score < nums[i]) {
                index = i;
                break;
            }
        }

        //元素后移
        for (int j = nums.length - 1; j > index; j--) {
            /*     注意点！！！    */
            nums[j] = nums[j - 1];
        }
        nums[index] = score;
        for (int num : nums) System.out.print(num + "\t");
    }
}
