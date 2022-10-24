package com.minhtien.demo.controller;

import com.minhtien.demo.model.Blog;
import com.minhtien.demo.service.IBlogService;
import com.minhtien.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String displayListBlog(@RequestParam(value = "page", defaultValue = "0") int page,
                                  Optional<String> author,
                                  Optional<Integer> categoryId,
                                  Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        if (author.isPresent() && !categoryId.isPresent()) {
            Sort sort = Sort.by("dateCreate").ascending();
            Page<Blog> blogPage = blogService.findByAuthorContaining(author.get(), PageRequest.of(page, 5, sort));
            model.addAttribute("blogPage", blogPage);
            model.addAttribute("author", author.get());
        } else if (!author.isPresent() && !categoryId.isPresent()) {
            Sort sort = Sort.by("dateCreate").ascending();
            Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 5, sort));
            model.addAttribute("blogPage", blogPage);
        } else if (!author.isPresent() && categoryId.isPresent()) {
            Sort sort = Sort.by("date_create").ascending();
            Page<Blog> blogPage = blogService.findByCategoryId(categoryId.get(), PageRequest.of(page, 5, sort));
            model.addAttribute("blogPage", blogPage);
            model.addAttribute("categoryId", categoryId.get());
        } else {
            Sort sort = Sort.by("date_create").ascending();
            model.addAttribute("blogPage", blogService.findByCategoryIdAndAuthor(categoryId.get(), author.get(), PageRequest.of(page, 5, sort)));
            model.addAttribute("author", author.get());
            model.addAttribute("categoryId", categoryId.get());
        }
        return "/blog/list";
    }

//    @GetMapping
//    public String displayBlog(Optional<String> author,
//                              Optional<Integer> categoryId,
//                              Model model,
//                              @PageableDefault(size = 5)
//                                      Pageable pageable) {
//
////        nếu input Author không nhập và Ecommerce nhập
//        if (!author.isPresent() && categoryId.isPresent()) {
//            model.addAttribute("blogPage", blogService.findByCategoryId(categoryId.get(), pageable));
//            model.addAttribute("categoryId", categoryId.get());
//        } else if (!author.isPresent() && !categoryId.isPresent()) {
//            model.addAttribute("blogPage", blogService.findAll(pageable));
//        } else if (author.isPresent() && !categoryId.isPresent()) {
//            model.addAttribute("blogPage", blogService.findByAuthorContaining(author.get(), pageable));
//            model.addAttribute("author", author.get());
//        } else {
//            model.addAttribute("blogPage", blogService.findByCategoryIdAndAuthor(categoryId.get(), author.get(), pageable));
//            model.addAttribute("author", author.get());
//            model.addAttribute("categoryId", categoryId.get());
//        }
//        model.addAttribute("categoryList", categoryService.findAll());
//        return "/blog/list";
//    }

    @GetMapping("/create")
    public String addBlog(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute(value = "blog") Blog blog,
                               RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Add new blog successfully!");
        return "redirect:/blog";
    }
}
