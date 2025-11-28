package com.myjavastudy.g_File.FileStream.FileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: FileWriterTest
 * Description:
 * 
 * 需求：将内存中的数据写出到指定的文件中
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-28 14:40:28
 */
public class FileWriterTest {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        FileWriter fw = null;
        try {
            // 1.创建file对象,指明写出的文件的名称
            File file = new File("src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/info.txt");
            // 2.创建输出流
            // 3.写出的具体过程
            //构造器的不同：true:代表着如果已有文件则会追加内容，false：代表着不追加，直接覆盖，默认是false

            // fw = new FileWriter(file);
            // fw = new FileWriter(file,false);
            fw = new FileWriter(file,true);

            // 输出的方法：write(String str) / write(char[] cdata)
            fw.write("hello\n");
            fw.write(new char[] { '1', '2', '3' });
            fw.write(new char[] { '1', '2', '3' });
            System.out.println("输出成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源，防止内存泄漏
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 需求：复制一份hello.txt，命名为helloCopy.txt
     */
    public static void test02(){
        FileReader fr = null;
        FileWriter fw = null;
        int len;
        try {
            //创建输出输入流
            File src = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/hello.txt");
            File copy = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/g_File/FileStream/FileReaderWriter/helloCopy.txt");
            fr = new FileReader(src);
            fw = new FileWriter(copy);
            char[] cbuffer = new char[5];
            //读写操作
            while((len = fr.read(cbuffer))!= -1){
                //write(char[] cbuffer,int fromIndex,int len)  写入len个字符
                fw.write(cbuffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fr!=null){
                    fr.close();
                }
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
