package com.myjavastudy.z_experiment.homework05;

import java.util.concurrent.BlockingQueue;

/**
 * ClassName: CustomerThread
 * Description:
 * 
 * 1. 顾客线程（3个）：随机间隔（1-3秒）生成订单（如“汉堡+可乐”“牛排+果汁”），将订单提交到“订单队列”。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-06 22:22:22
 */
public class CustomerThread implements Runnable {
    private int customerId;
    private BlockingQueue<Order> orderQueue;
    private volatile boolean running;
    private String[] menuItems;
    @Override
    public void run(){
        while(running){
            
        }
    }
}
