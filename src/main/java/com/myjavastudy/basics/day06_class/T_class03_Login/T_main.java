package com.myjavastudy.basics.day06_class.T_class03_Login;

import java.util.Scanner;

public class T_main {
    public static void main(String[] args) {
        //写一个面向对象的登录程序
        //使用数组
        UserInfo[] userArr = new UserInfo[100];
        Scanner input = new Scanner(System.in);

        userArr[0] = new UserInfo();
        userArr[0].username = "abc";
        userArr[0].password = "abc";

        userArr[3] = new UserInfo();
        userArr[3].username = "abc";
        userArr[3].password = "abc";

        System.out.print("请输入用户名：");
        String username = input.next();

        System.out.print("请输入密码：");
        String password = input.next();

        boolean flag = false;
        //初始化为登陆失败

        for (int i = 0; i < userArr.length; i++) {
            if (userArr[i] != null && userArr[i].username.equals(username)) {
                if (userArr[i].password.equals(password)) {
                    System.out.println("success");
                    flag = true;
                    break;
                } else {
                    System.out.println("password is wrong");
                    break;
                }
            }
            if (flag != true) {
                System.out.println("failure");
                break;
            }
        }


    }
}
