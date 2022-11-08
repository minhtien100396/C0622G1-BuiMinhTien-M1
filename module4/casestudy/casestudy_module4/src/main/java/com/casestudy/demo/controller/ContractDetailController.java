package com.casestudy.demo.controller;

import com.casestudy.demo.dto.ContractDetailDto;
import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.model.Contract;
import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.service.IAttachFacilityService;
import com.casestudy.demo.service.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService facilityService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getList(){
        return facilityService.getList();
    }

    @GetMapping("/{idContract}/create")
    public String showFormAddContractDetail(@PathVariable(value = "idContract") Integer idContract, Model model){
        Contract contract = new Contract();
        contract.setId(idContract);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(contract);
        model.addAttribute("contractDetailDto",contractDetailDto);
        model.addAttribute("idContract",idContract);
        return "/contract_detail/create";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute(value = "contractDetailDto") ContractDetailDto contractDetailDto,
                      RedirectAttributes redirectAttributes){
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Add new Contract Detail Of " + contractDetailDto.getContract().getCustomer().getName() + " successfully!");
        return "redirect:/contract";
    }
}
