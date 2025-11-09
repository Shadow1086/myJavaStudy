package Class03.thread.Thread01;
/**
 * ClassName: Apply01
 * Description:
 * 
 * 创建一个分线程1，用于遍历100以内的偶数
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-15 20:13:15
 * {@code @Version} 1.0
 */
public class Apply01 {
    public static void main(String[] args) {
        //3.   创建当前Thread的子类的对象
        PrintNumber printNumber = new PrintNumber();
        
    //4.   通过对象调用start()方法
        printNumber.start();

        /*
         * 问题1：能否使用t1.run()替换t1.start()的调用，来实现分线程的创建和使用：不行
         * 
         * 问题2：再提供一个分线程，用于100以内的偶数的遍历:
         * 注意：不能让已经start()的线程，再次执行start()，否则会报异常
         */

        //main方法中的线程,会发现两个线程同时进行
        for(int i = 2;i<=100;i+= 2 ){
            System.out.println(Thread.currentThread().getName() + ":" +i);

        }
    }
} 
//1.   创建一个继承于Tread类的子类
class PrintNumber extends Thread{
//2.   重写Thread中的run()---->将此线程要执行的操作，声明在此方法体内
    @Override
    public void run(){
        for(int i = 2;i<=100;i+= 2 ){
            System.out.println(Thread.currentThread().getName() + ":" + i);

        }
    }

}