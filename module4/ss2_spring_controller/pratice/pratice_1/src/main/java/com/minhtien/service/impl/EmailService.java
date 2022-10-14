package com.minhtien.service.impl;

import com.minhtien.service.IEmailService;
import com.minhtien.validation.Validation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService implements IEmailService {
    @Override
    public Map<String, String> checkEmail(String email) {
        Map<String, String> errorMap = new HashMap<>();
        if (email.equals("")){
            errorMap.put("email","Email không được để trống");
        }else if (!Validation.checkEmail(email)){
            errorMap.put("email","Email không đúng định dạng");
        }
        if (errorMap.size() == 0){
            errorMap.put("email","Email hợp lệ");
        }
        return errorMap;
    }
}
