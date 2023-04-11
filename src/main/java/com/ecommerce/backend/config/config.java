package com.ecommerce.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class config {
    @Configuration
    @ComponentScan(basePackages = "com.example.backend", includeFilters = {
            @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Service")
    }, useDefaultFilters = false)
    public class ServiceBean {

    }
}
