package com.adidas.backend.stock;

import com.adidas.backend.product.Product;
import com.adidas.backend.store.Store;

public class Stock {

    private Store store;
    private Product product;
    private Integer quantity;

    public Stock(Store store, Product product, Integer quantity) {
        this.store = store;
        this.product = product;
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

