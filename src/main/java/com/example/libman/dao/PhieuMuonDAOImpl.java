package com.example.libman.dao;

import com.example.libman.entity.PhieuMuon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PhieuMuonDAOImpl implements PhieuMuonDAO{
    private final JdbcTemplate jdbcTemplate;

    public PhieuMuonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveNewPhieuMuon(PhieuMuon phieuMuon) {
        String sql = "INSERT INTO phieumuon (ngayMuon, BanDocid, NhanVienThuVienid) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, phieuMuon.getNgayMuon(), phieuMuon.getBanDocid(), phieuMuon.getNhanVienThuVienid());
    }

    @Override
    public int getNewestPhieuMuonId() {
        String sql = "SELECT MAX(id) FROM phieumuon";
        int phieuMuonId = jdbcTemplate.queryForObject(sql, Integer.class);
        return phieuMuonId;
    }
}
