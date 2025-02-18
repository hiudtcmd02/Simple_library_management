package com.example.libman.service;

import com.example.libman.dao.PhieuTraDAO;
import com.example.libman.entity.PhieuTra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class PhieuTraService {
    @Autowired
    private PhieuTraDAO phieuTraDAO;

    public void saveNewReceiveApplication(int nhanVienId, int banDocId){
        //Lấy ngày hiện tại
        LocalDate dateOfNow = LocalDate.now();
        Date currentDate = Date.valueOf(dateOfNow);

        PhieuTra pt = new PhieuTra();
        pt.setNgayTra(currentDate);
        pt.setBanDocid(banDocId);
        pt.setNhanVienThuVienid(nhanVienId);
        phieuTraDAO.saveNewPhieuTra(pt);
    }
    public int getNewestReceiveApplicationId(){
        return phieuTraDAO.getNewestPhieuTraId();
    }
}
