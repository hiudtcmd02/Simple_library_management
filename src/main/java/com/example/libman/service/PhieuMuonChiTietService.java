package com.example.libman.service;

import com.example.libman.dao.PhieuMuonChiTietDAO;
import com.example.libman.dao.TaiLieuDAO;
import com.example.libman.entity.PhieuMuonChiTiet;
import com.example.libman.entity.TaiLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuMuonChiTietService {
    @Autowired
    private PhieuMuonChiTietDAO phieuMuonChiTietDAO;

    @Autowired
    private TaiLieuDAO taiLieuDAO;

    public void saveDocListForPhieuMuon(int phieuMuonId, List<Integer> docIds){
        for(int taiLieuId : docIds){
            PhieuMuonChiTiet pmct = new PhieuMuonChiTiet();
            pmct.setPhieuMuonid(phieuMuonId);
            pmct.setTrangThai(1);
            pmct.setTaiLieuid(taiLieuId);
            phieuMuonChiTietDAO.saveNewLendingDoc(pmct);

            TaiLieu t = taiLieuDAO.findById(taiLieuId);
            int soLuongCu = t.getTongSoLuong();
            int soLuongMoi = soLuongCu - 1;
            taiLieuDAO.updateSoLuongTaiLieu(taiLieuId, soLuongMoi);
        }
    }
}
