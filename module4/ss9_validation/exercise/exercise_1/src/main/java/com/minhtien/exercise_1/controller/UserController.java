package com.minhtien.exercise_1.controller;

import com.minhtien.exercise_1.dto.UserDto;
import com.minhtien.exercise_1.model.User;
import com.minhtien.exercise_1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/user/index";
    }

    @PostMapping("/create")
    public String checkValidation(@Validated @ModelAttribute("userDto") UserDto userDto,
                                  BindingResult bindingResult, Model model,
                                  RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/user/index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            model.addAttribute("userDto", userDto);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "Add new user successfully!");
            return "redirect:/";
        }

    }

    @GetMapping
    public String displayListUser(@RequestParam(value = "page", defaultValue = "0") int page,
                                  Model model) {
        model.addAttribute("userList", userService.findAll(PageRequest.of(page, 5)));
        return "/user/list";
    }
}
