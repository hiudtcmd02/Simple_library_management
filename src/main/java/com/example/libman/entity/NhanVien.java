package com.example.libman.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class NhanVien {
    private int id;
    private String taiKhoan;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
}
