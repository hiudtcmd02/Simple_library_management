package com.example.libman.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class BanDoc {
    private int id;
    private String hoTen;
    private String lop;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String vaiTro;
    private int kichHoat;
}
