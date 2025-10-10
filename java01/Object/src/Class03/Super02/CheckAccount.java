package Class03.Super02;

/**
  * ClassName: CheckAccount
 * Package: Class03.Super02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 22:08
 * {@code @Version} 1.0
 */

public class CheckAccount extends Account {
    private double overdraft;

    public CheckAccount() {
        super();
    }

    public CheckAccount(double overdraft) {
        this();
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("fail");
            return;
        }

        if (amount <= balance) {
            System.out.println("success get " + amount);
            balance -= amount;
        } else { // amount > balance
            double need = amount - balance; // amount to cover from overdraft
            if (need <= overdraft) {
                // use up the balance, reduce overdraft by needed amount
                balance = 0;
                overdraft -= need;
                System.out.println("success get " + amount);
            } else {
                System.out.println("fail , overdraft = " + overdraft);
            }
        }
    }
}
