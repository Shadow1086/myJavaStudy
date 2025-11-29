package com.myjavastudy.g_File.b_FileStream.Exer01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: PictureHide
 * Description:
 * 
 * 实现图片加密操作。
 * 注意点：不能直接对同一个文件进行处理，需要引入一个临时的来代替，此处不演示 了
 * 提示：
 * int b = 0;
 * while((b = fis.read()) != -1){
 * fos.write(b ^ 5);
 * }
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-30 00:12:23
 */
public class PictureHide {
    public static void main(String[] args) {
        // HidePicture("src/main/resources/fuzhi-L.png");
        RestorePicture("src/main/resources/fuzhi-L.png");
    }

    public static void HidePicture(String str) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            // 直接修改原图片
            File file = new File(str);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file);
            int len;
            while ((len = fis.read()) != -1) {
                fos.write(len ^ 5);
            }
            System.out.println("hide success");
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
     * 对加密的图片进行解密
     */
    public static void RestorePicture(String str){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(str);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file);
            int len;
            while((len = fis.read())!=-1){
                fos.write(len ^ 5);
            }
            System.out.println("restore success");
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
}
