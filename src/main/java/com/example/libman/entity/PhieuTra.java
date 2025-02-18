package com.example.libman.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class PhieuTra {
    private int id;
    private Date ngayTra;
    private int BanDocid;
    private int NhanVienThuVienid;
}
