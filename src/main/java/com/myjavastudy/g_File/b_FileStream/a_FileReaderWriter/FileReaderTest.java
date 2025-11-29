package com.myjavastudy.g_File.b_FileStream.a_FileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName: FileReaderWriterTest
 * Description:
 * 
 * FileWriter/FileReader的测试
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-27 20:44:15
 */
public class FileReaderTest {
    /**
     * 需求：读取hello.txt的内容，并打印在控制台上
     * 
     * 异常使用throw的方式不合适，推荐使用try- catch的方式
     */
    public static void main(String[] args) throws IOException {
        System.out.println("方法一：");
        test01();

        System.out.println("方法二：");
        test02();

        System.out.println("方法三：");
        test03();
    }

    public static void test01() throws IOException {
        // 1.创建File类的对象，对应着hello.txt文件
        File file = new File("src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/hello.txt");
        // 2. 创建输入型的字符流，用于读取数据
        FileReader fr = new FileReader(file);
        // 3.读取数据，并显示在控制台上

        // 方法一：
        // int data = fr.read();
        // while (data != -1) {
        // System.out.print((char) data);
        // data = fr.read();
        // }

        // 方法二：
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }

        // 注意：错误写法，不用变量data,这样的话第一个字符只会被做判断是不是-1，不是的话就会直接打印第二个字符

        System.out.println();
        // 4.流资源的关闭操作（必须要关闭，否则会出现内存泄漏）
        fr.close();
    }

    /**
     * 使用try-catch方法来处理异常，确保流一定可以被关闭，避免内存泄漏
     */
    public static void test02() {
        FileReader fr1 = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/hello.txt");
            fr1 = new FileReader(file);
            int data;
            while ((data = fr1.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (fr1 != null) {
                    fr1.close();
                }
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
    }

    /**
     * 进行优化，每次读取多个字符存放到字符数组中，减少了每次和磁盘交互的次数，提高效率
     */
    public static void test03() {
        FileReader fr = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/hello.txt");
            fr = new FileReader(file);
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
                //错误写法：不能是length，没办法确定最后一次肯定是规定的个数，可能真实存储的要少于规定的
                // for (int i = 0; i < cbuffer.length; i++) {
                //     System.out.print(cbuffer[i]);
                // }

                for(int i  = 0 ;i<len;i++){
                    System.out.print(cbuffer[i]);
                }

            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
