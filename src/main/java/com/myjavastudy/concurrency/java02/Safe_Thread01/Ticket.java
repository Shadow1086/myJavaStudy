package com.myjavastudy.concurrency.java02.Safe_Thread01;

/**
 * ClassName: Windows
 * Description: 
 * 
 * 没有解决线程安全问题的源代码
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 21:56:01
 */
public class Ticket {
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

class SaleTicket implements Runnable{
    static int ticket = 100;
    @Override
    public void run(){
        while (true) {
            if(ticket > 0){
                try{
                    Thread.sleep(50);
                }catch(InterruptedException exception){
                    exception.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 售票，票号为 : " + ticket);
                ticket --;
            }else{
                break;
            }
        }
    }
}


