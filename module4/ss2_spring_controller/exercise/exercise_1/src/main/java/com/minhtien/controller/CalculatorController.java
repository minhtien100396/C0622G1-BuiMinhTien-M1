package com.minhtien.controller;

import com.minhtien.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/display")
    public String getForm() {
        return "calculator";
    }

    @PostMapping("calculator")
    public String getCalculator(@RequestParam(value = "first" , required = false) String first, @RequestParam(value = "second") String second,
                                @RequestParam(value = "select") String select, Model model) {
        Map<String, String> map = calculatorService.check(first, second);
        if (map.size() != 0) {
            model.addAttribute("map", map);
        } else {
            double result = calculatorService.calculator(first, second, select);
            model.addAttribute("first", first);
            model.addAttribute("second", second);
            model.addAttribute("select", select);
            model.addAttribute("result", result);
        }
        return "calculator";
    }
}
