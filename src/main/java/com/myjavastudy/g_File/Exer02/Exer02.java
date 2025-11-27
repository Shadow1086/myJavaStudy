package com.myjavastudy.g_File.Exer02;

import java.io.File;
import java.io.FilenameFilter;

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
        // 方式一：
        // File file = new File("/Volumes/Users/htliang/Downloads/图标");
        // String[] filesList = file.list();
        // for(String s : filesList){
        // if(s.endsWith("jpg")){
        // System.out.println("以jpg格式结尾的文件：" + s);
        // }else if(s.endsWith("png")){
        // System.out.println("以png格式结尾的文件：" + s);
        // }
        // }
        // 方式二：
        File dir = new File("/Volumes/Users/htliang/Downloads/图标");
        String[] fileList = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("png")||name.endsWith("jpg");
            }
        });
        for(String s : fileList){
            System.out.println(s);
        }
    }
}
