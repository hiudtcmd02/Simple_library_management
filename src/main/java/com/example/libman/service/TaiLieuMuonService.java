package com.example.libman.service;

import com.example.libman.dao.TaiLieuDAO;
import com.example.libman.dao.TaiLieuMuonDAO;
import com.example.libman.dto.TaiLieuMuonDTO;
import com.example.libman.entity.TaiLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaiLieuMuonService {
    @Autowired
    private TaiLieuMuonDAO taiLieuMuonDAO;

    @Autowired
    private TaiLieuDAO taiLieuDAO;

    public List<TaiLieuMuonDTO> listAllTaiLieuMuonOfBanDoc(int id){
        List<TaiLieuMuonDTO> ltlm = taiLieuMuonDAO.getAllTaiLieuMuonOfBanDoc(id);
        for (TaiLieuMuonDTO tlm : ltlm){
            TaiLieu tl = taiLieuDAO.findById(tlm.getTaiLieuid());
            tlm.setTenTaiLieu(tl.getTenTaiLieu());
            tlm.setHinhAnh(tl.getHinhAnh());
            tlm.setDonGia(tl.getDonGia());
        }
        return ltlm;
    }
}
