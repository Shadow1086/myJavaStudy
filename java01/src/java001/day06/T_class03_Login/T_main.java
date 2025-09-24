package java001.day06.T_class03_Login;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class T_main {
    public static void main(String[] args) {
        //写一个面向对象的登录程序
        //使用数组
        UserInfo[] userArr = new UserInfo[100];
        Scanner input = new Scanner(System.in);

        userArr[0] = new UserInfo();
        userArr[0].username = "abc";
        userArr[0].password = "abc";

        System.out.print("请输入用户名：");
        String username = input.next();

        System.out.print("请输入密码：");
        String password = input.next();


        for(int i = 0;i<userArr.length;i++){
            if(userArr[i] != null && userArr[i].username.equals(username)){
                if(userArr[i].password.equals(password)){
                    System.out.println("success");
                    break;
                }
                else{
                    System.out.println("password is wrong");
                    break;
                }
            }else{
                System.out.println("failure");
                break;
            }
        }



    }
}
