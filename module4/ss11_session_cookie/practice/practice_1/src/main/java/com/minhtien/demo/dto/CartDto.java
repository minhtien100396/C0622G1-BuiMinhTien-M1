package com.minhtien.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            //update value +1
            Integer currentValue = productMap.get(productDto);
//            productMap.put(productDto,currentValue+1);
            productMap.replace(productDto, currentValue + 1);
        } else {
            //Lần đầu được thêm vào
            productMap.put(productDto, 1);
        }
    }

    public void decreaseProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);

            if (currentValue > 1) {
                productMap.replace(productDto, currentValue - 1);
            } else {
                productMap.remove(productDto);
            }
        }
    }

    public Double totalMoney() {
        double money = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            money += entry.getKey().getPrice() * entry.getValue();
        }
        return money;
    }

}