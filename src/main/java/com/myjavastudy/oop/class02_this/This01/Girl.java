package com.myjavastudy.oop.class02_this.This01;


/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 12:01
 * {@code @Version} 1.0
 */

public class Girl {
    private String name;
    private int age;
//构造器

    public Girl() {
    }

    public Girl(String name, int age) {
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

    public void marry(Boy boy) {
        System.out.println("我想和" + boy.getName() + "结婚");
        boy.marry(this);
    }

    /*
     *比较两个girl对象的年龄大小
     * @param girl
     * @return 正数：当前对象大，负数当前对象小（形参大
     * */
    public int compare(Girl girl) {
        if (this.age > girl.getAge()) {
            return 1;
        } else if (this.age < girl.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
