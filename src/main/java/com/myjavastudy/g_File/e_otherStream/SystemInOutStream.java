package com.myjavastudy.g_File.e_otherStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SystemInOutStream {
    /*
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     */
    public static void test01() {
        System.out.println("请输入信息（推出输入e/exit）");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null) {
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("退出");
                    break;
                }
                System.out.println("----->：" + s.toUpperCase());
                System.out.println("请继续输入");
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02() {
        PrintStream ps;
        try {
            ps = new PrintStream("io.txt");
            ps.println("hello");
            ps.println("1");
            ps.println(1.5);
            //重新设置输出的位置，不是控制台而是文件中
            System.setOut(ps);
            System.out.println("hello");
            ps.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // test01();
        test02();
    }
}
