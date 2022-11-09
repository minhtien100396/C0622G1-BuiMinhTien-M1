package com.casestudy.demo.controller;

import com.casestudy.demo.dto.ContractDto;
import com.casestudy.demo.dto.IContractDto;
import com.casestudy.demo.model.*;
import com.casestudy.demo.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContracService contracService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("customerList")
    public List<Customer> getCustomerList() {
        return customerService.getList();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList() {
        return employeeService.getList();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getFacilityList() {
        return facilityService.getList();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAttachFacilityList() {
        return attachFacilityService.getList();
    }

    @GetMapping
    public String getPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          Model model) {
        Sort sort = Sort.by("start_date").ascending();
        Page<Contract> contractPage = contracService.getPage(PageRequest.of(page, 5, sort));
        Page<ContractDto> contractDtoPage = contractPage.map(new Function<Contract, ContractDto>() {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                BeanUtils.copyProperties(contract, contractDto);
                contractDto.getTotal();
                return contractDto;
            }
        });
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractPage", contractDtoPage);
        return "/contract/list";
    }

    @GetMapping("/list-facility/{idContract}")
    public String getPageFacilityByContract(@PathVariable(value = "idContract") Integer idContract,
                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                            Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("facilityPage", attachFacilityService.getPage(idContract, PageRequest.of(page, 5, sort)));
        return "/contract/list_facility_by_contract";
    }

    @PostMapping("/save")
    public String saveContract(@ModelAttribute(value = "contractDto") ContractDto contractDto, RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contracService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Add new contract of Customer " + contract.getCustomer().getName() + " successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/using")
    public String getListUsing(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Page<IContractDto> contractUsingPage = contracService.getContractUsing(PageRequest.of(page, 5));
        model.addAttribute("contractUsingPage", contractUsingPage);
        return "/contract/using";
    }

    @PostMapping("/add-attach-facility")
    public String addAttachFacility(@RequestParam(value = "contractId") int contractId,
                                    @RequestParam(value = "attachFacilityId") int attachFacilityId,
                                    @RequestParam(value = "quantity") int quantity) {
        Contract contract = contracService.findContractById(contractId);
        AttachFacility attachFacility = attachFacilityService.findAttachFacilityById(attachFacilityId);

        ContractDetail contractDetailFind = contractDetailService.findContractDetailByContractIdAndAttachFacilityId(contractId, attachFacilityId);
        if (contractDetailFind != null) {
            contractDetailFind.setQuantity(contractDetailFind.getQuantity() + quantity);
            contractDetailService.save(contractDetailFind);
        } else {
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setAttachFacility(attachFacility);
            contractDetail.setContract(contract);
            contractDetail.setQuantity(quantity);
            contractDetailService.save(contractDetail);
        }
        return "redirect:/contract";
    }
}
