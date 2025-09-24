package java001.day05;

//输入一个n行m列的黑白图像，将它顺时针旋转90度后输出。
//本质上就是行和列的转换。
public class T_2_arr04 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for(int i = 0;i<3;i++){
            for(int j = 2;j>=0;j--){
                System.out.print( arr[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
