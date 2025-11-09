package com.myjavastudy.oop.class03_inheritance.super01;

import com.myjavastudy.oop.class03_inheritance.extend01.Mankind;

/**
 * ClassName: Practice01
 * Package: Class03.Extend01.Super
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 21:49
 * {@code @Version} 1.0
 */

public class Kids extends Mankind {
    private int yearsOld;

    public Kids(){}

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(yearsOld);
    }

    public void employeed(){
        super.employeed();
        System.out.println("but Kids should study and no job");
    }

}
