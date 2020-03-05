package com.firelord.test.core.fw.spring.core.ioc.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Bean
    public CustomClass customClass() {
        return new CustomClass();
    }
}
