package com.myjavastudy.oop.class06_static.Static.Exer02;

/**
 * ClassName: AccountTest
 * Package: Class06.Static.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/8 20:31
 * {@code @Version} 1.0
 */

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        System.out.println(account1.toString());

        Account.setRate(0.1);

        Account account2 =new Account("123456" , 2000);
        System.out.println(account2.toString());
    }

}
