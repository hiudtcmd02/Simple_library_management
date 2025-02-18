package com.example.libman.dao;

import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.entity.TaiLieu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaiLieuDAOImpl implements TaiLieuDAO{
    private final JdbcTemplate jdbcTemplate;

    public TaiLieuDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveNewTaiLieu(TaiLieu taiLieu){
        String sql = "INSERT INTO tailieu (tenTaiLieu, tacGia, hinhAnh, nhaXuatBan, nhaSanXuat,\n" +
                "                namXuatBan, chatLieu, donGia, tongSoLuong, kichThuoc, moTa, kichHoat, LoaiTaiLieuid) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, taiLieu.getTenTaiLieu(), taiLieu.getTacGia(), taiLieu.getHinhAnh(), taiLieu.getNhaXuatBan(),
                            taiLieu.getNhaSanXuat(), taiLieu.getNamXuatBan(), taiLieu.getChatLieu(), taiLieu.getDonGia(),
                            taiLieu.getTongSoLuong(), taiLieu.getKichThuoc(), taiLieu.getMoTa(), taiLieu.getKichHoat(),
                                                                                                taiLieu.getLoaiTaiLieuid());
    }

    @Override
    public List<TaiLieu> listAll() {
        String sql = "SELECT * FROM tailieu WHERE kichHoat = 1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TaiLieu tl = new TaiLieu();
            tl.setId(rs.getInt("id"));
            tl.setTenTaiLieu(rs.getString("tenTaiLieu"));
            tl.setTacGia(rs.getString("tacGia"));
            tl.setHinhAnh(rs.getString("hinhAnh"));
            tl.setNhaXuatBan(rs.getString("nhaXuatBan"));
            tl.setNhaSanXuat(rs.getString("nhaSanXuat"));
            tl.setNamXuatBan(rs.getInt("namXuatBan"));
            tl.setChatLieu(rs.getString("chatLieu"));
            tl.setDonGia(rs.getBigDecimal("donGia"));
            tl.setTongSoLuong(rs.getInt("tongSoLuong"));
            tl.setKichThuoc(rs.getString("kichThuoc"));
            tl.setMoTa(rs.getString("moTa"));
            tl.setKichHoat(rs.getInt("kichHoat"));
            tl.setLoaiTaiLieuid(rs.getInt("LoaiTaiLieuid"));
            return tl;
        });
    }

    public List<TaiLieu> findAllByName(String name){
        String sql = "SELECT * FROM tailieu WHERE tenTaiLieu LIKE ? AND kichHoat = 1";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, (rs, rowNum) -> {
            TaiLieu tl = new TaiLieu();
            tl.setId(rs.getInt("id"));
            tl.setTenTaiLieu(rs.getString("tenTaiLieu"));
            tl.setTacGia(rs.getString("tacGia"));
            tl.setHinhAnh(rs.getString("hinhAnh"));
            tl.setNhaXuatBan(rs.getString("nhaXuatBan"));
            tl.setNhaSanXuat(rs.getString("nhaSanXuat"));
            tl.setNamXuatBan(rs.getInt("namXuatBan"));
            tl.setChatLieu(rs.getString("chatLieu"));
            tl.setDonGia(rs.getBigDecimal("donGia"));
            tl.setTongSoLuong(rs.getInt("tongSoLuong"));
            tl.setKichThuoc(rs.getString("kichThuoc"));
            tl.setMoTa(rs.getString("moTa"));
            tl.setKichHoat(rs.getInt("kichHoat"));
            tl.setLoaiTaiLieuid(rs.getInt("LoaiTaiLieuid"));
            return tl;
        });
    }

    public TaiLieu findById(int id){
        String sql = "SELECT * FROM tailieu WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            TaiLieu tl = new TaiLieu();
            tl.setId(rs.getInt("id"));
            tl.setTenTaiLieu(rs.getString("tenTaiLieu"));
            tl.setTacGia(rs.getString("tacGia"));
            tl.setHinhAnh(rs.getString("hinhAnh"));
            tl.setNhaXuatBan(rs.getString("nhaXuatBan"));
            tl.setNhaSanXuat(rs.getString("nhaSanXuat"));
            tl.setNamXuatBan(rs.getInt("namXuatBan"));
            tl.setChatLieu(rs.getString("chatLieu"));
            tl.setDonGia(rs.getBigDecimal("donGia"));
            tl.setTongSoLuong(rs.getInt("tongSoLuong"));
            tl.setKichThuoc(rs.getString("kichThuoc"));
            tl.setMoTa(rs.getString("moTa"));
            tl.setKichHoat(rs.getInt("kichHoat"));
            tl.setLoaiTaiLieuid(rs.getInt("LoaiTaiLieuid"));
            return tl;
        });
    }

    public void deleteTaiLieuById(int id) {
        String sql = "UPDATE tailieu SET kichHoat=0 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public TaiLieu updateTaiLieu(TaiLieu taiLieu) {
        String sql = "UPDATE tailieu SET tenTaiLieu = ?, tacGia = ?, hinhAnh = ?, nhaXuatBan = ?, " +
                        "nhaSanXuat = ?, namXuatBan = ?, chatLieu = ?, donGia = ?, tongSoLuong = ?, " +
                            "kichThuoc = ?, moTa = ?, loaiTaiLieuid = ? WHERE id = ?";
        jdbcTemplate.update(sql, taiLieu.getTenTaiLieu(), taiLieu.getTacGia(), taiLieu.getHinhAnh(), taiLieu.getNhaXuatBan(),
                             taiLieu.getNhaSanXuat(), taiLieu.getNamXuatBan(), taiLieu.getChatLieu(), taiLieu.getDonGia(), taiLieu.getTongSoLuong(),
                                taiLieu.getKichThuoc(), taiLieu.getMoTa(), taiLieu.getLoaiTaiLieuid(), taiLieu.getId());
        return taiLieu;
    }

    @Override
    public void updateSoLuongTaiLieu(int taiLieuId, int soLuong) {
        String sql = "UPDATE tailieu SET tongSoLuong = ? WHERE id = ?";
        jdbcTemplate.update(sql, soLuong, taiLieuId);
    }

    @Override
    public List<TaiLieu> findAllByLoaiTaiLieu(int loaiTaiLieuId) {
        String sql = "SELECT * FROM tailieu WHERE LoaiTaiLieuid = ? AND kichHoat = 1";
        return jdbcTemplate.query(sql, new Object[]{loaiTaiLieuId}, (rs, rowNum) -> {
            TaiLieu tl = new TaiLieu();
            tl.setId(rs.getInt("id"));
            tl.setTenTaiLieu(rs.getString("tenTaiLieu"));
            tl.setTacGia(rs.getString("tacGia"));
            tl.setHinhAnh(rs.getString("hinhAnh"));
            tl.setNhaXuatBan(rs.getString("nhaXuatBan"));
            tl.setNhaSanXuat(rs.getString("nhaSanXuat"));
            tl.setNamXuatBan(rs.getInt("namXuatBan"));
            tl.setChatLieu(rs.getString("chatLieu"));
            tl.setDonGia(rs.getBigDecimal("donGia"));
            tl.setTongSoLuong(rs.getInt("tongSoLuong"));
            tl.setKichThuoc(rs.getString("kichThuoc"));
            tl.setMoTa(rs.getString("moTa"));
            tl.setKichHoat(rs.getInt("kichHoat"));
            tl.setLoaiTaiLieuid(rs.getInt("LoaiTaiLieuid"));
            return tl;
        });
    }
}
