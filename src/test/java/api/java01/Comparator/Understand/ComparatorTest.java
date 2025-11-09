package api.java01.Comparator.Understand;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * ClassName: ComparatorTest
 * Description:
 * 
 * Comparator类
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-09 15:54:14
 */
public class ComparatorTest {
    @Test
    public void test01() {
        Product[] arr = new Product[5];
        arr[0] = new Product("a", 1);
        arr[1] = new Product("b", 2);
        arr[2] = new Product("c", 3);
        arr[3] = new Product("d", 4);
        arr[4] = new Product("e", 5);
        // 创建一个实现了Comparator接口的实现类的对象
        Comparator comparator = new Comparator() {
            // 如何判断两个对象的大小，其标准就是吃方法的方法体要编写的逻辑
            // 比如：按照价格从低到高
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Product p1 && o2 instanceof Product p2) {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Comparator comparator2 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Product p1 && o2 instanceof Product p2) {
                    return p1.getName().compareTo(p2.getName());
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Arrays.sort(arr, comparator2);
        for (Product product : arr) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void test02(){
        String[] arr = new String[]{"tom","jerry","rose"};
        Arrays.sort(arr,new Comparator() {

            @Override
            public int compare(Object o1 , Object o2){
                if(o1 instanceof String s1 && o2 instanceof String s2){
                    return s1.compareTo(s2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        for(String str:arr){
            System.out.println(str);
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name = '" + name + '\'' + "," +
                "price = '" + price + "}";
    }

}