package com.example.libman.controller;

import com.example.libman.dto.TaiLieuMuonDTO;
import com.example.libman.entity.BanDoc;
import com.example.libman.entity.TaiLieu;
import com.example.libman.service.BanDocService;
import com.example.libman.service.TaiLieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receiveDocData/getData")
public class receiveDocGetAPIController {
    @Autowired
    private BanDocService banDocService;

    @Autowired
    private TaiLieuMuonService taiLieuMuonService;

    // Lấy danh sách bạn đọc mượn tài liệu
    @GetMapping("/listReader")
    public List<BanDoc> listReaderLendDoc() {
        return banDocService.listAllReaderLendDoc();
    }

    // Tìm kiếm bạn đọc mượn tài liệu
    @GetMapping("/searchReader")
    public List<BanDoc> searchReaderLendDoc(@RequestParam String name) {
        return banDocService.listAllReaderLendDocByName(name);
    }

    // Lấy danh sách tài liệu bạn đọc đang mượn
    @GetMapping("/listDoc/{readerId}")
    public List<TaiLieuMuonDTO> listLendDoc(@PathVariable int readerId) {
        return taiLieuMuonService.listAllTaiLieuMuonOfBanDoc(readerId);
    }
}
