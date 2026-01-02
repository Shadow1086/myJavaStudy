package com.myjavastudy.z_experiment.homework05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单订单模型，包含唯一 id、内容、创建时间戳。
 */
public class Order {
    // 自增，相当于SQL中的AUTO_INCREMENT，使得线程安全
    private static final AtomicInteger ID_GENERATED = new AtomicInteger(1);

    private final int orderId;
    private final String dishes;
    private final int customerId;
    private final long orderTime;
    private Status status;
//枚举类型
    private enum Status {
        PENDING,COOKING,COMPLETED // 等待中，烹饪中，已完成
    }

    public Order(String dishes , int customerId){
        this.orderId = ID_GENERATED.getAndIncrement();  // 自动生成订单号
        this.dishes = dishes;
        this.customerId = customerId;
        this.orderTime = System.currentTimeMillis();
        this.status = Status.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDishes() {
        return dishes;
    }

    public int getCustomerId() {
        return customerId;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
}
