package Class01.class01.Encapsulation01;

import java.util.Scanner;
import java.util.Arrays;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 14:21
 * {@code @Version} 1.0
 */
class Animal {
    //属性：
    String name;
    private int legs;

    //方法：
    //设置legs的属性值
    public void setlegs(int l) {
        if (l >= 0 && l % 2 == 0) {
            legs = l;
        } else {
            System.out.println("输入数据非法");
        }
    }

    //获取legs值
    public int getLegs() {
        return legs;
    }
}
