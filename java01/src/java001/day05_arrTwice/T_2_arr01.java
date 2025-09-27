package java001.day05_arrTwice;
import java.util.Scanner;

//二维数组的初始化

public class T_2_arr01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for(int j = 0;j<3;j++){
                int num = scan.nextInt();
                a[i][j] = num;
            }
        }
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
