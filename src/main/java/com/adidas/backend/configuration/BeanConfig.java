package com.adidas.backend.configuration;

import com.adidas.backend.database.InMemoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    InMemoryDatabase database() {
        return new InMemoryDatabase();
    }

}
