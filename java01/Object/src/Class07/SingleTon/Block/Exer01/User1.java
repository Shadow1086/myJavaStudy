package Class07.SingleTon.Block.Exer01;

/**
 * ClassName: User1
 * Package: Class07.SingleTon.Block.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/9 20:19
 * {@code @Version} 1.0
 */

public class User1 {
    private String userName;
    private String password;
    //注册时间
    private long registrationTime;

    {

        System.out.println("非静态代码块的调用\n新用户注册");
        registrationTime = System.currentTimeMillis();
    }
    public User1() {
        //获取系统当前时间，距离1970/1/1 00：00：00到现在的毫秒数
        userName = System.currentTimeMillis() + "";
        password = "123456";
    }

    public User1(String userName, String password) {
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
