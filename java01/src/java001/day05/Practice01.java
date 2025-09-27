package java001.day05;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description: 输出英文星期几
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
//输出英文星期几

//用一个数组，保存星期一到星期天的7个英语单词，从键盘输入1-7，显示对应的单词
//{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}
public class Practice01 {
    public static void main(String[] args) {
        String[] day = new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        Scanner input = new Scanner(System.in);
        System.out.println("请输入星期几对应的1-7之间的数字：");
        int num = input.nextInt();
        if (num < 1 || num > 7) {
            System.out.println("输入有误");
        } else {
            System.out.println("您查询的日期为：" + day[num - 1]);
        }
        input.close();
    }
}
