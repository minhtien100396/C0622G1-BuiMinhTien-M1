package com.minhtien.demo.controller;

import com.minhtien.demo.dto.CartDto;
import com.minhtien.demo.dto.ProductDto;
import com.minhtien.demo.model.Product;
import com.minhtien.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("")
    public String showList(Model model,
                           @CookieValue(value = "idProduct", defaultValue = "-1") Integer idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        model.addAttribute("productList", productService.findALl());
        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@CookieValue(value = "idProduct") Integer idPrdoduct, @PathVariable(value = "id") int id, HttpServletResponse response,
                             Model model) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(60 * 60 * 24 * 1);
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id).get());
        return "/product/detail";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable(value = "id") int id,
                            @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id); // trả về một Optional
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            Product product = productOptional.get();
            BeanUtils.copyProperties(product, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/back/{id}")
    public String backToHome(@PathVariable(value = "id") int id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60 * 24 * 1);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id,
                                @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id); // trả về một Optional
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            Product product = productOptional.get();
            BeanUtils.copyProperties(product, productDto);
            cart.decreaseProduct(productDto);
        }
        return "redirect:/cart";
    }
}
