package Homework01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//Java类和对象之构造方法与对象创建之比较大小：比较键盘输入的两个 double 型的数值的大小，输出较大的值（按照提示编写程序代码）

/**
* 任务：比较键盘输入的两个 double 型的数值的大小，输出较大的值。
* 类名为：Compare
*/
// 创建一个名为 Compare 的公开类
public class Compare {
    // 分别定义两个数
    private double num1;
    private double num2;
    //构造器
    public Compare(){}
    public Compare(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    //set get方法
    public void setnum1(double num1){
        this.num1 = num1;
    }
    public double getnum1(){
        return num1;
    }
    public void setnum2(double num2){
        this.num2 = num2;
    }
    public double getnum2(){
        return num2;
    }
/**
    * 定义一个方法，该方法实现比较两数大小，携带两个参数，分别为传来的两个数的值
    * 将两个数中较大的那个数返回，返回类型为double
    */
    public double compareTo(double num1,double num2){
        if(num1>num2){
            return num1;
        }else if(num1<num2){
            return num2;
        }else{
            return num1;
        }
    }
}

// 定义主方法
class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 获取键盘传来的两个数
        System.out.println("请输入两个数字");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        input.close();
// 在主方法中通过无参构造方法定义一个对象
        Compare compare = new Compare();
        // 调用比较大小的方法，获得较大的那个数
        
        // 不换行输出较大的那个数
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("time = " + format.format(date));
        System.out.print("两个数中较大的是：" + compare.compareTo(num1, num2));
    }
}




/********** End **********/






