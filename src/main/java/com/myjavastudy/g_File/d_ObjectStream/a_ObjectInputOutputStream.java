package com.myjavastudy.g_File.d_ObjectStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ClassName: a_ObjectInputOutputStream
 * Description:
 * 
 * description
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-30 14:12:55
 */
public class a_ObjectInputOutputStream {
    /**
     * 序列化过程：使用ObjectOutputStream流实现，将内存中的Java对象保存在文件中获通过网络传输出去
     */
    public static void test01() {
        ObjectOutputStream oos = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/d_ObjectStream/test.txt");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeUTF("你好");
            oos.flush();

            oos.writeObject("这是一个Object对象");
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化过程：使用ObjectInputStream流实现，将文件中的数据/网络传输过来的数据还原为内存中的Java对象。
     */
    public static void test02(){
        ObjectInputStream ois = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/d_ObjectStream/test.txt");
            ois = new ObjectInputStream(new FileInputStream(file));

            String str = ois.readUTF();
            System.out.println(str);
            String str1 = ois.readObject().toString();
            System.out.println(str1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        test01();
        test02();
    }
}
