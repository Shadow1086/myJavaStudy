package com.myjavastudy.basics.day02_loop;

public class T_while04 {
    public static void main(String[] args){
//        小明和小红玩报数游戏，小明按1〜20报数，小红按1〜30报数。
//        若两人同时开始，并以同样的速度报数，当两人都报了 1000个数时，同时报相同数的次数是多少？
        int numHong = 1,numMing = 1 ,sum = 1,time = 0;
        while(sum<=1000){
            if(numHong > 20)        numHong = 1;
            if(numMing > 30)        numMing = 1;
            if(numHong == numMing)      time += 1;
            numHong ++;
            numMing ++;
            sum ++;
        }
        System.out.println("小明与小红同时报相同数的次数是"+time+"次。");
    }
}
