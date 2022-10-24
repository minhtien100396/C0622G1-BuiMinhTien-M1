package com.minhtien.demo.controller;

import com.minhtien.demo.dto.PhoneNumberDto;
import com.minhtien.demo.model.PhoneNumber;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phoneNumberDto", new PhoneNumberDto());
        return "/index";
    }

    @PostMapping("/")
    public String checkValidation(@Validated @ModelAttribute("phoneNumberDto") PhoneNumberDto phoneNumberDto,
                                  BindingResult bindingResult, Model model) {
        new PhoneNumberDto().validate(phoneNumberDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return"/index";
        }else {
            PhoneNumber phoneNumber = new PhoneNumber();
            BeanUtils.copyProperties(phoneNumberDto,phoneNumber);
            model.addAttribute("phoneNumber",phoneNumber);
            return "/result";
        }

    }
}
