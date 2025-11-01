package Class03.thread.Thread02;

/**
 * ClassName: Ticket
 * Description:
 * 
 * 三个线程卖100张票
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-31 16:29:28
 */
public class Ticket {
    public static void main(String[] args) {
        SaleTicket runnable = new SaleTicket();
        Thread thread01 = new Thread(runnable,"窗口1");
        Thread thread02 = new Thread(runnable,"窗口2");
        Thread thread03 = new Thread(runnable,"窗口3");
        thread01.start();
        thread02.start();
        thread03.start();
    }

    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

}

class SaleTicket implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

    }
}
