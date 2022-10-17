package com.minhtien.model;

public class ConfiguringEmail {
    private String id;
    private String langueges;
    private String pageSize;
    private String spamsFilter;
    private String signature;

    public ConfiguringEmail() {
    }

    public ConfiguringEmail(String langueges, String pageSize, String spamsFilter, String signature) {
        this.langueges = langueges;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getLangueges() {
        return langueges;
    }

    public void setLangueges(String langueges) {
        this.langueges = langueges;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
