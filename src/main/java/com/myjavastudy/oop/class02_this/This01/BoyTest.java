package com.myjavastudy.oop.class02_this.This01;

// package Class02.This01;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;

// import static org.junit.Assert.*;

// /**
//  * ClassName: BoyTest
//  * Package: Class02.This01
//  * Description: 全面测试Boy类的所有方法
//  * {@code @Author} Liang-ht
//  * {@code @Create} 2025/10/2 12:59
//  * {@code @Version} 1.0
//  */
// public class BoyTest {
    
//     private ByteArrayOutputStream outContent;
//     private PrintStream originalOut;
    
//     @Before
//     public void setUp() {
//         outContent = new ByteArrayOutputStream();
//         originalOut = System.out;
//         System.setOut(new PrintStream(outContent));
//     }
    
//     @After
//     public void tearDown() {
//         System.setOut(originalOut);
//     }

//     @Test
//     public void testDefaultConstructor() {
//         Boy boy = new Boy();
//         assertNotNull("默认构造器应该创建对象", boy);
//         assertNull("默认构造器的name应该为null", boy.getName());
//         assertEquals("默认构造器的age应该为0", 0, boy.getAge());
//     }

//     @Test
//     public void testParameterizedConstructor() {
//         Boy boy = new Boy("张三", 25);
//         assertNotNull("有参构造器应该创建对象", boy);
//         assertEquals("有参构造器的name应该正确", "张三", boy.getName());
//         assertEquals("有参构造器的age应该正确", 25, boy.getAge());
//     }

//     @Test
//     public void testGettersAndSetters() {
//         Boy boy = new Boy();
        
//         // 测试setter和getter
//         boy.setName("李四");
//         assertEquals("setName/getName应该正确工作", "李四", boy.getName());
        
//         boy.setAge(30);
//         assertEquals("setAge/getAge应该正确工作", 30, boy.getAge());
        
//         // 测试边界值
//         boy.setAge(0);
//         assertEquals("age为0应该正确设置", 0, boy.getAge());
        
//         boy.setAge(100);
//         assertEquals("age为100应该正确设置", 100, boy.getAge());
        
//         boy.setName("");
//         assertEquals("空字符串name应该正确设置", "", boy.getName());
        
//         boy.setName(null);
//         assertNull("null name应该正确设置", boy.getName());
//     }

//     @Test
//     public void testMarry() {
//         Boy boy = new Boy("王五", 28);
//         Girl girl = new Girl("赵六", 26);
        
//         boy.marry(girl);
        
//         String output = outContent.toString();
//         assertTrue("marry方法应该输出正确信息", output.contains("我想娶赵六"));
//     }

//     @Test
//     public void testMarryWithNullGirl() {
//         Boy boy = new Boy("王五", 28);
        
//         try {
//             boy.marry(null);
//             fail("marry方法传入null应该抛出异常");
//         } catch (Exception e) {
//             // 预期会抛出NullPointerException
//             assertTrue("应该抛出NullPointerException", e instanceof NullPointerException);
//         }
//     }

//     @Test
//     public void testShoutAge22() {
//         Boy boy = new Boy("小明", 22);
//         boy.shout();
        
//         String output = outContent.toString();
//         assertTrue("22岁应该可以结婚", output.contains("可以结婚"));
//         assertFalse("22岁不应该显示未到法定年龄", output.contains("未到结婚法定年龄"));
//     }

//     @Test
//     public void testShoutAgeAbove22() {
//         Boy boy = new Boy("大明", 30);
//         boy.shout();
        
//         String output = outContent.toString();
//         assertTrue("30岁应该可以结婚", output.contains("可以结婚"));
//         assertFalse("30岁不应该显示未到法定年龄", output.contains("未到结婚法定年龄"));
//     }

//     @Test
//     public void testShoutAgeBelow22() {
//         Boy boy = new Boy("小刚", 21);
//         boy.shout();
        
//         String output = outContent.toString();
//         assertTrue("21岁应该显示未到法定年龄", output.contains("未到结婚法定年龄"));
//         assertFalse("21岁不应该显示可以结婚", output.contains("可以结婚"));
//     }

//     @Test
//     public void testShoutAge0() {
//         Boy boy = new Boy("婴儿", 0);
//         boy.shout();
        
//         String output = outContent.toString();
//         assertTrue("0岁应该显示未到法定年龄", output.contains("未到结婚法定年龄"));
//         assertFalse("0岁不应该显示可以结婚", output.contains("可以结婚"));
//     }

//     @Test
//     public void testShoutAgeNegative() {
//         Boy boy = new Boy("异常", -5);
//         boy.shout();
        
//         String output = outContent.toString();
//         assertTrue("负数年龄应该显示未到法定年龄", output.contains("未到结婚法定年龄"));
//         assertFalse("负数年龄不应该显示可以结婚", output.contains("可以结婚"));
//     }

//     @Test
//     public void testCompleteWorkflow() {
//         // 测试完整的工作流程
//         Boy boy = new Boy("测试男孩", 25);
//         Girl girl = new Girl("测试女孩", 23);
        
//         // 验证初始状态
//         assertEquals("测试男孩", boy.getName());
//         assertEquals(25, boy.getAge());
        
//         // 测试shout方法
//         boy.shout();
//         String shoutOutput = outContent.toString();
//         assertTrue("25岁应该可以结婚", shoutOutput.contains("可以结婚"));
        
//         // 清空输出缓冲区
//         outContent.reset();
        
//         // 测试marry方法
//         boy.marry(girl);
//         String marryOutput = outContent.toString();
//         assertTrue("应该输出结婚信息", marryOutput.contains("我想娶测试女孩"));
        
//         // 测试修改属性
//         boy.setName("修改后的名字");
//         boy.setAge(30);
//         assertEquals("修改后的名字", boy.getName());
//         assertEquals(30, boy.getAge());
//     }

//     @Test
//     public void testMultipleBoys() {
//         // 测试多个Boy对象
//         Boy boy1 = new Boy("男孩1", 20);
//         Boy boy2 = new Boy("男孩2", 25);
//         Girl girl = new Girl("女孩", 22);
        
//         // 测试boy1
//         boy1.shout();
//         String output1 = outContent.toString();
//         assertTrue("20岁应该显示未到法定年龄", output1.contains("未到结婚法定年龄"));
        
//         // 清空输出缓冲区
//         outContent.reset();
        
//         // 测试boy2
//         boy2.shout();
//         String output2 = outContent.toString();
//         assertTrue("25岁应该可以结婚", output2.contains("可以结婚"));
        
//         // 清空输出缓冲区
//         outContent.reset();
        
//         // 测试boy2的marry方法
//         boy2.marry(girl);
//         String marryOutput = outContent.toString();
//         assertTrue("应该输出结婚信息", marryOutput.contains("我想娶女孩"));
//     }
// }