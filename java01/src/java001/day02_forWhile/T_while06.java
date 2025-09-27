package java001.day02_forWhile;

import java.util.Scanner;

public class T_while06 {
    public static void main(String[] args){
//班上有学生若干名，给出每名学生的年龄（整数），求班上所有学生的平均年龄，保留到小数点后两位。
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入学生总数：\t");
        int num = scan.nextInt();
        int sum = 0, age;
        System.out.println("请依次输入学生的年龄");
        for(int i = 1;i <= num;i++){
            age = scan.nextInt();
            sum += age;
        }
        System.out.printf("所有学生的平均年龄为："+"%.2f", (double)sum / num);
    }
}
