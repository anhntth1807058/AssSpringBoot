package com.anhnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping(path = "/home")
    public String home() {
        return "home";
    }
}
