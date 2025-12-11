package com.jdbcStudy.Study02;

import java.sql.*;
import java.util.Scanner;

/**
 * 类名: test02
 * 创建时间: 2025/12/11 16:53
 * 项目描述:
 *
 * @author htLiang
 */
public class bInjection {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            Statement stmt = conn.createStatement();
            System.out.print("请输入员工id:");
            Scanner input = new Scanner(System.in);
            String getName = input.nextLine();
            // 编写SQL语句
            // 如果此时填写的getName为：hello2' or '1' = '1,sql就会被识别为：select id,name from table_name where name = 'hello2' or '1' = '1';"
            // 就会得到所有数据，因为1=1永远是true
            String sql = " select id,name from table_name where name = '"+getName+"';";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "\t" + name);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
