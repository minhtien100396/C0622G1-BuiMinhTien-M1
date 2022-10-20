package com.minhtien.controller;

import com.minhtien.model.Product;
import com.minhtien.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String selectAllProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "/product/list";
    }

    @GetMapping("/create")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute(value = "product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
            redirectAttributes.addFlashAttribute("message", "Add new product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(value = "product") Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Edit product successfully!");
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable(value = "id") int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete product successfully!");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/view";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("productList", productService.findByName(name));
        return "/product/list";
    }
}
