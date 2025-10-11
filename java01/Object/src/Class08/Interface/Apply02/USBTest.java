package Class08.Interface.Apply02;

/**
 * ClassName: USBTest
 * Package: Class08.Interface.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:29
 * {@code @Version} 1.0
 */

public class USBTest {
    public static void main(String[] args) {
        //多态
        Computer computer = new Computer();
        Printer printer = new Printer();
//      自动多态，相当于  USB printer = new Printer();

        computer.transfer(printer);
    }
}

