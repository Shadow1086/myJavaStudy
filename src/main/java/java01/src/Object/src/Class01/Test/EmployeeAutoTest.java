package Class01.Test;

import Class01.Encapsulation.Encapsulation04.Employee;

/**
 * 一个无需交互输入的自动化测试类，直接构造多个 Employee 对象并打印信息。
 * @author Liang-ht
 */
public class EmployeeAutoTest {
    public static void main(String[] args) {
        System.out.println("=== 启动 EmployeeAutoTest ===");

        Employee[] employees = new Employee[5];

        employees[0] = new Employee();
        employees[0].setName("张三");
        employees[0].setSex('男');
        employees[0].setAge(30);
        employees[0].setTeleNum("13800000001");

        employees[1] = new Employee();
        employees[1].setName("李四");
        employees[1].setSex('女');
        employees[1].setAge(28);
        employees[1].setTeleNum("13800000002");

        employees[2] = new Employee();
        employees[2].setName("王五");
        employees[2].setSex('男');
        employees[2].setAge(45);
        employees[2].setTeleNum("13800000003");

        // 边界与异常输入试探
        employees[3] = new Employee();
        employees[3].setName("边界A");
        employees[3].setSex('k');
        // 性别未限制，将被原样记录
        employees[3].setAge(0);
        // 会提示：输入年龄有误
        employees[3].setTeleNum("00000000000");

        employees[4] = new Employee();
        employees[4].setName("边界B");
        employees[4].setSex(' ');
        employees[4].setAge(121);
        // 会提示：输入年龄有误
        employees[4].setTeleNum("");

        System.out.println("编号\t姓名\t性别\t年龄\t电话");
        for (int i = 0; i < employees.length; i++) {
            System.out.println((i + 1) + "\t" + employees[i].getInfo());
        }

        System.out.println("=== 结束 EmployeeAutoTest ===");
    }
}


