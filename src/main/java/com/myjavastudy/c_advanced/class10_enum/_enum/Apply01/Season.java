package com.myjavastudy.c_advanced.class10_enum._enum.Apply01;
/**
 * ClassName: Season
 * Description:
 * 
 * 枚举类的应用
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-12 20:32:22
 * {@code @Version} 1.0
 */

//JDK5.0之前定义枚举类的方式
public class Season {
    //声明当前类的对象的实例变量。
    private final String seasonName;//季节的名称
    private final String seasonDesc;//季节的描述

    //1.私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //2.获取枚举类对象的属性：提供get方法
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //3.创建类的实例,需要使用public static final修饰
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");

    //4.提供toString()方法
    @Override
    public String toString(){
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
