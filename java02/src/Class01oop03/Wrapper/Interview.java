package Class01oop03.Wrapper;

public class Interview {
    public static void main(String[] args) {

        //自动装箱，但底层都会调用Integer的valueOf()方法
        //不一样的原因：
        //[-128,127]都是直接从底层中的某个数组取出来，相当于一个对象（享元模式）
        //而超过这个范围就会新建对象
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false

    }
}
