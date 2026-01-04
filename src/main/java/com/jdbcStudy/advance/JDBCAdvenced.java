package com.jdbcStudy.advance;

import com.jdbcStudy.advance.pojo.Employee;

import java.sql.*;
import java.util.ArrayList;

/**
 * 类名: JDBCAdvenced
 * 创建时间: 2025/12/11 19:56
 * 项目描述:
 * <p>
 * ORM框架
 *
 * @author htLiang
 */
public class JDBCAdvenced {
//    public static final Employee[] employeeList = new Employee[100];
    public static final ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        testOrm();
        for(int i = 0;i<employeeList.size();i++){
            System.out.println(employeeList.get(i).toString());
        }
    }

    public static void testOrm() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("select * from employee_table where id<=8");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int age = rs.getInt("age");
                employeeList.add(new Employee(id, name, salary, age));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void ReturnPKI(){

    }
    public Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            return  conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
