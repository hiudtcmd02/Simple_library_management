package com.example.libman.dao;

import com.example.libman.entity.PhieuTra;
import org.springframework.stereotype.Component;

@Component
public interface PhieuTraDAO {
    public void saveNewPhieuTra(PhieuTra phieuTra);
    public int getNewestPhieuTraId();
}
