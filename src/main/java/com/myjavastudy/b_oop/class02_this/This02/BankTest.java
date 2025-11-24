package com.myjavastudy.b_oop.class02_this.This02;

/**
 * ClassName: Practice01
 * Package: Class02.This02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 14:31
 * {@code @Version} 1.0
 */

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("六","瑞");
        bank.addCustomer("为","王");
        bank.getCustomer(0).setAccount(new Account(1000));
        bank.getCustomer(0).getAccount().withdraw(50);
        System.out.println(bank.getCustomer(0).getAccount().getBalance());
        bank.getCustomer(1).setAccount(new Account(2000));

    }

}
