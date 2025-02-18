package com.example.libman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageReaderController {
    @GetMapping("/manageReader")
    public String ReaderManPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "manageReader";
    }

    @GetMapping("/manageReader/addReader")
    public String AddReaderPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "addReader";
    }

    @GetMapping("/manageReader/detailReader")
    public String detailReaderPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "detailReader";
    }

    @GetMapping("/manageReader/editReader")
    public String editReaderPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "updateReader";
    }

    @GetMapping("/manageReader/deleteReader")
    public String deleteReaderPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "deleteReader";
    }

    @GetMapping("/manageReader/readerCard/view")
    public String viewReaderCardPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "viewReaderCard";
    }
}
