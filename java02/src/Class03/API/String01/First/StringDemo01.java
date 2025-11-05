package Class03.API.String01.First;
/**
 * ClassName: StringDemo01
 * Description: 
 * 
 * 关于String的基本
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-05 20:23:27
 */

import org.junit.Test;

public class StringDemo01 {
    @Test
    public void test01(){
        String s1 = "hello";    //字面量的定义方式，其中hello就放在了‘字符串常量池’中
        String s2 = "hello";    //只是将hello的地址给了s2
        System.out.println(s1 == s2);       //注意：对于字符串，==意味着判断两个字符串的地址是否相同
    //返回值为true
    }
    /*
     * String的不可变性
     * 1.当对字符串变量重新赋值时，需要重新制定一个字符串常量的位置进行复制，不能在原有的位置修改
     * 2.当对现有的字符串进行拼接操作时，需要重新开辟一个内存空间，不能直接对原有值进行修改
     * 3.当调用字符串的replace方法来替换现有的某个字符时需要重新开辟空间保存修改以后的字符串，不能在原有的位置修改
     */
    @Test
    public void test02(){
        String s1 = "hello";
        String s2 = "hello";
        s2 = "hi";
        System.out.println(s1);     //s1 = "hello"
    }

    @Test
    public void test03(){
        String s1 = "hello";
        String s2 = "hello";
        s2 += "word";
        System.out.println(s1); //s1 = "hello"
    }
    @Test
    public void test04(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s2.replace('l', 'w');
        System.out.println(s1); //hello
        System.out.println(s2); //hello
        System.out.println(s3); //hewwo
    }
}
