package com.example.libman.dao;

import com.example.libman.entity.PhieuMuon;
import org.springframework.stereotype.Component;

@Component
public interface PhieuMuonDAO {
    public void saveNewPhieuMuon(PhieuMuon phieuMuon);

    public int getNewestPhieuMuonId();
}
