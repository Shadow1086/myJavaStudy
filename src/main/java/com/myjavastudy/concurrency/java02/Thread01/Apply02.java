package com.myjavastudy.concurrency.java02.Thread01;

/**
 * ClassName: Apply02
 * Description:
 * 
 * 创建两个分线程，其中一个遍历100以内偶数，另一个遍历100以内的奇数
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-15 21:07:39
 * {@code @Version} 1.0
 */
public class Apply02 {
    public static void main(String[] args) {
        PrintNumberJi jiShu = new PrintNumberJi();
        jiShu.start();

        PrintNumberOu ouShu = new PrintNumberOu();
        ouShu.start();

        //方式二  创建Thread的匿名线程（子类）
        new Thread(){
            @Override
            public void run(){
                System.out.println("text");
            }
        }.start();


    }
}

// 偶数
class PrintNumberOu extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }
}

// 奇数
class PrintNumberJi extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
