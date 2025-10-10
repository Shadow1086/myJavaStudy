package java001.day04_arr;

//将数组a 中的第一个元素移到数组末尾，其余元素往前移动
public class Practice01 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("请输入数组元素个数：");
//        int num = scan.nextInt();
        int[] a = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        int temp = a[9];
        a[9] = a[0];
        for (int i = 0; i < a.length - 2; i++) {
            a[i] = a[i + 1];
        }
        a[8] = temp;
        for (int num : a) {
            System.out.print(num + "\t");
        }
    }
}
