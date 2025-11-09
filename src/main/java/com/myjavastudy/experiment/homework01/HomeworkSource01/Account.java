package com.myjavastudy.experiment.homework01.HomeworkSource01;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * ClassName: Account
 * Description:
 * 
 *  声明银行账户类Account，成员变量包括账号、储户姓名、开户时间、身份证号码、存款余额等账户信息，
 * 成员方法包括开户、存款、取款、查询（余额、明细）、销户等操作。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-13 18:13:13
 * {@code @Version} 1.0
 */

public class Account{
    //声明属性
    private String account;
    private String name;
    private String time;
    private String personId;
    private double balance;
    // private Details[] details = new Details[5];
    // private Details details;
    private static Scanner input = new Scanner(System.in);

    // 无参构造器
    public Account() {
    }

    // 全参构造器
    private Account(String name, String personId, double balance) {
        this.name = name;
        this.personId = personId;
        this.balance = balance;
//让时间戳成为账户
        this.account = String.valueOf(System.currentTimeMillis());

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
        this.time = sdf.format(date);
    }

    // Getter and Setter 方法
    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getPersonId() {
        return personId;
    }

    public double getBalance() {
        return balance;
    }

//成员方法包括开户、存款、取款、查询（余额、明细）、销户等操作。
    //账号、储户姓名、开户时间、身份证号码、存款余额等账户信息，
    /**
     * 初始化账户,调用私有构造器
     * @return void
     */
    public  Account initAccount(){
        System.out.print("请输入姓名：");
        String initName = input.next();

        System.out.print("请输入身份证号：");
        String initId = input.next();

        System.out.print("请输入存款余额：");
        double initBalance = input.nextDouble();

        if (balance < 0) {
            System.out.println("输入余额有误");
            return null;
        }
        return new Account(initName, initId, initBalance);
    }

    //存款方法
    public void deposit(double money){
        if(money<=0){
            System.out.println("输入金额有误");
        }else{
            balance += money;
            System.out.println("存入"+ money + "元，余额为：" + balance);
            // details.addRecord("存入"+ money + "元，余额为：" + balance);
        }
    }

    //取钱方法
    public void withdraw(double money){
        if(money<=0||balance<money){
            System.out.println("输入金额有误，或余额不足");
        }else{
            balance -= money;
            System.out.println("取出"+ money + "元，余额为：" + balance);
        }
    }


    public String toString(){
        return account + ": 姓名：" + name+ "\t余额：" + balance  +"元";
    }

    //查询信息
    public void info(){
        // System.out.println(this.toString());
        System.out.println(
            "------账户信息------"
            +"\n账号     :" + account
            +"\n姓名     :"   + name
            +"\n身份证号 :"   + personId
            +"\n开户时间 :"   + time
            +"\n当前余额 :"   + balance + "元\n"
            +"---------------------"
            );
    }

    //销户
    public boolean cancelAccount(){
        System.out.println("请慎重考虑，一旦操作不可撤回(Y/n)");

        char checking = input.next().charAt(0);
        if(checking == 'Y' || checking =='y'){
            name = null;
            personId = null;
            account = null;
            time = null;
            System.out.println("账户注销成功，余额：" + balance + "元，已提出，请及时取走");
            balance = 0;
            return true;
        }else if(checking == 'N' ||checking =='n'){
            System.out.println("已退出");
        }else{
            System.out.println("输入错误，已退出");
        }
        return false;
    }

    //查询明细
    public void transactionDetails(){

    }



}