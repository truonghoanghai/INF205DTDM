/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import bean.controller.PhongBan;
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
public class PhongBanModel {
    public PhongBanModel(){
        
    }
    
    public static List<PhongBan> showPhongBan(String tenpb) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from PhongBan";
            if (tenpb.length() > 0) {
                sql += " where TenPB like '%" + tenpb + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<PhongBan> list = new ArrayList<PhongBan>();
            while (rs.next()) {
                String id = rs.getString("mapb");
                String name = rs.getString("tenpb");
                PhongBan pb = new PhongBan(id, name);
                list.add(pb);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public static void delete(String mapb) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from PhongBan where MaPB=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, mapb);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(PhongBan sv) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "INSERT INTO PhongBan VALUES(?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getMapb());
            stm.setString(2, sv.getTenpb());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(PhongBan sv) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update PhongBan set TenPB=? where MaPB=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getTenpb());
            stm.setString(2, sv.getMapb());
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
