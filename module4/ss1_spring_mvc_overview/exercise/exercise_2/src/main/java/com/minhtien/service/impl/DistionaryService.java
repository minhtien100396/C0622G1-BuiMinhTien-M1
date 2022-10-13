package com.minhtien.service.impl;

import com.minhtien.repository.IDistionaryRepository;
import com.minhtien.service.IDistionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistionaryService implements IDistionaryService {
    @Autowired
    private IDistionaryRepository distionaryRepository;
    @Override
    public String search(String keyWord) {
        return distionaryRepository.search(keyWord);
    }
}
