package com.myjavastudy.d_exception.java01.Apply01;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest02 {
    @Test
    public void test4() {
        File file = new File("D:\\hello.txt");

        try (FileInputStream fis = new FileInputStream(file)) {
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}