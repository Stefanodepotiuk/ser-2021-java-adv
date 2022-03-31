package ua.com.owu.ser2021javaadv.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String home() {
        return "hello";
    }
}
