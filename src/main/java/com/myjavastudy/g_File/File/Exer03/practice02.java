package com.myjavastudy.g_File.File.Exer03;

import java.io.File;

/**
 * ClassName: practice02
 * Description:
 * 
 * 拓展1：删除指定文件目录及其下的所有文件
 * public void deleteDirectory(File file) //file可能是文件，也可能是文件目录
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-27 17:02:31
 */
public class practice02 {
    public static void main(String[] args) {
        File file = new File("#");
        deleteDirectory(file);
    }

    public static void deleteDirectory(File file) {
        if (!file.exists()) {
            return;
        }else if(file.isFile()) {
            file.delete();
        } else if(file.isDirectory()){
            File[] fileList = file.listFiles();
            for (File f : fileList) {
                deleteDirectory(f);
            }
            file.delete();
        }

    }
}
