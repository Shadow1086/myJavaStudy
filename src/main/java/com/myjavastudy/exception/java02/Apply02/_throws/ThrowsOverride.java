package com.myjavastudy.exception.java02.Apply02._throws;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsOverride {
    public static void main(String[] args) {
        Father father = new Son();
        try{
             father.method1();
        }catch(IOException e){
            e.printStackTrace();
        }

       
    }
}
class Father{
    public void method1() throws IOException{
        System.out.print("父类");
    }
}
class Son extends Father{
    @Override
    public void method1() throws FileNotFoundException{
        System.out.print("子类");
    }
}
