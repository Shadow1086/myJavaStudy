package colection.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * ClassName: collectionTest
 * Description: 
 * 
 * 测试Collection中方法的使用
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-10 13:39:47
 */
public class collectionTest {
    /**
     * 1.add(Object o) : 添加元素对象到当前集合中
     * 2.addAll(Collection other) : 添加other集合中的所有元素对象到当前集合中，即this = this U other
     */
    @Test
    public void test01(){
        Collection coll = new ArrayList();

        //add()
        coll.add("aa");
        coll.add(123);      //  自动装箱
        coll.add("abdksl");
        coll.add(new Person("Tom",12));

        System.out.println(coll);
        Collection coll1 = new ArrayList();
        coll1.add(456);

        coll.add(coll1);
        System.out.println("add : "+coll);

        coll.addAll(coll1)  ;
        System.out.println("addAll : "+ coll);
    }
    /**
     * 1.int size():获取当前集合中实际存储的元素个数
     * 2.boollean isEmpty():判断当前集合是否为空集合
     * 3.boollean contains(Object o):判断当前集合中是否存在一个与obj对象equals返回true的元素
     * 4.boolean containsAll(Collection coll): 判断coll集合中的元素是否在当前集合中都存在
     * 5.boolean equals(Object o):判断当前集合与obj是否相等
     */
    @Test
    public void test02(){
        Collection coll = new ArrayList();

        //add()
        coll.add("aa");
        coll.add(123);      //  自动装箱
        coll.add("abdksl");
        Person p1 = new Person("Tom",12);
        coll.add(p1);

        //isEmpty()
        System.out.println(coll.isEmpty());     //false

        //contains(Object obj)：
        System.out.println(coll.contains("AA"));    //false，并不判断地址，而是比较内容
        System.out.println(coll.contains(123));     //true
        System.out.println(coll.contains(p1));          //true
        System.out.println(coll.contains(new Person("Tom",12)));    //false
    }
}
