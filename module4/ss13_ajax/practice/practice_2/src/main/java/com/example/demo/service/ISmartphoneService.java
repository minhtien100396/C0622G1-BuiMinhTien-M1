package com.example.demo.service;

import com.example.demo.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartphone);
    void remove(Long id);
}
