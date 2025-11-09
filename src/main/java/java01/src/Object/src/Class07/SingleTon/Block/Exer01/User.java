package Class07.SingleTon.Block.Exer01;

/**
 * ClassName: User
 * Package: Class07.SingleTon.Block.Exer01
 * Description:
 *
 * 声明User类，
 * - 包含属性：username（String类型），password（String类型），registrationTime（long类型），私有化
 * - 包含get/set方法，其中registrationTime没有set方法
 * - 包含无参构造，
 *      - 输出“新用户注册”，
 *      - registrationTime赋值为当前系统时间，
 *      - username就默认为当前系统时间值，
 *      - password默认为“123456”
 * - 包含有参构造(String username, String password)，
 *      - 输出“新用户注册”，
 *      - registrationTime赋值为当前系统时间，
 *      - username和password由参数赋值
 *
 * - 包含public String getInfo()方法，返回：“用户名：xx，密码：xx，注册时间：xx”
 *
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/9 20:03
 * {@code @Version} 1.0
 */

public class User {
    private String userName;
    private String password;
    //注册时间
    private long registrationTime;

    public User() {
        System.out.println("新用户注册");
        //获取系统当前时间，距离1970/1/1 00：00：00到现在的毫秒数
        registrationTime = System.currentTimeMillis();
        userName = System.currentTimeMillis() + "";
        password = "123456";
    }

    public User(String userName, String password) {
        System.out.println("新用户注册");
        registrationTime = System.currentTimeMillis();
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRegistrationTime() {
        return registrationTime;
    }

    public String getInfo(){
        return "用户名："  + userName + "\t密码：" + password + "\t注册时间： " + registrationTime;
    }
}
