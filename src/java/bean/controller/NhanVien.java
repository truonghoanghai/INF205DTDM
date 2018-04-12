/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.controller;

/**
 *
 * @author hoanghai
 */

public class NhanVien {
    private int manv;
    private String tennv;
    private boolean gioitinh;
    private String ngaysinh;
    private String hinh;
    private String email;
    private String sdt;
    private Float luong;
    private String ghichu;
    private boolean capdo;
    private String mapbid;

    public NhanVien() {
    }

    public NhanVien(int manv, String tennv, boolean gioitinh, String ngaysinh, String hinh, String email,
            String sdt, Float luong, String ghichu, boolean capdo, String mapbid) {
        this.manv = manv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.hinh = hinh;
        this.email = email;
        this.sdt = sdt;
        this.luong = luong;
        this.ghichu = ghichu;
        this.capdo = capdo;
        this.mapbid = mapbid;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Float getLuong() {
        return luong;
    }

    public void setLuong(Float luong) {
        this.luong = luong;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public boolean isCapdo() {
        return capdo;
    }

    public void setCapdo(boolean capdo) {
        this.capdo = capdo;
    }

    public String getMapbid() {
        return mapbid;
    }

    public void setMapbid(String mapbid) {
        this.mapbid = mapbid;
    }
    
    
}
