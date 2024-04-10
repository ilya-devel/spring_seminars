package ru.gb.sem04_example2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {
    @GetMapping("/randomMinMax")
    public String getRandomNumEx(
                               @RequestParam(defaultValue = "1") int minVal,
                               @RequestParam(defaultValue = "100") int maxVal,
                               Model model) {
        int num = new Random().nextInt(minVal, maxVal);
        model.addAttribute("number", num);
        model.addAttribute("minVal", minVal);
        model.addAttribute("maxVal", maxVal);
        return "randomMinMax.html";
    }

    @GetMapping("/random")
    public String getRandomNum(
            @RequestParam(defaultValue = "1") int minVal,
            @RequestParam(defaultValue = "100") int maxVal,
            Model model) {
        int num = new Random().nextInt(minVal, maxVal);
        model.addAttribute("number", num);
        return "random.html";
    }
}
