package com.myjavastudy.e_concurrency.java01.Safe_Thread02;
/**
 * ClassName: Windows
 * Description: 
 * 
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 21:56:01
 */
public class Windows {
    public static void main(String[] args) {
        SaleTicket01 s = new SaleTicket01();
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

class SaleTicket01 implements Runnable{
    static int ticket = 100;
    boolean isFlag = true;
    @Override
    public void run(){
        while (isFlag) {
            //这里还是同步代码块
            // synchronized(this){
            //     show();
            // }
            show();
        }
    }
    //同步方法,此时的同步监视器是this；，此题目中即为s，是唯一的，保证了线程安全
    public synchronized void show(){
        if(ticket>0){
            try{
                Thread.sleep(50);
            }catch(InterruptedException exception){
                exception.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" 售票，票号为 : " + ticket);
            ticket --;

        }else{
            isFlag = false;
        }
    }
}


