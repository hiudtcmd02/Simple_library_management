package com.example.libman.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class TaiLieuMuonDTO {
    private int id;
    private int trangThai;
    private int taiLieuid;
    private int phieuMuonid;
    private Date ngayMuon;
    private int banDocid;
    private String tenTaiLieu;
    private String hinhAnh;
    private BigDecimal donGia;
}
