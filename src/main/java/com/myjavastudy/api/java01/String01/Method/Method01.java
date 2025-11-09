package com.myjavastudy.api.java01.String01.Method;
import org.junit.Test;
/**
 * ClassName: Method01
 * Description: 
 * 
 *  1）boolean isEmpty()：字符串是否为空
 *  2）int length()：返回字符串的长度
 *  3）String concat(xx)：拼接
 *  4）boolean equals(Object obj)：比较字符串是否相等，区分大小写
 *  5）boolean equalsIgnoreCase(Object obj)：比较字符串是否相等，不区分大小写
 *  6）int compareTo(String other)：比较字符串大小，区分大小写，按照Unicode编码值比较大小
 *  7）int compareToIgnoreCase(String other)：比较字符串大小，不区分大小写
 *  8）String toLowerCase()：将字符串中大写字母转为小写
 *  9）String toUpperCase()：将字符串中小写字母转为大写
 *  10）String trim()：去掉字符串前后空白符
 *  11）public String intern()：结果在常量池中共享
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-07 21:18:37
 */
public class Method01 {
    @Test
    public void test01(){
        String s1 = "";
        String s2 = new String();
        String s3 = new String("");

        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s3.isEmpty());

        // String s4 = null;
        // System.out.println(s4.isEmpty()); // 这行会抛出 NullPointerException
    }
    @Test
    public void test02(){
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

    }
    @Test
    public void test03(){
        String s1 = "abcd";
        String s2 = "adef";
        System.out.println(s1.compareTo(s2));

        String s5 = "abcd";
        String s6 = "abcd";
        System.out.println(s5.compareTo(s6));

        String s3  ="abcd";
        String s4 = "aBcd";
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareToIgnoreCase(s4));

        String s7 = "张ab";
        String s8 ="李cd";
        System.out.println(s7.compareTo(s8));

        String s9 = "he  llo                 ";
        System.out.println("*****" + s9.trim() + "*******");
    }

    /**
     * 查找方法
     */
    @Test
    public void test04(){
        String s1 = "hello";
        System.out.println(s1.contains("hel"));     //true

        System.out.println(s1.indexOf("he"));
        System.out.println(s1.indexOf("l",3));

        
    }
}
