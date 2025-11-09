package com.myjavastudy.homework.homework01.Homework02;

//仔细阅读编辑区内给出的代码框架及注释，在 Begin-End 中计算两个日期之间的间隔时间，具体要求如下:
//Test 类中定义了一个 getTime____ 的方法，其中具有两个参数，计算 d2 距离 d1 已经过去了多久，返回类型为 String;
//如果不到 1 分钟，返回:“刚刚”;
//如果超出 1 分钟但是没有超过 1 小时，返回:“xx分钟前”，有小数点的向上取整;
//如果超出 1 小时但是没有超过 1 天，返回:“xx小时前”，有小数点的向上取整;
//如果超出 1 天，返回:“xx天前”，有小数点的向上取整。/计算两个日期之间的间隔时间/
//
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static String getTime(Date date1, Date date2) {
        // 请在下面的Begin-End之间编写正确的代码
        // 毫秒
        long diff = date2.getTime() - date1.getTime();
        // 转化为分钟
        long minutes = diff / (1000 * 60);
        if (minutes < 1) {
            return "刚刚";
        } else if (minutes < 60) {
            // 向上取整：如果有余数，分钟数+1
            long minutesCeil = (diff % (1000 * 60) == 0) ? minutes : minutes + 1;
            return minutesCeil + "分钟前";
        } else if (minutes < 1440) {  // 1440分钟 = 24小时
            // 转换为小时
            long hours = diff / (1000 * 60 * 60);
            // 向上取整：如果有余数，小时数+1
            long hoursCeil = (diff % (1000 * 60 * 60) == 0) ? hours : hours + 1;
            return hoursCeil + "小时前";
        } else {
            // 转换为天
            long days = diff / (1000 * 60 * 60 * 24);
            // 向上取整：如果有余数，天数+1
            long daysCeil = (diff % (1000 * 60 * 60 * 24) == 0) ? days : days + 1;
            return daysCeil + "天前";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String d1 = scanner.next();
        String d2 = scanner.next();
        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date aDate = null;
        Date bDate = null;
        try {
            aDate = sft.parse(d1);
            bDate = sft.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("距离上一个时间过去了多久:" + getTime(aDate, bDate));
        scanner.close();
    }
}