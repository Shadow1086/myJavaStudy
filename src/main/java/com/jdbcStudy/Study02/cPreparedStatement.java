package com.jdbcStudy.Study02;

import java.sql.*;
import java.util.Scanner;

/**
 * 类名: cPreparedStatement
 * 创建时间: 2025/12/11 17:23
 * 项目描述:
 *
 * @author htLiang
 */
public class cPreparedStatement {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement(" select id,name from table_name where name = ?;");

            System.out.print("请输入员工姓名:");
            Scanner input = new Scanner(System.in);
            String getName = input.nextLine();

            // 为？占位符赋值，并执行SQL语句
            ps.setString(1,getName);
            // 执行SQL语句并接受返回结果
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "\t" + name);
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

