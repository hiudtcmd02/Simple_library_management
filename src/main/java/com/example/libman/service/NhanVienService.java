package com.example.libman.service;

import com.example.libman.dao.NhanVienDAO;
import com.example.libman.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienDAO nhanVienDAO;

    public NhanVien checkLogin(String taiKhoan){
        return nhanVienDAO.findByAccount(taiKhoan);
    }
}
