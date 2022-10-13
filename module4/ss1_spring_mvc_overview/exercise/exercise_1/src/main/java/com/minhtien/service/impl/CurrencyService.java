package com.minhtien.service.impl;

import com.minhtien.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public double conveter(double usd, double rate) {
        return usd*rate;
    }
}
