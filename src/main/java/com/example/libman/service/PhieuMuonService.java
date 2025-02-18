package com.example.libman.service;

import com.example.libman.dao.PhieuMuonDAO;
import com.example.libman.entity.PhieuMuon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class PhieuMuonService {
    @Autowired
    private PhieuMuonDAO phieuMuonDAO;

    public void saveNewPhieuMuon(int banDocid, int nhanVienid){
        //Lấy ngày hiện tại
        LocalDate dateOfNow = LocalDate.now();
        Date currentDate = Date.valueOf(dateOfNow);

        PhieuMuon pm = new PhieuMuon();
        pm.setNgayMuon(currentDate);
        pm.setBanDocid(banDocid);
        pm.setNhanVienThuVienid(nhanVienid);
        phieuMuonDAO.saveNewPhieuMuon(pm);
    }

    public int getNewestPhieuMuonId(){
        return phieuMuonDAO.getNewestPhieuMuonId();
    }
}
