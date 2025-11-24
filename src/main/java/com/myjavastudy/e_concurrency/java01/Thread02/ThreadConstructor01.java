package com.myjavastudy.e_concurrency.java01.Thread02;

public class ThreadConstructor01 {
    public static void main(String[] args) {
        PrintNumber t1 = new PrintNumber();
        // PrintNumber t1 = new PrintNumber("线程1");

        t1.setName("子线程1");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        // 给main线程改名：
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 100; i += 2) {
            System.out.println(Thread.currentThread().getName()  + "该线程的优先级：" + Thread.currentThread().getPriority()+ " : " + i);
            if (i == 20) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }
        System.out.println("子线程B是否还存在：" + t1.isAlive());
        
    }
}

class PrintNumber extends Thread {

    public PrintNumber() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i += 2) {
            // try {
            // Thread.sleep(1000);
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
            System.out.println(Thread.currentThread().getName() + "该线程的优先级：" + Thread.currentThread().getPriority() + " : " + i);
            if (i % 20 == 0) {
                Thread.yield();
            }
        }
    }   
}
