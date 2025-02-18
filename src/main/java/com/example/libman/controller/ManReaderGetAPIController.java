package com.example.libman.controller;

import com.example.libman.entity.BanDoc;
import com.example.libman.entity.LoaiTaiLieu;
import com.example.libman.entity.TaiLieu;
import com.example.libman.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readerData/getData")
public class ManReaderGetAPIController {
    @Autowired
    private BanDocService banDocService;

    // Lấy danh sách bạn đọc
    @GetMapping("/listReader")
    public List<BanDoc> listReader() {
        return banDocService.listAll();
    }

    // Tìm kiếm bạn đọc
    @GetMapping("/searchReader")
    public List<BanDoc> searchReader(@RequestParam String name) {
        return banDocService.listAllByName(name);
    }

    //Xem thông tin chi tiết bạn đọc
    @GetMapping("/detailReader/{readerId}")
    public BanDoc viewReader(@PathVariable int readerId){
        return banDocService.getBanDocById(readerId);
    }

    //Sửa thông tin bạn đọc
    @PutMapping("/editReader/{id}")
    public ResponseEntity<BanDoc> updateReader(@PathVariable int id, @RequestBody BanDoc banDocEditted) {
        BanDoc updatedBd = banDocService.editBanDoc(id, banDocEditted);
        return ResponseEntity.ok(updatedBd);
    }

    @DeleteMapping("/deleteReader/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable int id) {
        banDocService.deleteBanDoc(id);
        return ResponseEntity.noContent().build();
    }
}
