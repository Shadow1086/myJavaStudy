package com.myjavastudy.experiment.homework02;

/**
 * Homework02 包的示例类
 * 这是一个简单的 Hello World 示例
 * 
 * @author Student
 * @date 2025-10-13
 */
public class HelloWorld {
    
    /**
     * 主方法 - 程序入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("=== Homework02 示例程序 ===");
        System.out.println("欢迎使用 Experiment 模块！");
        System.out.println("这是 Homework02 包的第一个示例程序。");
        
        // 创建对象示例
        HelloWorld hello = new HelloWorld();
        hello.greet("同学");
    }
    
    /**
     * 问候方法
     * @param name 要问候的人的名字
     */
    public void greet(String name) {
        System.out.println("你好，" + name + "！欢迎学习 Java！");
    }
}

