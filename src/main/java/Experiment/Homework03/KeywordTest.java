package Homework03;

import java.util.Scanner;

public class KeywordTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String target;

        while (true) {
            System.out.print("请输入您想查找的java关键字(输入0退出)：");
            target = input.next();
            if (target.equals("0"))
                break;
            else {
                int result = Keyword.find(target);
                if (result != -1) {
                    System.out.println(target + "的位置为：" + result);
                } else {
                    System.out.println(target + "没有被找到，请确定是否为java关键字");
                }
            }
        }
        input.close();
    }
}
