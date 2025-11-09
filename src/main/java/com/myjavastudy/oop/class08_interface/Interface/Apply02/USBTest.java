package com.myjavastudy.oop.class08_interface.Interface.Apply02;

/**
 * ClassName: USBTest
 * Package: Class08.Interface.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:29
 * {@code @Version} 1.0
 */

public class USBTest {
    public static void main(String[] args) {
        //多态

        //1.创建 接口实现类 的对象
        Computer computer = new Computer();
        Printer printer = new Printer();
//      自动多态，相当于  USB printer = new Printer();
        computer.transfer(printer);
        System.out.println();

        //2.创建 接口实现类 的匿名对象
        computer.transfer(new Camera());
        System.out.println();

        //3.创建 接口匿名实现类 的对象
        USB usb1 = new USB(){
            @Override
            public void start(){
                System.out.println("u盘开始工作");
            }
            @Override
            public void stop(){
                System.out.println("u盘结束工作");
            }
        };
        computer.transfer(usb1);

        //4.创建 接口匿名实现类 的 匿名对象
        computer.transfer(new USB() {
            @Override
            public void start() {
                System.out.println("摄像头开始工作");
            }

            @Override
            public void stop() {
                System.out.println("摄像头结束工作");
            }
        });
    }
}

