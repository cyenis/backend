package com.adidas.backend.stock;

import com.adidas.backend.database.InMemoryDatabase;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/adidas")
public class StockController {

    private final InMemoryDatabase inMemoryDatabase;

    @Autowired
    public StockController(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @GetMapping(value = "/stock/all")
    public Collection<Stock> getAllStock() {
        return inMemoryDatabase.getAllStocks();
    }

    @GetMapping(value = "/stock/{id}")
    public Stock getStockById(@PathVariable String id) {
        return inMemoryDatabase.getStockById(id);
    }

    @GetMapping(value = "/stock")
    public Collection<Stock> getStock(@RequestParam String productName, @RequestParam String size) {
        return inMemoryDatabase.getAllStocks()
                .stream()
                .filter(stock -> getSimilarity(productName, stock.getProduct().getName()) > .7f)
                .filter(stock -> getSimilarity(size, stock.getProduct().getSize()) > .7f)
                .collect(toList());
    }

    private float getSimilarity(String incomingValue, String existingValue) {
        return new JaroWinklerDistance()
                .apply(incomingValue.toLowerCase(), existingValue.toLowerCase())
                .floatValue();
    }

}
