// package Class02.This01;

// import org.junit.runner.JUnitCore;
// import org.junit.runner.Result;
// import org.junit.runner.notification.Failure;

// /**
//  * BoyTest运行器 - 用于运行BoyTest并显示测试结果
//  * @author Liang-ht
//  */
// public class BoyTestRunner {
//     public static void main(String[] args) {
//         System.out.println("=== 开始运行Boy类全面测试 ===");
//         System.out.println();
        
//         // 运行BoyTest
//         Result result = JUnitCore.runClasses(BoyTest.class);
        
//         // 显示测试结果
//         System.out.println("=== 测试结果统计 ===");
//         System.out.println("总测试数: " + result.getRunCount());
//         System.out.println("失败数: " + result.getFailureCount());
//         System.out.println("忽略数: " + result.getIgnoreCount());
//         System.out.println("运行时间: " + result.getRunTime() + " 毫秒");
//         System.out.println("测试结果: " + (result.wasSuccessful() ? "全部通过" : "有失败"));
//         System.out.println();
        
//         // 显示失败的测试
//         if (result.getFailureCount() > 0) {
//             System.out.println("=== 失败的测试详情 ===");
//             for (Failure failure : result.getFailures()) {
//                 System.out.println("测试方法: " + failure.getTestHeader());
//                 System.out.println("失败原因: " + failure.getMessage());
//                 System.out.println("异常信息: " + failure.getException());
//                 System.out.println("---");
//             }
//         } else {
//             System.out.println("=== 所有测试都通过了！ ===");
//         }
        
//         System.out.println();
//         System.out.println("=== Boy类功能测试完成 ===");
//     }
// }
