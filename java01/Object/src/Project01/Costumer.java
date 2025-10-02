package Project01;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/1 22:05
 * {@code @Version} 1.0
 */

public class Costumer {
//属性：
    private String name;
    private int age;
    private char sex;
    private String phone;
    private String email;

    //构造器
    public Costumer() {
    }

    public Costumer(String name, int age, char sex, long tele, String phone, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }

    //初始化赋值
    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(char sex) {
        if (sex == '男' || sex == '女') {
            this.sex = sex;
        } else {
            System.out.println("输入的性别有误");
        }

    }

//方法：
    //输出用户信息
    public static void show(Costumer costumer) {
        System.out.println(costumer.getName() + "\t" + costumer.getSex() + "\t" +
                costumer.getAge() + "\t" + costumer.getPhone() + "\t" + costumer.getEmail());
    }
}
