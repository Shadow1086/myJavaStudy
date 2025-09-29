package Homework01.Factorial.Test;

import Homework01.Factorial.Factorial;

/**
 * 中文测试类：验证阶乘实现，并输出期望结果、实际结果与中间计算过程
 */
public class FactorialTestCN {

    /**
     * 主入口：运行一组测试用例
     */
    public static void main(String[] args) {
        int[] testCases = new int[]{-5, -1, 0, 1, 2, 3, 4, 5, 7, 10, 12, 15, 19, 20, 21};

        int passCount = 0;
        int failCount = 0;
        int unknownCount = 0; // 未判定（例如超出 long 范围）

        System.out.println("================ 开始阶乘功能测试 ================");
        for (int n : testCases) {
            TestStatus status = runSingleCase(n);
            if (status == TestStatus.PASS) {
                passCount++;
            } else if (status == TestStatus.FAIL) {
                failCount++;
            } else {
                unknownCount++;
            }
            System.out.println("--------------------------------------------------");
        }
        System.out.println("================ 测试结束 ================");
        System.out.println("通过用例数：" + passCount + ", 失败用例数：" + failCount + ", 未知用例数：" + unknownCount);
    }

    /**
     * 运行单个用例，展示完整过程与对比
     */
    private static TestStatus runSingleCase(int n) {
        System.out.println("用例：n = " + n);

        // 期望结果与期望过程（数学定义）
        System.out.println("[期望过程]");
        Expected expected = expectedFactorialWithTrace(n);
        if (expected.hasValue) {
            System.out.println("期望表达式：" + expected.expression);
            System.out.println("期望结果：" + expected.value);
        } else {
            System.out.println("期望说明：" + expected.message);
        }

        // 实际结果（调用被测代码）。
        // 仅 Factorial.recursion 返回数值；另外三种方法只打印过程与结果，我们作为附加输出展示。
        System.out.println("[实际过程]");
        // 1) 递归实际结果
        long actualRecursion = Factorial.recursion(n);
        System.out.println("递归函数返回值：" + actualRecursion);
        // 2) do-while / while / for 的控制台输出（仅展示它们的打印，不参与断言）
        System.out.println("调用 Do-While 版：");
        Factorial.FactorialDoWhile(n);
        System.out.println("调用 While 版：");
        Factorial.FactorialWhile(n);
        System.out.println("调用 For 版：");
        Factorial.FactorialFor(n);

        // 断言：仅在期望存在数值时进行严格对比；若期望为“负数没有阶乘”，则期望与实现的约定不同（实现返回0），此处视为通过提示一致性检查。
        TestStatus status;
        if (expected.hasValue) {
            status = (expected.value == actualRecursion) ? TestStatus.PASS : TestStatus.FAIL;
        } else if (n < 0) {
            // 负数：实现返回0，我们验证这一返回约定
            status = (actualRecursion == 0) ? TestStatus.PASS : TestStatus.FAIL;
        } else {
            // 非负但无期望数值，多为溢出等情况，标记为未知
            status = TestStatus.UNKNOWN;
        }

        // 最终小结
        System.out.println("[对比结果]");
        if (expected.hasValue) {
            System.out.println("期望结果：" + expected.value + ", 实际结果(递归)：" + actualRecursion);
        } else {
            System.out.println("期望说明：" + expected.message + ", 实际结果(递归)：" + actualRecursion);
        }
        String conclusion = (status == TestStatus.PASS) ? "通过" : (status == TestStatus.FAIL ? "未通过" : "未知");
        System.out.println("用例结论：" + conclusion);
        return status;
    }

    /**
     * 计算期望阶乘并生成过程表达式
     * 约定：
     * - n < 0：无阶乘（这里不给出数值，给出说明）
     * - n = 0：0! = 1
     * - n > 0：n! = 1×2×…×n
     */
    private static Expected expectedFactorialWithTrace(int n) {
        if (n < 0) {
            Expected e = new Expected();
            e.hasValue = false;
            e.message = "负数没有阶乘";
            e.expression = "无";
            return e;
        }

        long result = 1L;
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append("1");
        } else {
            for (int i = 1; i <= n; i++) {
                // 溢出检测：相乘前判断是否会超过 long 范围
                if (result > Long.MAX_VALUE / i) {
                    Expected e = new Expected();
                    e.hasValue = false;
                    e.message = "超过 long 范围，未判定";
                    e.expression = sb.append(" × ... (溢出)").toString();
                    return e;
                }
                result *= i;
                sb.append(i);
                if (i < n) {
                    sb.append(" × ");
                }
            }
        }
        sb.append(" = ").append(result);

        Expected e = new Expected();
        e.hasValue = true;
        e.value = result;
        e.expression = sb.toString();
        e.message = "";
        return e;
    }

    /**
     * 期望结果载体
     */
    private static class Expected {
        boolean hasValue;
        long value;
        String expression;
        String message;
    }

    private enum TestStatus {
        PASS,
        FAIL,
        UNKNOWN
    }
}


