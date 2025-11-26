package com.myjavastudy.g_File.Exer02;

import java.io.File;

/**
 * ClassName: Exer02
 * Description:
 *
 * 练习：
 * 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * 
 * 提示：File类提供了文件过滤器方法(拓展)
 * public String[] list(FilenameFilter filter)
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-24 22:07:59
 */
public class Exer02 {
    public static void main(String[] args) {
        File file = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/g_File");
        File[] fileList = file.listFiles();
        for(File fileEach : fileList){
            
        }
    }
}
