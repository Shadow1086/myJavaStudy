package Class01.Constructor03;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:41
 * {@code @Version} 1.0
 */

public class CustomerTest {
    public static void main(String[] args){
        Customer c1 = new Customer("Jane" , " Smith");
//        Account account = new Account(100000,2000,0.0123);
//        c1.setAccount(account);

        //匿名对象：
        c1.setAccount(new Account(100000,2000,0.0123));

        c1.getAccount().deposit(100);
        c1.getAccount().withdraw(960);
        c1.getAccount().withdraw(2000);

    }
}
