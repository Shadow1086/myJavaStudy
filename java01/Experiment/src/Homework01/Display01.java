package Homework01;

//导入动态数组
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: Display01
 * Description:
 * 
 * AccountTest中的界面类
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-13 19:33:34
 * {@code @Version} 1.0
 */
public class Display01 {
    public static Scanner input = new Scanner(System.in);

    // 保存所有已经开户的账户信息
    private static final ArrayList<Account> accountArr = new ArrayList<>();

    public static void show() {
        System.out.print(
                "----------主界面----------\n" +
                        "1. 注册账户\n" +
                        "2. 查询信息\n" +
                        "3. 存钱\n" +
                        "4. 取钱\n" +
                        "5. 注销账户\n" +
                        "0. 退出系统\n " +
                        "请输入想实现的功能编码：");
    }
//程序入口，调用其他方法，中介
    public static void start() {
        boolean flag = true;
        while (flag) {
            show();
            int ficNum = input.nextInt();
            switch (ficNum) {
                // 注册账户
                case 1:
                    createAccount();
                    break;
                // 查询信息
                case 2:
                    // account.info();
                    findInfo();
                    break;
                // 存钱
                case 3:
                    deposit();
                    break;
                // 取钱
                case 4:
                    withdraw();
                    break;
                // 注销账户
                case 5:
                    cancelAccount();
                    break;
                case 0:
                    flag  = false;
                    break;
                default:
                System.out.println("输入错误");
                    break;
            }

        }

    }

    // 说明进行处理的账户是哪一个
    public static Account selectAccount() {
        System.out.print("请输入账户id或持有人姓名：");
        String inputInfo = input.next();
        for (Account account : accountArr) {
            if (account.getAccount() == inputInfo || account.getName().equalsIgnoreCase(inputInfo)) {
                return account;
            }
        }
        System.out.println("错误，请重新检查您的输入");
        return null;
    }

    // 注册
    public static Account createAccount() {
        System.out.println("----------注册账户-----------");
        Account account = new Account().initAccount();
        // 判断是否创建成功，如果成功的话直接加入至已开户的用户列表
        if (account != null) {
            accountArr.add(account);
        } else {
            // 若未创建成功，则会返回错误。
            System.out.println("创建失败，请重新检查输入信息，并重试");
            return null;
        }
        System.out.println("创建成功，账户信息如下：");
        account.info();
        return account;
    }

    //查询信息：
    public static void findInfo(){
        System.out.println("------------查询信息------------");
        Account account = selectAccount();
        if(account!=null){
            account.info();
        }
    }

    //取钱
    public static void deposit(){
        System.out.println("----------------存钱---------------");
        Account account = selectAccount();
        if(account!=null){
            System.out.print("请输入存入的金额：");
        double number = input.nextDouble();
        account.deposit(number);
        }
    }

    //存钱
    public static void withdraw(){
        System.out.println("----------------取钱---------------");
        Account account = selectAccount();
        if(account !=null){
            System.out.print("请输入取出的金额：");
            double number = input.nextDouble();
            account.withdraw(number);
        }
        
    }

    //注销
    public static void cancelAccount(){
        System.out.println("----------------注销账户（请小心）---------------");
        Account account = selectAccount();
        if(account!=null){
            account.cancelAccount();
            accountArr.remove(account);
        }
        
    }
}
