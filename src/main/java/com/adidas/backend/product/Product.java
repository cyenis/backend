package com.adidas.backend.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public enum ProductType {
        CLOTHES, SHOES
    }

    private Long code;
    private String name;
    private String size;
    private ProductType productType;
    private String url;

}
