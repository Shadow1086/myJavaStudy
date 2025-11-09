package com.myjavastudy.advanced.class10_enum._enum.Apply02;
/**
 * ClassName: Season
 * Description:
 * 
 * 枚举类的应用
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-12 21:05:18
 * {@code @Version} 1.0
 */
public enum Season1 implements Info , Info2{
    //1.必须在枚举类开头声明多个对象，对象之间用逗号隔开，末尾对象用分号隔开
    SPRING("春天", "春暖花开"){
        public void show1(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        public void show1(){
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        public void show1(){
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天", "白雪皑皑"){
        public void show1(){
            System.out.println("冬天在哪里");
        }
    };


    private final String seasonName;//季节的名称
    private final String seasonDesc;//季节的描述

    //1.私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
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


    // //4.提供toString()方法
    // @Override
    // public String toString(){
    //     return "Season{" +
    //             "seasonName='" + seasonName + '\'' +
    //             ", seasonDesc='" + seasonDesc + '\'' +
    //             '}';
    // }
    public void show(){
        System.out.println();
    }
}
