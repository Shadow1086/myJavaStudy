package api.java01.Comparator.Understand;

import java.util.Arrays;

import org.junit.Test;

/**
 * ClassName: ComparatorTest
 * Description: 
 * 
 * java中的比较器
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-09 15:07:18
 */
public class CompareTest {
    @Test
    public void test1(){
        String[] arr = new String[]{
            "tom","jerry","rose","jack","lucy"
        };
        Arrays.sort(arr);
        //排序完之后遍历
        for(String str:arr){
            System.out.print(str + "\t");
        }
    }
    @Test
    public void test02(){
        CompareProduct[] arr = new CompareProduct[5];
        arr[0] = new CompareProduct("a", 1);
        arr[1] = new CompareProduct("b", 2);
        arr[2] = new CompareProduct("c", 3);
        arr[3] = new CompareProduct("d", 4);
        arr[4] = new CompareProduct("e", 5);

        Arrays.sort(arr);
        for(CompareProduct product : arr){
            System.out.println(product.toString());
        }
    }
}
class CompareProduct implements Comparable{
    private String name;
    private double price;
    public CompareProduct(String name,double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return "Product{"+
        "name = '" + name +'\''+","+
        "price = '" + price +"}";
    }
    /**
     * 当前的类需要实现Compaarable中的抽象方法：compareTo(Object o)
     * 在此方法中，知名如何判断当前类的对象的大小，比如：按照价格的高低进行大小的比较，从低到高排序
     * 如果返回值是正数：当前对象大
     * 如果返回值是负数：当前对象小
     * 如果返回值是0:一样大
     * 
     * 比较标准：先比较价格（从大到小），价格相同，比较名字（从小到大）
     */
    @Override
    public int compareTo(Object o){
        if(o == this){
            return 0;
        };
        if(o instanceof CompareProduct product){
            int value =  Double.compare(this.price, product.price);
            if(value != 0){
                return -value;
            }
            return this.name.compareTo(product.name);
            
        }

        //手动抛出一个异常类的对象
        throw new RuntimeException("类型不匹配");
    }
}