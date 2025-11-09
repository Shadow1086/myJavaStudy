package com.myjavastudy.concurrency.java02.Practice;
/**
 * ClassName: AccountTest
 * Description: 
 * 
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000源，每次存1000元，存3次，每次存完打印账户余额，
 * 
 * 1. 明确哪些代码时多线程运行的代码，需写入run()方法
 * 2. 明确什么事共享数据
 * 3. 明确多线程运行代码中那些语句事操作共享数据的。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 22:32:15
 */
public class AccountTest {

}

class Account{
    private float balance = 3000;
    
    public float getBalance(){
        return balance;
    }
}

class Customer extends Thread{
    Account account;

    public Customer(Account account){
        
    }

}
// class Person implements Runnable{
//     static float balance = 3000;

//     @Override
//     public void run(){
//         save();
//     }
//     public synchronized void save(float money){
        
//     }

// }
