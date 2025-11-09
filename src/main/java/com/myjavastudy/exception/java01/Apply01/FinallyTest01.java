package com.myjavastudy.exception.java01.Apply01;

import org.junit.Test;
/**
 * ClassName: FinallyTest01
 * Description:
 * 
 * 对于finally存在的必要性的证明
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-15 12:39:39
 * {@code @Version} 1.0
 */
public class FinallyTest01 {
    //对于try和catch中仍有未被处理的异常
    @Test
    public void test1(){
        try {
            String str  ="123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
             e.printStackTrace();
            System.out.println("异常已被处理");
            //在catch中出现异常
            System.out.println(10 / 0);
            //System.out.println(e.getMessage()); 

        }finally{
             System.out.println("程序结束");
        }
}

       @Test
       public void test2(){
            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }
       }
    
}