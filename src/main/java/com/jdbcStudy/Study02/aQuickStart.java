package com.jdbcStudy.Study02;

import java.sql.*;

/**
 * 类名: test01
 * 创建时间: 2025/12/11 16:02
 * 项目描述:
 *
 * @author htLiang
 */
public class aQuickStart {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            //初始化表格
//            String sql = """
//                    create table if not exists table_name(
//                        id integer,
//                        name varchar(10)
//                    )
//                    """;
//            stmt.executeUpdate(sql);
//            String query01 = """
//                    Insert into `table_name` (id,name) values (1,"hello1");
//                    Insert into `table_name` (id,name) values (2,"hello2");
//                    Insert into `table_name` (id,name) values (3,"hello3");
//                    Insert into `table_name` (id,name) values (4,"hello4");
//                    Insert into `table_name` (id,name) values (5,"hello5");
//                    """;
//            stmt.executeUpdate(query01);
            //编写SQL语句，并执行，并接受返回的结果集
            String query02 = """
                    Select id,name from `table_name`;
                    """;
            ResultSet resultSet = stmt.executeQuery(query02);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id+"\t"+name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
