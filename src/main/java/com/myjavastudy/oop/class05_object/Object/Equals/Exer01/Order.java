package com.myjavastudy.oop.class05_object.Object.Equals.Exer01;

/**
 * ClassName: Order
 * Package: Class05.Object.Equals.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 11:29
 * {@code @Version} 1.0
 */

public class Order {
    private int orderId;
    private String orderName;

    public Order() {
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object instanceof Order order){
            return this.orderId == order.orderId && this.orderName.equals(order.orderName);
        }
        return false;
    }
}
