package com.example.libman.dao;

import com.example.libman.entity.TaiLieu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaiLieuDAO {
    public void saveNewTaiLieu(TaiLieu taiLieu);

    public List<TaiLieu> listAll();
    public List<TaiLieu> findAllByName(String name);
    public TaiLieu findById(int id);
    public void deleteTaiLieuById(int id);

    public TaiLieu updateTaiLieu(TaiLieu taiLieu);

    public void updateSoLuongTaiLieu(int taiLieuId, int soLuong);

    public List<TaiLieu> findAllByLoaiTaiLieu(int loaiTaiLieuId);
}
