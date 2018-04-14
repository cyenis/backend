package com.adidas.backend.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/database")
public class InMemoryDatabaseController {

    private final InMemoryDatabase inMemoryDatabase;

    @Autowired
    public InMemoryDatabaseController(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @DeleteMapping
    public void resetDatabase() {
        inMemoryDatabase.resetDatabase();
    }

}