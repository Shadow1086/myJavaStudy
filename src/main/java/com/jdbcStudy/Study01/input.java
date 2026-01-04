package com.jdbcStudy.Study01;
import java.util.Scanner;

/**
 * ClassName: input
 * Description: 
 * 
 * 封装Scanner类
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-07 17:11:10
 */
public class input {
    private static final Scanner scanner = new Scanner(System.in);
    public static String readString(){
        return scanner.next();
    }
    public static String readLine(){
        return scanner.nextLine();
    }
    public static int readInt(){
        return scanner.nextInt();
    }
    public static double readDouble(){
        return scanner.nextDouble();
    }
    public static long readLong(){
        return scanner.nextLong();
    }
}
