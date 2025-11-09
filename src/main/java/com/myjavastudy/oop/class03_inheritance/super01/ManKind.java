package com.myjavastudy.oop.class03_inheritance.super01;

/**
 * ClassName: Practice01
 * Package: Class03.Super01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 21:50
 * {@code @Version} 1.0
 */

public class ManKind {
    private int sex;
    private int salary;


    public ManKind() {
    }

    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        if(sex == 0||sex==1){
            this.sex = sex;
        }else{
            System.out.println("输入有误");
        }

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman(){
        if(this.sex == 0){
            System.out.println("woman");
        }else if(this.sex == 1){
            System.out.println("man");
        }
    }

    public void employeed(){
        if(this.salary == 0){
            System.out.println("no job");
        }else if(this.salary != 0){
            System.out.println("job");
        }
    }

}
