package com.example.sights.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
