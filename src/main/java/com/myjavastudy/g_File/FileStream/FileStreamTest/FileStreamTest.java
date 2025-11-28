package com.myjavastudy.g_File.FileStream.FileStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: FileStreamTest
 * Description:
 * 
 * 复制图片等字节文件
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-28 19:59:34
 */
public class FileStreamTest {
    public static void main(String[] args) {
        test01();
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
            //创建Stream流
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
            //关闭资源
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.创建对象
    }
}
