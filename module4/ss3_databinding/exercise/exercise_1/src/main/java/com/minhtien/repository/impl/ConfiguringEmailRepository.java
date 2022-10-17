package com.minhtien.repository.impl;

import com.minhtien.model.ConfiguringEmail;
import com.minhtien.repository.IConfiguringEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfiguringEmailRepository implements IConfiguringEmailRepository {
    private static List<String> languageList = new ArrayList<>();
    private static List<String> pageSizeList = new ArrayList<>();
    private static List<String> spamsFilterList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    static {
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("20");
        pageSizeList.add("25");
    }

    static {
        spamsFilterList.add("Enable spams filter");
    }


    @Override
    public List<String> languages() {
        return languageList;
    }

    @Override
    public List<String> pageSize() {
        return pageSizeList;
    }

    @Override
    public List<String> spamsFilter() {
        return spamsFilterList;
    }


}

