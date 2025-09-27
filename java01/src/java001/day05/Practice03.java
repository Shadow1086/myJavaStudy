package java001.day05;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:创建元素各不重复的数组，两个方法
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */
//创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。
// 同时，要求元素的值各不相同。
public class Practice03 {
    public static void test1() {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 30) + 1);

            boolean flag = false;
            //判断随机数是否重复

            while (true) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    arr[i] = (int) ((Math.random() * 30) + 1);
                    flag = false;
                    continue;
                }
                break;
            }
        }
        for (int num : arr) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void test2() {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
      //i--的作用：下次循环的i和这次的i相同，那么下次的赋值就会覆盖掉这次，从而避免重复
                    i--;
                    break;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
//    public static void main(String[] args) {
//        int[] arr = new int[6];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) ((Math.random() * 30) + 1);
//
//            boolean flag = false;
//            //判断随机数是否重复
//
//            while (true) {
//                for (int j = 0; j < i; j++) {
//                    if (arr[i] == arr[j]) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    arr[i] = (int) ((Math.random() * 30) + 1);
//                    flag = false;
//                    continue;
//                }
//                break;
//
//            }
//
//        }
//        for (int num : arr) {
//            System.out.print(num + "\t");
//        }

}

