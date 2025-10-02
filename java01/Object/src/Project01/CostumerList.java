package Project01;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/1 22:35
 * {@code @Version} 1.0
 */

public class CostumerList {
    //创建新的对象列表
    static Costumer[] cosArr = new Costumer[100];
    int i = 1;

    //获得用户列表。传递给add（）方法。
    public static Costumer[] getCosArr() {
        return cosArr;
    }

    //添加用户方法。
    public static void addCostumer(int i, Costumer[] cosArr) {
        Costumer costumer = new Costumer();
        Scanner input = new Scanner(System.in);
        //初始化用户信息
        System.out.println("---------------------添加客户--------------------- ");
        System.out.print("姓名：");
        costumer.setName(input.next());
        System.out.print("性别：");
        costumer.setSex(input.next().charAt(0));
        System.out.print("年龄：");
        costumer.setAge(input.nextInt());
        System.out.print("电话：");
        costumer.setPhone(input.next());
        System.out.print("邮箱：");
        costumer.setEmail(input.next());

        //将创建好的对象存入数组中
        cosArr[i] = costumer ;
        i++;
        System.out.println("---------------------添加完成--------------------- ");
        input.close();
    }

    //修改用户信息
    public static void reset(){
        Scanner input = new Scanner(System.in);
        System.out.println("请选择待修改客户编号(-1退出)：");
        int ficNum = input.nextInt();

        if(ficNum == -1){
            System.out.println("退出");
        }else{
            Costumer costumer = cosArr[ficNum];
            System.out.print("姓名(" + costumer.getName() +"):");

            System.out.print("性别(" + costumer.getSex() +")：");

            System.out.print("年龄(" + costumer.getAge() +")：");

            System.out.print("电话(" + costumer.getPhone() +")：");

            System.out.print("邮箱(" + costumer.getEmail() +")：");

        }
    }
    //删除用户

    //用户列表
    public static void printArr() {
        System.out.println("编号 \t姓名 \t性别 \t年龄 \t电话 \t邮箱");
        int index = 1;
        for (Costumer costumer : cosArr) {
            if (costumer == null) {
                continue;
            }
            System.out.print(index + "\t");
            Costumer.show(costumer);
            index++;
        }
    }

}
