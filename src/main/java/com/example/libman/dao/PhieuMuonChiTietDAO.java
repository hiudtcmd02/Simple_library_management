package com.example.libman.dao;

import com.example.libman.entity.PhieuMuonChiTiet;
import org.springframework.stereotype.Component;

@Component
public interface PhieuMuonChiTietDAO {
    public void saveNewLendingDoc(PhieuMuonChiTiet phieuMuonChiTiet);
    public PhieuMuonChiTiet getPhieuMuonChiTietById(int id);
    public void updateTrangThaiPhieuMuonChiTiet(int id, int trangThai);
}
