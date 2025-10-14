package oop03.Wrapper;
import org.junit.Test;
//String 与基本数据类型，包装类之间的转换

        //String 与基本数据类型之间的转换
public class Apply02 {
        /*
         * 基本数据类型，包装类 ----> String：
         * 1. String 调用valueOf()方法
         * 2.利用基本数据类型加空字符串
         * 
         * String ----> 基本数据类型，包装类：
         * 1. 调用包装类的parseXxx()方法
         * 2. 调用包装类的valueOf()方法
         * 
         */
        @Test
        public void test2(){
            String s1 = "123";
            int i1 = Integer.parseInt(s1);
            System.out.println(i1 + 10);

            String s2="true";
            boolean flag = Boolean.parseBoolean(s2);
            System.out.println(!flag);
        }
    @Test
    public void test1() {

        int i1 = 10;
        String str1 = String.valueOf(i1);
        System.out.println(str1);

        Boolean b1 = true;
        String str2 = String.valueOf(b1);
        System.out.println(b1);
        System.out.println(str2);
        
        //便捷方式：
        String str4 = i1 + "";
        System.out.println(str4);
    }
}

