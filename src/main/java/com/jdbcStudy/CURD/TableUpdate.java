package com.jdbcStudy.CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 类名: TableUpdate
 * 创建时间: 2025/12/11 19:00
 * 项目描述:
 *
 * @author htLiang
 */
public class TableUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/study/02-java/myJavaStudy/test.sqlite");
            PreparedStatement ps = conn.prepareStatement("update table_name set id = ? , name = ? where id = ?");
            Scanner input = new Scanner(System.in);
            System.out.print("输入要修改的用户id：");
            int idWait = input.nextInt();
            ps.setInt(1,idWait);
            input.nextLine();
            System.out.print("请输入修改后的id:");
            String idStr = input.nextLine();
            System.out.print("请输入修改后的姓名：");
            String nameNew = input.nextLine();
            if(!idStr.isEmpty()){
                int idNew = Integer.parseInt(idStr);
                ps.setInt(2,idNew);
            }
            if(!nameNew.isEmpty()){
                ps.setString(3,nameNew);
            }
            System.out.println("成功");
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
