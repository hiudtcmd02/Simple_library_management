package com.example.libman.controller;

import com.example.libman.entity.BanDoc;
import com.example.libman.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readerData/postData")
public class ManReaderPostAPIController {
    @Autowired
    private BanDocService banDocService;
    //Thêm bạn đọc
    @PostMapping("/addBanDoc")
    public ResponseEntity<String> addNewBanDoc(@RequestBody BanDoc banDoc) {
        banDocService.save(banDoc);
        return ResponseEntity.ok("Thêm bạn đọc mới thành công!");
    }
}
