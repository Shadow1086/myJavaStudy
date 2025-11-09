package Class03.interview01;

/**
 * ClassName: Practice01
 * Package: Class03.interview01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 23:04
 * {@code @Version} 1.0
 */

public class Interview02 {

    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo()); //atguigu  就近原则，方法没有被重写，所以还是父类较近
        s.test();//atguigu atguigu
        System.out.println("-----------------");
        s.setInfo("大硅谷");
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo());//大硅谷
        s.test(); //大硅谷 大硅谷
    }
}

class Father {
    private String info = "atguigu";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Son extends Father {
    private String info = "尚硅谷";

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }

//    public String getInfo(){
//        return info;
//    }
}
