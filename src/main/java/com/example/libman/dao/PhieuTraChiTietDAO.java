package com.example.libman.dao;

import com.example.libman.entity.PhieuTraChiTiet;
import org.springframework.stereotype.Component;

@Component
public interface PhieuTraChiTietDAO {
    public void saveNewPhieuTraChiTiet(PhieuTraChiTiet phieuTraChiTiet);
}
