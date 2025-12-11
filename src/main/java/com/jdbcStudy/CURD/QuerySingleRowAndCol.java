package com.jdbcStudy.CURD;

import java.sql.*;

/**
 * 类名: QuerySingleRowAndCol
 * 创建时间: 2025/12/11 17:40
 * 项目描述:
 *
 *  使用preparedStatement来进行CURD(增删改查)操作之一：单行单列的数据，如：count(*)，只会返回一共有多少数据
 *
 * @author htLiang
 */
public class QuerySingleRowAndCol {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("select count(*) as count from table_name");

            ResultSet rs = ps.executeQuery();
            //处理结果，如果自己明确一定只有一个结果，那么resultSet至少要做一次next的判断，才能拿到我们要的列的结果
            while(rs.next()){
                int count =  rs.getInt(1);
                System.out.println(count);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
