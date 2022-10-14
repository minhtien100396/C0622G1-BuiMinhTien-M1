package com.minhtien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping
    public String getForm() {
        return "sanwich";
    }

    @GetMapping("/sanwich")
    public String getResult(@RequestParam(value = "condiment") String[] condiment, Model model) {
        model.addAttribute("condiment",condiment);
        return "sanwich";
    }
}
