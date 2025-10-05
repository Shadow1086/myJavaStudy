package Class04.Exer05;

/**
 * ClassName: java01
 * Package: Class04.Exer05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 22:33
 * {@code @Version} 1.0
 */

class Person {
    protected String name="person";
    protected int age=50;
    public String getInfo() {
        return "Name: "+ name + "\n" +"age: "+ age;
    }
}
class Student extends Person{
    protected String school="pku";

    public String getInfo() {
        return  "Name: "+ name + "\nage: "+ age
                + "\nschool: "+ school;
    }
}
class Graduate extends Student {
    public String major="IT";
    public String getInfo()
    {
        return  "Name: "+ name + "\nage: "+ age
                + "\nschool: "+ school+"\nmajor:"+major;
    }
}