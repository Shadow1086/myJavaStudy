package Class03.thread.Safe_Thread01;
/**
 * ClassName: Ticket01
 * Description:
 * 
 * 开启三个窗口售票，总票数为100张
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-17 20:42:16
 * {@code @Version} 1.0
 */
public class Ticket01 {
    public static void main(String[] args) {
        SaleTicket saleTicket1 = new SaleTicket();

        SaleTicket saleTicket2 = new SaleTicket();
        SaleTicket saleTicket3 = new SaleTicket();
        Thread thread1 = new Thread(saleTicket1);
        thread1.setName("窗口1  ");
        Thread thread2 = new Thread(saleTicket2);
        thread2.setName("窗口2  ");
        Thread thread3 = new Thread(saleTicket3);
        thread3.setName("窗口3  ");
        thread1.start();
        thread1.run();

        thread2.start();
        thread2.run();

        thread3.start();
        thread3.run();
    }
}

class Window01 implements Runnable {
    @Override
    public void run() {

    }
}

class Window02 extends Thread{
    @Override
    public void run(){

    }
}

class SaleTicket implements Runnable{
    int ticket = 100;
    @Override
    public void run(){
        while (true) {
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "售票，票号为 : " + ticket);
                ticket --;
            }else{
                break;
            }

        }
    }
}