package com.minhtien.practice_1.controller;

import com.minhtien.practice_1.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "/index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Validated @ModelAttribute("user") UserDto userDto,
                                  BindingResult bindingResult
                                  ) {
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        } else {
            return "/result";
        }
    }
}
