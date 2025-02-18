package com.example.libman.dao;

import com.example.libman.entity.BanDoc;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BanDocDAO {
    public void saveNewBanDoc(BanDoc banDoc);
    public List<BanDoc> findAll();
    public List<BanDoc> findAllByName(String hoTen);
    public BanDoc findById(int id);
    public void deleteBanDocById(int id);
    public BanDoc updateBanDoc(BanDoc banDoc);
    public List<BanDoc> findAllBanDocLendDoc();
    public List<BanDoc> findAllBanDocLendDocByName(String ten);
}
