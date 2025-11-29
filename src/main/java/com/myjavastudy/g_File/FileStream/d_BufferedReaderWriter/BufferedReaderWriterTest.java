package com.myjavastudy.g_File.FileStream.d_BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: BufferedReaderWriterTest
 * Description:
 * 
 * 测试BufferedReader/BufferWriter的使用
 * 实现一个文本文件的复制
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-29 18:01:36
 */
public class BufferedReaderWriterTest {
    public static void test01() {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/FileStream/BufferedReaderWriter/test.txt");
            bw = new BufferedWriter(new
            FileWriter("src/main/java/com/myjavastudy/g_File/FileStream/BufferedReaderWriter/testCopy.txt"));
            
            br = new BufferedReader(new FileReader(file));
            // 读取过程
            // 方式一：读char[]数组，read(char[] cbuffer)
            char[] cbuffer = new char[5];
            int len;
            while ((len = br.read(cbuffer)) != -1) {
                    bw.write(cbuffer,0,len);
                    bw.flush();//刷新的方法：作用：每次调用此方法时，就会主动的将内存中的数据写出到磁盘文件中
            }
            // 方式二：读一行，readLine():1.不会读换行符  2.若为文件末尾则返回null
            String data;
            while((data =br.readLine())!=null){
                System.out.println(data);
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
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test01();
    }
}
