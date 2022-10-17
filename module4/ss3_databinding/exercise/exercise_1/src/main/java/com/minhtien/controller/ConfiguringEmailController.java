package com.minhtien.controller;

import com.minhtien.model.ConfiguringEmail;
import com.minhtien.service.IConfiguringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfiguringEmailController {
    @Autowired
    IConfiguringEmailService configuringEmailService;

    @GetMapping
    public String getSetting(@ModelAttribute("configuringEmail") ConfiguringEmail configuringEmail, Model model) {
        model.addAttribute("configuringEmail", configuringEmail );
        model.addAttribute("languages", configuringEmailService.languages());
        model.addAttribute("pageSize", configuringEmailService.pageSize());
        model.addAttribute("spamsFilter", configuringEmailService.spamsFilter());
        return "setting";
    }
    @PostMapping
    public String getSettingg(@ModelAttribute("configuringEmail") ConfiguringEmail configuringEmail, Model model) {
        model.addAttribute("configuringEmail", configuringEmail );
        model.addAttribute("languages", configuringEmailService.languages());
        model.addAttribute("pageSize", configuringEmailService.pageSize());
        model.addAttribute("spamsFilter", configuringEmailService.spamsFilter());
        return "setting";
    }
    @PostMapping("result")
    public String getResult(@ModelAttribute("configuringEmail") ConfiguringEmail configuringEmail, Model model){
        model.addAttribute("msg","Thay đổi thành công");
        model.addAttribute("configuringEmail", configuringEmail);
        return "result";
    }
}
