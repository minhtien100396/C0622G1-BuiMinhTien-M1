package com.casestudy.demo.controller;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.dto.FacilityDto;
import com.casestudy.demo.model.Facility;
import com.casestudy.demo.model.FacilityType;
import com.casestudy.demo.model.RentType;
import com.casestudy.demo.service.IFacilityService;
import com.casestudy.demo.service.IFacilityTypeService;
import com.casestudy.demo.service.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> getList() {
        return facilityTypeService.getList();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> getListRentType() {
        return rentTypeService.getList();
    }

    @GetMapping
    public String getListFind(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "facilityType", defaultValue = "") String facilityType,
                              Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("name", name);
        model.addAttribute("facilityType", facilityType);
        model.addAttribute("facilityPage", facilityService.findByNameAndFacilityType(name, facilityType, PageRequest.of(page, 5, sort)));

        return "/facility/list";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable(value = "id") Integer id,
                       Model model) {
        Facility facility = facilityService.findById(id);
        model.addAttribute("facility", facility);
        return "/facility/view";
    }

    @GetMapping("/villa/create")
    public String createVilla(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create_facility/create_villa";
    }

    @PostMapping("/villa/create")
    public String createVilla(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/facility/create_facility/create_villa";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Add new villa " + facilityDto.getName() + " successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/house/create")
    public String createHouse(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create_facility/create_house";
    }

    @PostMapping("/house/create")
    public String createHouse(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/facility/create_facility/create_house";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Add new house " + facilityDto.getName() + " successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/room/create")
    public String createRoom(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create_facility/create_room";
    }

    @PostMapping("/room/create")
    public String createRoom(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/facility/create_facility/create_room";
        }else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Add new room " + facilityDto.getName() + " successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") Integer id,
                       Model model) {
        model.addAttribute("facilityDto", facilityService.findById(id));
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute(value = "facilityDto") FacilityDto facilityDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/facility/edit";
        }else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Edit " + facilityDto.getName() + " successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") Integer id,
                         RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        facility.setStatus(0);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Delete " + facility.getName() + " successfully!");
        return "redirect:/facility";
    }
}
