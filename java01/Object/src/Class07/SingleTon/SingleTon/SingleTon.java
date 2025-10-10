package Class07.SingleTon.SingleTon;

/**
 * ClassName: SingleTon
 * Package: Class07.SingleTon
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/9 19:42
 * {@code @Version} 1.0
 */

public class SingleTon {

}
//饿汉式
class SingleTon2{
    //2.内部提供一个当前类的实例
    private static SingleTon2 singleTon2;
    //1.私有化构造器
    private SingleTon2(){
    }

    //3.提供公共的静态的方法，返回当前类的对象。
    //4.由于此方法为静态，所以上面声明的唯一实例也必须静态化
    public static SingleTon2 getInstance(){
        if(singleTon2 == null){
            singleTon2 = new SingleTon2();
        }
        return singleTon2;
    }
}

//懒汉式
class SingleTon1{
    //2.内部提供一个类的实例
    private static SingleTon1 singleTon1 = new SingleTon1();
    //1.私有化构造器
    private SingleTon1(){
    }

    //3.提供公共的静态方法，返回类的对象。
    public static SingleTon1 getInstance(){
        return singleTon1;
    }
}
