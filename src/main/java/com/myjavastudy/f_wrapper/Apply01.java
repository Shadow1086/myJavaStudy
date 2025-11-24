package com.myjavastudy.f_wrapper;

import org.junit.Test;

public class Apply01 {
    /*
     * 基本数据类型 ->包装类：1.使用包装类的构造器
     *                      2. 建议使用包装类的valueOf()方法
     * 包装类 -> 基本数据类型：1. 调用包装类的xxxValue()方法
     */
    @Test
    public void test1() {
        //使用包装类的构造器将基本数据类型转换为包装类对象
        
        int i1 = 10;
        Integer ii1 = new Integer(i1);
        System.out.println(ii1.toString());
//可以传这样的字符串，但字符串里面的内容必须与包装类相符合，否则会报错
//对于boolean类型，可以忽略大小写
        String s1 = "123";
        Integer ii3 = new Integer(s1);
        System.out.println(ii3.toString());

        float f1 = 12.3f;
        Float ff1 = new Float(f1);
        System.out.println(ff1.toString());

        Integer ii2 = Integer.valueOf(i1);
        System.out.println(ii1);
        System.out.println(ii2);

        //自动拆箱
        int i2 = ii1.intValue();
        System.out.println(i2);

        //自动装箱
        Integer ii4 = i2;
        System.out.println(ii4);
    }

}
