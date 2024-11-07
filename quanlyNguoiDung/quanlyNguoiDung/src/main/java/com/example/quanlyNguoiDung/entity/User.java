package com.example.quanlyNguoiDung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;
        
    @Column(name = "password", nullable = false)
    private String password;
        
    @Column(name = "ho_ten", nullable = false)
    private String hoTen;
        
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "sdt")
    private String sdt;

    @Column(name = "ma_nhom")
    private String maNhom;

    @Column(name = "loai_nguoi_dung")
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
