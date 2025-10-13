package Homework01Instance;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * AccountManager 作为一个简单的“控制台界面”，帮助你把各个功能串起来。
 * <p>
 * 这里没有使用文件或数据库，仅用 List 保存账户。程序退出后数据会丢失，
 * 这样可以专注于练习类与方法之间的协作，而不用担心持久化的问题。
 */
public class AccountManager {

    /** 保存所有已经开户的账户。 */
    private final List<Account> accounts = new ArrayList<>();

    /** 统一使用一个 Scanner，避免重复创建和关闭导致的问题。 */
    private final Scanner scanner = new Scanner(System.in);

    /** 主循环：展示菜单并根据用户输入调用不同的功能。 */
    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    handleCreateAccount();
                    break;
                case "2":
                    handleShowSummary();
                    break;
                case "3":
                    handleDeposit();
                    break;
                case "4":
                    handleWithdraw();
                    break;
                case "5":
                    handleShowHistory();
                    break;
                case "6":
                    handleCloseAccount();
                    break;
                case "0":
                    running = false;
                    System.out.println("感谢使用，再见！");
                    break;
                default:
                    System.out.println("无法识别的选项，请重新输入。");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n========= 银行账户系统 =========");
        System.out.println("1. 注册账户");
        System.out.println("2. 查询账户信息");
        System.out.println("3. 存款");
        System.out.println("4. 取款");
        System.out.println("5. 查询交易明细");
        System.out.println("6. 销户");
        System.out.println("0. 退出系统");
        System.out.print("请输入想实现的功能编号：");
    }

    private void handleCreateAccount() {
        System.out.println("\n--- 注册账户 ---");
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();

        System.out.print("请输入身份证号（18 位）：");
        String id = scanner.nextLine();

        System.out.print("请输入初始存款金额：");
        double initDeposit = readDouble();

        Account account = Account.create(name, id, initDeposit);
        if (account != null) {
            accounts.add(account);
            System.out.println("账户注册成功，账号为：" + account.getAccountNumber());
        } else {
            System.out.println("注册失败，请按照提示重新尝试。");
        }
    }

    private void handleShowSummary() {
        Account account = selectAccount();
        if (account != null) {
            account.printSummary();
        }
    }

    private void handleDeposit() {
        Account account = selectAccount();
        if (account == null) {
            return;
        }

        System.out.print("请输入存款金额：");
        double amount = readDouble();
        account.deposit(amount);
    }

    private void handleWithdraw() {
        Account account = selectAccount();
        if (account == null) {
            return;
        }

        System.out.print("请输入取款金额：");
        double amount = readDouble();
        account.withdraw(amount);
    }

    private void handleShowHistory() {
        Account account = selectAccount();
        if (account != null) {
            account.printTransactionHistory();
        }
    }

    private void handleCloseAccount() {
        Account account = selectAccount();
        if (account == null) {
            return;
        }

        if (!account.closeAccount()) {
            System.out.println("已取消销户操作。");
            return;
        }

        System.out.print("确认销户？输入 'Y' 确认，其他键取消：");
        String confirm = scanner.nextLine().trim();
        if ("Y".equalsIgnoreCase(confirm)) {
            account.markAsClosed();
            accounts.remove(account);
            System.out.println("账户已成功销户。");
        } else {
            System.out.println("已取消销户。");
        }
    }

    /**
     * 让用户在已有账户中选择一个。
     * 如果当前列表为空，直接提示并返回 null。
     */
    private Account selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println("当前还没有任何账户，请先注册一个。");
            return null;
        }

        System.out.println("\n--- 请选择账户 ---");
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            System.out.printf(Locale.CHINA, "%d) %s (余额：%.2f 元)\n",
                    i + 1, acc.getAccountNumber(), acc.getBalance());
        }
        System.out.print("请输入序号：");
        int index = readInt();
        if (index < 1 || index > accounts.size()) {
            System.out.println("序号不存在，请重新尝试。");
            return null;
        }
        return accounts.get(index - 1);
    }

    /**
     * 从控制台读取一个 double，遇到非法输入时重复提示直到成功。
     */
    private double readDouble() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("请输入正确的数字：");
            }
        }
    }

    /**
     * 从控制台读取一个 int。
     */
    private int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("请输入合法的序号：");
            }
        }
    }
}
