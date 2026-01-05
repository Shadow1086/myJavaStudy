package com.myjavastudy.z_experiment.homework05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: Writer
 * Description:
 * 
 * 3. 服务员线程（1个）：接收厨师的出餐通知，打印“订单X已送达顾客”，完成订单闭环。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-06 22:22:45
 */
public class Waiter implements Runnable {
    private final int waiterId;
    private final BlockingQueue<Order> finishedQueue;
    private volatile boolean running;

    public Waiter(int waiterId, BlockingQueue<Order> finishedQueue) {
        this.waiterId = waiterId;
        this.finishedQueue = finishedQueue;
        this.running = true;
    }

    public void stopRunning() {
        this.running = false;
    }

    @Override
    public void run(){
        while(running){
            try {
                Order order = finishedQueue.poll(500, TimeUnit.MILLISECONDS);
                if (order == null) {
                    continue;
                }
                System.out.printf("服务员%d送达: 订单%d已送达顾客%d%n",
                        waiterId, order.getOrderId(), order.getCustomerId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("服务员%d停止送达%n", waiterId);
                break;
            }
        }
    }
}
