package com.example.libman.controller;

import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.service.LoaiTaiLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/data")
public class ManDocTypePostAPIController {
    @Autowired
    private LoaiTaiLieuService loaiTaiLieuService;

    //Thêm loại tài liệu
    @PostMapping("/addDocType")
    public ResponseEntity<String> submitNewLoaiTaiLieu(@RequestBody LoaiTaiLieu loaiTaiLieu) {
        loaiTaiLieuService.save(loaiTaiLieu.getTenLoaiTaiLieu(), loaiTaiLieu.getMoTa(), 1);
        return ResponseEntity.ok("Thêm thể loại mới thành công!");
    }
}
