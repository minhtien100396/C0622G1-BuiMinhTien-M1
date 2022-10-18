package com.minhtien.controller;

import com.minhtien.model.Customer;
import com.minhtien.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String selectAll(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute(value = "customer") Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Add new customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value = "customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("message", "Update customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String remove(@ModelAttribute (value = "customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.delete(customer.getId());
        redirectAttributes.addFlashAttribute("message","Delete customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view (@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/view";
    }
}
