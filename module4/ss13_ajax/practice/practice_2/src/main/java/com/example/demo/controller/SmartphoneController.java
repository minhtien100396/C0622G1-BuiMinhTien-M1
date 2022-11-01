package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Smartphone>> getAllSmartphonePage() {
        List<Smartphone> smartphones = smartphoneService.findAll();
        if (smartphones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

}
