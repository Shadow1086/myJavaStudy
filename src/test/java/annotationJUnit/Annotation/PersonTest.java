package annotationJUnit.Annotation;
import java.util.Date;
/**
 * ClassName: PersonTest
 * Description:
 * 
 * 三大常见注解的使用：
 * 1. @Override: 限定重写父类方法，该注解只能用于方法
 * 2. @Deprecated: 用于表示所修饰的元素(类，方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * 3. @SuppressWarnings: 抑制编译器警告
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-14 15:12:55
 * {@code @Version} 1.0
 */
@MyAnnotation(value = "class")
public class PersonTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.eat();
        s.walk();

        Date date = new Date();
        System.out.println(date);

        @SuppressWarnings("Date中的年份需要减掉1900")
        Date date1 = new Date(2021-1900,10,9);
        System.out.println(date1);

        @SuppressWarnings("Person中的构造器已过时")
        Person p = new Person("张三");
       System.out.println(p.name);

        @SuppressWarnings("num的值被重新赋值")
        int num = 10;
        



    }
}




class Person {
    String name;
    int age;
@MyAnnotation(value = "构造器")
    public Person(){
        System.out.println("Person中的无参构造器");
    }
@MyAnnotation()
    @Deprecated
    public Person(String name){
        this.name = name;
    }

    @Deprecated
    public void eat(){
        System.out.println("吃饭");
    }

    public void walk(){
        System.out.println("走路");
    }

}

class Student extends Person{
    public Student(){
        super();    //调用父类的无参构造器
    }
    public Student(String name){
        super(name);  //调用父类的有参构造器    
    }
    @Override
    public void eat(){
        System.out.println("学生吃饭");
    }
    @Override
    public void walk(){
        System.out.println("学生走路");
    }
}
