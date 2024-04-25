package ru.gb.sem07_homework01.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String indexPage(final HttpServletRequest request, Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
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
