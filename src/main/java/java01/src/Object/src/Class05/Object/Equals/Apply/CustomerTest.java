package Class05.Object.Equals.Apply;

/**
 * ClassName: CustomerTest
 * Package: Class05.Object.Equals.Apply
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 11:22
 * {@code @Version} 1.0
 */

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer =  new Customer("tom" , 12 , new Account(2000));
        Customer customer1 =  new Customer("tom" , 12 , new Account(2000));
//光重写Customer类的equal不好使，还需要重写Account中的
        System.out.println(customer1.equals(customer));
    }

}
