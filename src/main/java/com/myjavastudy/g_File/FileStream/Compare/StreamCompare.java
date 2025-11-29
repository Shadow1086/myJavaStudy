package com.myjavastudy.g_File.FileStream.Compare;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

/**
 * ClassName: StreamCompare
 * Description:
 * 
 * 通过复制一个视频来判断缓冲流和文件流之间速度的差异
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-29 16:45:36
 */
public class StreamCompare {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        test01("src/main/resources/确定.png", "src/main/java/com/myjavastudy/g_File/FileStream/Compare/copy01.png");
        long start2 = System.currentTimeMillis();
        System.out.println(start2 - start1);

        long start3 = System.currentTimeMillis();
        test02("src/main/resources/确定.png", "src/main/java/com/myjavastudy/g_File/FileStream/Compare/copy02.png");
        long start4 = System.currentTimeMillis();
        System.out.println(start4 - start3);
    }

    /**
     * 使用缓冲流的测试一
     */
    public static void test01(String srcStr, String targetStr) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File src = new File(srcStr);
            File target = new File(targetStr);

            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(target);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            int len;
            byte[] buffer = new byte[50];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer);
            }
            System.out.println("Buffered Stream success");
        } catch (IOException e) {
            e.printStackTrace();// TODO: handle exception
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用文件流的测试二
     */
    public static void test02(String srcStr, String targetStr) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File src = new File(srcStr);
            File target = new File(targetStr);
            fis = new FileInputStream(src);
            fos = new FileOutputStream(target);
            byte[] cbuffer = new byte[50];
            int len;
            while ((len = fis.read(cbuffer)) != -1) {
                fos.write(cbuffer);
            }
            System.out.println(" File Stream Success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
}
