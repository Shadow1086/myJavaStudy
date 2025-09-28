package Class01.Test;

import Class01.Constructor.Constructor03.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(1, 1000, 0.05);
    }

    @AfterEach
    public void tearDown() {
        account = null;
    }

    @Test
    public void test构造器_正常情况() {
        Account acc = new Account(2, 500, 0.03);
        assertEquals(2, acc.getId());
        assertEquals(500, acc.getBalance());
        assertEquals(0.03, acc.getAnnualInterestRate());
    }

    @Test
    public void test构造器_无效id() {
        Account acc = new Account(-1, 500, 0.03);
        assertEquals(0, acc.getId()); // 默认值为0
    }

    @Test
    public void test构造器_无效balance() {
        Account acc = new Account(2, -500, 0.03);
        assertEquals(0, acc.getBalance()); // 默认值为0
    }

    @Test
    public void test构造器_无效annualInterestRate() {
        Account acc = new Account(2, 500, -0.03);
        assertEquals(0, acc.getAnnualInterestRate()); // 默认值为0
    }

    @Test
    public void test取款_正常情况() {
        account.withdraw(200);
        assertEquals(800, account.getBalance());
    }

    @Test
    public void test取款_余额不足() {
        account.withdraw(1100);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void test取款_无效金额() {
        account.withdraw(-100);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void test存款_正常情况() {
        account.deposit(200);
        assertEquals(1200, account.getBalance());
    }

    @Test
    public void test存款_无效金额() {
        account.deposit(-200);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testSetter_有效id() {
        account.setId(3);
        assertEquals(3, account.getId());
    }

    @Test
    public void testSetter_无效id() {
        account.setId(-3);
        assertEquals(1, account.getId()); // 保持原值
    }

    @Test
    public void testSetter_有效balance() {
        account.setBalance(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testSetter_无效balance() {
        account.setBalance(-500);
        assertEquals(1000, account.getBalance()); // 保持原值
    }

    @Test
    public void testSetter_有效annualInterestRate() {
        account.setAnnualInterestRate(0.1);
        assertEquals(0.1, account.getAnnualInterestRate());
    }

    @Test
    public void testSetter_无效annualInterestRate() {
        account.setAnnualInterestRate(-0.1);
        assertEquals(0.05, account.getAnnualInterestRate()); // 保持原值
    }
}
