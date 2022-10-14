package com.minhtien.controller;

import com.minhtien.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;

    @GetMapping
    public String getCheck() {
        return "check";
    }

    @GetMapping(value = "/result")
    public ModelAndView getEmail(@RequestParam(value = "email") String email) {
        Map<String, String> map = emailService.checkEmail(email);
        return new ModelAndView("check", "map", map.get("email"));
    }
}
