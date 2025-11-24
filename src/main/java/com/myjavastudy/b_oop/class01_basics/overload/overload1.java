package com.myjavastudy.b_oop.class01_basics.overload;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */

/*
方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相
乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。
*/

public class overload1 {
    static int mol(int num){
        return num * num;
    }
    static int mol(int num1 ,int num2){
        return num1 * num2;
    }
    static void mol(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        System.out.println(mol(3));
        System.out.println(mol(3,5));

        mol("abc");

    }

}
