package api.java01.String01.Understand;
import org.junit.Test;
/**
 * ClassName: StringDemo2
 * Description: 
 * 
 * String类的实例化与连接操作
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-05 21:03:19
 */
public class StringDemo2 {
    @Test
    public void test1(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println(s1.equals(s4));  //true
    }
    /*
     * String s  = new String("hello");的内存解析
     */
    @Test
    public void test02(){
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "Tom";
        p2.name = "Tom";

        p1.name = "jerry";
        
        System.out.println(p1.name);        //jerry
        System.out.println(p2.name);        //Tom
    }

    /**
     * 测试String的连接符
     */
    @Test
    public void test03(){
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";

        String s5 = s1 +  "world";  
        //通过字节码文件发现调用了String Builder的toString()方法 ---> new String(),相当于new了一个新的对象
        String s6 = "hello" + s2;
        String s7 = s1+s2;

        //intern方法返回的是字符串常量池中字面值的地址
        String s8 = s5.intern();
        System.out.println(s3 == s8);   //true

    }   
    /**
     * 加上final之后
     */
    @Test
    public void test04(){
        //加上final之后，就变成了常量
        final String s1 = "hello";
        final String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";

        String s5 = s1 +  "world";  
        String s6 = "hello" + s2;
        String s7 = s1+s2;

        System.out.println(s3 == s5);   //true
    }   
    @Test
    public void test05(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1.concat(s2);
        String s4 = "hello".concat("world");
        String s5 = s1.concat("world");

        System.out.println(s3 == s4);   //false
        System.out.println(s3== s5);    //false
        System.out.println(s4 == s5);   //false
    }
}


 class Person {
    String name;
}