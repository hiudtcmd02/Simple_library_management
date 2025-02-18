package com.example.libman.dao;

import com.example.libman.entity.NhanVien;
import org.springframework.stereotype.Component;

@Component
public interface NhanVienDAO {
    public NhanVien findByAccount(String taiKhoan);
}
