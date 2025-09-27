package java001.day05;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:打印杨辉三角形
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */

public class Practice02 {
    public static void main(String[] args) {
        //1.创建二维数组
        int[][] yanghui = new int[10][];
        //2.使用循环结构，初始化外层数组元素
        for (int i = 0; i < yanghui.length; i++) {
            //呈现出梯形的结构
            yanghui[i] = new int[i + 1];
            //3.给数组元素赋值
            //3.1给数组每行的首末元素赋值（都是1
            yanghui[i][0] = yanghui[i][i] = 1;

            //3.2给每行的非首末元素赋值

            for (int j = 1; j < i; j++) {
                //j从每行的第二个元素开始，到倒数第二个元素结束
                yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
            }

        }
        //遍历二维数组并打印
        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
