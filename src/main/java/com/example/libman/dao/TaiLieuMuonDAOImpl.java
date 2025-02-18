package com.example.libman.dao;

import com.example.libman.dto.TaiLieuMuonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaiLieuMuonDAOImpl implements TaiLieuMuonDAO{
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public TaiLieuMuonDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TaiLieuMuonDTO> getAllTaiLieuMuonOfBanDoc(int id) {
        String sql = "SELECT pmct.id, pmct.trangThai, pmct.TaiLieuid, pmct.PhieuMuonid, pm.ngayMuon, pm.BanDocid " +
                        "FROM phieumuonchitiet pmct " +
                        "JOIN phieumuon pm ON pmct.PhieuMuonid = pm.id " +
                        "WHERE pm.BanDocid = ? AND pmct.trangThai = 1";

        List<TaiLieuMuonDTO> result = new ArrayList<>();
        jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            TaiLieuMuonDTO dto = new TaiLieuMuonDTO();
            dto.setId(rs.getInt("id"));
            dto.setTrangThai(rs.getInt("trangThai"));
            dto.setTaiLieuid(rs.getInt("TaiLieuid"));
            dto.setPhieuMuonid(rs.getInt("PhieuMuonid"));
            dto.setNgayMuon(rs.getDate("ngayMuon"));
            dto.setBanDocid(rs.getInt("BanDocid"));
            result.add(dto);
            return dto;
        });
        return result;
    }
}
