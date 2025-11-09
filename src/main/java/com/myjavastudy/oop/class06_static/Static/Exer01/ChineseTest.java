package com.myjavastudy.oop.class06_static.Static.Exer01;

/**
 * ClassName: ChineseTest
 * Package: Class06.Static.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 18:13
 * {@code @Version} 1.0
 */

public class ChineseTest {
    public static void main(String[] args) {
        System.out.println(Chinese.nation);
        Chinese.show();
        Chinese c1 = new Chinese("姚明" , 40);
        Chinese c2 = new Chinese("刘翔" , 39);
        c1.nation = "china";
        System.out.println(c1.nation);
        System.out.println(c2.nation);

        c2.nation = "CHN";
        System.out.println(c1.nation);
        System.out.println(c2.nation);

    }

}

class Chinese{
    static String nation;
    String name;
    int age;

    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void show(){
        System.out.println("我是中国人");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}