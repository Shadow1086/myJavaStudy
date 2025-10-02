package Project01;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * 功能：                                1 添 加 客 户
 * 2 修 改 客 户
 * 3 删 除 客 户
 * 4 客 户 列 表
 * 5 退           出
 * <p>
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/1 22:11
 * {@code @Version} 1.0
 */

public class Main {
    public static void main(String[] args) {
        System.out.print("-----------------拼电商客户管理系统-----------------\n" +
                "1 添 加 客 户\n" +
                "2 修 改 客 户\n" +
                "3 删 除 客 户\n" +
                "4 客 户 列 表\n" +
                "5 退      出\n" +
                "请选择(1-5)：");

        Scanner input = new Scanner(System.in);
        int ficNum = input.nextInt();
        while (ficNum != 5) {
            int i = 0;
            switch (ficNum) {
                //添加用户信息
                case 1:
                    CostumerList.addCostumer(i, CostumerList.getCosArr());
                    ficNum = input.nextInt();
                    break;
                //修改用户
                case 2:

                    ficNum = input.nextInt();
                    break;
                //删除用户
                case 3:

                    ficNum = input.nextInt();
                    break;
                //打印用户列表
                case 4:
                    CostumerList.printArr();
                    ficNum = input.nextInt();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("输入信息无效");
            }
        }
    }


}
