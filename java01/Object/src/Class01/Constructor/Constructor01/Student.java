package Class01.Constructor.Constructor01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 18:23
 * {@code @Version} 1.0
 */

public class Student {
    //属性
    String name;
    int age;
    String school;
    String major;

    //方法;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Student(String name,int age,String school){
        this.name = name;
        this.age = age;
        this.school = school;
    }
    public Student(String name,int age,String school,String major){
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
    }

    public void printInfo(){
        System.out.println("name = " + name + "\tage = " + age
                + "\tschool = " + school + "\tmajor = " + major);
    }

}
