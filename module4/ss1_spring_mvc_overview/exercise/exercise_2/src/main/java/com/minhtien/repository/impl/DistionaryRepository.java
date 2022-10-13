package com.minhtien.repository.impl;

import com.minhtien.repository.IDistionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

@Repository
public class DistionaryRepository implements IDistionaryRepository {

    private static Map<String, String> distionaryMap;

    static {
        distionaryMap = new TreeMap<>();
        distionaryMap.put("book", "sách");
        distionaryMap.put("pen", "cây bút");
        distionaryMap.put("pencil", "cây bút chì");
        distionaryMap.put("bag", "cái cặp");
        distionaryMap.put("telephone", "điện thoại");
    }

    @Override
    public String search(String keyWord) {
        return distionaryMap.get(keyWord);
    }
}
