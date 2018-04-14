package com.adidas.backend.product;

public class Product {

    public enum ProductType {
        CLOTHES, SHOES
    }

    private Long code;
    private String name;
    private String size;
    private ProductType productType;
    private String url;

    public Product(Long code, String name, String size, ProductType productType, String url) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.productType = productType;
        this.url = url;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
