package com.myjavastudy.oop.class07_advanced.SingleTon.Abstract.Apply01;

/**
 * ClassName: Student
 * Package: Class07.SingleTon.Abstract.Apply01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 09:56
 * {@code @Version} 1.0
 */

public class Student extends Person{
    String school;
    public Student(){
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    public void eat(){
        System.out.println("学生应该多吃有营养的食物");
    }

    @Override
    public void sleep(){
        System.out.println("学生要保持充足的睡眠");
    }

    public void breath(){
        System.out.println("学生应该多呼吸新鲜空气");
    }
}
