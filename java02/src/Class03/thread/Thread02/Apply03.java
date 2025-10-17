package Class03.thread.Thread02;

/**
 * ClassName: Apply03
 * Description:
 * 
 * 使用Runnable方法来实现输出100以内的偶数/奇数
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-15 21:21:50
 * {@code @Version} 1.0
 */
public class Apply03 {

    public static void main(String[] args) {
        // 3.   创建当前实现类的对象
        PrintNumberJi printJi = new PrintNumberJi();
        PrintNumberOu printOu = new PrintNumberOu();
        // 4.   将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
        Thread thread = new Thread(printJi);   
        Thread thread1  =new Thread(printOu);

        //通过调用Runnable匿名类的方式
        new Thread(new Runnable(){
            @Override
            public void run(){
            for (int i = 1; i <= 100; i += 2) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }).start();

        // 5.   Thread类的实例调用start():1.启动线程，2.调用当前线程中的run()
        thread.start();
        thread1.start();
    }

}

// 1. 创建一个实现Runnable接口的类
class PrintNumberJi implements Runnable {
    // 2. 实现接口中的run()方法 ----> 将此线程要执行的操作，声明在此方法体内
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/*
 * 在创建一个新线程遍历偶数
 */
class PrintNumberOu implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
