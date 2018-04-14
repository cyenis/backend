package com.adidas.backend.stock;

import com.adidas.backend.product.Product;
import com.adidas.backend.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private Store store;
    private Product product;
    private Integer quantity;

}

