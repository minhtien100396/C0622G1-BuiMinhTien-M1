package com.minhtien.repository;

import com.minhtien.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailRepository {
    List<String> languages();

    List<String> pageSize();

    List<String> spamsFilter();
}
