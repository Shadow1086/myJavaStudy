package com.myjavastudy.oop.class08_interface.Interface.JDK8;

/**
 * ClassName: CompareA
 * Package: Class08.Interface.JDK8
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:51
 * {@code @Version} 1.0
 */

interface CompareA {
    public static void method1(){
        System.out.println("静态方法");
    }

    public default void method2(){
        System.out.println("静态方法的调用");
    }
    public default void method3(){
        System.out.println("静态方法2的调用");
    }
}
