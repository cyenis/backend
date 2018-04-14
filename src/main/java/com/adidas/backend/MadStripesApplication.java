package com.adidas.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MadStripesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MadStripesApplication.class, args);
    }

}
