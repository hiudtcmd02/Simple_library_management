package com.example.libman.dao;

import com.example.libman.entity.NhanVien;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NhanVienDAOImpl implements NhanVienDAO{
    private final JdbcTemplate jdbcTemplate;

    public NhanVienDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public NhanVien findByAccount(String taiKhoan) {
        try{
            String sql = "SELECT * FROM nhanvienthuvien WHERE taiKhoan = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{taiKhoan}, (rs, rowNum) -> {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("id"));
                nv.setTaiKhoan(rs.getString("taiKhoan"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                return nv;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Trả về null nếu không tìm thấy người dùng
        }
    }
}
