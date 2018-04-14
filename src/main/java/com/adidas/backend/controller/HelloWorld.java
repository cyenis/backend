package com.adidas.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/adidas")
public class HelloWorld {

    @GetMapping(value = "/hello/{name}")
    String sayHello(@PathVariable String name) {
        return String.format("Hello %s!!", name);
    }

}
