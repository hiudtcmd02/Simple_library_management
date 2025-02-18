package com.example.libman.controller;

import com.example.libman.entity.TheBanDoc;
import com.example.libman.service.TheBanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readerCardData/postData")
public class AddReaderCardPostAPIController {
    @Autowired
    private TheBanDocService theBanDocService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewTheBanDoc(@RequestBody TheBanDoc theBanDoc) {
        theBanDocService.saveNewReaderCard(theBanDoc);
        return ResponseEntity.ok("Tạo thẻ bạn đọc thành công!");
    }
}
