package com.myjavastudy.e_concurrency.java01.Safe_Thread02;

/**
 * ClassName: Windows
 * Description:
 * 
 * 使用同步方法解决继承Thread类中的线程安全问题
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 21:56:01
 */
public class Window02 {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SaleTicket extends Thread{
    static int ticket = 100;
    static Object obj = new Object();
    boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            show();
        }
    }
//public synchronized void show()其中的同步监视器是this,this是w1,w2,w3,还是不安全
//如果非要使用同步方法的话，那就public static synchronized void show(),其中同步监视器就是当前类的本身，即为window01.class, 是唯一的
//  如果不这样的话那就使用同步代码块
    public void show() {

        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 售票，票号为 : " + ticket);
            ticket--;

        } else {
            isFlag = false;
        }
    }
}
