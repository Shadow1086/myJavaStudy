package com.myjavastudy.oop.class02_this.This01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 12:01
 * {@code @Version} 1.0
 */

public class Boy {
    private String name;
    private int age;

//构造器：
    public Boy() {}

    public Boy(String name, int age){
        this.name = name;
        this.age = age;
    }
    //方法：
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶" + girl.getName());
    }

    public void shout(){
        if(this.age>=22){
            System.out.println("可以结婚");
        }else{
            System.out.println("未到结婚法定年龄");
        }
    }
}
