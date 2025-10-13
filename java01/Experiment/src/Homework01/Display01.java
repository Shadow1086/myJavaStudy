package Homework01;
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
    public static void show(){
        System.out.print(
            "----------主界面----------\n" +
            "1. 注册账户\n" +
            "2. 查询信息\n" +
            "3. 存钱\n" +
            "4. 取钱\n" +
            "5. 注销账户\n" + 
            "0. 退出系统\n " + 
            "请输入想实现的功能编码："
        );  
    }

    public static void start(){
        boolean flag = true;
        while(flag){
            int ficNum =input.nextInt();
            show();
            switch (ficNum) {
                //注册账户
                case 1:
                    createAccount();
                    break;
                    // 查询信息
                case 2:
                    account.info();
                    break;
                    //存钱
                case 3:

                    break;
                    //取钱
                case 4:

                    break;
                    //注销账户
                case 5:

                    break;

                default:
                    break;
            }

        }

    }
    public Account seleAccount(){
        
    }
    //注册
    public static Account createAccount(){
        System.out.println("----------注册账户-----------");
        Account account = new Account();
        account.initAccount();
        return account;
    }


}
