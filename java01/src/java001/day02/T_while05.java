package java001.day02;

public class T_while05 {
    public static void main(String[] args){
//有一根长15米的铁丝，有一根长18米的铁丝，要把它们截成同样长的小段，不许剩余，每段最长有几米？      最大公约数！！！
        int m = 15,n = 18;
        int r = n % m;
        while(r != 0){
            n = m;
            m = r;
            r = m % n;
        }
        System.out.println("每段最长为："+ n +"米。");
    }
}
