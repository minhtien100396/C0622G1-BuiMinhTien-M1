package com.minhtien.service;

import java.util.Map;

public interface ICalculatorService {
    double calculator(String number1, String number2, String operator);
    Map<String,String> check(String number1,String number2);
}
