package com.myjavastudy.basics.day07_utils;

/*如何获取一个随机数？
1.可以使用Java提供的API：Math类的random（）；
2.random()调用以后，会返回一个[0.0-1.0）范围的double型的随机数

3.  需求1：获取一个0-100范围的随机整数
    需求2：获取一个1-100范围的随机整数
    需求3：获取一个[a,b]范围的随机整数

*/

public class Get_random {
    public static void main(String[] args) {

        double d1 = Math.random();
        System.out.println("d1 = " + d1);

        int num = (int) (Math.random() * 101);
        //只有乘以101才能使范围变为[0 - 100]
        System.out.println("num = " + num);

        int num1 = (int) (Math.random() * 100) + 1;
        System.out.println("num1 = " + num1);

        //公式！
        int a = 2,b = 59;
        int num2 = (int) (Math.random() * (b - a + 1)) +a;
    }
}
