package com.example.libman.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class PhieuMuon {
    private int id;
    private Date ngayMuon;
    private int banDocid;
    private int nhanVienThuVienid;
}
