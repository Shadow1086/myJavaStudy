package Class02.Error.Apply01;

import org.junit.Test;

public class ErrorTest01 {
    public static void main(String[] args) {
        // //举例1：栈内存溢出错误StackOverFlowError
        // main(args);
        // //举例2：OutOfMemoryError: Java heap space
        // byte[] arr = new byte[1024 * 1024 * 100];

    }
    @Test       
    //NullPointerException
    public void test1(){
        int[] arr = new int [10];
        arr = null;
        System.out.println(arr[0]);
    }
}
