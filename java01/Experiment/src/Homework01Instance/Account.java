package Homework01Instance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 账户实体类，负责保存银行账户的所有核心信息，并提供和金额相关的操作。
 * <p>
 * 本类只关心“一张卡”内部发生的事情：
 * <ul>
 *     <li>存款、取款等金额操作</li>
 *     <li>记录交易明细</li>
 *     <li>展示账户的概要信息</li>
 *     <li>销户时清除信息</li>
 * </ul>
 * 如果你以后想要管理很多账户，可以在其他类里维护一个 {@code List<Account>}，
 * 本类无需关心集合管理的细节。
 */
public class Account {

    /** 自动生成的账号。为了便于阅读，我们在时间戳前面加上 "ACC-" 前缀。 */
    private final String accountNumber;

    /** 账户持有人姓名。 */
    private String ownerName;

    /** 身份证号码（简单校验长度即可）。 */
    private final String personalId;

    /** 开户时间。使用字符串保存，避免引入日期类带来的复杂性。 */
    private final String openTime;

    /** 当前账户余额。 */
    private double balance;

    /** 负责记录所有交易明细的帮助类。 */
    private final TransactionHistory history = new TransactionHistory();

    /**
     * 私有构造器，统一通过 {@link #create(String, String, double)} 来实例化。
     * 这样可以保证账号、时间等字段在创建时就被正确地初始化。
     */
    private Account(String ownerName, String personalId, double balance) {
        this.accountNumber = generateAccountNumber();
        this.openTime = now();
        this.ownerName = ownerName;
        this.personalId = personalId;
        this.balance = balance;

        // 创建账户时立即写入一条交易明细，方便回顾
        history.addRecord(
                "开户",
                balance,
                balance,
                "欢迎开户，初始存入金额：" + String.format(Locale.CHINA, "%.2f", balance) + " 元"
        );
    }

    /**
     * 工厂方法：负责校验入参并返回一个新的 Account 实例。
     * <p>
     * 这样做的好处是：
     * <ul>
     *     <li>所有必填字段可以集中校验</li>
     *     <li>外部在创建失败时能拿到明确的错误信息</li>
     * </ul>
     */
    public static Account create(String ownerName, String personalId, double initDeposit) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            System.out.println("⚠ 姓名不能为空，开户失败。请重新输入。");
            return null;
        }
        if (!isPersonalIdValid(personalId)) {
            System.out.println("⚠ 身份证号码格式不正确，应为 18 位。请重新输入。");
            return null;
        }
        if (initDeposit < 0) {
            System.out.println("⚠ 初始存款不能为负数。请重新输入。");
            return null;
        }
        return new Account(ownerName.trim(), personalId.trim(), initDeposit);
    }

    /**
     * 存款操作。
     *
     * @param amount 存入的金额
     * @return 是否存款成功。如果金额不合法则返回 {@code false}。
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("⚠ 存款金额必须大于 0");
            history.addRecord("存款失败", amount, balance, "输入金额≤0，未改变余额");
            return false;
        }
        balance += amount;
        history.addRecord("存款", amount, balance, "成功存入现金");
        System.out.printf(Locale.CHINA, "✅ 存款成功，当前余额：%.2f 元%n", balance);
        return true;
    }

    /**
     * 取款操作。
     *
     * @param amount 取出的金额
     * @return 是否取款成功。
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("⚠ 取款金额必须大于 0");
            history.addRecord("取款失败", amount, balance, "输入金额≤0，未改变余额");
            return false;
        }
        if (amount > balance) {
            System.out.println("⚠ 余额不足，取款失败");
            history.addRecord("取款失败", amount, balance, "余额不足");
            return false;
        }
        balance -= amount;
        history.addRecord("取款", amount, balance, "成功支取现金");
        System.out.printf(Locale.CHINA, "✅ 取款成功，当前余额：%.2f 元%n", balance);
        return true;
    }

    /**
     * 查询概要信息，可以在菜单中“查询信息”时调用。
     */
    public void printSummary() {
        System.out.println("========== 账户概要 ==========");
        System.out.println("账号      ：" + accountNumber);
        System.out.println("姓名      ：" + ownerName);
        System.out.println("身份证号  ：" + personalId);
        System.out.println("开户时间  ：" + openTime);
        System.out.printf(Locale.CHINA, "当前余额  ：%.2f 元%n", balance);
        System.out.println("================================\n");

        history.addRecord("查看概要", 0, balance, "用户查看账户基本信息");
    }

    /**
     * 输出所有交易明细。
     */
    public void printTransactionHistory() {
        history.printAll();
    }

    /**
     * 销户操作。
     *
     * @return {@code true} 表示销户成功；{@code false} 表示用户取消操作。
     */
    public boolean closeAccount() {
        System.out.println("⚠ 确认销户：此操作会清空所有信息，余额也会清零。");
        System.out.println("   当前余额：" + String.format(Locale.CHINA, "%.2f", balance) + " 元");
        history.addRecord("申请销户", 0, balance, "已提示用户确认");
        return true;
    }

    /**
     * 销户成功后执行的收尾工作。
     * 在外部确认用户真的要销户时，调用该方法清空数据。
     */
    public void markAsClosed() {
        history.addRecord("销户成功", balance, 0, "账户已注销，余额置零");
        balance = 0;
        history.clear();
    }

    // ---------- 以下是一些 Getter，便于其他类（例如 AccountManager）读取信息 ----------

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            System.out.println("⚠ 姓名不能为空，修改失败");
            return;
        }
        this.ownerName = ownerName.trim();
        history.addRecord("修改姓名", 0, balance, "新姓名：" + this.ownerName);
    }

    public double getBalance() {
        return balance;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getOpenTime() {
        return openTime;
    }

    // ---------- 私有帮助方法 ----------

    /**
     * 简单判断身份证长度是否为 18 位（仅用于练习，真实项目需要更严格校验）。
     */
    private static boolean isPersonalIdValid(String personalId) {
        return personalId != null && personalId.trim().length() == 18;
    }

    /**
     * 生成账号：使用当前时间戳，保证一定唯一性。
     */
    private static String generateAccountNumber() {
        return "ACC-" + System.currentTimeMillis();
    }

    /**
     * 返回当前时间的字符串表示。
     */
    private static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
