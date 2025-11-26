package com.myjavastudy.g_File.Exer01;

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
        File file = new File("/Volumes/study/02-java/myJavaStudy/src/main/java/com/myjavastudy/g_File/Exer/hello.txt");
        System.out.println(file.getAbsolutePath());

        // //构造器
        // //使用这种方法并不会在磁盘上真正的创建一个文件
        File file2 = new File(file.getAbsoluteFile().getParent(), "abc.txt");
        System.out.println(file2.getAbsolutePath());

        //如果要真正创建文件，需要调用createNewFile()方法
        //file2.createNewFile();
        boolean isFlag = file2.createNewFile();
        if(isFlag){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }

    }
}
