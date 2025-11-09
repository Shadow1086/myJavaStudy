package com.myjavastudy.oop.class08_interface.Interface.JDK8;


/**
 * ClassName: CompareB
 * Package: Class08.Interface.JDK8
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:53
 * {@code @Version} 1.0
 */
public interface CompareB {
    public default void method3(){
        System.out.println("compareB 静态方法2的调用");
    }
}
