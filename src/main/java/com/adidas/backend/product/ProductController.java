package com.adidas.backend.product;

import com.adidas.backend.database.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/adidas")
public class ProductController {

    private final InMemoryDatabase inMemoryDatabase;

    @Autowired
    public ProductController(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @GetMapping(value = "/product")
    public Collection<Product> getProducts() {
        return inMemoryDatabase.getAllProducts();
    }

    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return inMemoryDatabase.getProductById(id);
    }

    @GetMapping(value = "/product/shoes")
    public Collection<Product> getShoes() {
        return inMemoryDatabase.getShoes();
    }

    @GetMapping(value = "/product/clothes")
    public Collection<Product> getClothes() {
        return inMemoryDatabase.getClothes();
    }

}