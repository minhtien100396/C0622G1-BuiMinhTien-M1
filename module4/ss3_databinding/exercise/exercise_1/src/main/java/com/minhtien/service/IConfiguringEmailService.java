package com.minhtien.service;

import com.minhtien.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailService {
    List<String> languages();

    List<String> pageSize();

    List<String> spamsFilter();


}
