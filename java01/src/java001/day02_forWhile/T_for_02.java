package java001.day02_forWhile;

public class T_for_02 {
    public static void main(String [] args){
        //1-101的乘积和
        long  sum = 1;
        for(int i = 2;i<102;i++){
            sum += i;
        }
        System.out.println("1*2*3*...*101 = " + sum);
    }
}
