package com.myjavastudy.b_oop.class03_inheritance.super02;

/**
  * ClassName: CheckAccountTest
 * Package: Class03.Super02
 * Description:
 * 测试 CheckAccount 类的取款逻辑：
 * - 创建账号1122，余额20000，年利率4.5%，可透支限额5000的账户
 * - 依次执行 withdraw(5000), withdraw(18000), withdraw(3000)
 * - 打印每次操作后的实际余额/可透支与期望值，并标注测试是否通过
 *
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 22:19
 * {@code @Version} 1.0
 */

public class CheckAccountTest {

    private static boolean approxEqual(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    private static void printAndCheck(int caseNo, double expectedBalance, double expectedOverdraft, double actualBalance, double actualOverdraft) {
        System.out.println("Case " + caseNo + ":");
        System.out.printf("  Expected -> balance: %.2f, overdraft: %.2f%n", expectedBalance, expectedOverdraft);
        System.out.printf("  Actual   -> balance: %.2f, overdraft: %.2f%n", actualBalance, actualOverdraft);
        boolean pass = approxEqual(expectedBalance, actualBalance) && approxEqual(expectedOverdraft, actualOverdraft);
        System.out.println(pass ? "  Result: PASS" : "  Result: FAIL");
        System.out.println();
    }

    public static void main(String[] args) {
        // 初始化账户
        CheckAccount account = new CheckAccount(1122, 20000, 0.045, 5000);

        int passed = 0;
        int total = 3;

        // Case 1: withdraw 5000 -> balance 15000, overdraft 5000
        System.out.println("Performing withdraw(5000)");
        account.withdraw(5000);
        double actualBal1 = account.getBalance();
        double actualOvd1 = account.getOverdraft();
        double expectBal1 = 15000.0;
        double expectOvd1 = 5000.0;
        printAndCheck(1, expectBal1, expectOvd1, actualBal1, actualOvd1);
        if (approxEqual(actualBal1, expectBal1) && approxEqual(actualOvd1, expectOvd1)) passed++;

        // Case 2: withdraw 18000 -> uses overdraft: expected balance 0, overdraft 2000
        System.out.println("Performing withdraw(18000)");
        account.withdraw(18000);
        double actualBal2 = account.getBalance();
        double actualOvd2 = account.getOverdraft();
        double expectBal2 = 0.0;
        double expectOvd2 = 2000.0;
        printAndCheck(2, expectBal2, expectOvd2, actualBal2, actualOvd2);
        if (approxEqual(actualBal2, expectBal2) && approxEqual(actualOvd2, expectOvd2)) passed++;

        // Case 3: withdraw 3000 -> should fail (insufficient overdraft), state unchanged: balance 0, overdraft 2000
        System.out.println("Performing withdraw(3000)");
        account.withdraw(3000);
        double actualBal3 = account.getBalance();
        double actualOvd3 = account.getOverdraft();
        double expectBal3 = 0.0;
        double expectOvd3 = 2000.0;
        printAndCheck(3, expectBal3, expectOvd3, actualBal3, actualOvd3);
        if (approxEqual(actualBal3, expectBal3) && approxEqual(actualOvd3, expectOvd3)) passed++;

        System.out.printf("Summary: Passed %d/%d cases.%n", passed, total);
        if (passed == total) {
            System.out.println("All tests PASSED.");
        } else {
            System.out.println("Some tests FAILED. Check CheckAccount.withdraw implementation.");
        }
    }
}
