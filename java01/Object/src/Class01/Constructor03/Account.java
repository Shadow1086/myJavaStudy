package Class01.Constructor03;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description: 写一个名为Account的类模拟账户。该类的属性和方法如下图所示。
 * 该类包括的属性：账号id，余额balance，年利率annualInterestRate；
 * 包含的方法：访问器方法（getter和setter方法），取款方法withdraw()，存款方法deposit()。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:41
 * {@code @Version} 1.0
 */

public class Account {
    //属性
    private int id;
    private double balance;
    private double annualInterestRate;

    //方法；

    //构造器
    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("输入id有误");
        }
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("输入balance有误");
        }

        if (annualInterestRate > 0) {
            this.annualInterestRate = annualInterestRate;
        } else {
            System.out.println("输入annualInterestRate有误");
        }
    }


    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("输入id有误");
        }
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("输入balance有误");
        }
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate > 0) {
            this.annualInterestRate = annualInterestRate;
        } else {
            System.out.println("输入annualInterestRate有误");
        }
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
//取款方法
    public void withdraw(double num) {
        if (num > 0 && num <= balance) {
            balance -= num;
            System.out.println("取款成功，取得" + num + "元，账户余额：" + balance + "元");
        }else{
            System.out.println("取款失败，余额不足，余额为：" + balance);
        }
    }
//存款方法
    public void deposit(double num){
        if(num>0){
            balance += num;
            System.out.println("存款成功，余额为：" + balance);
        }else{
            System.out.println("存款失败");
        }
    }
}
