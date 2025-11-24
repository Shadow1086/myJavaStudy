package com.myjavastudy.e_concurrency.java01.Safe_Thread01;
/**
 * ClassName: Ticket01
 * Description:
 * 
 * 开启三个窗口售票，总票数为100张
 * 通过实现Runnable接口的方式，实现卖票。------->存在线程安全问题
 *  使用同步代码块解决上述卖票中的线程安全问题。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-17 20:42:16
 * {@code @Version} 1.0
 */
public class Ticket01 {
    public static void main(String[] args) {
        SaleTicket01 saleTicket1 = new SaleTicket01();

        Thread thread1 = new Thread(saleTicket1);
        thread1.setName("窗口1  ");
        Thread thread2 = new Thread(saleTicket1);
        thread2.setName("窗口2  ");
        Thread thread3 = new Thread(saleTicket1);
        thread3.setName("窗口3  ");
        thread1.start();

        thread2.start();

        thread3.start();
    }
}
/*
 * ------------线程的两种声明方式---------------
 */
class Window01 implements Runnable {
    @Override
    public void run() {

    }
}

class Window02 extends Thread{
    @Override
    public void run(){

    }
}
//--------------
class SaleTicket01 implements Runnable{
    int ticket = 100;
    Object object = new Object();

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            synchronized(this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "售票，票号为 : " + ticket);
                    ticket --;
                }else{
                    break;
                }
            }

        }
    }
}