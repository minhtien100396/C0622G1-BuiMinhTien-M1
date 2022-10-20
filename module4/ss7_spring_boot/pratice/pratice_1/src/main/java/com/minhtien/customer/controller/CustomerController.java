package com.minhtien.customer.controller;

import com.minhtien.customer.model.Customer;
import com.minhtien.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public String listCustomers(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/customer/list";
    }
    @GetMapping("/list-page")
    public String getPageListCustomer(@RequestParam(value = "page",defaultValue = "0") int page, Model model){
        Sort sort = Sort.by("firstName").ascending();
        Page<Customer> customerPage = customerService.findAll(PageRequest.of(page,5,sort));
        model.addAttribute("customerPage",customerPage);
        return "/customer/list_page";
    }
    @GetMapping("/create")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute(value = "customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Add new customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable(value = "id") Integer id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute(value = "customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Edit product successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String viewCustomer(@PathVariable(value = "id") Integer id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/view";
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("customerList", customerService.findByName(name));
        return "/customer/list";
    }
}
