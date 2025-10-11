package Class08.Interface.Apply02;

import java.util.Scanner;
import java.util.Arrays;

/**
 * ClassName: Computer
 * Package: Class08.Interface.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:37
 * {@code @Version} 1.0
 */
class Computer {
    public void transfer(USB usb) {
        System.out.println("设备连接成功");
        usb.start();
        System.out.println("数据传输的细节操作");

        usb.stop();
        System.out.println("数据传输中止");
    }
}
