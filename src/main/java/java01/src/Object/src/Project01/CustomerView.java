package Project01;

import java.util.Scanner;

/**
 * ClassName: Practice01
 * Package: Project01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 15:39
 * {@code @Version} 1.0
 */

public class CustomerView {
    CustomerList customerList = new CustomerList(10);
    int total = 0;

    /**
     * 用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer）
     * 以完成客户信息处理。
     */
    public void enterMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.print("-----------------拼电商客户管理系统-----------------" +
                    "\n" +
                    "  1 添 加 客 户\n" +
                    "  2 修 改 客 户\n" +
                    "  3 删 除 客 户\n" +
                    "  4 客 户 列 表\n" +
                    "  5 退       出\n" +
                    "  请 选 择(1-5)： ");
            Scanner input = new Scanner(System.in);
            int ficNum = input.nextInt();
            switch (ficNum) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误,请等待1秒后重新输入");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.enterMainMenu();
                    break;
            }
        }

    }
//添加
    public void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        customer.setName(input.next());
        System.out.print("性别：");
        customer.setSex(input.next().charAt(0));
        System.out.print("年龄：");
        customer.setAge(input.nextInt());
        System.out.print("电话：");
        customer.setPhone(input.next());
        System.out.print("邮箱：");
        customer.setEmail(input.next());
        boolean flag = customerList.addCustomer(customer);
        if (flag) {
            System.out
                    .println("---------------------添加完成---------------------");
        }else{
            System.out
                    .println("---------------------添加失败---------------------");
        }

    }

//修改
    private void modifyCustomer() {

    }

    private void deleteCustomer() {

    }

    private void listAllCustomers() {

    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
//Scanner input = new Scanner(System.in);
//public static void main(String[] args) {
//    int ficNum = input.nextInt();
//    while(ficNum != 5){
//        switch(ficNum){
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//            case 4:
//
//                break;
//
//
//        }
//    }
//}
