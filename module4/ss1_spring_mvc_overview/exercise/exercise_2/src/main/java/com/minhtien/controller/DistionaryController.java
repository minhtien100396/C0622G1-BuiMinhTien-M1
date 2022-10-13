package com.minhtien.controller;

import com.minhtien.service.IDistionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/distionary")
public class DistionaryController {
    @Autowired
    private IDistionaryService distionaryService;

    @GetMapping
    public String getForm() {
        return "/display";
    }

    @PostMapping(value = "/result")
    public String search(@RequestParam String word, Model model) {
        String result = distionaryService.search(word);
        String error = "Từ bạn cần tra không tồn tại";
        model.addAttribute("result", result);
        model.addAttribute("error", error);
        model.addAttribute("word", word);
        return "/display";
    }
}
