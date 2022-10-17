package com.minhtien.service.impl;

import com.minhtien.model.ConfiguringEmail;
import com.minhtien.repository.IConfiguringEmailRepository;
import com.minhtien.service.IConfiguringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguringEmailService implements IConfiguringEmailService {
    @Autowired
    IConfiguringEmailRepository configuringEmailRepository;

    @Override
    public List<String> languages() {
        return configuringEmailRepository.languages();
    }

    @Override
    public List<String> pageSize() {
        return configuringEmailRepository.pageSize();
    }

    @Override
    public List<String> spamsFilter() {
        return configuringEmailRepository.spamsFilter();
    }


}
