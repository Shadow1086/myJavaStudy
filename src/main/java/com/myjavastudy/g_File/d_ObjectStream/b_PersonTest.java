package com.myjavastudy.g_File.d_ObjectStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class b_PersonTest {
    /**
     * 演示自定义类的对象的序列化
     */
    public static void test01(){
        ObjectOutputStream oos = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/d_ObjectStream/object.dat");
            oos = new ObjectOutputStream(new FileOutputStream(file));

            Person p1 = new Person("Tom",12,234,new Account(3241));
            oos.writeObject(p1);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 演示自定义类的反序列化过程
     */
    public static void test02(){
        ObjectInputStream ois = null;
        try {
            File file = new File("src/main/java/com/myjavastudy/g_File/d_ObjectStream/object.dat");
            ois = new ObjectInputStream(new FileInputStream(file));
            Person person = (Person)ois.readObject();
            System.out.println(person.toString());
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
