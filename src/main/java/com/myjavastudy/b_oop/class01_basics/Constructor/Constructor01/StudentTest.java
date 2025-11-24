package com.myjavastudy.b_oop.class01_basics.Constructor.Constructor01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:25
 * {@code @Version} 1.0
 */

public class StudentTest {
    public static void main(String[] args) {
        Student stu1 = new Student("xiaohua" , 15);
        Student stu2 = new Student("xiaoming" , 16 , "yizhong");
        Student stu3 = new Student("xiaodong" , 17 , "erzhong" , "shuxue");
        stu1.printInfo();
        stu2.printInfo();
        stu3.printInfo();
    }
}
