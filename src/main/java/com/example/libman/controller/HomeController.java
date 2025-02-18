package com.example.libman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/guestHome/detailDoc")
    public String detailDocGuestPage(){
        return "detailDocForGuest";
    }
}
