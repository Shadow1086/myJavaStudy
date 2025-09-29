package Homework01.Factorial;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:分别用for、while和do-while循环语句以及递归方法计算n!，并输出算式。按照模板撰写实验报告。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/29 17:00
 * {@code @Version} 1.0
 */

public class T_main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入n:");
        int n = input.nextInt();
        Factorial.method(n);
        Factorial.FactorialFor(n);
        Factorial.FactorialWhile(n);
        Factorial.FactorialDoWhile(n);
        input.close();
    }

}









