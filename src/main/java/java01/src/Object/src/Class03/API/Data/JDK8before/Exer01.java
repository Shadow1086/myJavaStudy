package Class03.API.Data.JDK8before;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

/**
 * ClassName: Exer01
 * Description: 
 * 
 * 如何将一个 java.util.Date 的实例转换为 java.sql.Date 的实例
 * 
 * 将控制台获取的年月日（比如：2022-12-13）的字符串数据，保存在数据库中。
 * （简化为得到 java.sql.Date 的对象，此对象对应的时间为 2022-12-13）。
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-08 18:46:18
 */
public class Exer01 {
    @Test
    public void test01(){
        Date date1 = new Date();
        java.sql.Date dateSql = new java.sql.Date(date1.getTime());
        System.out.println(dateSql.toString());
    }

    /**
     * 将控制台获取的年月日（比如：2022-12-13）的字符串数据，保存在数据库中。
     * （简化为得到 java.sql.Date 的对象，此对象对应的时间为 2022-12-13）。
     * 思路：先转化为SimpleDateFormat ---> java.util.Date ----> java.sql.Date;
     */
    @Test
    public void test02() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2022-12-13");
        System.out.println(date1.toString());

        java.sql.Date dateS = new java.sql.Date(date1.getTime());
        System.out.println(dateS.toString());

    }
}
