package com.adidas.backend.store;

import com.adidas.backend.database.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/adidas")
public class StoreController {

    private final InMemoryDatabase inMemoryDatabase;

    @Autowired
    public StoreController(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @GetMapping(value = "/store")
    public Collection<Store> getStores() {
        return inMemoryDatabase.getAllStores();
    }

    @GetMapping(value = "/store/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return inMemoryDatabase.getStoreById(id);
    }

}
