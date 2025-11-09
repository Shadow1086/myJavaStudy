package com.myjavastudy.exception.java02.Apply01;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

public class TryCatch01 {

    public static void main(String[] args) {
        try{
            System.out.println("请输入数字");
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            System.out.println(num);
        }catch(InputMismatchException e){
            System.out.println("出现了InputMismatchException异常");
        }catch(NullPointerException e){
            System.out.println("出现了NullPointerException异常");
        }catch(RuntimeException e){
            System.out.println("出现了RuntimeException异常");
        }finally{
            System.out.println("finally操作");
        }

        System.out.println("异常处理结束，代码继续执行");
    }

    @Test
    public void test1(){
        try {
            String str  ="123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            System.out.println("异常已被处理");
            System.out.println(e.getMessage()); 
        }

        
        System.out.println("程序结束");
        //System.out.println(str);
    }
}
