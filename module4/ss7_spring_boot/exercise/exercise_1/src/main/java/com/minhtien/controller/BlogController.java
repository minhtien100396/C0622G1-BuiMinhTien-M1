package com.minhtien.controller;

import com.minhtien.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String listBlog(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "/blog/list";
    }
}
