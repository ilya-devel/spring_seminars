package ru.gb.sem07_homework01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String indexPage() {
        return new String("index.html");
    }

    @GetMapping("/private-data")
    public String privatePage() {
        return "private.html";
    }

    @GetMapping("/public-data")
    public String publicPage() {
        return "public.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout.html";
    }
}
