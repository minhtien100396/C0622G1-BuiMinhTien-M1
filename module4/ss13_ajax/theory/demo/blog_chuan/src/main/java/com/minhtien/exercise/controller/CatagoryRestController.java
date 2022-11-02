package com.minhtien.exercise.controller;

import com.minhtien.exercise.model.Catagory;
import com.minhtien.exercise.service.ICatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catagory/v1")
public class CatagoryRestController {
    @Autowired
    private ICatagoryService catagoryService;

    @GetMapping
    public ResponseEntity<List<Catagory>> getCatagoryList() {
        List<Catagory> catagoryList = catagoryService.findAll();
        if (catagoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(catagoryList,HttpStatus.OK);
    }
}
