package com.example.libman.dao;

import com.example.libman.entity.LoaiTaiLieu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoaiTaiLieuDAO {
    public void saveNewLoaiTaiLieu(LoaiTaiLieu loaiTaiLieu);
    public List<LoaiTaiLieu> findAll();
    public List<LoaiTaiLieu> findAllByName(String tenLoaiTaiLieu);
    public void deleteLoaiTaiLieuById(int id);
    public LoaiTaiLieu findById(int id);
    public LoaiTaiLieu updateLoaiTaiLieu(LoaiTaiLieu loaiTaiLieu);
}
