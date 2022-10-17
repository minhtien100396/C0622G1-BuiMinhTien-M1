package com.minhtien.controller;

import com.minhtien.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
    @GetMapping(value = "showform")
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping(value = "create")
    public String addEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        modelMap.addAttribute("name",employee.getName());
        modelMap.addAttribute("id",employee.getId());
        modelMap.addAttribute("contactNumber",employee.getContactNumber());
        modelMap.addAttribute("msg","Successfully added employees");
        return "info";
    }
}
