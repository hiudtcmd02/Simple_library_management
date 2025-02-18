package com.example.libman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class receiveDocumentsController {
    @GetMapping("/receiveDocuments")
    public String receiveDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "searchReceiveReader";
    }
    @GetMapping("/receiveDocuments/createReceiveForm")
    public String createReceiveApplicationPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "createReceiveApplication";
    }
}
