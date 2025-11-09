package api.java01.String01.Understand;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * ClassName: StringDemo03
 * Description: 
 * 
 * String的构造器的使用
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-06 20:13:53
 */
public class StringDemo03 {
    /**
     * String 构造器的使用
     */
    @Test
    public void test01(){
        String s1 = new String();
        String s2 = new String("");
        String s3 = new String (new char[]{'a','b','c'});
        System.out.println(s3);
    }
    /**
     * String与其他结构之间的转换
     * 1.String与基本数据类型，包装类的转换
     * 2.String 和 char[]的转换  : 调用String的toCharArray()
     * 3. String 和 byte[]的转换 : 调用String的getBytes()
     */
    @Test
    public void test02(){
        int num = 10;
        //方式一：
        String s1 = num+"";
        //方式二：
        String s2 = String.valueOf(num);

        //String ----> 基本数据类型:调用包装类的parse()的方法
        String s3 = "123";
        int i1 = Integer.parseInt(s3);
    }

    @Test
    public void test03(){
        String str = "hello";
        //String ----> char[] :调用String的toCharArray()
        char[] arr = str.toCharArray();
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }

        //char[] ---->  String : 调用String的构造器
        String str1 = new String(arr);
        System.out.println(str1);
    }
    /**
     * String --->byte[] :调用String的getBytes()
     * 在utf-8字符集中：一个汉字占用三个字节，一个字母占用一个字节
     * 在gbk字符集中：一个汉字占用两个字节，一个字母占用了一个字节。
     * 
     * 在utf-8 和 gbk中都向下兼容了ASCII码
     * 
     * 编码与解码：
     * 编码：  String -----> 字节或字节数组
     * 解码：  字节或字节数组 —---->String
     * 
     * 要求：解码使用的字符集必须和编码时使用的字符集一致，若不一致，则会乱码
     */
    @Test
    public void test04() throws UnsupportedEncodingException{
        String str = new String("hello中国");

        byte[] arr = str.getBytes();    //使用默认字符集
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        //getBytes(String charsetName):使用指定的字符集
        byte[] arr1 = str.getBytes("gbk");
        for(int i = 0;i<arr1.length;i++){
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();

        // char[] ----> String
        String str1 = new String(arr);
        System.out.println(str1);


        String  str2 = new String(arr,"utf-8");//显式的知名解码的字符集： utf-8
        System.out.println(str2);
//乱码
        String  str3 = new String(arr,"gbk");//显式的知名解码的字符集： gbk
        System.out.println(str3);
    }
}
