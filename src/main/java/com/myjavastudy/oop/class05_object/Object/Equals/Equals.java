package com.myjavastudy.oop.class05_object.Object.Equals;

import java.io.File;
import java.util.Objects;

/**
 * ClassName: Equals
 * Package: Class05.Object
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 10:51
 * {@code @Version} 1.0
 */

public class Equals {
    public static void main(String[] args) {

        User u1 = new User("Tom", 12);
        User u2 = new User("Tom", 12);

        //变成了自己重写的方法了
        System.out.println(u1.equals(u2));//false ---> true
        System.out.println(u1 == u2);


        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1 == str2);//false
        System.out.println(str1.equals(str2));//true

        File file1 = new File("d:\\abc.txt");
        File file2 = new File("d:\\abc.txt");
        System.out.println(file1.equals(file2));//true

        //数组上使用equals()
        int[] arr = new int[10];
        System.out.println(arr.equals(new int[10]));
    }
}

class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    @Override
//    //重写equals()
//    public boolean equals(Object object){
//        if(this == object){
//            return true;
//        }
//
//        if(object instanceof User){
//            User user = (User)object;
//            //this.name.equals(user.name)原因：
//            //如果用==是比较地址，对于String中的equals已经被重写了，比较的是内容。
//            if(this.age == user.age && this.name.equals(user.name)){
//                return true;
//            }
//        }
//        return false;
//    }

//IDEA自动生成
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return age == user.age && Objects.equals(name, user.name);
    }

}
