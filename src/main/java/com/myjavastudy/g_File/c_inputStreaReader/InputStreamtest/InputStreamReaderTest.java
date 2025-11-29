package com.myjavastudy.g_File.c_inputStreaReader.InputStreamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ClassName: InputStreamReaderTest
 * Description:
 * 
 * description
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-29 19:51:05
 */
public class InputStreamReaderTest {
    /**
     * 读取文件时出现了乱码，因为文件使用的是gbk，所以在读取的时候也需要使用gbk
     */
    public static void test01() {
        InputStreamReader isr = null;
        try {
            // 创建File对象
            File file1 = new File("/Volumes/study/02-java/myJavaStudy/src/main/resources/项目阶段的思考_副本.txt");
            // 创建流对象
            FileInputStream fis = new FileInputStream(file1);
            // 此时使用的是默认的UTF-8字符集,也可以在后边指明：使用UTF-8
            isr = new InputStreamReader(fis, "UTF-8");

            // 读入操作
            char[] cbuffer = new char[1024];
            int len;
            while ((len = isr.read(cbuffer)) != -1) {
                String str = new String(cbuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    // 关闭操作
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void test02(){
        InputStreamReader isr = null;
        try {
            File file =  new File("/Volumes/study/02-java/myJavaStudy/src/main/resources/项目阶段的思考_副本.txt");
            FileInputStream fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"gbk");
            int len;
            char[] cbuffer = new char[1024];
            while ((len=isr.read(cbuffer))!=-1) {
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 将gbk编码的文件转换为UTF8的格式
     */
    public static void test03(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file = new File("/Volumes/study/02-java/myJavaStudy/src/main/resources/项目阶段的思考_副本.txt");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos =  new FileOutputStream("src/main/java/com/myjavastudy/g_File/c_inputStreaReader/InputStreamtest/项目阶段的思考Copy.txt");
            isr = new InputStreamReader(fis,"gbk");
            osw = new OutputStreamWriter(fos,"UTF-8");
            int len;
            char[] cbuffer = new char[1024];
            while((len = isr.read(cbuffer))!=-1){
                String str = new String(cbuffer,0,len);
                osw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw!=null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        test03();
    }
}
