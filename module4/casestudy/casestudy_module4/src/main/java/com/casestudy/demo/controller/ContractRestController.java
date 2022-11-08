package com.casestudy.demo.controller;

import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.model.Contract;
import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.service.IAttachFacilityService;
import com.casestudy.demo.service.IContracService;
import com.casestudy.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/contract-detail")
public class ContractRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/{contractId}")
    public ResponseEntity<List<ContractDetail>> getAll(@PathVariable int contractId) {

        List<ContractDetail> contractDetailList = contractDetailService.findByContractId(contractId);

        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
