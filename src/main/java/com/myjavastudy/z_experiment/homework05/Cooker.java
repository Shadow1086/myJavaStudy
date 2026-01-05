package com.myjavastudy.z_experiment.homework05;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: Cooker
 * Description:
 * 
 * 2. 厨师线程（2个）：从订单队列中取单，耗时（2-4秒）制作食物，完成后通知服务员。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-06 22:22:36
 */
public class Cooker implements Runnable {
    private final int cookerId;
    private final BlockingQueue<Order> orderQueue;
    private final BlockingQueue<Order> finishedQueue;
    private final Random random = new Random();
    private volatile boolean running;

    public Cooker(int cookerId, BlockingQueue<Order> orderQueue, BlockingQueue<Order> finishedQueue) {
        this.cookerId = cookerId;
        this.orderQueue = orderQueue;
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
                Order order = orderQueue.poll(500, TimeUnit.MILLISECONDS);
                if (order == null) {
                    continue;
                }
                System.out.printf("厨师%d接单: 订单%d [%s]%n",
                        cookerId, order.getOrderId(), order.getDishes());

                int cookMillis = 2000 + random.nextInt(2000);
                Thread.sleep(cookMillis);

                finishedQueue.put(order);
                System.out.printf("厨师%d出餐: 订单%d%n", cookerId, order.getOrderId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("厨师%d停止接单%n", cookerId);
                break;
            }
        }
    }
}
