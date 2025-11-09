package com.myjavastudy.api.java01.Data.JDK8Later.Exer01;
import org.junit.Test;
import java.util.Calendar;

/**
 * ClassName: Exer01
 * Description: 
 * 
 * 使用Calendar获取当前时间, 把这个时间设置为你的生日, 再获取你的百天(出生后100天)日期。
 * 使用LocalDateTime获取当前时间, 把这个时间设置为你的生日, 再获取你的百天(出生后100天)日期。
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-08 21:48:44
 */
public class Exer01 {
    @Test
    public void test01(){
        Calendar calendar  = Calendar.getInstance();
        System.out.println("你的生日为：" + calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,100);
        System.out.println(calendar.getTime());
    }

    
}
