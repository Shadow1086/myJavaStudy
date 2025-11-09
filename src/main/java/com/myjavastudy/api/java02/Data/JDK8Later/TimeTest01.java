package com.myjavastudy.api.java02.Data.JDK8Later;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

/**
 * ClassName: TimeTest01
 * Description: 
 * 
 * JDK8及以后的新的API
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-08 20:57:25
 */
public class TimeTest01 {
    /**
     * LocalDate \ LocalTime \ LocalDateTime
     */
    @Test
    public void test01(){
        //now():静态方法，根据当前时间创建对象/指定时区的对象
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld); //2025-11-08
        System.out.println(lt); //21:01:20.240280
        System.out.println(ldt);    //2025-11-08T21:01:20.240293

        //of(xx,xx,xx,xx,xx,xxx):获取指定的日期，时间对应的实例
        LocalDate ld1 = LocalDate.of(2021, 5, 21);
        LocalDateTime ldt1  = LocalDateTime.of(2022, 12,13,11,23,45);
        System.out.println(ld1);    //2021-05-21
        System.out.println(ldt1);   //2022-12-13T11:23:45

        LocalDateTime ldt2 = LocalDateTime.now();           
        System.out.println("这个月的第几天：" + ldt2.getDayOfMonth());  //8
        //体现了不可变性
        //withxxx()
        LocalDateTime ldt3 = ldt2.withDayOfMonth(15);
        System.out.println(ldt2);       //2025-11-08T21:10:30.110151
        System.out.println(ldt3);       //2025-11-15T21:10:30.110151

        //plusxxx()
        LocalDateTime ldt4 = ldt2.plusDays(3);
        System.out.println(ldt4);       //2025-11-11T21:13:03.778551
    }
    /**
     * Instant
     */
    @Test
    public void test02(){
        Instant instant = Instant.now();
        System.out.println(instant);        //2025-11-08T13:25:08.749430Z,差8个小时

        OffsetDateTime instant2 = instant.atOffset(ZoneOffset.ofHours(8));//调整时区
        System.out.println(instant2);

        Instant instant3 = Instant.ofEpochMilli(1762595931658L);
        System.out.println(instant3);

        long milliTimes = instant.toEpochMilli();
        System.out.println(milliTimes);         //1762608734314
    }
    /**
     * DateTimeFormatter
     */
    @Test
    public void test03(){
        //自定义的格式：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //格式化：日期，时间  ---> 字符串
        LocalDateTime ldt = LocalDateTime.now();
        String str = dtf.format(ldt);
        System.out.println(str);        //2025-11-08 21:38:31

        //解析：字符串  ---> 日期，时间
        //TemporalAccessor是一个接口
        TemporalAccessor temporalAccessor = dtf.parse("2025-11-08 21:38:31");
        LocalDateTime ldt1  = LocalDateTime.from(temporalAccessor);
        System.out.println(ldt1);       //2025-11-08T21:38:31
    }
}
