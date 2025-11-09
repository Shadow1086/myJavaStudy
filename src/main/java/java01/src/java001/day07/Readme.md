### 使用Scanner获取不同类型数据的步骤：

1.导入import java.util.Scanner

2.提供或创建一个Scanner类的实例

3.调用Scanner类中的方法，获取指定类型的变量

4.关闭资源，调用Scanner类中的close（）

例如：

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //布尔类型
        Boolean isSingle = input.nextBoolean();
        //单字符类型
        char sex = input.next().charAt(0);
        //字符串
        String name = input.next();
        scanner.close();

    }
}
``` 

### Get_random:获取随机数

导入java.Math,使用Math.random()方法可以获取[0.0,1.0)
获取[a,b]之间的随机数：**_公式：(int) ( Math.random() * (b - a + 1)) + a;_**

