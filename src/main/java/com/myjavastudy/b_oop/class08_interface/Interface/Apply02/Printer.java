package com.myjavastudy.b_oop.class08_interface.Interface.Apply02;

import java.util.Scanner;
import java.util.Arrays;

/**
 * ClassName: Printer
 * Package: Class08.Interface.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:38
 * {@code @Version} 1.0
 */
class Printer implements USB {
    @Override
    public void start() {
        System.out.println("Printer 连接");
    }

    @Override
    public void stop() {
        System.out.println("Printer 终止");
    }
}
