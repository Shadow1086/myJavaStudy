package com.jdbcStudy.CURD;

import java.sql.*;
import java.util.Scanner;

/**
 * 类名: QuerySingleRow
 * 创建时间: 2025/12/11 18:39
 * 项目描述:
 * 单行多列的查询
 *
 * @author htLiang
 */
public class QuerySingleRow {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("select id,name from table_name where id = ?");
            Scanner input = new Scanner(System.in);
            System.out.print("请输入要查询的id:");
            int getInt = input.nextInt();
            ps.setInt(1,getInt);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id= rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+"\t"+name);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
