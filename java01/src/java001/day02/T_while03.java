package java001.day02;

import java.util.Scanner;

public class T_while03 {
    public static void main(String [] args){
        //对于正整数n,m，求s=1+2+3……+n，当加到第几项时，s的值会超过m？
        Scanner scan = new Scanner(System.in);
        int m =  scan.nextInt();
        int num = 1;
        int sum = 0;
        while(sum < m){
            sum += num;
            num += 1;
        }
        System.out.println("当加到N = " + num +"时，s的值超过了m。");
    }
}
