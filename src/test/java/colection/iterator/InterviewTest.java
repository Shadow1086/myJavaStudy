package colection.iterator;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;

import org.junit.Test;

/**
 * ClassName: InterviewTest
 * Description: 
 * 
 * 迭代器的使用
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-17 21:52:20
 */
public class InterviewTest {
    @Test
    public void test01(){
        Collection<Object> coll = new ArrayList<Object>();

        coll.add("AA");
        coll.add("AA");

        Person p1 = new Person("tom", 12);
        coll.add(p1);
        coll.add(128);//自动装箱
        coll.add(new String("java"));

        //获取迭代器对象
        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        //方式二：
        while( iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Person {
    String name;
    int age;
    public Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

