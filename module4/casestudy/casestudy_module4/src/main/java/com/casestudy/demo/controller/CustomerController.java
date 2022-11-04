package com.casestudy.demo.controller;

import com.casestudy.demo.model.Customer;
import com.casestudy.demo.service.ICustomerService;
import com.casestudy.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public String getListFind(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "email", defaultValue = "") String email,
                              @RequestParam(value = "status", defaultValue = "1") String status,
                              @RequestParam(value = "customerTypeId", defaultValue = "") String customerTypeId,
                              Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("customerTypeList", customerTypeService.getList());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        if (customerTypeId.equals("") && name.equals("") && email.equals("")) {
            model.addAttribute("customerPage", customerService.findByStatus(status, PageRequest.of(page, 5, sort)));
        } else if (customerTypeId.equals("")) {
            model.addAttribute("customerPage", customerService.findByNameAndEmail(name, email, status, PageRequest.of(page, 5, sort)));
        } else {
            model.addAttribute("customerPage", customerService.findByNameAndEmailAndCustomerType(name, email, status, customerTypeId, PageRequest.of(page, 5, sort)));
        }
        return "/customer/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") Integer id,
                       Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id,
                         RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        customer.setStatus(0);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Delete customer "+ customer.getName() +" successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String create(){
        return "/customer/create";
    }
}
