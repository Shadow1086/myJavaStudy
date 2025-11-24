package com.myjavastudy.c_advanced.class10_enum._enum.Apply02;

/**
 * ClassName: SeasonTest
 * Description:
 * 
 * SeasonTest的测试文件
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-12 21:05:40
 * {@code @Version} 1.0
 */
public class SeasonTest {
    public static void main(String[] args) {
        // Season1.SPRING.toString();
        // System.out.println(Season1.SPRING.getClass());
        // System.out.println(Season1.SPRING.getClass().getSuperclass());

        //1.toString()方法。
        System.out.println("toString() 方法 : " + Season1.SPRING);

        //2.name()
        System.out.println("name()方法 : " + Season1.SPRING.name());

        //3.vlaues()
        Season1[] values = Season1.values();
        for(Season1 season1 :values){
            System.out.println(season1);
        }

        //valueOf(String objName)，返回枚举类中对象名是objName的对象,如果找不到就会直接报错。
        String objName = "WINTER";
        Season1 season1 = Season1.valueOf(objName);
        System.out.println(season1);

        //ordinal()

        System.out.println(Season1.AUTUMN.ordinal());

        //通过枚举类的对象重写接口中的方法
    }
}
