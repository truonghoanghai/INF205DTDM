/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import bean.controller.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoanghai
 */
public class UserModel {
    public UserModel(){
        
    }
    public static List<User> showUser(String username) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from Users";
            if (username.length() > 0) {
                sql += " where Username like '%" + username + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String full = rs.getString("fullname");
                User us = new User(user, pass, full);
                list.add(us);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public static void delete(String username) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Users where Username =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(User sv) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Users values(?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getUsername());
            stm.setString(2, sv.getPassword());
            stm.setString(3, sv.getFullname());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(User sv) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update PhongBan set Password=? Fullname=? where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getPassword());
            stm.setString(2, sv.getFullname());
            stm.setString(3, sv.getUsername());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
