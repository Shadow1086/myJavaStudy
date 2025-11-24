package com.myjavastudy.d_exception.java01.Apply02._throws;

import java.io.*;

import org.junit.Test;

public class ThrowsTest01 {

    @Test
    public void test2(){
        try{
            test1();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws FileNotFoundException,IOException{
        File file = new File("D:\\hello.txt");
        //可能报filenotfoundException
        FileInputStream fis = new FileInputStream(file);

        //IOException
        int data = fis.read();
        while(data!= -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }
}

