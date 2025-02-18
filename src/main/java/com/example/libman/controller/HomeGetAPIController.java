package com.example.libman.controller;

import com.example.libman.entity.TaiLieu;
import com.example.libman.service.TaiLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeGetAPIController {
    @Autowired
    private TaiLieuService taiLieuService;

    // Lọc theo loại tài liệu
    @GetMapping("/homeData/getData/searchByDocType")
    public List<TaiLieu> searchByDocType(@RequestParam int docTypeId) {
        return taiLieuService.filterByDocType(docTypeId);
    }
}
