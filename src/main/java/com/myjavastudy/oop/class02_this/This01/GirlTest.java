package com.myjavastudy.oop.class02_this.This01;

// package Class02.This01;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;

// import static org.junit.Assert.*;

// /**
//  * ClassName: GirlTest
//  * Package: Class02.This01
//  * Description: 全面测试Girl类的所有方法
//  * {@code @Author} Liang-ht
//  * {@code @Create} 2025/10/2 12:30
//  * {@code @Version} 1.0
//  */
// public class GirlTest {

//     private Girl girl1;
//     private Girl girl2;
//     private Girl girl3;
//     private Boy boy1;
//     private Boy boy2;

//     @Before
//     public void setUp() {
//         // 创建测试对象
//         girl1 = new Girl("小红", 20);
//         girl2 = new Girl("小美", 25);
//         girl3 = new Girl("小丽", 25);
//         boy1 = new Boy("小明", 23);
//         boy2 = new Boy("小强", 19);
//     }

//     @After
//     public void tearDown() {
//         girl1 = null;
//         girl2 = null;
//         girl3 = null;
//         boy1 = null;
//         boy2 = null;
//     }

//     @Test
//     public void testDefaultConstructor() {
//         Girl defaultGirl = new Girl();
//         assertNotNull("默认构造器创建的对象不应为null", defaultGirl);
//         assertNull("默认构造器创建的对象name应为null", defaultGirl.getName());
//         assertEquals("默认构造器创建的对象age应为0", 0, defaultGirl.getAge());
//     }

//     @Test
//     public void testParameterizedConstructor() {
//         Girl testGirl = new Girl("测试", 30);
//         assertEquals("参数构造器name设置错误", "测试", testGirl.getName());
//         assertEquals("参数构造器age设置错误", 30, testGirl.getAge());
//     }

//     @Test
//     public void testGetters() {
//         assertEquals("getName()方法错误", "小红", girl1.getName());
//         assertEquals("getAge()方法错误", 20, girl1.getAge());
        
//         assertEquals("getName()方法错误", "小美", girl2.getName());
//         assertEquals("getAge()方法错误", 25, girl2.getAge());
//     }

//     @Test
//     public void testSetters() {
//         Girl testGirl = new Girl();
        
//         // 测试setName
//         testGirl.setName("新名字");
//         assertEquals("setName()方法错误", "新名字", testGirl.getName());
        
//         // 测试setAge
//         testGirl.setAge(28);
//         assertEquals("setAge()方法错误", 28, testGirl.getAge());
        
//         // 测试边界值
//         testGirl.setAge(0);
//         assertEquals("setAge()边界值0错误", 0, testGirl.getAge());
        
//         testGirl.setAge(100);
//         assertEquals("setAge()边界值100错误", 100, testGirl.getAge());
//     }

//     @Test
//     public void testMarry() {
//         // 测试marry方法输出
//         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//         PrintStream originalOut = System.out;
//         System.setOut(new PrintStream(outContent));
        
//         try {
//             girl1.marry(boy1);
//         } finally {
//             System.setOut(originalOut);
//         }
        
//         String output = outContent.toString();
//         assertTrue("marry方法应输出'我想和' + boy.getName() + '结婚'", 
//                   output.contains("我想和小明结婚"));
//         assertTrue("marry方法应调用boy.marry(this)", 
//                   output.contains("我想娶小红"));
//     }

//     @Test
//     public void testMarryWithDifferentBoys() {
//         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//         PrintStream originalOut = System.out;
//         System.setOut(new PrintStream(outContent));
        
//         try {
//             girl2.marry(boy2);
//         } finally {
//             System.setOut(originalOut);
//         }
        
//         String output = outContent.toString();
//         assertTrue("marry方法应输出正确的boy名字", 
//                   output.contains("我想和小强结婚"));
//         assertTrue("marry方法应调用boy.marry(this)", 
//                   output.contains("我想娶小美"));
//     }

//     @Test
//     public void testCompareCurrentGirlOlder() {
//         // girl2(25) vs girl1(20) - 当前对象大
//         int result = girl2.compare(girl1);
//         assertTrue("当前对象年龄大时应返回正数", result > 0);
//         assertEquals("当前对象年龄大时应返回1", 1, result);
//     }

//     @Test
//     public void testCompareCurrentGirlYounger() {
//         // girl1(20) vs girl2(25) - 当前对象小
//         int result = girl1.compare(girl2);
//         assertTrue("当前对象年龄小时应返回负数", result < 0);
//         assertEquals("当前对象年龄小时应返回-1", -1, result);
//     }

//     @Test
//     public void testCompareSameAge() {
//         // girl2(25) vs girl3(25) - 年龄相同
//         int result = girl2.compare(girl3);
//         assertEquals("年龄相同时应返回0", 0, result);
//     }

//     @Test
//     public void testCompareWithSelf() {
//         // 自己和自己比较
//         int result = girl1.compare(girl1);
//         assertEquals("自己和自己比较应返回0", 0, result);
//     }

//     @Test
//     public void testCompareEdgeCases() {
//         Girl youngGirl = new Girl("小", 0);
//         Girl oldGirl = new Girl("老", 100);
        
//         // 测试边界年龄
//         assertTrue("0岁与20岁比较", youngGirl.compare(girl1) < 0);
//         assertTrue("20岁与0岁比较", girl1.compare(youngGirl) > 0);
//         assertTrue("100岁与25岁比较", oldGirl.compare(girl2) > 0);
//         assertTrue("25岁与100岁比较", girl2.compare(oldGirl) < 0);
//     }

//     @Test
//     public void testCompleteWorkflow() {
//         // 测试完整工作流程
//         Girl workflowGirl = new Girl("工作流测试", 22);
//         Boy workflowBoy = new Boy("工作流男孩", 24);
        
//         // 设置属性
//         workflowGirl.setName("修改后的名字");
//         workflowGirl.setAge(23);
        
//         // 验证设置
//         assertEquals("工作流测试name", "修改后的名字", workflowGirl.getName());
//         assertEquals("工作流测试age", 23, workflowGirl.getAge());
        
//         // 测试marry
//         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//         PrintStream originalOut = System.out;
//         System.setOut(new PrintStream(outContent));
        
//         try {
//             workflowGirl.marry(workflowBoy);
//         } finally {
//             System.setOut(originalOut);
//         }
        
//         String output = outContent.toString();
//         assertTrue("工作流marry测试", output.contains("我想和工作流男孩结婚"));
        
//         // 测试比较
//         int compareResult = workflowGirl.compare(girl1); // 23 vs 20
//         assertTrue("工作流比较测试", compareResult > 0);
//     }

//     @Test
//     public void testNullHandling() {
//         // 测试null参数处理（虽然代码中没有null检查，但测试边界情况）
//         Girl testGirl = new Girl("测试", 25);
        
//         // 注意：实际代码中marry方法有@NotNull注解，但测试时仍可能传入null
//         // 这里主要测试compare方法对null的处理
//         try {
//             testGirl.compare(null);
//             fail("compare方法应该对null参数抛出异常");
//         } catch (Exception e) {
//             // 预期会抛出NullPointerException
//             assertTrue("应该抛出NullPointerException", e instanceof NullPointerException);
//         }
//     }
// }
