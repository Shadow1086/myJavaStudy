package com.myjavastudy.b_oop.class02_this.This02;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * <p>
 * 银行类
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 13:20
 * {@code @Version} 1.0
 */

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    //构造器：
    public Bank() {
        customers = new Customer[10];
    }
//方法：

    /**
     * 将指定姓名的客户保存在银行的客户列表中
     *
     * @param f firstName
     * @param l lastName
     *
     */
    public void addCustomer(String f, String l) {
        Customer cust = new Customer(f, l);
        customers[numberOfCustomer++] = cust;
    }

    /**
     * 获取客户列表中存储的客户的个数
     *
     * @return  客户列表人数
     */
    public int getNumOfCustomer() {
        return numberOfCustomer;
    }

    /**
     * 获取指定索引位置上的客户
     *
     * @param index     客户编号
     * @return          客户
     */
    public Customer getCustomer(int index) {
        if (index >= numberOfCustomer || index < 0) {
            System.out.println("无效的索引值");
            return null;
        } else {
            return customers[index];
        }
    }
}
