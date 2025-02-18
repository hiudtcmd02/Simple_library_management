package com.example.libman.controller;

import com.example.libman.entity.TaiLieu;
import com.example.libman.service.TaiLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

@RestController
@RequestMapping("/docData/postData")
public class ManDocPostAPIController {
    @Autowired
    private TaiLieuService taiLieuService;

    @PostMapping("/addTaiLieu")
    public ResponseEntity<String> submitNewTaiLieu(
            @RequestParam String tenTaiLieu,
            @RequestParam String tacGia,
            @RequestParam("hinhAnh") MultipartFile hinhAnh,
            @RequestParam String nhaXuatBan,
            @RequestParam String nhaSanXuat,
            @RequestParam int namXuatBan,
            @RequestParam String chatLieu,
            @RequestParam BigDecimal donGia,
            @RequestParam int tongSoLuong,
            @RequestParam String kichThuoc,
            @RequestParam String moTa,
            @RequestParam int loaiTaiLieuid) {

        TaiLieu taiLieu = new TaiLieu();
        taiLieu.setTenTaiLieu(tenTaiLieu);
        taiLieu.setTacGia(tacGia);
        taiLieu.setNhaXuatBan(nhaXuatBan);
        taiLieu.setNhaSanXuat(nhaSanXuat);
        taiLieu.setNamXuatBan(namXuatBan);
        taiLieu.setChatLieu(chatLieu);
        taiLieu.setDonGia(donGia);
        taiLieu.setTongSoLuong(tongSoLuong);
        taiLieu.setKichThuoc(kichThuoc);
        taiLieu.setMoTa(moTa);
        taiLieu.setKichHoat(1);
        taiLieu.setLoaiTaiLieuid(loaiTaiLieuid);

        // Xử lý tải lên hình ảnh
        if (!hinhAnh.isEmpty()) {
            try {
                byte[] bytes = hinhAnh.getBytes();
                Path path = Paths.get("src/main/resources/static/imgTaiLieu/" + hinhAnh.getOriginalFilename());
                Files.write(path, bytes);
//                taiLieu.setHinhAnh(path.toString()); // Lưu đường dẫn hình ảnh

                // Lưu đường dẫn vào cơ sở dữ liệu
                String relativePath = "/imgTaiLieu/" + hinhAnh.getOriginalFilename();
                taiLieu.setHinhAnh(relativePath); // Lưu đường dẫn hình ảnh vào cơ sở dữ liệu
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Lỗi tải lên hình ảnh: " + e.getMessage());
            }
        }

        taiLieuService.save(taiLieu); // Lưu tài liệu
        return ResponseEntity.ok("Thêm tài liệu thành công!");
    }
}
