package com.minhtien.exercise.controller;

import com.minhtien.exercise.model.Blog;
import com.minhtien.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String listBlog(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "/blog/list";
    }
    @GetMapping("/list-page")
    public String getPageListBlog(@RequestParam(value = "page",defaultValue = "0") int page, Model model){
        Sort sort = Sort.by("author").ascending();
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,5,sort));
        model.addAttribute("blogPage",blogPage);
        return "/blog/list_page";
    }
    @GetMapping("/create")
    public String addBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute(value = "blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Add new blog successfully!");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
    public String editBlog(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/edit";
    }
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute(value = "blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
            redirectAttributes.addFlashAttribute("message","Edit blog successfully!");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String viewBlog(@PathVariable(value = "id") Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete blog successfully!");
        return "redirect:/blog";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("blogList", blogService.findByName(name));
        return "/blog/list";
    }
}
