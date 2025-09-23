package java001.day02;

public class T_for01 {
    public static void main(String [] args){
        int num_ji = 0;
        int num_ou =0;
        for (int i = 1; i <= 100; i++){
            if(i % 2 ==0 ){
                num_ou += i;
            }
            else{
                num_ji += i;
            }
        }
        System.out.println("100以内的奇数和为："+num_ji + ",偶数和为" + num_ou + "。");
    }
}
