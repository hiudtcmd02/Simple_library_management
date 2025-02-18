package com.example.libman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageDocController {
    @GetMapping("/manageDoc")
    public String manageDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "manageDoc";
    }

    @GetMapping("/manageDoc/addDoc")
    public String addDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "addDoc";
    }

    @GetMapping("/manageDoc/detailDoc")
    public String detailDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "detailDoc";
    }

    @GetMapping("/manageDoc/editDoc")
    public String editDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "updateDoc";
    }

    @GetMapping("/manageDoc/deleteDoc")
    public String deleteDocPage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "deleteDoc";
    }
}
