package com.example.libman.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaiLieuDTO {
    private int id;
    private String tenTaiLieu;
    private String tacGia;
    private String hinhAnh;
    private String nhaXuatBan;
    private String nhaSanXuat;
    private int namXuatBan;
    private String chatLieu;
    private BigDecimal donGia;
    private int tongSoLuong;
    private String kichThuoc;
    private String moTa;
    private String loaiTaiLieu;
}
