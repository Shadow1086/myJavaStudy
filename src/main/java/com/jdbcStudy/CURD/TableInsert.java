package com.jdbcStudy.CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 类名: TableInsert
 * 创建时间: 2025/12/11 18:50
 * 项目描述:
 *
 * @author htLiang
 */
public class TableInsert {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("Insert into table_name(id,name) values (?,?)");
            Scanner input = new Scanner(System.in);
            System.out.print("输入id:");
            int idInsert = input.nextInt();
            System.out.print("输入姓名：");
            String nameInsert = input.next();
            ps.setInt(1,idInsert);
            ps.setString(2,nameInsert);

            int result =  ps.executeUpdate();
            System.out.println("受影响行数："+ result );
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
