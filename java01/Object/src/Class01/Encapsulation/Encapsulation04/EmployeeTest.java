package Class01.Encapsulation.Encapsulation04;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 14:36
 * {@code @Version} 1.0
 */

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入员工总数：");
        int num = input.nextInt();

        Employee[] arrEm = new Employee[num];
//给数组中的各个成员进行赋值
        for (int i = 0; i < arrEm.length; i++) {
            arrEm[i] = new Employee();
            System.out.println("--------添加第" + (i + 1) + "个员工----------");
            System.out.print("姓名：");
            arrEm[i].setName(input.next());

            System.out.print("性别：");
            arrEm[i].setSex(input.next().charAt(0));

            System.out.print("年龄：");
            arrEm[i].setAge(input.nextInt());

            System.out.print("电话：");
            arrEm[i].setTeleNum(input.next());
        }
        //遍历显示信息
        System.out.println("----------员工列表----------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话");
        for(int i = 0;i<arrEm.length;i++){
            System.out.println((i+1) + "\t" + arrEm[i].getInfo());
        }
        System.out.println("----------员工列表完成----------");
    }
}
