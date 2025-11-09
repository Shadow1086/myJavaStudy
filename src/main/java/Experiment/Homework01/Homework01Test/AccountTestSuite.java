package Homework01.Homework01Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Homework01.HomeworkSource01.Account;
import Homework01.HomeworkSource01.Display01;

/**
 * 手写回归测试套件：运行 main() 可查看每个用例的期望值与实际值。
 */
public class AccountTestSuite {

    private static final List<TestResult> RESULTS = new ArrayList<>();
    private static final double EPSILON = 1e-6;

    public static void main(String[] args) {
        run("Account.deposit 增加余额", AccountTestSuite::testDepositIncreasesBalance);
        run("Account.deposit 拒绝非法金额", AccountTestSuite::testDepositRejectsInvalidAmount);
        run("Account.withdraw 成功扣款", AccountTestSuite::testWithdrawDecreasesBalance);
        run("Account.withdraw 拒绝超额取款", AccountTestSuite::testWithdrawRejectsWhenInsufficient);
        run("Account.cancelAccount 确认后注销", AccountTestSuite::testCancelAccountConfirmed);
        run("Account.cancelAccount 拒绝后保留", AccountTestSuite::testCancelAccountDeclined);
        run("Account.initAccount 允许重新输入余额", AccountTestSuite::testInitAccountRetryOnInvalidBalance);
        run("Display01.selectAccount 账号匹配", AccountTestSuite::testSelectAccountById);
        run("Display01.selectAccount 姓名匹配", AccountTestSuite::testSelectAccountByName);
        run("Display01.cancelAccount 确认后移除", AccountTestSuite::testDisplayCancelRemovesWhenConfirmed);
        run("Display01.cancelAccount 拒绝后仍被移除", AccountTestSuite::testDisplayCancelRemovesWhenDeclined);

        printReport();
    }

    private static void run(String name, TestExecutable executable) {
        try {
            TestOutcome outcome = executable.execute();
            RESULTS.add(new TestResult(name, outcome));
        } catch (Throwable t) {
            String actual = "异常: " + t.getClass().getSimpleName() + " - " + t.getMessage();
            String details = stackTraceToString(t);
            RESULTS.add(new TestResult(name,
                    new TestOutcome("测试应当正常完成", actual, false, details)));
        }
    }

    private static TestOutcome testDepositIncreasesBalance() throws Exception {
        Account account = buildAccount("ACC100", "Alice", "ID123", 100.0, "2025-10-14 10:00:00");
        CaptureResult<Void> capture = captureOutput(() -> {
            account.deposit(50.0);
            return null;
        });

        double actualBalance = account.getBalance();
        boolean passed = Math.abs(actualBalance - 150.0) < EPSILON;
        String expected = "余额应增加到 150.0";
        String actual = "余额=" + actualBalance + ", 输出=" + sanitize(capture.output);
        return new TestOutcome(expected, actual, passed, "");
    }

    private static TestOutcome testDepositRejectsInvalidAmount() throws Exception {
        Account account = buildAccount("ACC101", "Bob", "ID456", 100.0, "2025-10-14 10:05:00");
        CaptureResult<Void> capture = captureOutput(() -> {
            account.deposit(-10.0);
            return null;
        });

        double actualBalance = account.getBalance();
        boolean balanceOk = Math.abs(actualBalance - 100.0) < EPSILON;
        boolean messageOk = sanitize(capture.output).contains("输入金额有误");
        boolean passed = balanceOk && messageOk;
        String expected = "余额保持 100.0 且提示 \"输入金额有误\"";
        String actual = "余额=" + actualBalance + ", 输出=" + sanitize(capture.output);
        StringBuilder details = new StringBuilder();
        if (!balanceOk) {
            details.append("余额发生变化；");
        }
        if (!messageOk) {
            details.append("未输出错误提示；");
        }
        return new TestOutcome(expected, actual, passed, details.toString());
    }

    private static TestOutcome testWithdrawDecreasesBalance() throws Exception {
        Account account = buildAccount("ACC200", "Carol", "ID789", 100.0, "2025-10-14 10:10:00");
        CaptureResult<Void> capture = captureOutput(() -> {
            account.withdraw(40.0);
            return null;
        });

        double actualBalance = account.getBalance();
        boolean passed = Math.abs(actualBalance - 60.0) < EPSILON;
        String expected = "余额应扣至 60.0";
        String actual = "余额=" + actualBalance + ", 输出=" + sanitize(capture.output);
        return new TestOutcome(expected, actual, passed, "");
    }

    private static TestOutcome testWithdrawRejectsWhenInsufficient() throws Exception {
        Account account = buildAccount("ACC201", "Dave", "ID999", 30.0, "2025-10-14 10:15:00");
        CaptureResult<Void> capture = captureOutput(() -> {
            account.withdraw(50.0);
            return null;
        });

        double actualBalance = account.getBalance();
        boolean balanceOk = Math.abs(actualBalance - 30.0) < EPSILON;
        boolean messageOk = sanitize(capture.output).contains("输入金额有误，或余额不足");
        boolean passed = balanceOk && messageOk;
        String expected = "余额保持 30.0 且提示余额不足";
        String actual = "余额=" + actualBalance + ", 输出=" + sanitize(capture.output);
        StringBuilder details = new StringBuilder();
        if (!balanceOk) {
            details.append("余额被错误扣减；");
        }
        if (!messageOk) {
            details.append("缺少余额不足提示；");
        }
        return new TestOutcome(expected, actual, passed, details.toString());
    }

    private static TestOutcome testCancelAccountConfirmed() throws Exception {
        Account account = buildAccount("ACC300", "Eve", "ID777", 200.0, "2025-10-14 10:20:00");
        return withScanner(Account.class, "input", "y\n", () -> {
            CaptureResult<Boolean> capture = captureOutput(account::cancelAccount);
            boolean fieldsCleared = account.getName() == null && account.getPersonId() == null
                    && account.getAccount() == null && account.getBalance() == 0.0;
            boolean passed = capture.value && fieldsCleared;
            String expected = "确认后返回 true 且账号信息清空";
            String actual = "返回=" + capture.value + ", name=" + account.getName() + ", balance=" + account.getBalance();
            String details = fieldsCleared ? "" : "取消后仍有残留字段";
            return new TestOutcome(expected, actual, passed, details);
        });
    }

    private static TestOutcome testCancelAccountDeclined() throws Exception {
        Account account = buildAccount("ACC301", "Eve", "ID888", 150.0, "2025-10-14 10:25:00");
        return withScanner(Account.class, "input", "n\n", () -> {
            CaptureResult<Boolean> capture = captureOutput(account::cancelAccount);
            boolean fieldsIntact = "Eve".equals(account.getName()) && "ID888".equals(account.getPersonId())
                    && "ACC301".equals(account.getAccount()) && Math.abs(account.getBalance() - 150.0) < EPSILON;
            boolean passed = !capture.value && fieldsIntact;
            String expected = "拒绝后返回 false 且账户保持不变";
            String actual = "返回=" + capture.value + ", name=" + account.getName() + ", balance=" + account.getBalance();
            String details = fieldsIntact ? "" : "拒绝后字段被修改";
            return new TestOutcome(expected, actual, passed, details);
        });
    }

    private static TestOutcome testInitAccountRetryOnInvalidBalance() throws Exception {
        return withScanner(Account.class, "input", "Alice\n123456\n-100\n50\n", () -> {
            CaptureResult<Account> capture = captureOutput(() -> new Account().initAccount());
            boolean passed = capture.value != null;
            String expected = "错误余额后重新输入 50 并成功开户";
            String actual = (capture.value == null ? "返回 null" : "成功返回账户")
                    + ", 输出=" + sanitize(capture.output);
            String details = "当前实现未重新校验 initBalance，导致直接返回 null";
            return new TestOutcome(expected, actual, passed, details);
        });
    }

    private static TestOutcome testSelectAccountById() throws Exception {
        List<Account> list = getAccountList();
        list.clear();
        Account account = buildAccount("ACC900", "Frank", "ID900", 80.0, "2025-10-14 10:30:00");
        list.add(account);

        return withScanner(Display01.class, "input", "ACC900\n", () -> {
            CaptureResult<Account> capture = captureOutput(Display01::selectAccount);
            boolean passed = capture.value == account;
            String expected = "输入账号 ACC900 应返回对应账户";
            String actual = capture.value == null ? "返回 null" : "返回账户: " + capture.value.getAccount();
            String details = "使用 == 比较字符串导致匹配失败";
            return new TestOutcome(expected, actual, passed, details);
        });
    }

    private static TestOutcome testSelectAccountByName() throws Exception {
        List<Account> list = getAccountList();
        list.clear();
        Account account = buildAccount("ACC901", "Grace", "ID901", 90.0, "2025-10-14 10:35:00");
        list.add(account);

        return withScanner(Display01.class, "input", "grace\n", () -> {
            CaptureResult<Account> capture = captureOutput(Display01::selectAccount);
            boolean passed = capture.value == account;
            String expected = "大小写无关的姓名匹配应成功";
            String actual = capture.value == null ? "返回 null" : "返回账户: " + capture.value.getAccount();
            return new TestOutcome(expected, actual, passed, passed ? "" : "姓名匹配未成功");
        });
    }

    private static TestOutcome testDisplayCancelRemovesWhenConfirmed() throws Exception {
        List<Account> list = getAccountList();
        list.clear();
        Account account = buildAccount("ACC910", "Helen", "ID910", 120.0, "2025-10-14 10:40:00");
        list.add(account);

        return withScanner(Display01.class, "input", "helen\n", () -> withScanner(Account.class, "input", "y\n", () -> {
            CaptureResult<Void> capture = captureOutput(() -> {
                Display01.cancelAccount();
                return null;
            });
            boolean passed = list.isEmpty();
            String expected = "确认后账户应被移出列表";
            String actual = "剩余账户数量=" + list.size() + ", 输出=" + sanitize(capture.output);
            return new TestOutcome(expected, actual, passed, "");
        }));
    }

    private static TestOutcome testDisplayCancelRemovesWhenDeclined() throws Exception {
        List<Account> list = getAccountList();
        list.clear();
        Account account = buildAccount("ACC911", "Ivan", "ID911", 130.0, "2025-10-14 10:45:00");
        list.add(account);

        return withScanner(Display01.class, "input", "ivan\n", () -> withScanner(Account.class, "input", "n\n", () -> {
            CaptureResult<Void> capture = captureOutput(() -> {
                Display01.cancelAccount();
                return null;
            });
            boolean passed = list.size() == 1;
            String expected = "拒绝销户后账户应仍在列表";
            String actual = "剩余账户数量=" + list.size() + ", 输出=" + sanitize(capture.output);
            String details = passed ? "" : "取消操作后仍被移除";
            return new TestOutcome(expected, actual, passed, details);
        }));
    }

    private static void printReport() {
        System.out.println("========== Homework01 测试报告 ==========");
        int passCount = 0;
        for (TestResult result : RESULTS) {
            if (result.outcome.passed) {
                passCount++;
            }
            System.out.println("[" + (result.outcome.passed ? "PASS" : "FAIL") + "] " + result.name);
            System.out.println("  期望：" + result.outcome.expected);
            System.out.println("  实际：" + result.outcome.actual);
            if (result.outcome.details != null && !result.outcome.details.isEmpty()) {
                System.out.println("  说明：" + result.outcome.details);
            }
        }
        int total = RESULTS.size();
        int failCount = total - passCount;
        System.out.println("----------------------------------------");
        System.out.println("合计 " + total + " 项，用例通过 " + passCount + " 项，失败 " + failCount + " 项。");
        if (failCount > 0) {
            System.out.println("请根据失败用例中的说明定位并修复问题。");
        } else {
            System.out.println("全部用例通过。");
        }
    }

    private static Account buildAccount(String accountNo, String name, String personId, double balance, String time) throws Exception {
        Account account = new Account();
        setField(Account.class, account, "account", accountNo);
        setField(Account.class, account, "name", name);
        setField(Account.class, account, "personId", personId);
        setField(Account.class, account, "balance", balance);
        setField(Account.class, account, "time", time);
        return account;
    }

    @SuppressWarnings("unchecked")
    private static List<Account> getAccountList() throws Exception {
        Field field = Display01.class.getDeclaredField("accountArr");
        field.setAccessible(true);
        return (List<Account>) field.get(null);
    }

    private static void setField(Class<?> clazz, Object target, String fieldName, Object value) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static String sanitize(String text) {
        return text == null ? "" : text.replace("\r", "").trim();
    }

    private static String stackTraceToString(Throwable t) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);
        t.printStackTrace(ps);
        ps.flush();
        return out.toString();
    }

    private static <T> CaptureResult<T> captureOutput(OutputAction<T> action) throws Exception {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(buffer, true);
        try {
            System.setOut(ps);
            T value = action.run();
            ps.flush();
            return new CaptureResult<>(value, buffer.toString(StandardCharsets.UTF_8));
        } finally {
            System.setOut(originalOut);
            ps.close();
        }
    }

    private static <T> T withScanner(Class<?> clazz, String fieldName, String data, ScannerAction<T> action) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Scanner originalScanner = (Scanner) field.get(null);
        InputStream originalIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        Scanner newScanner = new Scanner(in);
        try {
            field.set(null, newScanner);
            System.setIn(in);
            return action.run();
        } finally {
            field.set(null, originalScanner);
            System.setIn(originalIn);
            newScanner.close();
        }
    }

    private interface TestExecutable {
        TestOutcome execute() throws Exception;
    }

    @FunctionalInterface
    private interface OutputAction<T> {
        T run() throws Exception;
    }

    @FunctionalInterface
    private interface ScannerAction<T> {
        T run() throws Exception;
    }

    private static class CaptureResult<T> {
        final T value;
        final String output;

        CaptureResult(T value, String output) {
            this.value = value;
            this.output = output;
        }
    }

    private static class TestOutcome {
        final String expected;
        final String actual;
        final boolean passed;
        final String details;

        TestOutcome(String expected, String actual, boolean passed, String details) {
            this.expected = expected;
            this.actual = actual;
            this.passed = passed;
            this.details = details == null ? "" : details;
        }
    }

    private static class TestResult {
        final String name;
        final TestOutcome outcome;

        TestResult(String name, TestOutcome outcome) {
            this.name = name;
            this.outcome = outcome;
        }
    }
}


