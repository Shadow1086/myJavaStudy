package api.java01.Data.JDK8Later;
import java.util.Calendar;
import org.junit.Test;
import java.util.Date;
/**
 * ClassName: DateTimeTest
 * Description: 
 * 
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-08 20:18:21
 */
public class DateTimeTest {
    /**
     * JDK8之前的问题：
     * 可变性：像日期和时间这样的类应该是不可变的。
     * 便宜行：Date中的年份是从1900开始的，而月份都从0开始
     * 格式化：格式化只对Date有用，Calendar则不行。
     * 此外，他们也不是线程安全的，不能处理闰秒
     */
    @Test
    public void test01(){
        String s1 = "hello";
        String s2 = s1.replace('l','w');//String的不可变性
        System.out.println(s1);         //hello

        //体会Calendar的可变性  
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,23);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
    @Test
    public void test02(){
        Date date = new Date(2022,11,14);
        System.out.println(date);       //Thu Dec 14 00:00:00 CST 3922,月份和年份和输入的并不一致
    }
}
