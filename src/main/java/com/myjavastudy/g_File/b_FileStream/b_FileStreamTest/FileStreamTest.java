package com.myjavastudy.g_File.b_FileStream.b_FileStreamTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: FileStreamTest
 * Description:
 * 
 * 使用字节流复制图片等字节文件
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-28 19:59:34
 */
public class FileStreamTest {
    public static void main(String[] args) {
        test02();
        
    }

    /**
     * 需求：复制一份fuzhi.png图片，命名为fuzhiCopy.png
     */
    public static void test01() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建File对象
            File srcFile = new File("src/main/resources/fuzhi-L.png");
            File targetFile = new File("src/main/java/com/myjavastudy/g_File/FileStream/FileStreamTest/fuzhiCopy.png");
            // 创建Stream流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(targetFile);

            // 读写操作
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 需求：使用BufferedInputStream / BufferedOutputStream 复制一张图片
     * 
     * 关键点：缓冲流是处理流，必须包装在节点流（如FileInputStream）之上
     */
    public static void test02() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 创建File对象
            File srcFile = new File("src/main/resources/fuzhi-L.png");
            File targetFile = new File(
                    "src/main/java/com/myjavastudy/g_File/FileStream/FileStreamTest/fuzhiCopyStream.png");
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(targetFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer))!= -1){
                bos.write(buffer);
            }
            System.out.println("成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源（关闭外层流会自动关闭内层流）
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();// TODO: handle exception
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();// TODO: handle exception
            }
        }
    }
}
