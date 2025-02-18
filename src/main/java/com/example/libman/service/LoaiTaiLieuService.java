package com.example.libman.service;

import com.example.libman.dao.LoaiTaiLieuDAO;
import com.example.libman.entity.LoaiTaiLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTaiLieuService {
    @Autowired
    private LoaiTaiLieuDAO loaiTaiLieuDAO;

    public List<LoaiTaiLieu> listAll(){
        return loaiTaiLieuDAO.findAll();
    }

    public List<LoaiTaiLieu> listAllByName(String tenLoaiTaiLieu){
        return loaiTaiLieuDAO.findAllByName(tenLoaiTaiLieu);
    }

    public void save(String tenLoaiTaiLieu, String moTa, int kichHoat){
        LoaiTaiLieu a  = new LoaiTaiLieu();
        a.setTenLoaiTaiLieu(tenLoaiTaiLieu);
        a.setMoTa(moTa);
        a.setKichHoat(kichHoat);
        loaiTaiLieuDAO.saveNewLoaiTaiLieu(a);
    }

    public void delete(int id){
        loaiTaiLieuDAO.deleteLoaiTaiLieuById(id);
    }

    public LoaiTaiLieu getLoaiTaiLieuById(int id){
        return loaiTaiLieuDAO.findById(id);
    }

    public LoaiTaiLieu edit(int id, LoaiTaiLieu docTypeEdited){
        LoaiTaiLieu ltl = loaiTaiLieuDAO.findById(id);
        ltl.setTenLoaiTaiLieu(docTypeEdited.getTenLoaiTaiLieu());
        ltl.setMoTa(docTypeEdited.getMoTa());
        final LoaiTaiLieu updatedltl = loaiTaiLieuDAO.updateLoaiTaiLieu(ltl);
        return updatedltl;
    }
}
