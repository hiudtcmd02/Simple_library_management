package com.example.libman.controller;

import com.example.libman.entity.NhanVien;
import com.example.libman.service.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginAPIController {
    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        NhanVien user = nhanVienService.checkLogin(username);
        if (user != null && user.getMatKhau().equals(password)) {
            session.setAttribute("userId", user.getId());
            return "Đăng nhập thành công!";
        }
        return "Thông tin đăng nhập không hợp lệ!";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Hủy session
        return "Đăng xuất!";
    }

    @GetMapping("/currentUserId")
    @ResponseBody
    public Integer getCurrentUserId(HttpSession session) {
        int id = (Integer) session.getAttribute("userId");
        return id;
    }
}
