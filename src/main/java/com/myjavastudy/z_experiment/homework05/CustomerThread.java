package com.myjavastudy.z_experiment.homework05;

import java.util.Random;
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
    private final int customerId;
    private final BlockingQueue<Order> orderQueue;
    private volatile boolean running;
    private final String[] menuItems;
    private static final String[] DRINKS = {"可乐", "果汁", "奶茶", "柠檬水"};
    private final Random random = new Random();

    public CustomerThread(int customerId, BlockingQueue<Order> orderQueue) {
        this.customerId = customerId;
        this.orderQueue = orderQueue;
        this.running = true;
        this.menuItems = new String[]{"汉堡", "牛排", "薯条", "披萨", "鸡腿"};
    }

    public void stopRunning() {
        this.running = false;
    }

    @Override
    public void run(){
        while(running){
            try {
                int sleepMillis = 1000 + random.nextInt(2000);
                Thread.sleep(sleepMillis);

                String dish = menuItems[random.nextInt(menuItems.length)];
                String drink = DRINKS[random.nextInt(DRINKS.length)];
                Order order = new Order(dish + "+" + drink, customerId);

                orderQueue.put(order);
                System.out.printf("顾客%d下单: 订单%d [%s]%n",
                        customerId, order.getOrderId(), order.getDishes());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("顾客%d停止下单%n", customerId);
                break;
            }
        }
    }
}
