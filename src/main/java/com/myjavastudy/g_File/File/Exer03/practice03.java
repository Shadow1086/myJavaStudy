package com.myjavastudy.g_File.File.Exer03;

import java.io.File;

/**
 * ClassName: practice03
 * Description:
 * 
 * 拓展2：计算指定文件目录占用空间的大小
 * public long getDirectorySize(File file) //file可能是文件，也可能是文件目录
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-27 18:01:50
 */
public class practice03 {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(getDirectorySize(file));
    }
    public static long getDirectorySize(File file){
        long size = 0;
        if(file.isFile()){
            size = file.length();
        }else if(file.isDirectory()){
            File[] fileList = file.listFiles();
            for(File f : fileList){
                size += getDirectorySize(f);
            } 
        }
        return size;
    }
}
