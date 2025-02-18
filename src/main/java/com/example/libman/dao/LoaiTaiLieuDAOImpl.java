package com.example.libman.dao;

import com.example.libman.entity.LoaiTaiLieu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoaiTaiLieuDAOImpl implements LoaiTaiLieuDAO{
    private final JdbcTemplate jdbcTemplate;

    public LoaiTaiLieuDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveNewLoaiTaiLieu(LoaiTaiLieu loaiTaiLieu){
        String sql = "INSERT INTO loaitailieu (tenLoaiTaiLieu, moTa, kichHoat) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, loaiTaiLieu.getTenLoaiTaiLieu(), loaiTaiLieu.getMoTa(), loaiTaiLieu.getKichHoat());
    }
    public List<LoaiTaiLieu> findAll() {
        String sql = "SELECT * FROM loaitailieu WHERE kichHoat = 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            LoaiTaiLieu ltl = new LoaiTaiLieu();
            ltl.setId(rs.getInt("id"));
            ltl.setTenLoaiTaiLieu(rs.getString("tenLoaiTaiLieu"));
            ltl.setMoTa(rs.getString("moTa"));
            ltl.setKichHoat(rs.getInt("kichHoat"));
            return ltl;
        });
    }

    public List<LoaiTaiLieu> findAllByName(String tenLoaiTaiLieu) {
        String sql = "SELECT * FROM loaitailieu WHERE tenLoaiTaiLieu LIKE ? AND kichHoat = 1";
        return jdbcTemplate.query(sql, new Object[]{"%" + tenLoaiTaiLieu + "%"}, (rs, rowNum) -> {
            LoaiTaiLieu ltl = new LoaiTaiLieu();
            ltl.setId(rs.getInt("id"));
            ltl.setTenLoaiTaiLieu(rs.getString("tenLoaiTaiLieu"));
            ltl.setMoTa(rs.getString("moTa"));
            ltl.setKichHoat(rs.getInt("kichHoat"));
            return ltl;
        });
    }

    public void deleteLoaiTaiLieuById(int id) {
        String sql = "UPDATE loaitailieu SET kichHoat=0 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public LoaiTaiLieu findById(int id){
        String sql = "SELECT * FROM loaitailieu WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            LoaiTaiLieu ltl = new LoaiTaiLieu();
            ltl.setId(rs.getInt("id"));
            ltl.setTenLoaiTaiLieu(rs.getString("tenLoaiTaiLieu"));
            ltl.setMoTa(rs.getString("moTa"));
            ltl.setKichHoat(rs.getInt("kichHoat"));
            return ltl;
        });
    }

    public LoaiTaiLieu updateLoaiTaiLieu(LoaiTaiLieu loaiTaiLieu){
        String sql = "UPDATE loaitailieu SET tenLoaiTaiLieu = ?, moTa = ? WHERE id = ?";
        jdbcTemplate.update(sql, loaiTaiLieu.getTenLoaiTaiLieu(), loaiTaiLieu.getMoTa(), loaiTaiLieu.getId());
        return loaiTaiLieu;
    }
}
