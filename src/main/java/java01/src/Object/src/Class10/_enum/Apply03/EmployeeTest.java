package Class10._enum.Apply03;
/**
 * ClassName: EmployeeTest
 * Description:
 * 
 * Description
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-12 21:54:29
 * {@code @Version} 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        
        Employee employee1 = new Employee("Tom" , 12 ,Status.BUSY);
        System.out.println(employee1);

        Employee employee2 = new Employee("Lyly", 13, Status.DIMISSION);
        System.out.println(employee2);

    }
}
