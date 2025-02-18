package com.example.libman.controller;

import com.example.libman.service.PhieuTraChiTietService;
import com.example.libman.service.PhieuTraService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/receiveDocData/postData")
public class receiveDocPostAPIController {
    @Autowired
    private PhieuTraService phieuTraService;

    @Autowired
    private PhieuTraChiTietService phieuTraChiTietService;

    @PostMapping("/submitReturn")
    public ResponseEntity<String> submitReturn(@RequestBody Map<String, Object> payload, HttpSession session) {
        String readerId = (String) payload.get("readerId");
        List<Integer> returnedDocIds = (List<Integer>) payload.get("returnedDocIds");
        int userId = (Integer) session.getAttribute("userId");
        int banDocId = Integer.parseInt(readerId);

        phieuTraService.saveNewReceiveApplication(userId, banDocId);
        int phieuTraId = phieuTraService.getNewestReceiveApplicationId();
        phieuTraChiTietService.saveNewPhieuTraChiTiet(phieuTraId, returnedDocIds);

        // Trả về phản hồi
        return ResponseEntity.ok("Phiếu trả đã được tạo thành công.");
    }
}
