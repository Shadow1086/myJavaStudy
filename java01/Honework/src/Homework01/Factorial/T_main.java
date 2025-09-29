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
        System.out.println("请输入你想调用的方法(1.递归 2.for 3.while 4.do-while):");
        int fiction = input.nextInt();
        if(fiction == 1){
            Factorial.method(n);
        }else if(fiction == 2){
            Factorial.FactorialFor(n);
        }else if(fiction == 3){
            Factorial.FactorialWhile(n);
        }else if(fiction == 4){
            Factorial.FactorialDoWhile(n);
        }else{
            System.out.println("输入有误");
        }
        input.close();
    }

}









