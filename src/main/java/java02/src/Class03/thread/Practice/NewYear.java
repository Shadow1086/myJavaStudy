package Class03.thread.Practice;

/**
 * ClassName: NewYear
 * Description:
 * 
 * 模拟新年倒计时，每隔一秒输出一个数字，依次输出10，9，8，7，。。。1，最后输出，新年快乐！
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-01 22:22:12
 */
public class NewYear {
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 0){
                System.out.println("新年快乐！");
                break;
            }else{
                System.out.println(i);
            }
        }
    }
}
