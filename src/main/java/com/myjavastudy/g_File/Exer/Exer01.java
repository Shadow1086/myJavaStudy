package com.myjavastudy.g_File.Exer;

import java.io.File;
import java.io.IOException;

/**
 * 类名: Exer01
 * 创建时间: 2025/11/23 20:02
 * 项目描述:
 * 练习：创建一个与hello.txt文件在相同文件目录下的另一个名为abc.txt文件
 * @author htLiang
 */
public class Exer01{
    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());

        //构造器
        File file2 = new File(file.getAbsoluteFile().getParent(),"abc.txt");
        System.out.println(file2.getAbsolutePath());

    }
}
