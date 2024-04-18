package ru.gb.sem06_homework02.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.sem06_homework02.service.ServiceApi;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CharacterController {
    @Autowired
    private final ServiceApi serviceApi;

    @GetMapping
    public String getAllCharacters(Model model) {
        model.addAttribute("characters", serviceApi.getAllCharacters());
        return "index.html";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model) {
        model.addAttribute("character", serviceApi.getCharacterById(id));
        return "character.html";
    }
}
