/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import bean.controller.NhanVien;
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
public class NhanVienModel {
    public NhanVienModel(){
        
    }
    
    public static List<NhanVien> showNhanVien(String tennv) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from NhanVien";
            if (tennv.length() > 0) {
                sql += " where TenPB like '%" + tennv + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<NhanVien> list = new ArrayList<NhanVien>();
            while (rs.next()) {
                Integer manv =rs.getInt("manv");
                String name =rs.getString("tennv");
                Boolean gioitinh =rs.getBoolean("gioitinh");
                String ngaysinh =rs.getString("ngaysinh");
                String hinh =rs.getString("hinh");
                String email =rs.getString("email");
                String sdt =rs.getString("sdt");
                Float luong = rs.getFloat("luong");
                String ghichu =rs.getString("ghichu");
                Boolean capdo =rs.getBoolean("capdo");
                String mapbid = rs.getString("mapbid");
                NhanVien nv = new NhanVien(manv, name, gioitinh, ngaysinh, hinh, email, sdt, luong, ghichu, capdo, mapbid);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static void delete(String mapb) {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
//            Connection con = DriverManager.getConnection(url, "sa", "123");
//            String sql = "delete from PhongBan where MaPB=?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, mapb);
//            stm.executeUpdate();
//            stm.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insert(NhanVien sv) {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
//            Connection con = DriverManager.getConnection(url, "sa", "123");
//            String sql = "insert into PhongBan values(?,?)";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, sv.getMapb());
//            stm.setString(2, sv.getTenpb());
//            stm.executeUpdate();
//            stm.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//       
//    }
//
//    public static void update(NhanVien sv) {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://HOANGHAI-PC\\SQLEXPRESS:1433;databaseName=ASM_SOF302";
//            Connection con = DriverManager.getConnection(url, "sa", "123");
//            String sql = "update PhongBan set TenPB=? where MaPB=?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, sv.getTenpb());
//            stm.setString(2, sv.getMapb());
//            stm.executeUpdate();
//            stm.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
