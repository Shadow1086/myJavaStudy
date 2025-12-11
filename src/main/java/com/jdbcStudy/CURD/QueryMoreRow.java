package com.jdbcStudy.CURD;

import java.sql.*;

/**
 * 类名: QueryMoreRow
 * 创建时间: 2025/12/11 18:46
 * 项目描述:
 *
 * @author htLiang
 */
public class QueryMoreRow {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("select * from table_name where id>=1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
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
