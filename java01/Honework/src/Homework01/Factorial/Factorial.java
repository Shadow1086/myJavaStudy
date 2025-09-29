package Homework01.Factorial;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * <p>
 * 分别用for、while和do-while循环语句以及递归方法计算n!，并输出算式
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/29 17:03
 * {@code @Version} 1.0
 */

public class Factorial {
    //展示信息
    public static void method(int num) {
        if (num > 0) {
            System.out.println("用递归求" + num + "的阶乘:");
            for (int i = 1; i <= num; i++) {
                if (i != num) {
                    System.out.print(i + " * ");
                } else {
                    System.out.print(i + " = ");
                }
            }
            System.out.print(recursion(num));
        } else if (num == 0) {
            System.out.println("用递归求0的阶乘结果：1");
        } else if (num < 0) {
            System.out.println("负数没有阶乘");
        } else {
            System.out.println("输入的n有误");
        }
    }

    //提供算法，返回最终结果
    public static long recursion(int num) {
        if (num > 0) {
            return num * recursion(num - 1);
        } else if (num == 0) {
            return 1;
        } else if (num < 0) {
            return 0;
        } else {
            return 0;
        }
    }

    //do-while
    public static void FactorialDoWhile(int num) {
        if (num > 0) {
            long result = 1, n = 1;
            do {
                result *= n;
                n++;
            } while (n <= num);
            System.out.println("用for循环语句求" + num + "的阶乘：");
            for (int i = 1; i <= num; i++) {
                if (i != num) {
                    System.out.print(i + " * ");
                } else {
                    System.out.print(i + " = ");
                }
            }
            System.out.print(result);
        } else if (num == 0) {
            System.out.println("用while循环语句求0的阶乘-结果：1");
        } else if (num < 0) {
            System.out.println("负数没有阶乘");
        } else {
            System.out.println("输入的n有误");
        }
    }

    //while
    public static void FactorialWhile(int num) {
        if (num > 0) {
            long result = 1;
            int temp = 1;
            while (temp <= num) {
                result *= temp;
                temp++;
            }
            System.out.println("用while循环语句求" + num + "的阶乘：");
            for (int i = 1; i <= num; i++) {
                if (i != num) {
                    System.out.print(i + " * ");
                } else {
                    System.out.print(i + " = ");
                }
            }
            System.out.print(result);
        } else if (num == 0) {
            System.out.println("用while循环语句求0的阶乘：\n1");
        } else if (num < 0) {
            System.out.println("负数没有阶乘");
        } else {
            System.out.println("输入的n有误");
        }
    }

    //for
    public static void FactorialFor(int num) {
        if (num > 0) {
            long sum = 1;
            for (int n = 1; n <= num; n++) {
                sum *= n;
            }
            System.out.println("用for循环语句求" + num + "的阶乘：");
            for (int i = 1; i <= num; i++) {
                if (i != num) {
                    System.out.print(i + " * ");
                } else {
                    System.out.print(i + " = ");
                }
            }
            System.out.print(sum);
        } else if (num == 0) {
            System.out.println("用for循环语句求" + num + "的阶乘：\n1");
        } else {
            System.out.println("负数没有阶乘");
        }
    }
}

