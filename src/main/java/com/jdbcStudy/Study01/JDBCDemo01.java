package com.jdbcStudy.Study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ClassName: JDBCDemo01
 * Description: 
 * 
 * 学习JDBC的快速入门
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-12-07 15:38:13
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动(MySQL 8.x 使用新的驱动类名)
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://167.99.162.149:13306/curriculumdesign?" +
                     "useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "myDigitalOcean";
        String password = "LHTl527218713";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql语句
        String sql = "ALTER TABLE contacts CHANGE compant company VARCHAR(20)";
    
        //4.获取执行sql的对象Statment
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql); //返回的是受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }

    /**
     * 添加联系人
     * TODO：插入数据的时候现在这么写容易将一行数据拆开，所以应该要引入SELECT WHERE
     */
    public static void addContact(Statement stmt , Connection conn) throws Exception{
        //必填
        String name = input.readString();
        String tele1 = input.readString();
        //可选项
        String tele2 = input.readString();
        String home = input.readString();
        String email = input.readString();
        String notes = input.readString();
        String group = input.readString();
        if(name.isEmpty()){
            //TODO:返回一个错误窗口
        }else if(tele1.isEmpty()){
            //TODO:返回一个错误窗口
        }else{
            String setNameTele1 = "INSERT INTO contacts (contact_name,contact_tele1) VALUES ("+ name + ","+ tele1 +");";
            stmt = conn.createStatement();
            stmt.executeUpdate(setNameTele1);
        }
        if(!tele2.isEmpty()){
            String setTele2 = "UPDATE contacts SET contact_tele2 = "+ tele2 +" WHERE contact_name = "+ name +";";
            stmt = conn.createStatement();
            stmt.executeUpdate(setTele2);
        }
        if(!home.isEmpty()){
            String setHome = "UPDATE contacts SET home = "+ home +" WHERE contact_name = "+ name +";";
            stmt = conn.createStatement();
            stmt.executeUpdate(setHome);
        }
        if(!email.isEmpty()){
            String setEmail = "UPDATE contacts SET email = "+ email +" WHERE contact_name = "+ name +";";
            stmt = conn.createStatement();
            stmt.executeUpdate(setEmail);
        }
        if(!notes.isEmpty()){
            String setNotes = "UPDATE contacts SET notes = "+ notes +" WHERE contact_name = "+ name +";";
            stmt = conn.createStatement();
            stmt.executeUpdate(setNotes);
        }
        if(!group.isEmpty()){
            String setGroup = "UPDATE contacts SET group_id = "+ group +" WHERE contact_name = "+ name +";";
            stmt = conn.createStatement();
            stmt.executeUpdate(setGroup);
        }
    }

    /**
     * 查找联系人
     */
    public static void findContact(String name){
        String sql = "Select ";
    }

}
