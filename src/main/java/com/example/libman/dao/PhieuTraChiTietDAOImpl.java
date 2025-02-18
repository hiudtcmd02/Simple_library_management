package com.example.libman.dao;

import com.example.libman.entity.PhieuTraChiTiet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PhieuTraChiTietDAOImpl implements PhieuTraChiTietDAO{
    private final JdbcTemplate jdbcTemplate;
    public PhieuTraChiTietDAOImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveNewPhieuTraChiTiet(PhieuTraChiTiet phieuTraChiTiet) {
        String sql = "INSERT INTO phieutrachitiet (maSachMuon, TaiLieuid, PhieuTraid) VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql, phieuTraChiTiet.getMaSachMuon(), phieuTraChiTiet.getTaiLieuid(), phieuTraChiTiet.getPhieuTraid());
    }
}
