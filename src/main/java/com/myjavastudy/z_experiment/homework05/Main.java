package com.myjavastudy.z_experiment.homework05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * ClassName: Main
 * Description: 
 * 
 * 程序主入口
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-06 22:23:11
 */
public class Main {
    public static void main(String[] args) {
        mainUI(true);

        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Order> finishedQueue = new LinkedBlockingQueue<>();

        List<CustomerThread> customers = new ArrayList<>();
        List<Thread> customerThreads = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            CustomerThread customer = new CustomerThread(i, orderQueue);
            Thread thread = new Thread(customer, "Customer-" + i);
            customers.add(customer);
            customerThreads.add(thread);
            thread.start();
        }

        List<Cooker> cookers = new ArrayList<>();
        List<Thread> cookerThreads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cooker cooker = new Cooker(i, orderQueue, finishedQueue);
            Thread thread = new Thread(cooker, "Cooker-" + i);
            cookers.add(cooker);
            cookerThreads.add(thread);
            thread.start();
        }

        Waiter waiter = new Waiter(1, finishedQueue);
        Thread waiterThread = new Thread(waiter, "Waiter-1");
        waiterThread.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            for (CustomerThread customer : customers) {
                customer.stopRunning();
            }
            for (Cooker cooker : cookers) {
                cooker.stopRunning();
            }
            waiter.stopRunning();

            for (Thread thread : customerThreads) {
                thread.interrupt();
            }
            for (Thread thread : cookerThreads) {
                thread.interrupt();
            }
            waiterThread.interrupt();

            for (Thread thread : customerThreads) {
                joinQuietly(thread);
            }
            for (Thread thread : cookerThreads) {
                joinQuietly(thread);
            }
            joinQuietly(waiterThread);
        }
    }
    public static void mainUI(boolean flag){
        if (flag) {
            System.out.println("=====================");
            System.out.println("      点餐系统");
            System.out.println("顾客下单 -> 厨师做菜 -> 服务员送达");
            System.out.println("=====================");
        }
    }

    private static void joinQuietly(Thread thread) {
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
