package com.practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index"; // Archivo HTML en "src/main/resources/templates/index.html"
    }
}
