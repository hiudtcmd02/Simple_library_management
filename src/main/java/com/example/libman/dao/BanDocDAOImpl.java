package com.example.libman.dao;

import com.example.libman.entity.BanDoc;
import com.example.libman.entity.LoaiTaiLieu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class BanDocDAOImpl implements BanDocDAO{
    private final JdbcTemplate jdbcTemplate;

    public BanDocDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void saveNewBanDoc(BanDoc banDoc) {
        String sql = "INSERT INTO bandoc (hoTen, lop, ngaySinh, diaChi, soDienThoai, email, vaiTro, kichHoat) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, banDoc.getHoTen(), banDoc.getLop(), banDoc.getNgaySinh(), banDoc.getDiaChi(), banDoc.getSoDienThoai(),
                                banDoc.getEmail(), banDoc.getVaiTro(), banDoc.getKichHoat());
    }

    @Override
    public List<BanDoc> findAll() {
        String sql = "SELECT * FROM bandoc WHERE kichHoat = 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BanDoc bd = new BanDoc();
            bd.setId(rs.getInt("id"));
            bd.setHoTen(rs.getString("hoTen"));
            bd.setLop(rs.getString("lop"));
            bd.setNgaySinh(rs.getDate("ngaySinh"));
            bd.setDiaChi(rs.getString("diaChi"));
            bd.setSoDienThoai(rs.getString("soDienThoai"));
            bd.setEmail(rs.getString("email"));
            bd.setVaiTro(rs.getString("vaiTro"));
            bd.setKichHoat(rs.getInt("kichHoat"));
            return bd;
        });
    }

    @Override
    public List<BanDoc> findAllByName(String hoTen) {
        String sql = "SELECT * FROM bandoc WHERE hoTen LIKE ? AND kichHoat = 1";
        return jdbcTemplate.query(sql, new Object[]{"%" + hoTen + "%"}, (rs, rowNum) -> {
            BanDoc bd = new BanDoc();
            bd.setId(rs.getInt("id"));
            bd.setHoTen(rs.getString("hoTen"));
            bd.setLop(rs.getString("lop"));
            bd.setNgaySinh(rs.getDate("ngaySinh"));
            bd.setDiaChi(rs.getString("diaChi"));
            bd.setSoDienThoai(rs.getString("soDienThoai"));
            bd.setEmail(rs.getString("email"));
            bd.setVaiTro(rs.getString("vaiTro"));
            bd.setKichHoat(rs.getInt("kichHoat"));
            return bd;
        });
    }

    @Override
    public BanDoc findById(int id) {
        String sql = "SELECT * FROM bandoc WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            BanDoc bd = new BanDoc();
            bd.setId(rs.getInt("id"));
            bd.setHoTen(rs.getString("hoTen"));
            bd.setLop(rs.getString("lop"));
            bd.setNgaySinh(rs.getDate("ngaySinh"));
            bd.setDiaChi(rs.getString("diaChi"));
            bd.setSoDienThoai(rs.getString("soDienThoai"));
            bd.setEmail(rs.getString("email"));
            bd.setVaiTro(rs.getString("vaiTro"));
            bd.setKichHoat(rs.getInt("kichHoat"));
            return bd;
        });
    }

    @Override
    public void deleteBanDocById(int id) {
        String sql = "UPDATE bandoc SET kichHoat=0 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public BanDoc updateBanDoc(BanDoc banDoc) {
        String sql = "UPDATE bandoc SET hoTen = ?, lop = ?, ngaySinh = ?, diaChi = ?, soDienThoai = ?, email = ?, vaiTro = ? WHERE id = ?";
        jdbcTemplate.update(sql, banDoc.getHoTen(), banDoc.getLop(), banDoc.getNgaySinh(), banDoc.getDiaChi(),
                            banDoc.getSoDienThoai(), banDoc.getEmail(), banDoc.getVaiTro(), banDoc.getId());
        return banDoc;
    }

    @Override
    public List<BanDoc> findAllBanDocLendDoc() {
        String sql = "SELECT DISTINCT * FROM bandoc WHERE id IN (SELECT BanDocid FROM phieumuon) AND kichHoat = 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BanDoc bd = new BanDoc();
            bd.setId(rs.getInt("id"));
            bd.setHoTen(rs.getString("hoTen"));
            bd.setLop(rs.getString("lop"));
            bd.setNgaySinh(rs.getDate("ngaySinh"));
            bd.setDiaChi(rs.getString("diaChi"));
            bd.setSoDienThoai(rs.getString("soDienThoai"));
            bd.setEmail(rs.getString("email"));
            bd.setVaiTro(rs.getString("vaiTro"));
            bd.setKichHoat(rs.getInt("kichHoat"));
            return bd;
        });
    }

    @Override
    public List<BanDoc> findAllBanDocLendDocByName(String ten) {
        String sql = "SELECT DISTINCT * FROM BanDoc WHERE id IN (SELECT BanDocid FROM PhieuMuon) AND hoTen LIKE ? AND kichHoat = 1";
        return jdbcTemplate.query(sql, new Object[]{"%" + ten + "%"}, (rs, rowNum) -> {
            BanDoc bd = new BanDoc();
            bd.setId(rs.getInt("id"));
            bd.setHoTen(rs.getString("hoTen"));
            bd.setLop(rs.getString("lop"));
            bd.setNgaySinh(rs.getDate("ngaySinh"));
            bd.setDiaChi(rs.getString("diaChi"));
            bd.setSoDienThoai(rs.getString("soDienThoai"));
            bd.setEmail(rs.getString("email"));
            bd.setVaiTro(rs.getString("vaiTro"));
            bd.setKichHoat(rs.getInt("kichHoat"));
            return bd;
        });
    }
}
