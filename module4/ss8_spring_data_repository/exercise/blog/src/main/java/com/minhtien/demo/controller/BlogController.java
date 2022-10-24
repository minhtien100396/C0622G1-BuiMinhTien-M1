package com.minhtien.demo.controller;

import com.minhtien.demo.service.IBlogService;
import com.minhtien.demo.service.IECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IECommerceService commerceService;

    @GetMapping
    public String displayBlog(Optional<String> author,
                              Optional<Integer> ecomId,
                              Model model,
                              @PageableDefault(size = 5)
                              Pageable pageable){

//        nếu input Author không nhập và Ecommerce nhập
        if (!author.isPresent() && ecomId.isPresent()){
            model.addAttribute("blogList",blogService.findByEcommerceId(ecomId.get(),pageable));
            model.addAttribute("ecomId",ecomId.get());
        }else if (!author.isPresent() && !ecomId.isPresent()){
            model.addAttribute("blogList",blogService.findAllBlog(pageable));
        }else if (author.isPresent() && !ecomId.isPresent()){
            model.addAttribute("blogList",blogService.findByAuthor(author.get(),pageable));
            model.addAttribute("author",author.get());
        }else {
            model.addAttribute("blogList",blogService.findByAuthorAndEcommerceId(author.get(),ecomId.get(),pageable));
            model.addAttribute("author",author.get());
            model.addAttribute("ecomId",ecomId.get());
        }
        model.addAttribute("ecomerList",commerceService.findAll());
        return "/list";
    }
}
