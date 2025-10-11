package Homework01;
/**
* 任务：使用 instanceof 运算符判断所给对象是否为特定类的一个实例，并输出判断结果。
*/

public class Demo {
    public static void main(String[] args){
        Object hello = "Hello";

    // 判断hello是否是Object类的实例
        if(hello instanceof Object){
            System.out.println("hello is Object");
        }else{
            System.out.println("hello isn't Object");
        }


    // 判断hello是否是String类的实例
        if(hello instanceof String){
            System.out.println("hello is String");
        }else{
            System.out.println("hello isn't String");
        }


    // 判断hello是否是Math类的实例
        if(hello instanceof Math){
                System.out.println("hello is Math");
        }else{
            System.out.println("hello isn't Math");
        }
    // 判断a是否是Object类的实例
        String a = "hello";
        if(a instanceof Object){
                System.out.println("a is Object");
        }else{
            System.out.println("a isn't Object");
        }

    }
}
