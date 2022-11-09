package com.casestudy.demo.controller;

import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contract-detail/v1")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/{contractId}")
    public ResponseEntity<List<ContractDetail>> getContractDetailList(@PathVariable(value = "contractId") int contractId) {
        List<ContractDetail> contractDetailPage = contractDetailService.findByContractId(contractId);
        if (contractDetailPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContractDetail> createContractDetail(@RequestBody ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return new ResponseEntity<>(contractDetail, HttpStatus.OK);
    }

    @GetMapping("/using/{customerId}")
    public ResponseEntity<List<ContractDetail>> getContractDetailList(@PathVariable(value = "customerId") int customerId) {
        List<ContractDetail> contractDetailPage = contractDetailService.findByCustomerId(customerId);
        if (contractDetailPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailPage, HttpStatus.OK);
    }

}
