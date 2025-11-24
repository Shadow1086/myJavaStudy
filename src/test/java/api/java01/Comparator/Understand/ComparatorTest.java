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
        CompareProduct[] arr = new CompareProduct[5];
        arr[0] = new CompareProduct("a", 1);
        arr[1] = new CompareProduct("b", 2);
        arr[2] = new CompareProduct("c", 3);
        arr[3] = new CompareProduct("d", 4);
        arr[4] = new CompareProduct("e", 5);
        // 创建一个实现了Comparator接口的实现类的对象
        Comparator<CompareProduct> comparator = new Comparator<CompareProduct>() {
            // 如何判断两个对象的大小，其标准就是吃方法的方法体要编写的逻辑
            // 比如：按照价格从低到高
            @Override
            public int compare(CompareProduct p1, CompareProduct p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        };
        Comparator<CompareProduct> comparator2 = new Comparator<CompareProduct>() {
            @Override
            public int compare(CompareProduct p1, CompareProduct p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        Arrays.sort(arr, comparator2);
        for (CompareProduct product : arr) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void test02(){
        String[] arr = new String[]{"tom","jerry","rose"};
        Arrays.sort(arr,new Comparator<String>() {

            @Override
            public int compare(String s1 , String s2){
                return s1.compareTo(s2);
            }
        });
        for(String str:arr){
            System.out.println(str);
        }
    }
}
