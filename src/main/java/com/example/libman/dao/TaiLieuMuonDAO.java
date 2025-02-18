package com.example.libman.dao;

import com.example.libman.dto.TaiLieuMuonDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaiLieuMuonDAO {
    public List<TaiLieuMuonDTO> getAllTaiLieuMuonOfBanDoc(int id);
}
