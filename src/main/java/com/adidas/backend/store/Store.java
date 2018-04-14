package com.adidas.backend.store;

public class Store {

    private Long code;
    private String name;
    private String location;

    public Store(Long code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
