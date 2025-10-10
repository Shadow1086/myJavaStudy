package Class01.Encapsulation.Encapsulation04;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:声明普通员工类Employee，提供get/set方法，并提供String getInfo()方法
 * 在测试类的main中创建员工数组，并从键盘输入员工对象信息，最后遍历输出
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 14:26
 * {@code @Version} 1.0
 */

public class Employee {
    //属性
    private String name;
    private char sex;
    private int age;
    private String teleNum;

    //方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age>0&&age<120){
            this.age= age;
        }else{
            System.out.println("输入年龄有误");
        }
    }
    public int  getAge(){
        return age;
    }

    public void setSex(char sex){

        this.sex = sex;
    }
    public char getSex(){
        return sex;
    }

    public void setTeleNum(String num){
        this.teleNum = num;
    }
    public String getTeleNum(){
        return teleNum;
    }

    //显示总信息方法
    public String getInfo(){
        return (name + "\t" + sex + "\t" + age + "\t" + teleNum);
    }
}
