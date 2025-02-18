package com.example.libman.controller;

import com.example.libman.dto.TaiLieuDTO;
import com.example.libman.entity.TaiLieu;
import com.example.libman.service.TaiLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/docData/getData")
public class ManDocGetAPIController {
    @Autowired
    private TaiLieuService taiLieuService;

    // Lấy danh sách tài liệu
    @GetMapping("/listDoc")
    public List<TaiLieu> listDoc() {
        return taiLieuService.listAll();
    }

    // Tìm kiếm tài liệu
    @GetMapping("/searchDoc")
    public List<TaiLieu> searchDoc(@RequestParam String name) {
        return taiLieuService.listAllByName(name);
    }

    //Xem thông tin chi tiết tài liệu
    @GetMapping("/viewDoc/{docId}")
    public TaiLieuDTO getDetailDoc(@PathVariable int docId){
        return taiLieuService.getTaiLieuById(docId);
    }

    //Lấy thông tin tài liệu để cập nhật
    @GetMapping("/detailDoc/{docId}")
    public TaiLieu getDetailDocForUpdate(@PathVariable int docId){
        return taiLieuService.getTaiLieuDetailForUpdate(docId);
    }
    //Sửa tài liệu
    @PutMapping("/editDoc/{id}")
    public ResponseEntity<TaiLieu> updateDoc(@PathVariable int id, @RequestParam Map<String, String> params,
                                             @RequestParam(required = false) MultipartFile hinhAnh) {
        TaiLieu taiLieu = new TaiLieu();
        taiLieu.setId(id);
        taiLieu.setTenTaiLieu(params.get("tenTaiLieu"));
        taiLieu.setTacGia(params.get("tacGia"));
        taiLieu.setNhaXuatBan(params.get("nhaXuatBan"));
        taiLieu.setNhaSanXuat(params.get("nhaSanXuat"));
        taiLieu.setNamXuatBan(Integer.parseInt(params.get("namXuatBan")));
        taiLieu.setChatLieu(params.get("chatLieu"));
        taiLieu.setDonGia(new BigDecimal(params.get("donGia")));
        taiLieu.setTongSoLuong(Integer.parseInt(params.get("tongSoLuong")));
        taiLieu.setKichThuoc(params.get("kichThuoc"));
        taiLieu.setMoTa(params.get("moTa"));
        taiLieu.setLoaiTaiLieuid(Integer.parseInt(params.get("loaiTaiLieuid")));

        if (hinhAnh != null && !hinhAnh.isEmpty()) {
            try {
                byte[] bytes = hinhAnh.getBytes();
                Path path = Paths.get("src/main/resources/static/imgTaiLieu/" + hinhAnh.getOriginalFilename());
                Files.write(path, bytes);
//                taiLieu.setHinhAnh(path.toString()); // Lưu đường dẫn hình ảnh

                // Lưu đường dẫn vào cơ sở dữ liệu
                String relativePath = "/imgTaiLieu/" + hinhAnh.getOriginalFilename();
                taiLieu.setHinhAnh(relativePath); // Lưu đường dẫn hình ảnh vào cơ sở dữ liệu
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            TaiLieu tlo = taiLieuService.getTaiLieuDetailForUpdate(id);
            taiLieu.setHinhAnh(tlo.getHinhAnh());
        }

        TaiLieu updatedDoc = taiLieuService.edit(id, taiLieu);
        return ResponseEntity.ok(updatedDoc);
    }
    // Xóa tài liệu
    @DeleteMapping("/deleteDoc/{id}")
    public ResponseEntity<Void> deleteDoc(@PathVariable int id) {
        taiLieuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
