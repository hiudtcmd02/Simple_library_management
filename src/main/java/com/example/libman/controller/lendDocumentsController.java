package com.example.libman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class lendDocumentsController {
    @GetMapping("/lendDocuments")
    public String searchReaderToLendPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "searchLendReader";
    }

    @GetMapping("/lendDocuments/createLoanForm")
    public String createLoanFormPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "createLoanApplication";
    }
}
