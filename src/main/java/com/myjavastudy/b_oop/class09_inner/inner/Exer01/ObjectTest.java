package com.myjavastudy.b_oop.class09_inner.inner.Exer01;

public class ObjectTest{
    public static void main(String[] args) {
        //提供一个继承于Object的匿名子类
        new Object(){
            public void test(){
                System.out.println("Test");
            }
        }.test();
    }
}