package com.example.libman.service;

import com.example.libman.dao.BanDocDAO;
import com.example.libman.entity.BanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanDocService {
    @Autowired
    private BanDocDAO banDocDAO;

    public void save(BanDoc banDoc){
        BanDoc bd = new BanDoc();
        bd.setHoTen(banDoc.getHoTen());
        bd.setLop(banDoc.getLop());
        bd.setNgaySinh(banDoc.getNgaySinh());
        bd.setDiaChi(banDoc.getDiaChi());
        bd.setSoDienThoai(banDoc.getSoDienThoai());
        bd.setEmail(banDoc.getEmail());
        bd.setVaiTro(banDoc.getVaiTro());
        bd.setKichHoat(1);
        banDocDAO.saveNewBanDoc(bd);
    }

    public List<BanDoc> listAll(){
        return banDocDAO.findAll();
    }

    public List<BanDoc> listAllByName(String name){
        return banDocDAO.findAllByName(name);
    }

    public BanDoc getBanDocById(int id){
        return banDocDAO.findById(id);
    }

    public BanDoc editBanDoc(int id, BanDoc banDocEditted) {
        BanDoc bd = banDocDAO.findById(id);
        bd.setHoTen(banDocEditted.getHoTen());
        bd.setLop(banDocEditted.getLop());
        bd.setNgaySinh(banDocEditted.getNgaySinh());
        bd.setDiaChi(banDocEditted.getDiaChi());
        bd.setSoDienThoai(banDocEditted.getSoDienThoai());
        bd.setEmail(banDocEditted.getEmail());
        bd.setVaiTro(banDocEditted.getVaiTro());
        return banDocDAO.updateBanDoc(bd);
    }

    public void deleteBanDoc(int id){
        banDocDAO.deleteBanDocById(id);
    }

    public List<BanDoc> listAllReaderLendDoc(){
        return banDocDAO.findAllBanDocLendDoc();
    }

    public List<BanDoc> listAllReaderLendDocByName(String name){
        return banDocDAO.findAllBanDocLendDocByName(name);
    }
}
