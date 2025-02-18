package com.example.libman.service;

import com.example.libman.dao.PhieuMuonChiTietDAO;
import com.example.libman.dao.PhieuTraChiTietDAO;
import com.example.libman.dao.TaiLieuDAO;
import com.example.libman.entity.PhieuMuonChiTiet;
import com.example.libman.entity.PhieuTraChiTiet;
import com.example.libman.entity.TaiLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuTraChiTietService {
    @Autowired
    private PhieuTraChiTietDAO phieuTraChiTietDAO;

    @Autowired
    private PhieuMuonChiTietDAO phieuMuonChiTietDAO;

    @Autowired
    private TaiLieuDAO taiLieuDAO;

    public void saveNewPhieuTraChiTiet(int phieuTraId, List<Integer> taiLieuTraIds){
        for(int tltId : taiLieuTraIds){
            PhieuMuonChiTiet pmct = phieuMuonChiTietDAO.getPhieuMuonChiTietById(tltId);
            String maSachMuon = Integer.toString(tltId);

            PhieuTraChiTiet ptct = new PhieuTraChiTiet();
            ptct.setMaSachMuon(maSachMuon);
            ptct.setTaiLieuid(pmct.getTaiLieuid());
            ptct.setPhieuTraid(phieuTraId);
            phieuTraChiTietDAO.saveNewPhieuTraChiTiet(ptct);
            phieuMuonChiTietDAO.updateTrangThaiPhieuMuonChiTiet(tltId, 0);

            TaiLieu t = taiLieuDAO.findById(ptct.getTaiLieuid());
            int soLuongCu = t.getTongSoLuong();
            int soLuongMoi = soLuongCu + 1;
            taiLieuDAO.updateSoLuongTaiLieu(ptct.getTaiLieuid(), soLuongMoi);
        }
    }
}
