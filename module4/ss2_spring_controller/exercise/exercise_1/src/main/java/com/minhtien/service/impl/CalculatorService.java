package com.minhtien.service.impl;

import com.minhtien.service.ICalculatorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculator(String number1, String number2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(number1) + Double.parseDouble(number2);
                break;
            case "-":
                result = Double.parseDouble(number1) - Double.parseDouble(number2);
                break;
            case "x":
                result = Double.parseDouble(number1) * Double.parseDouble(number2);
                break;
            case "/":
                result = Double.parseDouble(number1) / Double.parseDouble(number2);
                break;
        }
        return result;
    }

    @Override
    public Map<String, String> check(String number1, String number2) {
        Map<String,String> errorMap  = new HashMap<>();
        if (number1.equals("")){
            errorMap.put("number1","Tử số không được để trống");
        }
        if (number2.equals("")){
            errorMap.put("number2","Mẫu số không được để trống");
        }else if (Integer.parseInt(number2) == 0) {
            errorMap.put("number2","Mẫu số không được bằng 0");
        }
        return errorMap;
    }
}
