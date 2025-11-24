package com.myjavastudy.b_oop.class03_inheritance.super02;

/**
  * ClassName: AccountTest
 * Package: Class03.Super02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 22:05
 * {@code @Version} 1.0
 */

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000,0.045);
        account.withdraw(5000);
        System.out.println(account.getBalance());
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterest());
    }

}
