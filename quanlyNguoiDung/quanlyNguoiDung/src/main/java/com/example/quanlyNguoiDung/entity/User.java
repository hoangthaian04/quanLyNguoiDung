package com.example.quanlyNguoiDung.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    private String hoTen;
    private String email;
    private String sdt;
    private String maNhom;
    private String loaiNguoiDung;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSdt(){
        return sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    public String getMaNhom(){
        return maNhom;
    }
    public void setMaNhom(String maNhom){
        this.maNhom = maNhom;
    }
    public String getLoaiNguoiDung(){
        return loaiNguoiDung;
    }
    public void setLoaiNguoiDung(String loaiNguoiDung){
        this.loaiNguoiDung = loaiNguoiDung;
    }
}
