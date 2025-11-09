package Class03.API.Data.JDK8before;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * ClassName: DateTimeTest
 * Description: 
 * 
 * 关于Date类
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-08 17:47:19
 */
public class DateTimeTest {
    /**
     * Date类的使用
     * | --- java.util.Date
     *      >两个构造器的使用
     *      >两个方法的使用：1.toString()方法   2.long getTime()：获得毫秒数
     *           | ---- java.sql.Date :对应着数据库中的date类,只有一个带参数的构造器
     *            
     */
    @Test
    public void test01(){
        Date date1 = new Date();        //创建一个基于当前系统时间的Date实例
        System.out.println(date1.toString());//Sat Nov 08 18:04:21 CST 2025
        long milliTimes = date1.getTime();      //对应的毫秒数为： 1762596261612
        System.out.println("对应的毫秒数为： " + milliTimes);

        Date date2 = new Date(1762595931658L);//创建基于时间戳的Date实例
        System.out.println(date2.toString());   //Sat Nov 08 17:58:51 CST 2025

    }

    @Test
    public void test02(){
        java.sql.Date date1 = new java.sql.Date(1762595931658L);
        System.out.println(date1.toString());   //2025-11-08

        System.out.println(date1.getTime());    //1762595931658

    }

    /**
     * SimpleDateFormat类：用于日期时间的格式化和解析
     * 格式化：日期----->字符串
     * 解析： 字符串----->日期
     */
    @Test
    public void test03() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期----->字符串
        Date date1 = new Date();
        String strDate = sdf.format(date1);
        System.out.println(strDate);        //   2025/11/8 18:09


        //解析： 字符串----->日期
        Date date2 = sdf.parse("2025/11/8 18:09");
        System.out.println(date2);
    }
    /**
     * 使用自己规定的格式
     */
    @Test
    public void test04() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    //格式化：日期----->字符串    
        //规定时间格式为：  EEE, d MMM yyyy HH:mm:ss Z
        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = new Date();
        String strDate = sdf.format(date1);
        System.out.println(strDate);        
        // EEE, d MMM yyyy HH:mm:ss Z  ------> 周六, 8 11月 2025 18:14:04 +0800
        // yyyy-MM-dd hh:mm:ss   ----->  2025-11-08 06:16:05

     //解析： 字符串----->日期    
        Date date2 = sdf.parse("2025-11-08 06:16:05");//只能传yyyy-MM-dd hh:mm:ss格式，别的格式识别不了
        System.out.println(date2);          //Sat Nov 08 06:16:05 CST 2025
    }

    /**
     * Calendar:日历类
     * 1. 实例化：由于Calendar是一个抽象类，所以我们需要创建其之类的实例，这里我们通过Calendar的静态方法getInstance()即可获取
     * 2.常用方法：get(int field)  /  set(int field,xx)  /   add(int field,xx)  /  getTime()  /  setTime()
     */
    @Test
    public void test05(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());        //class java.util.GregorianCalendar

        //测试方法
        //get(int field)
        System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");     //这个月的第8天
        System.out.println("今年的第"+calendar.get(Calendar.DAY_OF_YEAR)+"天");          //今年的第312天

        //set(int field,xx)
        calendar.set(Calendar.DAY_OF_MONTH,23);
        System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //这个月的第23天

        //add(int field,xx)
        calendar.add(Calendar.DAY_OF_MONTH,3);
        calendar.add(Calendar.DAY_OF_MONTH,-5);
        System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //这个月的第21天  (加了三天，又减了五天)

        //getTime()
        System.out.println(calendar.getTime());     //Fri Nov 21 18:42:24 CST 2025,返回的是Date类

        //setTime()：使用指定的Date重置Calenda
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println("这个月的第" + calendar.get(Calendar.DAY_OF_MONTH)+"天");    //相当于重置了，还是第8天
    }
}
