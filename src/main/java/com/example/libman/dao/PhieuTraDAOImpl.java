package com.example.libman.dao;

import com.example.libman.entity.PhieuTra;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PhieuTraDAOImpl implements PhieuTraDAO{
    private final JdbcTemplate jdbcTemplate;

    public PhieuTraDAOImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveNewPhieuTra(PhieuTra phieuTra) {
        String sql = "INSERT INTO phieutra (ngayTra, BanDocid, NhanVienThuVienid) VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql, phieuTra.getNgayTra(), phieuTra.getBanDocid(), phieuTra.getNhanVienThuVienid());
    }

    @Override
    public int getNewestPhieuTraId() {
        String sql = "SELECT MAX(id) FROM phieutra";
        int phieuTraId = jdbcTemplate.queryForObject(sql, Integer.class);
        return phieuTraId;
    }
}
