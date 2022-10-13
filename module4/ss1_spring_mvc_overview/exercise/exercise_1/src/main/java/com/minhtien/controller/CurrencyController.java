package com.minhtien.controller;

import com.minhtien.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/conveter")
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;
    @GetMapping
    public String getForm() {
        return "/display";
    }

    @PostMapping(value = "/usd")
    public String getCurrency(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = currencyService.conveter(usd,rate);
        model.addAttribute("error", "USD phải là số dương");
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        return "/display";
    }
}
