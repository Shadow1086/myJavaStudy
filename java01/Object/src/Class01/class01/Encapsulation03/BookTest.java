package Class01.class01.Encapsulation03;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:创建Book实例
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 14:07
 * {@code @Version} 1.0
 */

public class BookTest {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setBookName("唐诗三百首");
        b1.setAuthor("李白");
        b1.setPrice(48);
        System.out.println("name = " +b1.getBookName() + "\nauthor = "
                + b1.getAuthor() + "\nprice = " + b1.getPrice());
    }
}
