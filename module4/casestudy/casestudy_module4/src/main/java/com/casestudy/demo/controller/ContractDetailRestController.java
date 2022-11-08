package com.casestudy.demo.controller;

import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/{contractDetailId}")
    public ResponseEntity<List<ContractDetail>> getContractDetailList(@PathVariable(value = "contractDetailId") int contractDetailId,
                                                                      @PageableDefault(value = 2) Pageable pageable) {
        Page<ContractDetail> contractDetailPage = contractDetailService.findByContract(contractDetailId,pageable);
        if (contractDetailPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailPage.getContent(),HttpStatus.OK);
    }
}
