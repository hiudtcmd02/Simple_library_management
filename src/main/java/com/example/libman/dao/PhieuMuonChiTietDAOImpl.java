package com.example.libman.dao;

import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.entity.PhieuMuonChiTiet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PhieuMuonChiTietDAOImpl implements PhieuMuonChiTietDAO{
    private final JdbcTemplate jdbcTemplate;

    public PhieuMuonChiTietDAOImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveNewLendingDoc(PhieuMuonChiTiet phieuMuonChiTiet) {
        String sql = "insert into phieumuonchitiet (trangThai, TaiLieuid, PhieuMuonId) values (?, ?, ?)";
        jdbcTemplate.update(sql, phieuMuonChiTiet.getTrangThai(), phieuMuonChiTiet.getTaiLieuid(), phieuMuonChiTiet.getPhieuMuonid());
    }

    @Override
    public PhieuMuonChiTiet getPhieuMuonChiTietById(int id) {
        String sql = "SELECT * FROM phieumuonchitiet WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            PhieuMuonChiTiet pmct = new PhieuMuonChiTiet();
            pmct.setId(rs.getInt("id"));
            pmct.setTrangThai(rs.getInt("trangThai"));
            pmct.setTaiLieuid(rs.getInt("TaiLieuid"));
            pmct.setPhieuMuonid(rs.getInt("PhieuMuonId"));
            return pmct;
        });
    }

    @Override
    public void updateTrangThaiPhieuMuonChiTiet(int id, int trangThai) {
        String sql = "UPDATE phieumuonchitiet SET trangThai = ? WHERE id = ?";
        jdbcTemplate.update(sql, trangThai, id);
    }
}
