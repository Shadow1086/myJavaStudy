package com.myjavastudy.g_File.File.Exer03;

import java.io.File;

/**
 * ClassName: Exer03
 * Description:
 * 
 * 练习：
 * 遍历指定文件目录下的所有文件的名称，包括子文件目录中的文件。
 * 编写方法：public void printFileName(File file) //file可能是文件，也可能是文件目录
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-27 16:52:35
 */
public class practice01 {
    public static void main(String[] args) {
        File file = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/g_File");
        printFileName(file);
    }

    public static void printFileName(File file) {
        if (file.isFile()) {
            System.out.println(file.getName());
        } else {
            // 用list()方法只能得到当前目录下的文件名，不能得到其子目录下的文件名称
            // String[] fileList = file.list();
            // for (String str : fileList) {
            // System.out.println(str);
            // }

            //使用listFile即可得到子目录下的文件
            File[] fileList = file.listFiles();
            for (File f : fileList) {
                printFileName(f);
            }
        }

    }
}
