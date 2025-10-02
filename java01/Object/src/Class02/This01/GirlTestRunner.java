package Class02.This01;

/**
 * ClassName: GirlTestRunner
 * Package: Class02.This01
 * Description: 运行Girl类的测试并输出结果
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 12:35
 * {@code @Version} 1.0
 */
public class GirlTestRunner {
    public static void main(String[] args) {
        System.out.println("=== Girl类功能测试开始 ===");
        
        // 创建测试对象
        Girl girl1 = new Girl("小红", 20);
        Girl girl2 = new Girl("小美", 25);
        Girl girl3 = new Girl("小丽", 25);
        Boy boy1 = new Boy("小明", 23);
        Boy boy2 = new Boy("小强", 19);
        
        System.out.println("\n1. 测试构造器:");
        System.out.println("默认构造器: " + new Girl());
        System.out.println("参数构造器 girl1: " + girl1.getName() + ", " + girl1.getAge());
        System.out.println("参数构造器 girl2: " + girl2.getName() + ", " + girl2.getAge());
        
        System.out.println("\n2. 测试getter和setter:");
        Girl testGirl = new Girl();
        testGirl.setName("测试女孩");
        testGirl.setAge(30);
        System.out.println("设置后: " + testGirl.getName() + ", " + testGirl.getAge());
        
        System.out.println("\n3. 测试marry方法:");
        System.out.println("girl1与boy1结婚:");
        girl1.marry(boy1);
        
        System.out.println("\ngirl2与boy2结婚:");
        girl2.marry(boy2);
        
        System.out.println("\n4. 测试compare方法:");
        System.out.println("girl1(20) vs girl2(25): " + girl1.compare(girl2) + " (负数表示girl1小)");
        System.out.println("girl2(25) vs girl1(20): " + girl2.compare(girl1) + " (正数表示girl2大)");
        System.out.println("girl2(25) vs girl3(25): " + girl2.compare(girl3) + " (0表示相等)");
        System.out.println("girl1 vs girl1: " + girl1.compare(girl1) + " (0表示自己和自己相等)");
        
        System.out.println("\n5. 测试边界情况:");
        Girl youngGirl = new Girl("小", 0);
        Girl oldGirl = new Girl("老", 100);
        System.out.println("0岁 vs 20岁: " + youngGirl.compare(girl1));
        System.out.println("100岁 vs 25岁: " + oldGirl.compare(girl2));
        
        System.out.println("\n6. 完整工作流程测试:");
        Girl workflowGirl = new Girl("工作流", 22);
        Boy workflowBoy = new Boy("工作流男孩", 24);
        
        workflowGirl.setName("修改后的工作流");
        workflowGirl.setAge(23);
        System.out.println("修改后: " + workflowGirl.getName() + ", " + workflowGirl.getAge());
        
        System.out.println("工作流女孩与工作流男孩结婚:");
        workflowGirl.marry(workflowBoy);
        
        System.out.println("工作流女孩(23) vs girl1(20): " + workflowGirl.compare(girl1));
        
        System.out.println("\n=== Girl类功能测试结束 ===");
    }
}
