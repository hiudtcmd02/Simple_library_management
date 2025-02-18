package com.example.libman.controller;

import com.example.libman.dto.LendingRequest;
import com.example.libman.service.PhieuMuonChiTietService;
import com.example.libman.service.PhieuMuonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lendDocData/postData")
public class lendDocPostAPIController {
    @Autowired
    private PhieuMuonService phieuMuonService;

    @Autowired
    private PhieuMuonChiTietService phieuMuonChiTietService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitLending(@RequestBody LendingRequest lendingRequest, HttpSession session) {
        int readerId = lendingRequest.getReaderId();
        List<Integer> lentDocIds = lendingRequest.getLentDocIds();
        int userId = (Integer) session.getAttribute("userId");

        phieuMuonService.saveNewPhieuMuon(readerId, userId);
        int phieuMuonId = phieuMuonService.getNewestPhieuMuonId();
        phieuMuonChiTietService.saveDocListForPhieuMuon(phieuMuonId, lentDocIds);

        return ResponseEntity.ok("Phiếu mượn đã được xử lý thành công.");
    }
}
