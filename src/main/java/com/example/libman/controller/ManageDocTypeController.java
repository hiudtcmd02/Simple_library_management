package com.example.libman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageDocTypeController {
    @GetMapping("/manageDocType")
    public String manageDocTypePage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "manageDocType";
    }

    @GetMapping("/manageDocType/addDocType")
    public String addDocTypePage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "addDocType";
    }

    @GetMapping("/manageDocType/detailDocType")
    public String detailDocTypePage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "detailDocType";
    }

    @GetMapping("/manageDocType/editDocType")
    public String updateDocTypePage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "updateDocType";
    }

    @GetMapping("/manageDocType/deleteDocType")
    public String deleteDocTypePage(HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/login"; // Chuyển hướng nếu chưa đăng nhập
        }
        return "deleteDocType";
    }
}
