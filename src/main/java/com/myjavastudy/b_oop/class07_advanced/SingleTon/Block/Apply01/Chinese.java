package com.myjavastudy.b_oop.class07_advanced.SingleTon.Block.Apply01;

/**
 * ClassName: Apply01
 * Package: Class07.SingleTon.Block
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/9 19:52
 * {@code @Version} 1.0
 */

public class Chinese {

    //静态代码块
    private static String country;

    static {
        country = "中国";
        System.out.println("静态代码块");
    }

    private String name;

    {
        System.out.println("非静态代码块，country = " + country);
    }

    public Chinese(String name) {
        this.name = name;
    }
}

