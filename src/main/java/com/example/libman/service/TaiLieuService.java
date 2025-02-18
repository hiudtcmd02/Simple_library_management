package com.example.libman.service;

import com.example.libman.dao.LoaiTaiLieuDAO;
import com.example.libman.dao.TaiLieuDAO;
import com.example.libman.dto.TaiLieuDTO;
import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.entity.TaiLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaiLieuService {
    @Autowired
    private TaiLieuDAO taiLieuDAO;

    @Autowired
    private LoaiTaiLieuDAO loaiTaiLieuDAO;

    public void save(TaiLieu taiLieu){
        taiLieuDAO.saveNewTaiLieu(taiLieu);
    }

    public List<TaiLieu> listAll(){
        return taiLieuDAO.listAll();
    }

    public List<TaiLieu> listAllByName(String name){
        return taiLieuDAO.findAllByName(name);
    }

    public TaiLieuDTO getTaiLieuById(int id){
        TaiLieu tl = taiLieuDAO.findById(id);
        LoaiTaiLieu ltl = loaiTaiLieuDAO.findById(tl.getLoaiTaiLieuid());

        TaiLieuDTO taiLieuDTO = new TaiLieuDTO();
        taiLieuDTO.setId(tl.getId());
        taiLieuDTO.setTenTaiLieu(tl.getTenTaiLieu());
        taiLieuDTO.setTacGia(tl.getTacGia());
        taiLieuDTO.setHinhAnh(tl.getHinhAnh());
        taiLieuDTO.setNhaXuatBan(tl.getNhaXuatBan());
        taiLieuDTO.setNhaSanXuat(tl.getNhaSanXuat());
        taiLieuDTO.setNamXuatBan(tl.getNamXuatBan());
        taiLieuDTO.setChatLieu(tl.getChatLieu());
        taiLieuDTO.setDonGia(tl.getDonGia());
        taiLieuDTO.setTongSoLuong(tl.getTongSoLuong());
        taiLieuDTO.setKichThuoc(tl.getKichThuoc());
        taiLieuDTO.setMoTa(tl.getMoTa());
        taiLieuDTO.setLoaiTaiLieu(ltl.getTenLoaiTaiLieu());

        return taiLieuDTO;
    }

    public TaiLieu getTaiLieuDetailForUpdate(int id){
        return taiLieuDAO.findById(id);
    }

    public void delete(int id){
        taiLieuDAO.deleteTaiLieuById(id);
    }

    public TaiLieu edit(int id, TaiLieu docEdited){
        TaiLieu tl = taiLieuDAO.findById(id);

        tl.setTenTaiLieu(docEdited.getTenTaiLieu());
        tl.setTacGia(docEdited.getTacGia());
        tl.setHinhAnh(docEdited.getHinhAnh());
        tl.setNhaXuatBan(docEdited.getNhaXuatBan());
        tl.setNhaSanXuat(docEdited.getNhaSanXuat());
        tl.setNamXuatBan(docEdited.getNamXuatBan());
        tl.setChatLieu(docEdited.getChatLieu());
        tl.setDonGia(docEdited.getDonGia());
        tl.setTongSoLuong(docEdited.getTongSoLuong());
        tl.setKichThuoc(docEdited.getKichThuoc());
        tl.setMoTa(docEdited.getMoTa());
        tl.setLoaiTaiLieuid(docEdited.getLoaiTaiLieuid());

        final TaiLieu updatedtl = taiLieuDAO.updateTaiLieu(tl);
        return updatedtl;
    }

    public List<TaiLieu> filterByDocType(int docTypeId){
        if(docTypeId == 0){
            return taiLieuDAO.listAll();
        } else {
            return taiLieuDAO.findAllByLoaiTaiLieu(docTypeId);
        }
    }
}
