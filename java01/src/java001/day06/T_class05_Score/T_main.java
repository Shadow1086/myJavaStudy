package java001.day06.T_class05_Score;

import java.util.Scanner;
import java.util.Arrays;

public class T_main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Score a =  new Score();
        System.out.println("请输入三科成绩：");
        for(int i = 0;i<3;i++){
            a.score[i] = input.nextInt();
        }

        System.out.println("总分为：" + a.sum());
        System.out.println("平均分为：" + a.averageScore());

    }
}
