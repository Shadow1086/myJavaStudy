package com.myjavastudy.basics.day06_class.T_class05_Score;



public class Score {

    int[] score = new int[3];

    public int sum(){
        int sum = 0;
        for(int num:score){
            sum += num;
        }
        return sum;
    }

    public double  averageScore(){
        int sum = 0;
        for(int num:score){
            sum += num;
        }
        return (double)sum / 3;
    }

}
