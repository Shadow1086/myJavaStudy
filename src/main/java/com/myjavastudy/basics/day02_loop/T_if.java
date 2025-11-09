package com.myjavastudy.basics.day02_loop;
import java.util.Scanner;

public class T_if {
    public static void main(String [] args){
        int score;
        Scanner scan = new Scanner(System.in);
        score = scan.nextInt();
        if(score >= 90)         System.out.println("优秀");
        else if (score >= 80)       System.out.println("良好");
        else if (score >= 70)       System.out.println("中等");
        else if (score >= 60)       System.out.println("及格");
        else        System.out.println("不及格");
    }
}
