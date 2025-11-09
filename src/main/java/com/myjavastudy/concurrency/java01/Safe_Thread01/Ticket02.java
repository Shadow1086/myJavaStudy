package com.myjavastudy.concurrency.java01.Safe_Thread01;

import org.junit.experimental.theories.Theories;

/**
 * ClassName: Ticket02
 * Description:
 * 
 * 使用继承Thread类的方式，实现卖票
 * 使用同步代码块的方式解决线程安全问题
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 17:53:40
 */
public class Ticket02 {
    public static void main(String[] args) {
        SaleTicket saleticket = new SaleTicket();
        Windows windows1 = new Windows();
        Windows windows2 = new Windows();
        Windows windows3 = new Windows();

        windows1.start();

    }
}

class Windows extends Thread{
    int ticket = 100;
    //加上static就能保证三个对象调用的是同一个对象了
    static Object obj =  new Object();
    @Override
    public void run(){
        while(true){
            //使用this的话，w1,w2,w3不能保证锁的唯一性。
            // synchronized (obj) {
            synchronized(Windows.class){    //结构：Class cz = Windows.class
                if(ticket<=0){
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 1; i <= 100; i++) {
                    System.out.println(this.getName() + " : " + i);
                    ticket--;
                }
            }
    
        }
    }
}

// class SaleTicket extends Thread {
//     int ticket = 100;
//     while(true){
//         try {
//             Thread.sleep(5);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         synchronized (this) {
//             for (int i = 1; i <= ticket; i++) {
//                 System.out.println(this.getName() + " : " + i);
//                 ticket--;
//             }
//         }

//     }
// }
