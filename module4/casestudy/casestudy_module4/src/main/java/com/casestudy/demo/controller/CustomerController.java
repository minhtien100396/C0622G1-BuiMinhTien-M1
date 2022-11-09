package com.casestudy.demo.controller;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.model.Customer;
import com.casestudy.demo.model.CustomerType;
import com.casestudy.demo.model.Gender;
import com.casestudy.demo.service.ICustomerService;
import com.casestudy.demo.service.ICustomerTypeService;
import com.casestudy.demo.service.IGenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IGenderService genderService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getList() {
        return customerTypeService.getList();
    }

    @ModelAttribute("gender")
    public List<Gender> getListGender() {
        return genderService.getList();
    }

    @GetMapping
    public String getListFind(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "email", defaultValue = "") String email,
                              @RequestParam(value = "customerType", defaultValue = "") String customerType,
                              Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerType", customerType);
        model.addAttribute("customerPage", customerService.findByNameAndEmailAndCustomerType(name, email, customerType, PageRequest.of(page, 5, sort)));
        return "/customer/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") Integer id,
                       Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Integer id,
                         RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        customer.setStatus(0);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Delete customer " + customer.getName() + " successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(value = "customerDto") CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Add new customer " + customerDto.getName() + " successfully!");
            return "redirect:/customer";
        }

    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") Integer id,
                       Model model) {
        model.addAttribute("customerDto", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute(value = "customerDto") CustomerDto customerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit new customer " + customerDto.getName() + " successfully!");
            return "redirect:/customer";
        }
    }
}
